package prop.assignment0;

public class AssignmentNode implements INode {

	private Lexeme lexeme;
	private Object ID;
	private Token token;
	private ExpressionNode expr;
	
	AssignmentNode(String ID, ExpressionNode expr){
		this.ID = ID;
		this.expr = expr;
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
	
	void setLexeme(Lexeme lexeme){
		this.lexeme = lexeme;
	}

}
