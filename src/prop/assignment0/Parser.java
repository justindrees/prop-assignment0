package prop.assignment0;

import java.io.IOException;
import java.util.ArrayList;

public class Parser implements IParser {
	
	Tokenizer tn = new Tokenizer();
	ArrayList<Lexeme> parseTree = new ArrayList<Lexeme>();
	
	
	public Parser() {	
	}
	// Opens a file for parsing.
	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		Tokenizer tokenizer = new Tokenizer();
		tokenizer.open(fileName);
	}
	// Parses a program from file returning a parse tree (the root node of a parse tree).
	@Override
	public INode parse() throws IOException, TokenizerException, ParserException {		// use tn.current() and tn.moveNext()
		tn.moveNext();
		INode n = assign();
		return n;
	}
	private AssignmentNode assign() throws IOException, TokenizerException{
		// assign = id , = , expr ,;
		if(tn.current().token() == Token.IDENT){
			parseTree.add(tn.current());
			tn.moveNext();
			if(tn.current().token() == Token.ASSIGN_OP){
				parseTree.add(tn.current());
				tn.moveNext();
				INode n = expr();
				//parseTree.add(/*lexeme?*/)
				if(tn.current().token() == Token.SEMICOLON){
					return n;
				}
			}
		}
		throw new ParserException("Syntax error. ParserException in assign() ");
	}
	private ExpressionNode expr() throws IOException, TokenizerException{
		// expr = term, + || -, expr
		tn.moveNext();
		INode n = term();
		if(tn.current().token() == Token.ADD_OP){
			parseTree.add(tn.current());
			tn.moveNext();
		}
		if(tn.current().token() == Token.SUB_OP){
			parseTree.add(tn.current());
			tn.moveNext();
		}
		INode n2 = expr();
		return n2;
		throw new ParserException("Syntax error. ParserException in expr() ");
	}
	private TermNode term() throws IOException, TokenizerException{
		// term = factor, * | /, term
		INode n = factor();
		if(tn.current().token() == Token.MULT_OP){
			parseTree.add(tn.current());
			tn.moveNext();
		}
		if(tn.current().token() == Token.DIV_OP){
			parseTree.add(tn.current());
			tn.moveNext();
		}
		return n;
		throw new ParserException("Syntax error. ParserException in term() ");
	}
	private FactorNode factor() throws IOException, TokenizerException{
		// factor = int | (, expr ,)
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
			
		}
		
		return new FactorNode();
		throw new ParserException("Syntax error. ParserException in factor() ");
	}
	// Closes the file and releases any system resources associated with it.
	@Override
	public void close() throws IOException {
		tn.close();
	}
}