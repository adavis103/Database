import Grammar.*;
import org.antlr.v4.runtime.*;  //  imports the ANTLR4 version of the Grammar

public class GrammarParserTest {
    public static void main(String[] args) {
        String curLine;  //  string representation of current input line
        do {
            System.out.println("Enter in the command or query to test. If you wish to quit, enter quit: \n");
            curLine = System.console().readLine();  //  reads input from command line
            if(!curLine.toUpperCase().equals("QUIT")) {  //  checks if user has quit operations
                GrammarParser parser = new GrammarParser(new CommonTokenStream(new GrammarLexer(CharStreams.fromString(curLine))));  //  creates a parser based on the lexer, using current line as its token stream
                GrammarParseVisitor visitor = new GrammarParseVisitor();
                visitor.visit(parser.program());  //  initiates the parsing
                int invalidHits = parser.getNumberOfSyntaxErrors();
                if(invalidHits > 0)  //  if any hits are returned, the input was invalid according to the grammar
                    System.out.println("The input given is invalid. The number of syntax errors is " + invalidHits + "\n");
                else  //  successful parsing
                    System.out.println("Input is valid\n");
            }
        } while(!curLine.toUpperCase().equals("QUIT"));  //  quits when input is equal to "quit"
    }
}
