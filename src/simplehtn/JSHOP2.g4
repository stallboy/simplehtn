grammar JSHOP2;


shop
    : domain
    | problem
    ;

//------------------------------- Problem ---------------------------

problem
    : '(' 'defproblem' pn=ID dn=ID state=latomlist tl=tasklist ')'
        // latomlist 里latom必须都是ground，不能有变量
        // 而tasklist 可以有变量
    ;


//------------------------------- Domain ----------------------------

//-- Domain
domain
    : '(' 'defdomain' ID '(' pde+ ')' ')'
    ;

//-- Planning Domain Element
pde
    : method
    | operator
    | axiom
    ;

method
    : '(' ':method' '(' ID terml ')' methodsub+ ')'
    ;

methodsub
    : ID? pre=lprecond tl=tasklist
    ;

operator
    : '(' ':operator' '(' OPID terml ')' pre=lprecond del=deladd add=deladd cost=term? ')'
    ;

axiom
    : '(' ':-' '(' ID terml ')' axiomsub+ ')'     // constant 来源term, logic atom ID, axiom ID
    ;

axiomsub
    : ID? pre=lprecond
    ;

//-- Delete/Add
deladd
    : '(' deladdele* ')'                # DelAdd_Basic
    | VARID                             # DelAdd_Var
    | 'nil'                             # DelAdd_Nil
    ;

//-- Delete/Add Element
deladdele
    : latom                             # DelAddEle_Atom
    | '(' ':protection' latom ')'       # DelAddEle_Protect
    | '(' 'forall' lexp latomlist ')'   # DelAddEle_ForAll
        // 这里相对标准，去掉了varlist，不影响语义
    ;


//------------------------------- Task ------------------------------

//-- Task List
tasklist
    : '(' UNORDERED? tasklistsub* ')'   # TaskList_Basic
    | 'nil'                             # TaskList_Nil
    ;

tasklistsub
    : tasklist                          # TaskListSub_List
    | taskatom                          # TaskListSub_Atom
    ;

//-- Task Atom
taskatom
    :'(' IMMEDIATE? (ID | OPID) terml ')'
    ;

//------------------------------- Logical precondition --------------

//-- Logical Precondition
lprecond
    : lexp                                      # Precond_Exp
    | '(' ':first' lexp ')'                     # Precond_First
    | '(' ':sort-by' VARID compname? lexp ')'   # Precond_SortBy
        // vars最大值 来源1,
        // 例如：(:sort-by ?d < (and (at ?here) (distance ?here ?there ?d))) 优先考虑离我最近的点
    ;

compname
    : ID
    | '<'
    | '>'
    ;

//-- Logical Expression
lexp
    : 'nil'                             # Exp_Nil
    | '(' 'and'? lexp* ')'              # Exp_And
    | '(' 'or' lexp+ ')'                # Exp_Or
    | '(' 'not' lexp ')'                # Exp_Not
    | '(' 'imply' lexp lexp ')'         # Exp_Imply     // 含义为 (¬Y ∨ Z).  Y 应该是 ground, 否则这里语义不好解释
    | latom                             # Exp_Atom
    | '(' 'forall' lexp lexp ')'        # Exp_ForAll    // 这里相对标准，去掉了varlist，不影响语义
    | '(' 'assign' VARID term ')'       # Exp_Assign    // vars最大值 来源2
    | '(' 'call' funcname terml ')'     # Exp_Call
    ;

latomlist
    : '(' latom* ')'                    # AtomList_Basic
    | 'nil'                             # AtomList_Nil
    ;

//-- Logical Atom
latom
    : '(' ID terml ')'                   # Atom_Basic   // constant 来源term, logic atom ID, axiom ID
    | VARID                              # Atom_Var
    ;

funcname
    : ID
    | '/'
    | '='
    | '<'
    | '<='
    | 'member'
    | '-' WS
    | '>'
    | '>='
    | '*'
    | '!='
    | '+' WS
    | '^'
    ;

//------------------------------- Term ------------------------------

//-- Term List
terml
    : term*
    ;


term
    : VARID                             # Term_Var   // vars最大值 来源3
    | ID                                # Term_Const // constant 来源term, logic atom ID, axiom ID
    | NUM                               # Term_Num
    | '(' terml ('.' term)? ')'         # Term_List
    | 'nil'                             # Term_Nil
    | '(' 'call' funcname terml ')'     # Term_Call
    ;

//------------------------------- Lexer -----------------------------

IMMEDIATE
    : ':immediate'
    ;

UNORDERED
    : ':unordered'
    ;

//-- Whitespace (ignored)
WS
    : (' ' | '\t' | '\f' | '\r\n' | '\r' |'\n')+ -> skip
    ;

//-- Comments, LISP style (ignored)
COMMENT
    : ';' (~('\n' | '\r'))* -> skip
    ;

//-- Identifier
ID
    : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '-' | '_' | '?' | '!' | '0'..'9')*
    ;

//-- Operator name
OPID
    : '!' ('a'..'z' | 'A'..'Z' | '-' | '_' | '?' | '!' | '0'..'9')*
    ;

//-- Variable symbol identifier
VARID
    : '?' ('a'..'z' | 'A'..'Z' | '-' | '_' | '?' | '!' | '0'..'9')*
    ;

//-- Numerical value
NUM
    : ('-' | '+')? ('0'..'9')+ ('.' ('0' .. '9')+)? ('e' ('-' | '+')? ('0' .. '9')+ )?
    ;
