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
			tn.moveNext();
		}
		if(tn.current().token() == Token.DIV_OP){
			sign = '/';
			tn.moveNext();
		}
		
		term = new TermNode(tn);
		
		if(factor == null || term == null || sign == ' ')
			throw new ParserException("Syntax error. ParserException in TermNode.");	
	}
	
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		System.out.println("TermNode buildString(): "+factor+" "+sign+" "+term);
	}

}
