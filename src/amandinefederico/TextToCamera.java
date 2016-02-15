package amandinefederico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextToCamera {
    private String textToDecode;
    private AsciiTable tableToDecrypt;
    private Map<String, Integer> hexValues;
    private int[] positionsForCamera;

    public TextToCamera(AsciiTable tableToDecrypt) {
        this.tableToDecrypt = tableToDecrypt;
        createMapHexValues();
    }

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

    public void translateTextToPositions() {
        translateHexToPositions();
    }

    private String[] translateTextToHex() {
        String[] hex = new String[textToDecode.length()];
        for(int i = 0; i < hex.length; ++i) {
            hex[i] = tableToDecrypt.toHex(String.valueOf(textToDecode.charAt(i)));
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
        positionsForCamera = new int[2*hex.length];
        //ArrayList<Integer> positionsList = new ArrayList<Integer>();

        for(int i = 0; i < hex.length; ++i) {
            positionsForCamera[2*i] = hexValues.get(String.valueOf(hex[i].charAt(0)));
            positionsForCamera[2*i+1] = hexValues.get(String.valueOf(hex[i].charAt(1)));
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
