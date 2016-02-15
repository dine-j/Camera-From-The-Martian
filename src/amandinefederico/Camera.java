package amandinefederico;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class Camera extends JSlider {
	
	Hashtable<Integer, JLabel> labels;
	
	public Camera() {
		super(0,15,0);
		
		labels = new Hashtable<Integer, JLabel>(16);
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
	
	public void move(final int[] positions) {
/*		final Timer timer = new Timer(2000, new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

			}
		});

		ActionListener listener = new ActionListener() {
			int counter = 0;

			public void actionPerformed(ActionEvent actionEvent) {
				if(counter == positions.length)
					timer.stop();
				else {
					setValue(positions[counter]);
					counter++;
				}
			}
		};
		timer.addActionListener(listener);
		timer.start();*/

		final SwingWorker<Void, Void> cameraThreadWorker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				for(int i = 0; i < positions.length; i++) {
					setValue(positions[i]);

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				return null;
			}
		};

		cameraThreadWorker.execute();

/*		for(int i = 0; i < positions.length; i++){
			setValue(positions[i]);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	
	
}
