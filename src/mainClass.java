
import java.awt.*;

import javax.swing.*;

public class mainClass {
	
	static double speed_multiplier = 1.0;	
	static final int NUMBER_OF_USERS = 4;
	static final int NUMBER_OF_DISKS = 2;
	static final int NUMBER_OF_PRINTERS = 3;
	static UserThread users[] = new UserThread[NUMBER_OF_USERS];
	static Disk disks[] = new Disk[NUMBER_OF_DISKS];
	static Printer printers[] = new Printer[NUMBER_OF_PRINTERS];
	static DiskManager disM = new DiskManager(NUMBER_OF_DISKS);
	static PrinterManager priM = new PrinterManager(NUMBER_OF_PRINTERS);
	static DirectoryManager dirM = new DirectoryManager();
	
	public static void main(String[] args) {
	
		for (int i = 0; i < NUMBER_OF_DISKS; i++) {
			disks[i] = new Disk();
		}
		
		for (int i = 0; i < NUMBER_OF_PRINTERS; i++) {
			printers[i] = new Printer("PRINTER" + (i+1));
		}
		
		for (int i = 0; i < NUMBER_OF_USERS; i++) {
			users[i] = new UserThread("USER" + (i + 1));
		}
		
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new OSMainFrame("141OS");
				frame.setSize(1200,700);
				frame.setForeground(Color.BLACK);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			
			}
		});
				
	}

};
