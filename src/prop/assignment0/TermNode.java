package prop.assignment0;

public class TermNode implements INode {

	private Token token;
	private TermNode term;
	private FactorNode fnode;
	private char sign;
	
	TermNode(TermNode term, FactorNode fnode, char sign){
		this.term = term;
		this.fnode = fnode;
		this.sign = sign;
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
