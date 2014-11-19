package prop.assignment0;

public class ExpressionNode implements INode {

	 //expr = term , [ ( '+' | '-' ) , expr ] ;

	private Token token;
	private TermNode term;
	private ExpressionNode expr;
	private String sign;
	
	ExpressionNode(TermNode term, ExpressionNode expr, String sign){
		this.term = term;
		this.expr = expr;
		this.sign = sign;
		
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
		//INode n2 = expr();
		//return n2;
		return null;
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
