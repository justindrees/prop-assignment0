package prop.assignment0;

import java.io.*;

public class Tokenizer implements ITokenizer {
	/**
	 * The tokenizer should call the Scanner to get a stream of characters, and from that stream of
	 * characters create a stream of lexemes/tokens. You should implement a Tokenizer class, which 
	 * implements the interface ITokenizer.
	 */
	private Scanner scanner;
	
	public Tokenizer() {
	}
	
	// Opens a file for tokenizing.
	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		scanner = new Scanner();
		scanner.open(fileName);
		scanner.moveNext();
		/*
		 * assign = id , '=' , expr , ';' 
		 * expr = term , [ ( '+' | '-' ) , expr ]  
		 * term = factor , [ ( '*' | '/') , term] 
		 * factor = int | '(' , expr , ')' 
		 */
	}

	// Returns the current token in the stream.
	@Override
	public Lexeme current() {
		// Figure out if char is assign, expr, term, or factor
		// Create Lexeme(Object value, Token token)
			// NULL, IDENT, INT_LIT, ADD_OP, SUB_OP, MULT_OP, DIV_OP, ASSIGN_OP, 
			// LEFT_PAREN, RIGHT_PAREN, SEMICOLON, LEFT_CURLY, RIGHT_CURLY, EOF
		char firstChar = scanner.current();
		int firstCharType = Character.getType(firstChar);
		if (Character.isLetter(firstChar) || firstChar == '$' || firstChar == '_') {
			//Subsequent characters may be letters, digits, dollar signs, or underscore characters
			boolean continueLoop = true;
			while (continueLoop) {
				
			}
		}

		if (Character.isDigit(firstChar)) {
			boolean continueLoop = true;
			while (continueLoop) {
				
			}
		}

		if (Character.isSpaceChar(firstChar) || Character.isWhitespace(firstChar)) {
		}

		if (firstCharType == Character.MATH_SYMBOL) {
			
		}

		if (firstCharType == Character.CONNECTOR_PUNCTUATION) {
			
		}
		/*
		if (firstChar == null) {
			
		}
		
		if (firstChar == EOF) {
		
		}*/
		return null;
	}

	// Moves current to the next token in the stream.
	@Override
	public void moveNext() throws IOException, TokenizerException {
		// TODO
		// If scanner.MoveNext() == EOF { this.close() }
	}

	// Closes the file and releases any system resources associated with it.
	@Override
	public void close() throws IOException {
		scanner.close();
	}

}
