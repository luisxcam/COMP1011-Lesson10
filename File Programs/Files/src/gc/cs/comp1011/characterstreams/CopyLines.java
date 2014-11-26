package gc.cs.comp1011.characterstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {
	public static void main(String[] args) {

		BufferedReader in = null;
	//	BufferedWriter out = null;
		PrintWriter out = null;

		try {
			in = new BufferedReader(new FileReader("File Programs/Files/info.txt"));

			try {
				//out = new BufferedWriter(new FileWriter("File Programs/Files/lineinfo.txt"));
				out = new PrintWriter(new BufferedWriter(new FileWriter("File Programs/Files/lineinfo.txt")));
				String data;

				// The value of -1 signals the end of file
				try {
					while ((data = in.readLine()) != null) {
						//out.write(data,0,data.length());
						//out.write("\n");
						out.println(data);
					}
				} catch (IOException e) {

					e.printStackTrace();
				}

			} catch (IOException ex) {
				System.out.println("File cannot be created or opened");
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Input File does not exist.");
		} catch (SecurityException se) {
			System.out.println("Read access denied on input file.");
		} finally {
			// close the files
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("Input file could not be closed");
					e.printStackTrace();
				}
			if (out != null)
				
					out.close();
			
			System.out.println("Done");
				
		}

	}

}
