prop-assignment0
================

Implement an interpreter in Java for assignment statements in some programming language.

If you are aiming for grade C, D or E you should implement an interpreter 
for the following grammar in EBNF (ISO standard) Grammar1:

assign = id , '=' , expr , ';' ; 
expr = term , [ ( '+' | '-' ) , expr ]  
term = factor , [ ( '*' | '/') , term] 
factor = int | '(' , expr , ')' 

where id is defined as (a..z)+ and int is defined as (0..9)+.

If you are aiming for grade A or B you should implement an interpreter
for the following grammar in EBNF (ISO standard) Grammar2:
 
block = '{' , stmts , '}' ; 
stmts = [ assign , stmts ] ; 
assign = id , '=' , expr , ';' ; 
expr = term , [ ( '+' | '-' ) , expr ] ; 
term = factor , [ ( '*' | '/' ) , term ] ; 
factor = int | id | '(' , expr , ')' ;

where id is defined as (a..z)+ and int is defined as (0..9)+.

Tokenizer
The tokenizer should call the Scanner to get a stream of characters, and from that stream of 
characters create a stream of lexemes/tokens. You should implement a Tokenizer class, which 
implements the interface ITokenizer.


Parser
The parser should call the Tokenizer to get a stream of lexemes/tokens, and from that stream of
lexemes/tokens create a parse tree. The parse tree should be built of instances of the following classes: 
AssignmentNode, ExpressionNode, TermNode and FactorNode (and for grade A and B: BlockNode and StatementsNode). 
You should implement these classes, which should all implement the interface INode. 
 
For the lexemes in the parse tree you should use the Lexeme class.
You should also implement a class Parser, which should implement the interface IParser.
The INode interface includes a method buildString(StringBuilder, int), 
which should be used to create a string representation of the parse tree.
Your program should output a parse tree as a string, which should exactly 
follow the given examples. An interpreter for Grammar 1 with input program1.txt 
should output parsetree1.txt, and an interpreter for Grammar2 
with input program2.txt should output parsetree2.txt.


Evaluator
The Evaluator should be distributed in an object oriented manner over the nodes in the parse tree.
The INode interface includes a method evaluate(Object[]), which should return the value of the node.
Your program should output a parse tree evaluation as a string, 
which should exactly follow the given example files program1.txt, parsetree1.txt,
program2.txt and parsetree2.txt.

Note that the grammar rules are right recursive (tail recursive) but the arithmetic operators
are left associative. This complexity needs to be handled in a correct way to get a grade of A or B.
 
Note also that in Grammar2 the assignment statement may include identifiers (variables) in the expression. 
To be able to evaluate expressions including variables the evaluator needs to maintain a data structure
including the current value of all found variables.
Assume the default value of an unassigned variable is 0.
