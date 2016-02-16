package amandinefederico;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;

public class Communication extends JFrame {

	/**
	 * Constructor for the main communication frame, takes an ASCII file as a parameter
	 * Creates a frame with a JSlider as a camera, a JTextArea as a text box and a JButton to send text
	 * Creates a text decoder to be used in the translation process
	 * @param asciiFile	ASCII.csv file for translation purposes
     */
	public Communication(AsciiTable asciiFile){
		super("Communication");
		setLayout(new BorderLayout());

		TextToCamera textDecoder = new TextToCamera(asciiFile);
		
		JTextArea input = new JTextArea();
		Camera camera = new Camera(this);
		JButton jbSend = new JButton("Send");
		jbSend.addActionListener(new ButtonListener(input, textDecoder, camera));
		
		add(camera, BorderLayout.NORTH);
		add(new JScrollPane(input), BorderLayout.CENTER);
		add(jbSend, BorderLayout.SOUTH);

		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Main method
	 * @param args	Input from user not needed in this case
	 * @throws FileNotFoundException	Throws an exception if file not found
     */
	public static void main(String args[]) {
		AsciiTable table = null;
		try {
			table = new AsciiTable(new File("ascii_table.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		Communication app = new Communication(table);
	}
}
