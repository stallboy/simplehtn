;;; This file contains a SHOP domain representation of the block-stacking
;;; algorithm from the following paper:
;;;    N. Gupta and D. Nau, On the complexity of blocks-world planning,
;;;    Artificial Intelligence 56(2-3):223-254, August 1992.


;;; ------------------------------------------------------------------------
;;; Declare all the data
;;; ------------------------------------------------------------------------

(defdomain blocks
  (
    ;; basic block-stacking operators

    (:operator (!pickup ?a)                     ; head - primitive task atom
               ()                               ; logical precondition
               ((clear ?a) (on-table ?a))       ; delete list
               ((holding ?a)))                  ; add list
                                                ; cost, default value=1

    (:operator (!putdown ?b)
               ()
               ((holding ?b))
               ((on-table ?b) (clear ?b)))

    (:operator (!stack ?c ?d)
               ()
               ((holding ?c) (clear ?d))
               ((on ?c ?d) (clear ?c)))

    (:operator (!unstack ?e ?f)
               ()
               ((clear ?e) (on ?e ?f))
               ((holding ?e) (clear ?f)))

    ;; book-keeping methods & ops, to keep track of what needs to be done
    (:operator (!!assert ?g)
               ()
               ()
               (?g)
               ;; Since !!ASSERT isn't a real blocks-world operator, make its cost 0
               0)

    (:operator (!!remove ?g)
               ()
               (?g)
               ()
               ;; Since !!REMOVE isn't a real blocks-world operator, make its cost 0
               0)

    ;; The method for the top-layer task
    (:method (achieve-goals ?goals)         ; head - task atom
             ()                             ; logical precondition
             ((assert-goals ?goals)         ; task list
              (find-nomove)
              (add-new-goals)
              (find-movable)
              (move-block)))

    ;; 先把goals里的每个x都添加到state里，形式为(goal ?x)
    (:method (assert-goals (?goal . ?goals))
             ()
             ((!!assert (goal ?goal))
              (assert-goals ?goals)))

    (:method (assert-goals nil)
             ()
             ())



    ;; Find those blocks which don't need to be moved.
    ;; This is called once in the beginning of the process.
    ;; Blocks in their final positions are distinguished with a
    ;; dont-move predicate in the world state

    ;; 对不用移动的block x，也加上标签放到state里，形式为(dont-move ?x)
    (:method (find-nomove)
             ((block ?x) (not (dont-move ?x)) (not (need-to-move ?x)))
             ((!!assert (dont-move ?x)) (find-nomove))
             nil
             nil)



    ;; Find blocks with no assosiated goals and add an appropriate goal
    ;; (on-table ?x) for those blocks if they have to be moved, i.e. if
    ;; they are on the way of something else. Otherwise, we can simply
    ;; ignore them

    ;; 把所有没设置goal，也没dont-move的block x都设置上 (goal (on-table ?x)
    ;; 这之后，所有block，要么有goal，要么是dont-move
    (:method (add-new-goals)
             ((block ?x) (not (dont-move ?x)) (not (goal (on-table ?x)))
             (not (goal (on ?x ?y))))
             ;Decomposition
             ((!!assert (goal (on-table ?x))) (add-new-goals))

             nil
             nil)


    ;; Find all those blocks which can be moved to their final position
    ;; directly in the initial state of the world. Such blocks are marked
    ;; with either a put-on-table predicate or a stack-on-block predicate,
    ;; depending on their associated goal

    ;; 把最顶端需要移动并且可以一步移动成功的block做标记 (put-on-table ?x) 或者 (stack-on-block ?x ?y)
    ;; 引入这两个标记，方便后的递归method书写
    (:method (find-movable)
             ((clear ?x) (not (dont-move ?x))
             (goal (on-table ?x)) (not (put-on-table ?x)))
             ; Decomposition
             ((!!assert (put-on-table ?x)) (find-movable))

             ((clear ?x) (not (dont-move ?x)) (goal (on ?x ?y))
             (not (stack-on-block ?x ?y)) (dont-move ?y) (clear ?y))
             ;Decomposition
             ((!!assert (stack-on-block ?x ?y)) (find-movable))

             nil
             nil)

    ;; Check if the thing that is supposed to end up on top of ?x is ready
    ;; to go there. This is called whenever we move block ?x to its final
    ;; position.

    ;; 此时 --- x 是clear，dont-move  --- 检查是否能放y到x
    (:method (check ?x)
             ((goal (on ?y ?x)) (clear ?y))
             ((!!assert (stack-on-block ?y ?x)))
             nil
             nil)

    ;; Check if the thing that is supposed to end up on top of ?x is ready
    ;; to go there. This is called whenever something is removed from top
    ;; of the ?x. Note that here, we must check if ?x is in final position,
    ;; while in the latter method we were sure that it was and thus we did
    ;; not need a verification.

    ;; 此时 --- x 是 clear --- 检查是否能放y到x
    (:method (check2 ?x)
             ((dont-move ?x) (goal (on ?y ?x)) (clear ?y))
             ((!!assert (stack-on-block ?y ?x)))
             nil
             nil)

    ;; Check if x can go to where it is supposed to end up. This is again
    ;; called whenever something is removed from top of the ?x, making it
    ;; able to move around.

    ;; 此时 --- x 是 clear --- 检查是否要放x到y或table上
    (:method (check3 ?x)
             (dont-move ?x)
             nil
             ((goal (on ?x ?y)) (clear ?y) (dont-move ?y))
             ((!!assert (stack-on-block ?x ?y)))
             ((goal (on-table ?x)))
             ((!!assert (put-on-table ?x)))
             nil
             nil)

    ;; Just an efficiency trick, to avoid calculating things twice
    ;; This trick is a general technique while working with SHOP. If there
    ;; are several possible decompositions for a task and they have some
    ;; preconditions in common, one can "factor" those preconditions and
    ;; add a new level in the task hierarchy whose precondition is the
    ;; set of common preconditions. This way, one may avoid calculating
    ;; the shared preconditions for several times. Here, the stack-on-block
    ;; is the shared precondition in the move-block method

    ; 此时 --- x: clear, z: dont-move，clear --- 把x以到z上面去，然后这次移动后的影响
    (:method (move-block1 ?x ?z)
             method-for-moving-x-from-y-to-z
             ((on ?x ?y))
             ;Decomposition
             ((!unstack ?x ?y) (!stack ?x ?z)
             (!!assert (dont-move ?x))
             (!!remove (stack-on-block ?x ?z))
             (check ?x) (check2 ?y) (check3 ?y))

             method-for-moving-x-from-table-to-z
             nil
             ; Decomposition
             ((!pickup ?x) (!stack ?x ?z)
             (!!assert (dont-move ?x))
             (!!remove (stack-on-block ?x ?z))
             (check ?x)))

    ;; This is the main method. It first moves the blocks that are directly
    ;; movable to their final positions to their final position. Doing so
    ;; may make other blocks directly movable to their final positions.
    ;; Thus this method checks such possibilities using methods check, check1
    ;; and check2 and then calls itself to simulate an iteration. If there is
    ;; no such block, it means that we are done with the planning (A direct
    ;; result of the fact that blocks world problems are always solvable).
    (:method (move-block)
             ; 把x放到y上
             ((stack-on-block ?x ?y))
             ((move-block1 ?x ?y) (move-block))

             ; 把y上的x放到table上，这里x的goal就是table
             method-for-moving-x-from-y-to-table
             ((put-on-table ?x) (on ?x ?y))
             ;Decomposition
             ((!unstack ?x ?y) (!putdown ?x)
             (!!assert (dont-move ?x))
             (!!remove (put-on-table ?x))
             (check ?x) (check2 ?y) (check3 ?y) (move-block))

             ; 把y上的x放到table上，这里x的goal不是table，只是暂时放到table而已
             method-for-moving-x-out-of-the-way
             ((clear ?x) (not (dont-move ?x)) (on ?x ?y))
             ;Decomposition
             ((!unstack ?x ?y) (!putdown ?x)
             (check2 ?y) (check3 ?y) (move-block))

             termination-method-branch
             nil
             nil)

    ;; state axioms

    (:- (same ?x ?x) nil)

    ;; Finds the blocks that must be moved, because they are blocking other
    ;; blocks' way.

    ;; block x是否需要移动
    (:- (need-to-move ?x)
        ;; need to move x if x needs to go from one block to another
        ((on ?x ?y) (goal (on ?x ?z)) (not (same ?y ?z)))
        ;; need to move x if x needs to go from table to block
        ((on-table ?x) (goal (on ?x ?z)))
        ;; need to move x if x needs to go from block to table
        ((on ?x ?y) (goal (on-table ?x)))
        ;; need to move x if x is on y and y needs to be clear
        ((on ?x ?y) (goal (clear ?y)))
        ;; need to move x if x is on z and something else needs to be on z
        ((on ?x ?z) (goal (on ?y ?z)) (not (same ?x ?y)))
        ;; need to move x if x is on something else that needs to be moved
        ((on ?x ?w) (need-to-move ?w))
    )
  )
)
