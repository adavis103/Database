# CSCE315 Part 1 Submission:

### Github Repository for Team 13: https://github.tamu.edu/adavis103/CSCE315Project2
#### Team 13 Github for directly to the Development Log wiki: https://github.tamu.edu/adavis103/CSCE315Project2/wiki/Development-Log

## Run Instructions:
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


## Test Program:

```
CREATE TABLE animals (name VARCHAR(20), kind VARCHAR(8), years INTEGER) PRIMARY KEY (name, kind);

INSERT INTO animals VALUES FROM ("Joe", "cat", 4);
INSERT INTO animals VALUES FROM ("Spot", "dog", 10);
INSERT INTO animals VALUES FROM ("Snoopy", "dog", 3);
INSERT INTO animals VALUES FROM ("Tweety", "bird", 1);
INSERT INTO animals VALUES FROM ("Joe", "bird", 2);

SHOW animals;

dogs <- select (kind == "dog") animals;
old_dogs <- select (age > 10) dogs;

cats_or_dogs <- dogs + (select (kind == "cat") animals);

CREATE TABLE species (kind VARCHAR(10)) PRIMARY KEY (kind);

INSERT INTO species VALUES FROM RELATION project (kind) animals;

a <- rename (aname, akind) (project (name, kind) animals);
common_names <- project (name) (select (aname == name && akind != kind) (a * animals));
answer <- common_names;

SHOW answer;

WRITE animals;
CLOSE animals;

EXIT;
```
