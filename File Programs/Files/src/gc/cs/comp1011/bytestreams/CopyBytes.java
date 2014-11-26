package gc.cs.comp1011.bytestreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

	public static void main(String[] args) {
		
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try
		{
			in = new FileInputStream("File Programs/Files/info.txt");
			
			try{
			out = new FileOutputStream("File Programs/Files/infoagain.txt");
			
			int data;
			
			//The value of -1 signals the end of file
			try {
				while( (data = in.read()) != -1)
				{
					out.write(data);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
			}
			catch(FileNotFoundException ex){
				System.out.println("Output File could not be created.");
			}
			catch(SecurityException se){
				System.out.println("Write access denied on output file.");
			}
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Input File does not exist.");
		}
		catch(SecurityException se){
			System.out.println("Read access denied on input file.");
		}
		finally
		{		
			//close the files
			if(in != null)
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("Input file could not be closed");
					e.printStackTrace();
				}
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					System.out.println("Output file could not be closed");
					e.printStackTrace();
				}
			
			System.out.println("All Done.");
		}

	}

}
