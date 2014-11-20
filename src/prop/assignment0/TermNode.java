package prop.assignment0;

import java.io.IOException;

public class TermNode implements INode {

	//term = factor , [ ( ‘*’ | ‘/’) , term] ;
	
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
		double sum = 0;
		double val1 = (double)factor.evaluate(null);
		if(term != null){
			double val2 = (double)term.evaluate(null);
			switch(sign){
				case '*':
					sum = val1 * val2;
					break;
				case '/':
					sum = (double)val1 / val2;
					break;
			}
			return sum;
		}
		return val1;
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
