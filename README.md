# CSCE315 Part 2 Submission:

### Github Repository for Team 13: https://github.tamu.edu/adavis103/CSCE315Project2
#### Team 13 Github for directly to the Development Log wiki: https://github.tamu.edu/adavis103/CSCE315Project2/wiki/Development-Log

## DB Engine Test Run Instructions:
#### 1. Download ANTLR4 to the current directory:

    curl -O http://www.antlr.org/download/antlr-4.7.1-complete.jar

#### 2. Create ANTLR4 path:

    export CLASSPATH="antlr-4.7.1-complete.jar:$CLASSPATH"

    alias antlr4='java -Xmx500M -cp "antlr-4.7.1-complete.jar:$CLASSPATH" org.antlr.v4.Tool'

#### 3. Compile all .java files:

    javac *.java

#### 4. Run the Database File Parser:

    java parsingcsv

#### 5. Run GrammarParserTest to input commands:

    java GrammarParserTest

## Assumptions:
* Rename simply renames the column of the attribute
