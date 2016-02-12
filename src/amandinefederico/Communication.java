package amandinefederico;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

public class Communication extends JFrame {
	
	public Communication(){
		super("Communication");
		setLayout(new BorderLayout());
		
		JTextArea input = new JTextArea();
		Camera camera = new Camera();
		JButton jbSend = new JButton("Send");
		
		add(camera, BorderLayout.NORTH);
		add(new JScrollPane(input), BorderLayout.CENTER);
		add(jbSend, BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void main(String args[]) throws FileNotFoundException {
		AsciiTable table = new AsciiTable("/media/acelis/Data1/Dropbox/CS 1st year/Programming Applications/Courseworks/Coursework 2/src/ascii_table.csv");
		System.out.println(table);
	}


}
