package amandinefederico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextToCamera {
    private String textToDecode;
    private AsciiTable tableToDecrypt;
    private Map<Character, Integer> hexValues;
    private int[] positionsForCamera;

    public TextToCamera(String incomingText, AsciiTable tableToDecrypt) {
        textToDecode = incomingText;
        this.tableToDecrypt = tableToDecrypt;
        createMapHexValues();
        translateTextToPositions();
    }

    private void createMapHexValues() {
        hexValues = new HashMap<Character, Integer>();
        for(int i = 0; i < 10; ++i) {
            hexValues.put((char) i, i);
        }
        hexValues.put('A', 10);
        hexValues.put('B', 11);
        hexValues.put('C', 12);
        hexValues.put('D', 13);
        hexValues.put('E', 14);
        hexValues.put('F', 15);
    }

    private void translateTextToPositions() {
        translateHexToPositions();
    }

    private String[] translateTextToHex() {
        String[] hex = new String[textToDecode.length()];
        for(int i = 0; i < hex.length; ++i) {
            hex[i] = tableToDecrypt.toHex(textToDecode.charAt(i));
        }

/*        ArrayList<String> hexList = new ArrayList<String>();

        for(char c: textToDecode.toCharArray()) {
            hexList.add(tableToDecrypt.toHex(c));
        }

        String[] hex = new String[hexList.size()];
        hex = hexList.toArray(hex);*/

        return hex;
    }

    private void translateHexToPositions(){
        String[] hex = translateTextToHex();
        //ArrayList<Integer> positionsList = new ArrayList<Integer>();

        for(int i = 0; i < hex.length; ++i) {
            positionsForCamera[2*i] = hexValues.get(hex[i].charAt(0));
            positionsForCamera[2*i+1] = hexValues.get(hex[i].charAt(1));
        }

/*        for(int i = 0; i < hex.length; ++i) {
            for(char c: hex[i].toCharArray()) {
                positionsList.add(hexValues.get(c));
            }
        }

        positionsForCamera = new int[positionsList.size()];

        for(int i = 0; i < positionsForCamera.length; ++i) {
            positionsForCamera[i] = positionsList.get(i).intValue();
        }*/
    }

    public int[] getPositionsForCamera() {
        return positionsForCamera;
    }

    public void setTextToDecode(String incomingText) {
        textToDecode = incomingText;
    }
}
