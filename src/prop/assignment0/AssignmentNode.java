package prop.assignment0;

import java.io.IOException;

public class AssignmentNode implements INode {

	//assign = id , '=' , expr ,  ';'
	
	private String id = "";
	private ExpressionNode expr = null;
	private boolean semicolon = false;
	
	AssignmentNode(Tokenizer tn) throws IOException, TokenizerException, ParserException{
		if(tn.current().token() == Token.IDENT){
			id = (String) tn.current().value();
			tn.moveNext();
			if(tn.current().token() == Token.ASSIGN_OP){
				tn.moveNext();
				expr = new ExpressionNode(tn);
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
		double value = (double)expr.evaluate(null);
		String str = id+" = "+value; 
		return (Object)str;
	}
	@Override
	public void buildString(StringBuilder builder, int tabs) {
		builder.append("AssignmentNode");
		builder.append("\n\t"+Token.IDENT+" "+id);
		builder.append("\n\t"+Token.ASSIGN_OP+" =");
		expr.buildString(builder,tabs+1);
		builder.append("\n\t"+Token.SEMICOLON+" ;");
	}
}
