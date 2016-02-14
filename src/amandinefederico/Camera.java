package amandinefederico;
import javax.swing.JLabel;
import javax.swing.JSlider;
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
	
	public void move(int[] positions){
		for(int i=0; i<positions.length; i++){
			setValue(i);
			
			try {
			    Thread.sleep(1000);
			} catch (InterruptedException e) {
				//nothing
			}
		}
		setValue(15);
	}
	
	
	
}
