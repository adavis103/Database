import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import DBTypes.*;

// Will be creating the domain, attributes, database, tuples, relations, etc.

// (P) stands for professor, so the string values before this represent
// the professors name

// M,T,W,R,F stands for the lecture day
// the integers with strings and - after the lecture day will be the 
// lecture time, and the integers with - and / after (P) are the days the 
// specified course will be lasting and the following string after
// the days will be the course location

public class parsingcsv {

    public static void main(String[] args) {
        try {
            String csvFile = "RelationFiles/Class-Schedule-18spring-XML.txt";  //source file
            Scanner input = new Scanner(new FileInputStream(csvFile));
            String line;
            String cvsSplitBy = ";";
            Vector<String> skips = new Vector<String>();  //creates skips that will bypass useless lines
            skips.add("CRN;Subj;Crse;Sec;Cmp;Cred;Title;Days;Time;Cap;Act;Rem;Instructor;Date (MM/DD);Location;Attribute");
            skips.add(";;;;;;;;;;;;Click name to see CV;;;");
            skips.add(";;;;;;(Restrictions/Details);;;;;;;;;");
            Database db = new Database();
            String curRelationName = null;
            Vector<Attribute> curAttributes;
            Vector<Domain<?>> domains = new Vector<Domain<?>>();  //creates the main domains used in the file
            domains.add(new Domain<Integer>(Integer.class, "CRN"));
            domains.add(new Domain<String>(String.class, "Subj"));
            domains.add(new Domain<String>(String.class, "Crse"));
            domains.add(new Domain<String>(String.class, "Sec"));
            domains.add(new Domain<String>(String.class, "Cmp"));
            domains.add(new Domain<String>(String.class, "Cred"));
            domains.add(new Domain<String>(String.class, "Title"));
            domains.add(new Domain<String>(String.class, "Days"));
            domains.add(new Domain<String>(String.class, "Time"));
            domains.add(new Domain<Integer>(Integer.class, "Cap"));
            domains.add(new Domain<Integer>(Integer.class, "Act"));
            domains.add(new Domain<Integer>(Integer.class, "Rem"));
            domains.add(new Domain<String>(String.class, "Instructor"));
            domains.add(new Domain<String>(String.class, "Date_(MM/DD)"));
            domains.add(new Domain<String>(String.class, "Location"));
            domains.add(new Domain<String>(String.class, "Attribute"));
            while (input.hasNextLine()) {
                line = input.nextLine();
                // use comma as separator
                if(skips.contains(line) || line.startsWith(";;;;;;;"))  //catches skipped lines
                    continue;
                Vector<String> info = new Vector<String>(Arrays.asList(line.split(cvsSplitBy)));

                System.out.println(info.size());
                //relation name
                if(info.size() == 1) {  //catches the lines to be turned into relation headers
                    curRelationName = info.get(0).substring(0,4);
                    db.create(curRelationName, domains, domains.get(0).getName());
                }
                else {  //catches all major "CRN" lines
                    Vector<Attribute> attrList = new Vector<Attribute>();
                    if (info.size() == 15) {
                        info.add("N/A");
                    }
                    for(int i = 0; i < info.size(); i++) {
                        if(domains.get(i).getType() == Integer.class) {
                            if(info.get(i) == null)
                                attrList.add(new Attribute(domains.get(i), 0));
                            else
                                attrList.add(new Attribute(domains.get(i), Integer.parseInt(info.get(i))));
                        }
                        else {
                            if(info.get(i) == null){
                                attrList.add(new Attribute(domains.get(i), ""));
                            }
                            else {
                                //concatenate strings with underscores
                                String s = info.get(i);
                                s = s.replaceAll(" ", "_");
                                attrList.add(new Attribute(domains.get(i), s));

                                if (i == 7 && info.get(i).equals("")) { //puts TBA in both Day/Time
                                    attrList.get(i).setValue("TBA");
                                }
                            }
                        }
                    }
                    db.insert(curRelationName, attrList);  //adds new values to db
                }
            }
            db.exit();  //on exit it generates the files
        }
        catch (Exception e){  //something went wrong
            System.out.println("OUCH");
        }
    }

}
