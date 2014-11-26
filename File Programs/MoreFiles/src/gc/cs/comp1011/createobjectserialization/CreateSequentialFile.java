package gc.cs.comp1011.createobjectserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateSequentialFile {

	private ObjectOutputStream output;
	private Scanner input = new Scanner(System.in);

	public void openFile() {

		try {
			//output = new ObjectOutputStream(new FileOutputStream("File Programs/MoreFiles/clients.ser"));
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("File Programs/MoreFiles/clients.ser")));

		} catch (IOException ioException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}

	}// end of openFile()
	
	public void addRecords()
	{
		//create a record
		AccountRecordSerializable record ;


		System.out.println("Please input the client record one per line. Stop input by pressing Ctrl Z");
		System.out.println("Please input the account number(>0), first name, last name and balance");
		System.out.println("for each client, separating the input values with a whitespace character");
		System.out.println("------------------------------------------------------------------------");

		while(input.hasNext())
		{
			try{
				record = new AccountRecordSerializable();
			record.setAccount(input.nextInt());
			record.setFirstName(input.next());
			record.setLastName(input.next());
			record.setBalance(input.nextDouble());

			if(record.getAccount() > 0)
			{
				output.writeObject(record);
			}
			}//of try
			catch(NotSerializableException e)
			{
				System.err.println("The object cannot be saved");
				
			}
			catch(InvalidClassException e)
			{
				System.err.println("Some error occured.");
			}
			catch(IOException ex)
			{
				System.err.println("I/O error occured. Can't write object");
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


		}//of while

	}

	public void closeFiles()
	{
		if(input != null)
			input.close();
		if (output != null)
			try {
				output.close();
			} catch (IOException e) {
				System.err.println("Error closing file.");
				//e.printStackTrace();
			}
	}

}
