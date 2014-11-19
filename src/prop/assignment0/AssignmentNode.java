package prop.assignment0;

public class AssignmentNode implements INode {

	//assign = id , ‘=’ , expr , ‘;’
	
	private Token token;
	private String ID;
	private ExpressionNode expr;
	// no variables for = and ;, will check if they exist below
	
	AssignmentNode(String ID, ExpressionNode expr){
		this.ID = ID;
		this.expr = expr;
		
		/*
		String id = "";
		if(tn.current().token() == Token.IDENT){
			id = (String) tn.current().value();
			tn.moveNext();
			if(tn.current().token() == Token.ASSIGN_OP){
				tn.moveNext();
				ExpressionNode n = expr();
				if(tn.current().token() == Token.SEMICOLON){
					AssignmentNode n2 = new AssignmentNode(id,n);		// TABS for correct buildString??
					parseTree.add(n);
					return n2;
				}
			}
		}
		throw new ParserException("Syntax error. ParserException in assign() ");
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
