package prop.assignment0;

public class AssignmentNode implements INode {

	private Lexeme lexeme;
	private Object value;
	private Token token;
	
	AssignmentNode(Object value){
		this.value = value;
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
