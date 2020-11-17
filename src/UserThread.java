// UserThread.java

import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.StringBuffer;


public class UserThread extends Thread {
	
	String username;
	StringBuffer r;
	int user;
	int d;
	
	public UserThread(String fname) {
		username = fname;	
		user = Integer.valueOf(username.replace("USER", "")) - 1;
	}
	
	public void run() {
		
		try {
			FileReader fr = new FileReader("../inputs/" + username);
			Scanner read = new Scanner(fr);
			while (read.hasNext()) {
				r = new StringBuffer(read.nextLine());
				if (r.substring(0, 4).equals(".sav")) {
					String saveFile = r.substring(6);
					FileInfo info = new FileInfo();
					OSMainFrame.users[user].setForeground(Color.ORANGE);
					OSMainFrame.users[user].setText(username + "- Waiting for disk...");
					d = mainClass.disM.request();
					int i = mainClass.disM.nextAvail(d);
					Disk writingDisk = mainClass.disks[d];
					info.diskNumber = d;
					info.startingSector = i;
					r = new StringBuffer(read.nextLine());
					while (!r.substring(0, 4).equals(".end")) {
						OSMainFrame.users[user].setForeground(Color.MAGENTA);
						OSMainFrame.users[user].setText(username + "- Saving file " + saveFile + " to DISK" + (d + 1) + "...");
						writingDisk.write(i, d, user, r);
						Thread.sleep((long) (200/mainClass.speed_multiplier));
						i++;
						r = new StringBuffer(read.nextLine());
					}
			    	OSMainFrame.disks[d].setForeground(Color.RED);
			    	OSMainFrame.disks[d].setText("DISK" + (d + 1) + " - Available.");
					info.fileLength = i - info.startingSector;
					mainClass.dirM.enter(saveFile, info);
					mainClass.disM.release(d);
				}
				
				else if (r.substring(0,4).equals(".pri")) {
					String loadFile = r.substring(7);
			    	OSMainFrame.users[user].setForeground(Color.ORANGE);
			    	OSMainFrame.users[user].setText("USER" + (user + 1) + " - Sending Print Request");
					PrintJobThread print = new PrintJobThread(loadFile, user);
					print.start();
				}				
				
			}
			
			OSMainFrame.users[user].setForeground(Color.RED);
			OSMainFrame.users[user].setText(username + "- PROCCESSED.");
			read.close();
			
		} 
		
		
		
		catch (FileNotFoundException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
};