package prop.assignment0;

import java.io.IOException;

public class FactorNode implements INode {

	//factor = int | ‘(’ , expr , ‘)’
	int value = 0;
	ExpressionNode expr = null;
	// no variable for parentheses, will check if they exist below
	
	
	FactorNode(Tokenizer tn) throws ParserException, IOException, TokenizerException{
		System.out.println("-------------NEW INSTANCE OF FACTORNODE-----------------");
		System.out.println("FactorNode constructor called, current is: "+tn.current());
		if (tn.current().token() == Token.INT_LIT){
			value = Integer.parseInt((String)tn.current().value());
			System.out.println("value set to "+value+" and moveNext creates following:");
			tn.moveNext();
		}else if(tn.current().token() == Token.LEFT_PAREN){
			tn.moveNext();
			System.out.println("STARTING LEFT PAREN EXPR");
			expr = new ExpressionNode(tn);
			System.out.println("BACK FROM EXPR");
			if(tn.current().token() == Token.RIGHT_PAREN){
				System.out.println("Token = RIGHT PAREN and moveNext creates following:");
				tn.moveNext();
			}
		}
		if(expr == null && value == 0){
			throw new ParserException("Syntax error. ParserException in FactorNode.");
		}
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		System.out.println("FactorNode buildString(): "+value+" "+"("+expr+")");
	}

}
