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
		return new AssignmentNode(tn);
	}
	// Closes the file and releases any system resources associated with it.
	@Override
	public void close() throws IOException {
		tn.close();
	}

}