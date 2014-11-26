package gc.cs.comp1011.scanning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanNumbers {

	public static void main(String[] args) {

		Scanner input = null;
		double sum =0;
		int counter = 1;
		
		try
		{
			input = new Scanner(new BufferedReader(new FileReader("File Programs/Files/numbers.txt")));
			
			
			while(input.hasNext()){
				System.out.println("Read Line "+counter);
				counter++;
				try{
					sum += input.nextDouble();
				}
				catch(InputMismatchException ex)
				{
					//System.out.println("Non numeric input...ignored");
					//ignoring the non-numeric input
					//input.next();
					System.out.println("Non numeric input...application will stop executing");
					System.exit(1);
				}
				
			}
			
			System.out.printf("The sum of the numbers is %.2f", sum);
			
			
		}
		catch (FileNotFoundException e) {
			System.out.println("File does not exist or could not be opened for reading");
			e.printStackTrace();
		}
		finally
		{
			if (input != null)
				input.close();
		}


	}

}
