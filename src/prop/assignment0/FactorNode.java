package prop.assignment0;

import java.io.IOException;

public class FactorNode implements INode {

	//factor = int | ‘(’ , expr , ‘)’
	int value = 0;
	ExpressionNode expr;
	// no variable for parentheses, will check if they exist below
	
	
	FactorNode(Tokenizer tn) throws ParserException, IOException, TokenizerException{
		System.out.println("FactorNode constructor called");
		if(tn.current().token() == Token.INT_LIT){
			value = (int) tn.current().value();
			tn.moveNext();
		}else if(tn.current().token() == Token.LEFT_PAREN){
			tn.moveNext();
			expr = new ExpressionNode(tn);
			if(tn.current().token() == Token.RIGHT_PAREN){
				tn.moveNext();
			}
		}
		
		if(expr == null && value == 0)
			throw new ParserException("Syntax error. ParserException in FactorNode.");
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
