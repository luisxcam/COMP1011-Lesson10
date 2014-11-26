package gc.cs.comp1011.readingtextfiles;

import gc.cs.comp1011.writingtextfiles.AccountRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ReadTextFile {

	private Scanner input;

	// open the file for reading

	public void openFile() {
		try {
			input = new Scanner(new File("clients.txt"));
		} catch (FileNotFoundException fnf) {
			System.err.println("Error opening file");
			System.exit(1);
		}

	}// end of openFile
	
	public void readRecords()
	{
		//record to read the record
		AccountRecord record = new AccountRecord();
		try{
		while(input.hasNext())
		{
			record.setAccount(input.nextInt());
			record.setFirstName(input.next());
			record.setLastName(input.next());
			record.setBalance(input.nextDouble());
			
			System.out.printf("%-10d%-15s%-15s%.2f\n",
					record.getAccount(),
					record.getFirstName(),
					record.getLastName(),
					record.getBalance());
					
		}
		}
		catch(InputMismatchException ex)
		{
			System.err.println("Invalid input...try again");
		}
		
		catch(NoSuchElementException ex)
		{
			System.err.println("Input has exhausted");
		}
		
		catch(IllegalStateException ex)
		{
			System.err.println("Scanner is closed");
		}
	}
	
	public void closeFile()
	{
		if (input != null)
			input.close();
	}

}// of class ReadTextFile
