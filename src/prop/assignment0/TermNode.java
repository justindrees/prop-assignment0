package prop.assignment0;

public class TermNode implements INode {

	//term = factor , [ ( ‘*’ | ‘/’) , term] ;
	
	private Token token;
	private TermNode term = null;
	private FactorNode factor = null;
	private char sign = ' ';		// sign for * or /
	
	TermNode(Tokenizer tn) throws ParserException{
		
		/*char sign = ' ';
		INode n = factor();
		if(tn.current().token() == Token.MULT_OP){
			sign = '*';
			tn.moveNext();
		}
		if(tn.current().token() == Token.DIV_OP){
			sign = '/';
			tn.moveNext();
		}
		if(sign == ' ')
			throw new ParserException("Syntax error. ParserException in term() ");
		//TermNode n2 = new TermNode(TermNode term,n,sign);
		//return n2;
		return null;
		*/
		
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
		// TODO Auto-generated method stub
		
	}

}
