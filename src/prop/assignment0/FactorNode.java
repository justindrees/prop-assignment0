package prop.assignment0;

import java.io.IOException;

public class FactorNode implements INode {

	//factor = int | '(' , expr , ')'
	int value = 0;
	ExpressionNode expr = null;
	Token token;
	boolean paren = false;
	
	FactorNode(Tokenizer tn) throws ParserException, IOException, TokenizerException{
		if (tn.current().token() == Token.INT_LIT){
			value = Integer.parseInt((String)tn.current().value());
			tn.moveNext();
		}else if(tn.current().token() == Token.LEFT_PAREN){
			token = Token.LEFT_PAREN;
			tn.moveNext();
			expr = new ExpressionNode(tn);
			if(tn.current().token() == Token.RIGHT_PAREN){
				paren = true;
				token = Token.RIGHT_PAREN;
				tn.moveNext();
			}
		}
		if(expr == null && value == 0){
			throw new ParserException("Syntax error. ParserException in FactorNode.");
		}
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		if(value != 0){
			return (double)value;
		}else if(expr != null){
			return (double)expr.evaluate(null);
		}
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		String std_tab = "";
		for(int i = 0;i<tabs;i++){
			std_tab += "\t";
		}
		builder.append("\n"+std_tab+"FactorNode");
		if(expr != null && paren == true){
			builder.append("\n"+std_tab+"\t"+Token.LEFT_PAREN+" "+"(");
			expr.buildString(builder,tabs+1);
			builder.append("\n"+std_tab+"\t"+Token.RIGHT_PAREN+" "+")");
		}else if(value != 0){
			builder.append("\n"+std_tab+"\t"+Token.INT_LIT+" "+value);
		}
	}

}
