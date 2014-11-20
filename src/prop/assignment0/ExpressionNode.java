package prop.assignment0;

public class ExpressionNode implements INode {

	 //expr = term , [ ( ‘+’ | ‘-’ ) , expr ] ;

	private Token token;
	private TermNode term;
	private char sign;		// sign for + or -
	private ExpressionNode expr;
	
	ExpressionNode(Tokenizer tn){


		/*
		tn.moveNext();
		char sign = ' ';
		//INode n = term();
		if(tn.current().token() == Token.ADD_OP){
			tn.moveNext();
			sign = '+';
		}
		if(tn.current().token() == Token.SUB_OP){
			sign = '-';
			tn.moveNext();
		}
		//ExpressionNode n2 = new ExpressionNode(n, ExpressionNode expr,sign);

		//throw new ParserException("Syntax error. ParserException in expr() ");
		 */
	}
	
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		// TODO Auto-generated method stub
		
	}

}
