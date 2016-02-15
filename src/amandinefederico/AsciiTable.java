package amandinefederico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AsciiTable {
    private String[][] asciiTable;
    private int MAX_ROW = 257, MAX_COLUMN = 7;
    private Map<String, String> symbolToHexMap;

    public AsciiTable(File asciiFile) throws FileNotFoundException {
        translateFileIntoTable(asciiFile);
        tableToMap();
    }

    public AsciiTable(String filePath) throws FileNotFoundException {
        translateFileIntoTable(new File(filePath));
        tableToMap();
    }

    private void translateFileIntoTable(File asciiFile) throws FileNotFoundException {
        Scanner reader = new Scanner(asciiFile);
        reader.useDelimiter("\n");

        String line;
        String[] bits;
        asciiTable = new String[MAX_ROW][MAX_COLUMN];

        for(int i = 0; i < MAX_ROW; ++i) {
            if (reader.hasNext()) {
                line = reader.next();
                bits = line.split(",");
                //System.arraycopy(bits, 0, asciiTable[i], 0, MAX_COLUMN);
                for(int j = 0; j < MAX_COLUMN; ++j) {
                    asciiTable[i][j] = bits[j];
                }
            }
        }
    }

    private void tableToMap() {
        symbolToHexMap = new HashMap<String, String>();
        int hexColumn = -1, symbolColumn = -1;
        for(int i = 0; i < MAX_COLUMN; ++i) {
            if(asciiTable[0][i].equals("HEX"))
                hexColumn = i;
            if(asciiTable[0][i].equals("Symbol"))
                symbolColumn = i;
            if(hexColumn != -1 && symbolColumn != -1)
                break;
        }
        for(int i = 0; i < MAX_ROW; ++i) {
            symbolToHexMap.put(asciiTable[i][symbolColumn], asciiTable[i][hexColumn]);
        }
    }

    public String toHex(String symbol) {
        return symbolToHexMap.get(symbol);
    }

    public String toString() {
        String output = "";
        for(int i = 0; i < MAX_ROW; ++i) {
            for(int j = 0; j < MAX_COLUMN; ++j) {
                output += asciiTable[i][j] + " | ";
            }
            output += "\n-\n";
        }
        return output;
    }
}
