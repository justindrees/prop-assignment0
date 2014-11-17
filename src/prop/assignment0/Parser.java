package prop.assignment0;

import java.io.IOException;

public class Parser implements IParser {
	
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
	public INode parse() throws IOException, TokenizerException, ParserException {
		// TODO 
		return null;
	}

	// Closes the file and releases any system resources associated with it.
	@Override
	public void close() throws IOException {
		// TODO 
	}
}
