
(defdomain az
  (
    (:operator (!print ?a)
             ()
             ()
             ()
             )

    (:method (solve (?a ?b . ?others))
             ( (valid ?a) )
             ( (!print ?a) (solve (?b . ?others)) )
             )

    (:method (solve (?a ?b . ?others))
            ( (not (call = ?a 0)) (assign ?c (call Combine ?a ?b)) (valid ?c) )
            ( (!print ?c) (solve ?others) )
            )

    (:method (solve (?a))
             ( (valid ?a) )
             ( (!print ?a) )
             )

    (:method (solve nil)
             ()
             ()
             )

    (:- (valid ?a)
            ( (call <= ?a 26) (call > ?a 0) )
            )
  )
)