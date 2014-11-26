package gc.cs.comp1011.scanning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScanInfo {

	public static void main(String[] args) {
	
		Scanner input=null;
		
		try {
			input = new Scanner(new BufferedReader(new FileReader("info.txt")));
			
			while(input.hasNext())
			{
				System.out.println(input.next());
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist or could not be opened for reading");
			e.printStackTrace();
		}
		

	}

}
