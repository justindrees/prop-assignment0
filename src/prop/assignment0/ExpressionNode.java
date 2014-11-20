package prop.assignment0;

import java.io.IOException;

public class ExpressionNode implements INode {

	 //expr = term , [ ( ‘+’ | ‘-’ ) , expr ] ;

	private Token token;
	private TermNode term = null;
	private char sign = ' ';		// sign for + or -
	private ExpressionNode expr = null;
	
	ExpressionNode(Tokenizer tn) throws ParserException, IOException, TokenizerException{

		term = new TermNode(tn);
		
		if(tn.current().token() == Token.ADD_OP){
			sign = '+';
			token = Token.ADD_OP;
			tn.moveNext();
		}else if(tn.current().token() == Token.SUB_OP){
			sign = '-';
			token = Token.SUB_OP;
			tn.moveNext();
		}
		if(tn.current().token() != Token.RIGHT_PAREN && tn.current().token() != Token.SEMICOLON){
			expr = new ExpressionNode(tn);
		}
		if(term == null && expr == null && sign == ' '){
			throw new ParserException("Syntax error. ParserException in ExpressionNode.");	
		}
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		double sum = 0;
		double val1 = (double)term.evaluate(null);
		if(expr != null){	
			double val2 = (double)expr.evaluate(null);
			switch(sign){
				case '+':
					sum = val1 + val2;
					break;
				case '-':
					sum = val1 - val2;
					break;
			}
			return (Object)sum;
		}
		return val1;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		String std_tab = "";
		for(int i = 0;i<tabs;i++){
			std_tab += "\t";
		}
		builder.append("\n"+std_tab+"ExpressionNode");
		if(term != null)
			term.buildString(builder,tabs+1);
		if (sign != ' ')
			builder.append("\n"+std_tab+"\t"+token+" "+sign);
		if(expr != null)
			expr.buildString(builder,tabs+1);

	}
}
