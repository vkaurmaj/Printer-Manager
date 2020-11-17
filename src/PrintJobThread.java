import java.awt.Color;

public class PrintJobThread extends Thread {
	
	String hashIndex;
	int user;
	
	public PrintJobThread(String hashI, int user) {
		hashIndex = hashI;
		this.user = user;
	}
	
	public void run() {
		FileInfo info = mainClass.dirM.lookup(hashIndex);
		Disk targetDisk = mainClass.disks[info.diskNumber];
		try {
			int pI = mainClass.priM.request();
			Printer p = mainClass.printers[pI];
			StringBuffer str = new StringBuffer();
	    	OSMainFrame.disks[info.diskNumber].setForeground(Color.MAGENTA);
	    	OSMainFrame.disks[info.diskNumber].setText("DISK" + (info.diskNumber + 1) + " - being read from");
			for (int i = info.startingSector; i < (info.startingSector + info.fileLength); i++) {
				targetDisk.read(i, info.diskNumber, str);
				p.write(new StringBuffer(str));
		    	OSMainFrame.printers[pI].setForeground(Color.MAGENTA);
		    	OSMainFrame.printers[pI].setText("PRINTER" + (pI + 1) + " - Printing " + str.toString() +" from DISK" + (info.diskNumber+1));
				str = new StringBuffer();
				Thread.sleep((long) (2750/mainClass.speed_multiplier));
			}
	    	OSMainFrame.printers[pI].setForeground(Color.RED);
	    	OSMainFrame.printers[pI].setText("PRINTER" + (pI + 1) + " - Available.");
	    	OSMainFrame.disks[info.diskNumber].setForeground(Color.RED);
	    	OSMainFrame.disks[info.diskNumber].setText("DISK" + (info.diskNumber + 1) + " - Available.");
			mainClass.priM.release(pI);
		} 
		
		catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
};
