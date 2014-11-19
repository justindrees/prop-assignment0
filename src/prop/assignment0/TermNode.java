package prop.assignment0;

public class TermNode implements INode {

	//term = factor , [ ( ‘*’ | ‘/’) , term] ;
	
	private Token token;
	private TermNode term;
	private FactorNode fnode;
	private char sign;
	
	TermNode(TermNode term, FactorNode fnode, char sign){
		this.term = term;
		this.fnode = fnode;
		this.sign = sign;
		
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
