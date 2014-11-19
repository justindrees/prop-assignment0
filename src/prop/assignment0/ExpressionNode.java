package prop.assignment0;

public class ExpressionNode implements INode {

	private Token token;
	private TermNode term;
	private ExpressionNode expr;
	private String sign;
	
	ExpressionNode(TermNode term, ExpressionNode expr, String sign){
		this.term = term;
		this.expr = expr;
		this.sign = sign;
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
