//Disk.java

import java.awt.Color;
import java.lang.StringBuffer;

public class Disk {
    
    static final int NUM_OF_SECTORS = 1024;
    StringBuffer sectors[] = new StringBuffer[NUM_OF_SECTORS];
    
    public void write(int sector, int diskInd, int userInd, StringBuffer data) {
    	OSMainFrame.disks[diskInd].setForeground(Color.MAGENTA);
    	OSMainFrame.disks[diskInd].setText("DISK" + (diskInd + 1) + " is saving from USER" + (userInd + 1));
    	sectors[sector] = data;
     }
    
    public void read(int sector, int diskInd, StringBuffer data) {
    	OSMainFrame.disks[diskInd].setForeground(Color.MAGENTA);
    	OSMainFrame.disks[diskInd].setText("DISK" + (diskInd + 1) + " - being read from");
    	data.append(sectors[sector]);
    }
    
};
