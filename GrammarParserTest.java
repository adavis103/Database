import DBTypes.Database;
import Grammar.*;
import org.antlr.v4.runtime.*;  //  imports the ANTLR4 version of the Grammar
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.Scanner;

public class GrammarParserTest {
    public static void main(String[] args) {
        String curLine;  //  string representation of current input line
        Database db = new Database();
        do {
            System.out.println("\nEnter in the command or query to test. If you wish to quit, enter quit: \n");
            //curLine = System.console().readLine();  //  reads input from command line

            Scanner s = new Scanner(System.in);
            curLine = s.nextLine();
            if (!curLine.toUpperCase().equals("QUIT")) {  //  checks if user has quit operations
                GrammarParser parser = new GrammarParser(new CommonTokenStream(new GrammarLexer(CharStreams.fromString(curLine))));  //  creates a parser based on the lexer, using current line as its token stream
                GrammarVisitorProgram visitor = new GrammarVisitorProgram(db);
                ParseTree t = parser.program();
				
				int invalidHits = parser.getNumberOfSyntaxErrors();
                if (invalidHits > 0)  //  if any hits are returned, the input was invalid according to the grammar
                    System.out.println("The input given is invalid. The number of syntax errors is " + invalidHits + "\n");
                else  //  successful parsing
                    t.accept(visitor);
            }
        } while (!curLine.toUpperCase().equals("QUIT"));  //  quits when input is equal to "quit"
    }
}
