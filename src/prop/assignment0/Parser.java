package prop.assignment0;

import java.io.IOException;
import java.util.ArrayList;

public class Parser implements IParser {
	
	Tokenizer tn = new Tokenizer();
	ArrayList<INode> parseTree = new ArrayList<INode>();
	
	
	public Parser() {	
	}
	// Opens a file for parsing.
	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		tn.open(fileName);
	}
	// Parses a program from file returning a parse tree (the root node of a parse tree).
	@Override
	public INode parse() throws IOException, TokenizerException, ParserException {		// use tn.current() and tn.moveNext()	
		tn.moveNext();
		INode n = assign();
		return n;
	}
	private AssignmentNode assign() throws IOException, TokenizerException, ParserException{
		// assign = id , = , expr ,;
		String id = "";
		if(tn.current().token() == Token.IDENT){
			id = (String) tn.current().value();
			tn.moveNext();
			if(tn.current().token() == Token.ASSIGN_OP){
				tn.moveNext();
				ExpressionNode n = expr();
				if(tn.current().token() == Token.SEMICOLON){
					AssignmentNode n2 = new AssignmentNode(id,n);		// TABS for correct buildString??
					parseTree.add(n);
					return n2;
				}
			}
		}
		throw new ParserException("Syntax error. ParserException in assign() ");
	}
	private ExpressionNode expr() throws IOException, TokenizerException{
		// expr = term, + || -, expr
		tn.moveNext();
		char sign = ' ';
		//INode n = term();
		if(tn.current().token() == Token.ADD_OP){
			tn.moveNext();
			sign = '+';
		}
		if(tn.current().token() == Token.SUB_OP){
			sign = '-';
			tn.moveNext();
		}
		//ExpressionNode n2 = new ExpressionNode(n, ExpressionNode expr,sign);
		//INode n2 = expr();
		//return n2;
		return null;
		//throw new ParserException("Syntax error. ParserException in expr() ");
	}
	private TermNode term() throws IOException, TokenizerException, ParserException{
		// term = factor, * | /, term
		char sign = ' ';
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
	}
	private FactorNode factor() throws IOException, TokenizerException{
		// factor = int | (, expr ,)
		/*if(tn.current().token() == Token.INT_LIT){
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
			*/

		
		return new FactorNode();
		//throw new ParserException("Syntax error. ParserException in factor() ");
	}
	// Closes the file and releases any system resources associated with it.
	@Override
	public void close() throws IOException {
		tn.close();
	}
}