package amandinefederico;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Observable;

public class Camera extends JSlider {

	private JFrame frame;

	/**
	 * Camera constructor, takes a JFrame as a parameter
	 * Construct the slider with labels from 0 to F
	 * @param frame	The main frame
     */
	public Camera(JFrame frame) {
		super(0,15,0);
		this.frame = frame;

		Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>(16);
		for(int i = 0; i < 10; ++i) {
			labels.put(i, new JLabel(String.valueOf(i)));
		}
		labels.put(10, new JLabel("A"));
		labels.put(11, new JLabel("B"));
		labels.put(12, new JLabel("C"));
		labels.put(13, new JLabel("D"));
		labels.put(14, new JLabel("E"));
		labels.put(15, new JLabel("F"));
				
		setLabelTable(labels);
		setPaintLabels(true);
	}

	/**
	 * Moves the slider sequentially according to input positions in a separate thread and makes sure the title is updated in consequence
	 * @param positions	Array of integers
     */
	public void move(final int[] positions) {
		final SwingWorker<Void, Void> cameraThreadWorker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				frame.setTitle("Sending...");
				for(int i = 0; i < positions.length; i++) {
					setValue(positions[i]);

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				frame.setTitle("Communication");
				return null;
			}
		};

		cameraThreadWorker.execute();
	}
	
	
	
}
