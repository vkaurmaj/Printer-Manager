import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OSMainFrame extends JFrame {

	JButton start;
	JSlider speed;
	JLabel speedDisplay;
	static JLabel disks[] = new JLabel[mainClass.NUMBER_OF_DISKS];
	static JLabel users[] = new JLabel[mainClass.NUMBER_OF_USERS];
	static JLabel printers[] = new JLabel[mainClass.NUMBER_OF_PRINTERS];
	
	public OSMainFrame (String name) {
		super(name);
		setLayout(new GridBagLayout());		
		GridBagConstraints gc = new GridBagConstraints();
		Font font = new Font("Helvetica", Font.BOLD,16);
		
		gc.weightx = 0.5;
		gc.weighty = 0.5;

		for (int i = 0; i < mainClass.NUMBER_OF_DISKS; i++) {
			disks[i] = new JLabel("DISK" + (i + 1) + " - Available");
			disks[i].setFont(font);
			disks[i].setForeground(Color.RED);
			gc.gridx = 0;
			gc.gridy = i;
			add(disks[i], gc);

		}
		
		for (int i = 0; i < mainClass.NUMBER_OF_USERS; i++) {
			users[i] = new JLabel("USER" + (i + 1) + " - Uninitialized");
			users[i].setFont(font);
			users[i].setForeground(Color.RED);
			gc.gridx = 1;
			gc.gridy = i;
			add(users[i], gc);

		}
		
		for (int i = 0; i < mainClass.NUMBER_OF_PRINTERS; i++) {
			printers[i] = new JLabel("PRINTER" + (i + 1) + " - Available");
			printers[i].setForeground(Color.RED);
			printers[i].setFont(font);
			gc.gridx = 2;
			gc.gridy = i;
			add(printers[i], gc);

		}
		
		speedDisplay = new JLabel("Execution speed: 1.0x");
		speedDisplay.setFont(font);
		gc.gridx = 0;
		gc.gridy = 4;
		add(speedDisplay, gc);
		
		start = new JButton("Run");
		gc.gridx = 1;
		gc.gridy = 4;
		add(start, gc);
		
		speed = new JSlider(JSlider.HORIZONTAL, 1,4,2);
		speed.setMajorTickSpacing(1);
		speed.setPaintTicks(true);
		gc.gridx = 2;
		gc.gridy = 4;
		add(speed, gc);
		 
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < mainClass.NUMBER_OF_USERS; i++) {
					mainClass.users[i].start();	
				}
				speed.setEnabled(false);
				start.setEnabled(false);
				
			}
		});
		
		speed.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				double i = speed.getValue();
				speedDisplay.setText("Execution speed: " + (i/2) + "x");
				mainClass.speed_multiplier = i/2;
				
			}
			
			
		});
			
		
	}

}
