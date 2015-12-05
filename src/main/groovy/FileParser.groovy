package main.groovy

/**
 * Created by Dzianis_Padbiarezski on 11/11/2015.
 */

def lineNumber = 0;
int fileNumber = 100001;
int counter = 0;

File file = new File("e:" + File.separator + "sql12" + File.separator + "v100000.sql");

new File('../../../wl_v1112.sql').eachLine { line ->

//    lineNumber++;
    counter++;
    file << line << "\n"

//    if (fileNumber > 107496) {
//        if (line.length() == 0 || line[line.length() - 1] == ";") {
//            file = null;
//            file = new File(String.format("e:" + File.separator + "sql" + File.separator + "v%s.sql", fileNumber));
//            counter = 0;
//            fileNumber++;
//        }
//    }
if (counter >= 600 && (line.length() == 0 || line[line.length() - 1] == ";")) {
        file = null;
        file = new File(String.format("e:" + File.separator + "sql12" + File.separator + "v%s.sql", fileNumber));
        counter = 0;
        fileNumber++;
    }

//    if (lineNumber == 300) System.exit(0);
}
