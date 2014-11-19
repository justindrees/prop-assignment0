package prop.assignment0;

import java.io.*;
import java.util.ArrayList;

public class Tokenizer implements ITokenizer {
	/**
	 * The tokenizer should call the Scanner to get a stream of characters, and from that stream of
	 * characters create a stream of lexemes/tokens. You should implement a Tokenizer class, which 
	 * implements the interface ITokenizer.
	 */
	private Scanner scanner;
	private Lexeme currentLexeme;
	ArrayList<Lexeme> tokens = new ArrayList<Lexeme>();
	
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
		return currentLexeme;
	}

	// Moves current to the next token in the stream.
	@Override
	public void moveNext() throws IOException, TokenizerException {
		// Figure out if char is assign, expr, term, or factor
		// Create Lexeme(Object value, Token token)

		char firstChar = scanner.current();
		int firstCharType = Character.getType(firstChar);
		String lexemeToCreate;
		
		// Code to read in lexeme if it is type IDENT 
		if (Character.isLetter(firstChar) || firstChar == '$' || firstChar == '_') {
			//Subsequent characters may be letters, digits, dollar signs, or underscore characters
			boolean continueLoop = true;
			while (continueLoop) {
				// Use scanner.moveNext() to read in subsequence characters of the lexeme
				// Concatenate those characters:  lexemeToCreate += nextCharacter;
				// Find character that is not letters, digits, dollar signs, or underscore characters
				// Then you know the lexeme ends before this character
				// Add the whole lexeme to the arraylist tokens
			}
		}

		// Code to read in lexeme if it's type INT_LIT
		if (Character.isDigit(firstChar)) {
			boolean continueLoop = true;
			while (continueLoop) {
				// Use scanner.moveNext() to read in subsequence characters of the lexeme
				// Concatenate those characters:  lexemeToCreate += nextCharacter;
				// Find character that is not a digit
				// Then you know the lexeme ends before this character
				// Add the whole lexeme to the arraylist tokens
			}
		}

		// Code to read in lexeme if it's type ADD_OP, SUB_OP, MULT_OP, DIV_OP
		if (firstCharType == Character.MATH_SYMBOL) {
			
		}

		if (firstCharType == Character.CONNECTOR_PUNCTUATION) {
			
		}
		
		// Code to read in lexeme if it's type ASSIGN_OP
		if (firstChar == '=') {
			
		}
		
		if (Character.isSpaceChar(firstChar) || Character.isWhitespace(firstChar)) {

		}
		
		// TODO: Add if-statements for:
		//	NULL, LEFT_PAREN, RIGHT_PAREN, SEMICOLON, LEFT_CURLY, RIGHT_CURLY, EOF
		/*
		if (firstChar == null) {
			
		}
		
		if (firstChar == EOF) {
		
		}*/
		
		// If scanner.MoveNext() == EOF { this.close() }
	}

	// Closes the file and releases any system resources associated with it.
	@Override
	public void close() throws IOException {
		scanner.close();
	}

}
