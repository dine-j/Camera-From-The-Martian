package amandinefederico;

import java.util.HashMap;
import java.util.Map;

public class TextToCamera {
    private String textToDecode;
    private AsciiTable tableToDecrypt;
    private Map<String, Integer> hexValues;
    private int[] positionsForCamera;

    /**
     * Constructor for the TextToCamera, takes the table for translation
     * Calls a method to create a map between hexedecimal values and corresponding decimal value for optimization of the searching process
     * @param tableToDecrypt    Table for translation
     */
    public TextToCamera(AsciiTable tableToDecrypt) {
        this.tableToDecrypt = tableToDecrypt;
        createMapHexValues();
    }

    /**
     * Method to create a map between hexedecimal values and corresponding decimal value for optimization of the searching process
     *
     */
    private void createMapHexValues() {
        hexValues = new HashMap<String, Integer>();
        for(int i = 0; i < 10; ++i) {
            hexValues.put(""+i, i);
        }
        hexValues.put("A", 10);
        hexValues.put("B", 11);
        hexValues.put("C", 12);
        hexValues.put("D", 13);
        hexValues.put("E", 14);
        hexValues.put("F", 15);
    }

    /**
     * Translates a text to integer positions for the Camera
     */
    public void translateTextToPositions() {
        translateHexToPositions();
    }

    /**
     * Translates each character in a text to its corresponding hexadecimal value
     * @return Array of hexadecimal values
     */
    private String[] translateTextToHex() {
        String[] hex = new String[textToDecode.length()];
        for(int i = 0; i < hex.length; ++i) {
            if(!String.valueOf(textToDecode.charAt(i)).equals(" ") && !String.valueOf(textToDecode.charAt(i)).equals("\n"))
                hex[i] = tableToDecrypt.toHex(String.valueOf(textToDecode.charAt(i)));
            else
                hex[i] = "20";
        }

        return hex;
    }

    /**
     * Translates two characters in hexadecimal to their respective integer values
     */
    private void translateHexToPositions(){
        String[] hex = translateTextToHex();
        positionsForCamera = new int[2*hex.length];

        for(int i = 0; i < hex.length; ++i) {
            positionsForCamera[2*i] = hexValues.get(String.valueOf(hex[i].charAt(0)));
            positionsForCamera[2*i+1] = hexValues.get(String.valueOf(hex[i].charAt(1)));
        }
    }

    /**
     * Gets the integer positions for the Camera
     * @return Array of integers
     */
    public int[] getPositionsForCamera() {
        return positionsForCamera;
    }

    /**
     * Sets the text to be decoded
     * @param incomingText  Text to be decoded
     */
    public void setTextToDecode(String incomingText) {
        textToDecode = incomingText;
    }
}
