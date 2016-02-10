package amandinefederico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonListener implements ActionListener {

	private JTextArea inputBox;
	private int[] output;
	
	public ButtonListener(JTextArea inputBox) {
		
		String input = inputBox.getText();
		
		Scanner scanner = Scanner(File )
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. read numbers from text fields
		String sNum1 = num1.getText();
		float flNum1 = Float.parseFloat(sNum1);
		
		String sNum2 = num2.getText();
		float flNum2 = Float.parseFloat(sNum2);
		
		// 2. compute the sum
		float flSum = flNum1 + flNum2;
		
		// 3. change the label text to show the sum
		output.setText(Float.toString(flSum));
	}

}