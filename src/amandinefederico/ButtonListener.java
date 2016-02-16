package amandinefederico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;
import javax.xml.soap.Text;

public class ButtonListener implements ActionListener {

	private JTextArea inputBox;
	private int[] output;
	private TextToCamera decoder;
	private Camera camera;

	/**
	 * Constructor for ButtonListener takes JTextArea from which to take the text input, TextToCamera object to be used for translation purposes,
	 * the Camera object to display the translation on the slider
	 * @param inputBox	JTextArea from which to take the text input
	 * @param decoder	Object to be used for translation purposes
	 * @param camera	Display the translation on the slider
     */
	public ButtonListener(JTextArea inputBox, TextToCamera decoder, Camera camera) {
		this.inputBox = inputBox;
		this.decoder = decoder;
		this.camera = camera;
	}

	/**
	 * Method in reaction to the Press Button Event
	 * It gets the text from the JTextArea text area, hides it and display the translation on the camera
	 * @param e	Event that triggers the method - here press button
     */
	public void actionPerformed(ActionEvent e) {
		decodeMessage(inputBox.getText());
		inputBox.setText("");
		camera.move(output);
	}

	/**
	 * Method to decode the input for the JTextArea in order to send it to the Camera
	 * @param message	Input from the JTextArea
     */
	private void decodeMessage(String message) {
		decoder.setTextToDecode(message);
		decoder.translateTextToPositions();
		output = decoder.getPositionsForCamera();
	}
}