package prop.assignment0;

public class FactorNode implements INode {

	//factor = int | ‘(’ , expr , ‘)’
	int value = 0;
	ExpressionNode expr;
	// no variable for parentheses, will check if they exist below
	
	
	FactorNode(Tokenizer tn) throws ParserException{
		
		/*
		if(tn.current().token() == Token.INT_LIT){
			parseTree.add(tn.current());
			tn.moveNext();
		}else if(tn.current().token() == Token.LEFT_PAREN){
			parseTree.add(tn.current());
			tn.moveNext();
			INode n = expr();
			if(tn.current().token() == Token.RIGHT_PAREN){
				parseTree.add(tn.current());
				tn.moveNext();
			}
		return new FactorNode();
		//throw new ParserException("Syntax error. ParserException in factor() ");*/

		
		if(expr == null || value == 0)
			throw new ParserException("Syntax error. ParserException in FactorNode.");	
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
