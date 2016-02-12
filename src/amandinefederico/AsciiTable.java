package amandinefederico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AsciiTable {
    private String[][] asciiTable;
    //TODO Compter nb lignes dans fichier pour créer variable ?

    public AsciiTable(File asciiFile) throws FileNotFoundException {
        translateFileIntoTable(asciiFile);
    }

    public AsciiTable(String filePath) throws FileNotFoundException {
        translateFileIntoTable(new File(filePath));
    }

    private void translateFileIntoTable(File asciiFile) throws FileNotFoundException {
        Scanner reader = new Scanner(asciiFile);
        String line;
        String[] bits;
        reader.useDelimiter("\n");
        asciiTable = new String[257][7];
        for(int i = 0; i < 257; ++i) {
            if (reader.hasNext()) {
                line = reader.next();
                bits = line.split(",");
                System.arraycopy(bits, 0, asciiTable[i], 0, 7);
/*                for (int j = 0; j < 7; ++j) {
                    asciiTable[i][j] = bits[j];

                }*/
            }
        }
    }

    public String toHex(char symbol) {
        int hexColumn = -1, symbolColumn = -1, wantedLine = -1;
        for(int i = 0; i < 7; ++i) {
            if(asciiTable[0][i].equals("HEX"))
                hexColumn = i;
            if(asciiTable[0][i].equals("SYMBOL"))
                symbolColumn = i;
            if(hexColumn != -1 && symbolColumn != -1)
                break;
        }
        for(int i = 0; i < 257; ++i) {
            if(asciiTable[i][symbolColumn].equals(symbol))
                wantedLine = i;
            if(wantedLine != -1)
                break;
        }
        return asciiTable[wantedLine][hexColumn];
    }

    public String toString() {
        String output = "";
        for(int i = 0; i < 257; ++i) {
            for(int j = 0; j < 7; ++j) {
                output += asciiTable[i][j] + " | ";
            }
            output += "\n-\n";
        }
        return output;
    }
}
