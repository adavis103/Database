// Generated from Grammar.g4 by ANTLR 4.7.1

package Grammar;

import org.antlr.v4.runtime.*;
import DBTypes.*;
import java.util.Vector;
import java.io.*;

/**
 * This class provides an empty implementation of {@link GrammarListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class GrammarVisitorDomainList extends GrammarBaseVisitor<Vector<Domain<?>>> {

    @Override
    public Vector<Domain<?>> visitTyped_attribute_list(GrammarParser.Typed_attribute_listContext ctx) {
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        for (int i = 0; i < ctx.getChildCount(); i += 3) {
            String domainName = ctx.getChild(i).accept(new GrammarVisitorString());
            Class domainType = ctx.getChild(i + 1).accept(new GrammarVisitorType());
            Domain<?> domain;
            if(domainType == Integer.class)
                domain = new Domain<Integer>(Integer.class, domainName);
            else
                domain = new Domain<String>(String.class, domainName);
            domainList.add(domain);
        }
        return domainList;
    }
}
