package prop.assignment0;

import java.io.IOException;

public class AssignmentNode implements INode {

	//assign = id , ‘=’ , expr , ‘;’
	
	private Token token;
	private String id = "";
	private ExpressionNode expr = null;
	// no variables for = and ;, will check if they exist below
	
	AssignmentNode(Tokenizer tn) throws IOException, TokenizerException, ParserException{
		System.out.println("AssignmentNode begin");
		System.out.println(tn.current().token());
		if(tn.current().token() == Token.IDENT){
			id = (String) tn.current().value();
			tn.moveNext();
			if(tn.current().token() == Token.ASSIGN_OP){
				tn.moveNext();
				System.out.println("before checking for semicolon: "+tn.current().token());
				if(tn.current().token() == Token.SEMICOLON){
					expr = new ExpressionNode(tn);
				}
			}
		}
		System.out.println("AssignmentNode end");
		System.out.println("ID: "+id);
		System.out.println("Expr: "+expr);
		if(id.equals("") || expr == null )
			throw new ParserException("Syntax error. ParserException in AssignmentNode.");
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void buildString(StringBuilder builder, int tabs) {
		System.out.println(id+" "+expr);
	}
}
