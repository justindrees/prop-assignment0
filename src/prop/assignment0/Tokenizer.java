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
		//int scanner.current()Type = Character.getType(scanner.current());
		String lexemeToCreate = "";
		if(scanner.current() == ' '){		// remove whitespaces
			scanner.moveNext();
		}
		// Code to read in lexeme if it is type IDENT 
		if (Character.isLetter(scanner.current()) || scanner.current() == '$' || scanner.current() == '_') {
			//Subsequent characters may be letters, digits, dollar signs, or underscore characters
			boolean continueLoop = true;
			while (continueLoop == true) {
				// Use scanner.moveNext() to read in subsequence characters of the lexeme
				// Concatenate those characters:  lexemeToCreate += nextCharacter;
				// Find character that is not letters, digits, dollar signs, or underscore characters
				// Then you know the lexeme ends before this character
				// Add the whole lexeme to the arraylist tokens

				lexemeToCreate += scanner.current();
				scanner.moveNext();
				if(scanner.current() == ' '){
					continueLoop = false;
					currentLexeme = new Lexeme(lexemeToCreate,Token.IDENT);
					lexemeToCreate = "";
				}
			}
		}else if (Character.isDigit(scanner.current())) {	// Code to read in lexeme if it's type INT_LIT
			boolean continueLoop = true;
			while (continueLoop) {
				// Use scanner.moveNext() to read in subsequence characters of the lexeme
				// Concatenate those characters:  lexemeToCreate += nextCharacter;
				// Find character that is not a digit
				// Then you know the lexeme ends before this character
				// Add the whole lexeme to the arraylist tokens
				lexemeToCreate += scanner.current();
				scanner.moveNext();
				if(scanner.current() == ' ' || scanner.current() == ';' || scanner.current() == ')'){
					continueLoop = false;
					currentLexeme = new Lexeme(lexemeToCreate,Token.INT_LIT);
					lexemeToCreate = "";
				}
			}

		}/*else if (scanner.current() == null) {		// How do you handle null?
			currentLexeme = new Lexeme(lexemeToCreate,Token.NULL);
		}*/else if (scanner.current() == '+') {
			currentLexeme = new Lexeme('+',Token.ADD_OP);
			scanner.moveNext();
		}else if (scanner.current() == '-') {
			currentLexeme = new Lexeme('-',Token.SUB_OP);
			scanner.moveNext();
		}else if (scanner.current() == '*') {
			currentLexeme = new Lexeme('*',Token.MULT_OP);
			scanner.moveNext();
		}else if (scanner.current() == '/') {
			currentLexeme = new Lexeme('/',Token.DIV_OP);
			scanner.moveNext();
		}else if (scanner.current() == '=') {
			currentLexeme = new Lexeme('=',Token.ASSIGN_OP);
			scanner.moveNext();
		}else if (scanner.current() == '(') {
			currentLexeme = new Lexeme('(',Token.LEFT_PAREN);
			scanner.moveNext();
		}else if (scanner.current() == ')') {
			currentLexeme = new Lexeme(')',Token.RIGHT_PAREN);
			scanner.moveNext();
		}else if (scanner.current() == ';') {
			currentLexeme = new Lexeme(';',Token.SEMICOLON);
			scanner.moveNext();
		}else if (scanner.current() == '{') {
			currentLexeme = new Lexeme('{',Token.LEFT_CURLY);
			scanner.moveNext();
		}else if (scanner.current() == '}') {
			currentLexeme = new Lexeme('}',Token.RIGHT_CURLY);
			scanner.moveNext();
		}/*else if (scanner.current() == Token.EOF) {			// how can EOF be defined?
			currentLexeme = new Lexeme(lexemeToCreate,Token.EOF);
		}*/
		
		// If scanner.MoveNext() == EOF { this.close() }
		
		/*else if (scanner.current()Type == Character.MATH_SYMBOL) { // Code to read in lexeme if it's type ADD_OP, SUB_OP, MULT_OP, DIV_OP
		}else if (scanner.current()Type == Character.CONNECTOR_PUNCTUATION) {
		}else if (scanner.current() == '=') { // Code to read in lexeme if it's type ASSING_OP
		}else if (Character.isSpaceChar(scanner.current()) || Character.isWhitespace(scanner.current())) {

		}*/
	}

	// Closes the file and releases any system resources associated with it.
	@Override
	public void close() throws IOException {
		scanner.close();
	}
}
