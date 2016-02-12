package amandinefederico;

import java.awt.BorderLayout;

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
	
	
	
	public static void main(String args[]){
		Communication test = new Communication();
	}

}
