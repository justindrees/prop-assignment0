package prop.assignment0;

import java.io.IOException;

public class ExpressionNode implements INode {

	 //expr = term , [ ( ‘+’ | ‘-’ ) , expr ] ;

	private Token token;
	private TermNode term = null;
	private char sign = ' ';		// sign for + or -
	private ExpressionNode expr = null;
	
	ExpressionNode(Tokenizer tn) throws ParserException, IOException, TokenizerException{
		System.out.println("-------------NEW INSTANCE OF EXPRESSIONNODE-----------------");
		System.out.println("ExpressionNode constructor called, current is: "+tn.current());

		term = new TermNode(tn);
		System.out.println("BACK TO EXPR FROM TERMNODE");
		
		if(tn.current().token() == Token.ADD_OP){
			sign = '+';
			System.out.println("Token = ADD_OP and moveNext creates following:");
			tn.moveNext();
		}else if(tn.current().token() == Token.SUB_OP){
			sign = '-';
			System.out.println("Token = SUB_OP and moveNext creates following:");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		String std_tab = "";
		for(int i = tabs;i==0;tabs--){
			std_tab += "\t";
		}
		builder.append("\n"+std_tab+"ExpressionNode");
		term.buildString(builder,tabs+1);
		builder.append("\n"+std_tab+"\t"+sign);
		expr.buildString(builder,tabs+1);
	}
}
