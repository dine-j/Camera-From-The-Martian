package amandinefederico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class ButtonListener implements ActionListener {

	private String input;
	private int[] output;
	
	public ButtonListener(JTextArea inputBox) {
		input = inputBox.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		decodeMessage(input);
	}

	private void decodeMessage(String message) {

	}

}