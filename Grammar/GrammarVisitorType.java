// Generated from Grammar.g4 by ANTLR 4.7.1

package Grammar;

import org.antlr.v4.runtime.*;

/**
 * This class provides an empty implementation of {@link GrammarListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class GrammarVisitorType extends GrammarBaseVisitor<Class> {
    @Override
    public Class visitType(GrammarParser.TypeContext ctx) {
        if (ctx.getChild(0).getText() == "Integer")
            return Integer.class;
        return String.class;
    }
}
