package prop.assignment0;

import java.io.IOException;

public class TermNode implements INode {

	//term = factor , [ ( ‘*’ | ‘/’) , term] ;
	
	private Token token;
	private TermNode term = null;
	private FactorNode factor = null;
	private char sign = ' ';		// sign for * or /
	
	TermNode(Tokenizer tn) throws ParserException, IOException, TokenizerException{
		System.out.println("-------------NEW INSTANCE OF TERMNODE-----------------");
		System.out.println("TermNode constructor called, current is: "+tn.current());
		factor = new FactorNode(tn);
		System.out.println("BACK TO TERMNODE FROM FACTORNODE");
		
		if(tn.current().token() == Token.MULT_OP){
			sign = '*';
			System.out.println("sign in TermNode = * and moveNext creates following:");
			tn.moveNext();
		}else if(tn.current().token() == Token.DIV_OP){
			System.out.println("sign in TermNode = / and moveNext creates following:");
			sign = '/';
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
		System.out.println("TermNode buildString(): "+factor+" "+sign+" "+term);
	}

}
