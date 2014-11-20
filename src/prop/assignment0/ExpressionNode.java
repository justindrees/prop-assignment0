package prop.assignment0;

import java.io.IOException;

public class ExpressionNode implements INode {

	 //expr = term , [ ( ‘+’ | ‘-’ ) , expr ] ;

	private Token token;
	private TermNode term = null;
	private char sign = ' ';		// sign for + or -
	private ExpressionNode expr = null;
	
	ExpressionNode(Tokenizer tn) throws ParserException, IOException, TokenizerException{
		
		term = new TermNode(tn);
		tn.moveNext();
		if(tn.current().token() == Token.ADD_OP){
			tn.moveNext();
			sign = '+';
		}
		if(tn.current().token() == Token.SUB_OP){
			sign = '-';
			tn.moveNext();
		}
		expr = new ExpressionNode(tn);
		
		if(term == null || expr == null || sign == ' ')
			throw new ParserException("Syntax error. ParserException in ExpressionNode.");	
	}
	
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		System.out.println("ExpressionNode buildString(): "+term+" "+sign+" "+expr);
	}

}
