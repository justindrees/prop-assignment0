package prop.assignment0;

import java.io.IOException;

public class AssignmentNode implements INode {

	//assign = id , ‘=’ , expr , ‘;’
	
	private String id = "";
	private ExpressionNode expr = null;
	private boolean semicolon = false;
	// no variables for = and ;, will check if they exist below
	
	AssignmentNode(Tokenizer tn) throws IOException, TokenizerException, ParserException{
		System.out.println("-------------NEW INSTANCE OF ASSIGNMENTNODE-----------------");
		System.out.println("AssignmentNode constructor called, current is: "+tn.current());
		if(tn.current().token() == Token.IDENT){
			id = (String) tn.current().value();
			tn.moveNext();
			if(tn.current().token() == Token.ASSIGN_OP){
				tn.moveNext();
				expr = new ExpressionNode(tn);
				System.out.println("BACK TO ASSIGNMENTNODE FROM EXPR");
				if(tn.current().token() == Token.SEMICOLON){
					semicolon = true;
				}
			}
		}
		if(id.equals("") || expr == null || semicolon == false){
			throw new ParserException("Syntax error. ParserException in AssignmentNode.");
		}
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void buildString(StringBuilder builder, int tabs) {
		builder.append("AssignmentNode");
		builder.append("\n\t"+Token.IDENT+" "+id);
		builder.append("\n\t"+Token.ASSIGN_OP+" =");
		expr.buildString(builder,tabs+1);
		builder.append("\n\t"+Token.SEMICOLON+" ;");
		System.out.println("Parse tree built");
	}
}
