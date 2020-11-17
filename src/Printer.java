// Printer.java

import java.io.*;

public class Printer {
	
	String fname;
	PrintWriter out;
	
		// Constructor builds a printer to the specified directory
		// for outputs using the the format of PRINTERi (where i is
		// is one of our three printers) to create a output file to write to
	Printer(String filename) {
		fname = filename;
		try {
			out = new PrintWriter("../outputs/" + filename);
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void write(StringBuffer target) {
		out.println(target.toString());
		out.flush();
	}
	
};