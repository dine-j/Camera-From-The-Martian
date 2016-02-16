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

    /**
     * Constructor for the "virtual" AsciiTable, takes a file as a parameter
     * It takes the file, translates it in a two dimensional array,
     * and also put the hexadecimal values and the symbols in a map for optimization of searching process
     * @param asciiFile File containing the translation table
     * @throws FileNotFoundException    If file is absent, warns user
     */
    public AsciiTable(File asciiFile) throws FileNotFoundException {
        translateFileIntoTable(asciiFile);
        tableToMap();
    }

    /**
     * Constructor for the "virtual" AsciiTable, takes the file path as a parameter
     * It takes the file, translates it in a two dimensional array,
     * and also put the hexadecimal values and the symbols in a map for optimization of searching process
     * @param filePath  Path of the wanted file
     * @throws FileNotFoundException    If file is absent, warns user
     */
    public AsciiTable(String filePath) throws FileNotFoundException {
        translateFileIntoTable(new File(filePath));
        tableToMap();
    }

    /**
     * Translates the file into a two dimensional array
     * @param asciiFile     The file containing the table for translation
     * @throws FileNotFoundException If file is absent, warns user
     */
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
                for(int j = 0; j < MAX_COLUMN; ++j) {
                    asciiTable[i][j] = bits[j];
                }
            }
        }
    }

    /**
     * Translate the two dimensional array into a map of hexadecimals and symbols to optimize the searching process
     */
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

    /**
     * Method to translate a symbol into its hexadecimal value
     * @param symbol    Symbol to be translated
     * @return  Hexadecimal translation
     */
    public String toHex(String symbol) {
        return symbolToHexMap.get(symbol);
    }

    /**
     * toString method to print the table in a readable way
     * @return  The String representation of the ASCII table
     */
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
