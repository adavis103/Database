# CSCE315 Part 2 Submission:

### Github Repository for Team 13: https://github.tamu.edu/adavis103/CSCE315Project2
#### Team 13 Github for directly to the Development Log wiki: https://github.tamu.edu/adavis103/CSCE315Project2/wiki/Development-Log

## DB Engine Test Run Instructions:
#### 1. Compile all grammar.java files:

    javac DBEngineTest.java

#### 2. Run the Parser Program:

    java DBEngineTest

## Parser Test Run Instructions:
#### 1. Download ANTLR4 to the current directory:

    curl -O http://www.antlr.org/download/antlr-4.7.1-complete.jar

#### 2. Create ANTLR4 path:

    export CLASSPATH="antlr-4.7.1-complete.jar:$CLASSPATH"

    alias antlr4='java -Xmx500M -cp "antlr-4.7.1-complete.jar:$CLASSPATH" org.antlr.v4.Tool'

#### 3. Generate parser from grammar with ANTLR 4:

    antlr4 Grammar.g4

#### 4. Compile all grammar.java files:

    javac Grammar*.java

#### 5. Run the Parser Program:

    java GrammarParserTest

## Assumptions:
* Rename simply renames the column of the attribute
