package gc.cs.comp1011.characterstreams;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {

	public static void main(String[] args) {

		FileReader in = null;
		FileWriter out = null;

		try {
			in = new FileReader("info.txt");

			try {
				out = new FileWriter("charinfo.txt");

				int data;

				// The value of -1 signals the end of file
				try {
					while ((data = in.read()) != -1) {
						out.write(data);
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
				try {
					out.close();
				} catch (IOException e) {
					System.out.println("Output file could not be closed");
					e.printStackTrace();
				}
		}

	}

}
