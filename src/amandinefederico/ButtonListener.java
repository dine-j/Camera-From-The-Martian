package amandinefederico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.soap.Text;

public class ButtonListener implements ActionListener {

	private JTextArea inputBox;
	private int[] output;
	private TextToCamera decoder;
	private Camera camera;
	
	public ButtonListener(JTextArea inputBox, TextToCamera decoder, Camera camera) {
		this.inputBox = inputBox;
		this.decoder = decoder;
		this.camera = camera;
	}

	public void actionPerformed(ActionEvent e) {
		decodeMessage(inputBox.getText());
		camera.move(output);
	}

	private void decodeMessage(String message) {
		decoder.setTextToDecode(message);
		decoder.translateTextToPositions();
		output = decoder.getPositionsForCamera();
	}
}