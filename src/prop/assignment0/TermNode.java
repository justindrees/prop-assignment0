package prop.assignment0;

import java.io.IOException;

public class TermNode implements INode {

	//term = factor , [ ( '*' | '/') , term];
	
	private Token token;
	private TermNode term = null;
	private FactorNode factor = null;
	private char sign = ' ';		// sign for * or /
	
	TermNode(Tokenizer tn) throws ParserException, IOException, TokenizerException{
		factor = new FactorNode(tn);
		
		if(tn.current().token() == Token.MULT_OP){
			sign = '*';
			token = Token.MULT_OP;
			tn.moveNext();
		}else if(tn.current().token() == Token.DIV_OP){
			sign = '/';
			token = Token.DIV_OP;
			tn.moveNext();
		}
		if(tn.current().token() == Token.INT_LIT){
			term = new TermNode(tn);
		}
		if(factor == null){
			throw new ParserException("Syntax error. ParserException in TermNode.");
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
		for(int i = 0;i<tabs;i++){
			std_tab += "\t";
		}
		builder.append("\n"+std_tab+"TermNode");
		if(factor != null)
			factor.buildString(builder,tabs+1);
		if(sign != ' ')
			builder.append("\n"+std_tab+"\t"+token+" "+sign);
		if(term != null)
			term.buildString(builder,tabs+1);
	}
}
