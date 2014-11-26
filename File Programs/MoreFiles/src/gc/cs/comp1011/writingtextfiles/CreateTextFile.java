package gc.cs.comp1011.writingtextfiles;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {

	private Formatter output;
	private Scanner input = new Scanner(System.in);

	// open the file to write
	public void openFile() {
		try {
			output = new Formatter("clients.txt");

		} catch (SecurityException se) {

			System.err.println("You do not have write access to this file");
			System.exit(1);

		} catch (FileNotFoundException fnf) {
			System.err.println("Error opening or creating file");
			System.exit(1);

		}
	}// end of openFile

	public void addRecords()
	{
		//create a record
		AccountRecord record = new AccountRecord();


		System.out.println("Please input the client record. Stop input by pressing Ctrl Z");
		System.out.println("Please input the account number(>0), first name, last name and balance");
		System.out.println("Separate the data items with a whitespace character");

		while(input.hasNext())
		{
			try{
			record.setAccount(input.nextInt());
			record.setFirstName(input.next());
			record.setLastName(input.next());
			record.setBalance(input.nextDouble());

			if(record.getAccount() > 0)
			{
				output.format("%d %s %s %f\n",
						record.getAccount(),
						record.getFirstName(),
						record.getLastName(),
						record.getBalance());
			}
			}//of try
			catch(FormatterClosedException ex)
			{
				System.err.println("Output file is already closed...cannot write to it");
			}
			catch(InputMismatchException ex)
			{
				System.err.println("Invalid input...try again");
				input.nextLine(); //discard input so user can try again

			}
			catch(NoSuchElementException ex)
			{
				System.err.println("Input has exhausted");
				input.nextLine(); //discard input so user can try again
			}
			catch(IllegalFormatException ex)
			{
				System.err.println("Format string is illegal");
			}
			catch(IllegalStateException ex)
			{
				System.err.println("Scanner is closed");
			}


			//System.out.println("Please input the account number(>0), first name, last name and balance");
			//System.out.println("Separate the data items with a whitespace character");

		}//of while

	}

	public void closeFiles()
	{
		if(input != null)
			input.close();
		if (output != null)
			output.close();
	}

}
