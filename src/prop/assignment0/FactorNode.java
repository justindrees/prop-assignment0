package prop.assignment0;

import java.io.IOException;

public class FactorNode implements INode {

	//factor = int | ‘(’ , expr , ‘)’
	int value = 0;
	ExpressionNode expr = null;
	Token token;
	boolean leftParen = false;
	boolean rightParen = false;
	
	
	FactorNode(Tokenizer tn) throws ParserException, IOException, TokenizerException{
		System.out.println("-------------NEW INSTANCE OF FACTORNODE-----------------");
		System.out.println("FactorNode constructor called, current is: "+tn.current());
		if (tn.current().token() == Token.INT_LIT){
			value = Integer.parseInt((String)tn.current().value());
			System.out.println("value set to "+value+" and moveNext creates following:");
			token = Token.INT_LIT;
			tn.moveNext();
		}else if(tn.current().token() == Token.LEFT_PAREN){
			leftParen = true;
			token = Token.LEFT_PAREN;
			tn.moveNext();
			expr = new ExpressionNode(tn);
			if(tn.current().token() == Token.RIGHT_PAREN){
				rightParen = true;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		String std_tab = "";
		for(int i = tabs;i==0;tabs--){
			std_tab += "\t";
		}
		builder.append("\n"+std_tab+"FactorNode");
		if(expr != null){
			expr.buildString(builder,tabs+1);
		}else if(value != 0){
			builder.append("\n"+std_tab+"\t"+token+" "+value);
		}else if(leftParen == true){
			builder.append("\n"+std_tab+"\t"+token+" "+"(");
		}
	}

}
