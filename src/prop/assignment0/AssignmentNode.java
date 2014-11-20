package prop.assignment0;

import java.io.IOException;

public class AssignmentNode implements INode {

	//assign = id , ‘=’ , expr , ‘;’
	
	private Token token;
	private String id = "";
	private ExpressionNode expr = null;
	// no variables for = and ;, will check if they exist below
	
	AssignmentNode(Tokenizer tn) throws IOException, TokenizerException, ParserException{
		System.out.println("AssignmentNode constructor called");
		if(tn.current().token() == Token.IDENT){
			id = (String) tn.current().value();
			tn.moveNext();
			System.out.println("1 value(): "+tn.current().value()+" token(): "+tn.current().token());
			if(tn.current().token() == Token.ASSIGN_OP){
				System.out.println("2 value(): "+tn.current().value()+" token(): "+tn.current().token());
				tn.moveNext();
				System.out.println("3 value(): "+tn.current().value()+" token(): "+tn.current().token());
				if(tn.current().token() == Token.SEMICOLON){
					System.out.println("AssignmentNode #1");
					expr = new ExpressionNode(tn);
				}
			}
		}
		if(id.equals("") || expr == null)
			throw new ParserException("Syntax error. ParserException in AssignmentNode.");
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void buildString(StringBuilder builder, int tabs) {
		System.out.println("AssignmentNode buildString(): "+id+" = "+expr+";");
		//builder.append();
	}
}
