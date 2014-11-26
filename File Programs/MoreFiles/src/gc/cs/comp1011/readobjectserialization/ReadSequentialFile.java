package gc.cs.comp1011.readobjectserialization;

import gc.cs.comp1011.createobjectserialization.AccountRecordSerializable;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.IllegalFormatException;

public class ReadSequentialFile {

	private ObjectInputStream input;
	private PrintWriter output;

	// open the file to read
	public void openFile() {
		try {
			//input = new ObjectInputStream(new FileInputStream("File Programs/MoreFiles/clients.ser"));
			input = new ObjectInputStream(Files.newInputStream(Paths.get("File Programs/MoreFiles/clients.ser")));

			output = new PrintWriter(new File("clientsagain.txt"));

		} catch (IOException ioException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}//open file
	
	//read records from the file
	public void readRecords()
	{
		//record to read the record
		AccountRecordSerializable record = new AccountRecordSerializable();
		try{
		while(true)
		{
			record = (AccountRecordSerializable)input.readObject();
			
			System.out.printf("%-10d%-15s%-15s%.2f\n",
					record.getAccount(),
					record.getFirstName(),
					record.getLastName(),
					record.getBalance());
			output.printf("%d %s %s %f\n",
					record.getAccount(),
					record.getFirstName(),
					record.getLastName(),
					record.getBalance());					
		}
		}
		catch(EOFException e)
		{
			return;
		}
		catch(ClassNotFoundException e)
		{
			System.err.println("Class definition not found.");
		}
		catch(IOException e)
		{
			System.err.println("An I/O error occured");
		}
		catch(IllegalFormatException e)
		{
			System.err.println("Illegal syntax in the format string.");
		}
		catch(NullPointerException e)
		{
			System.err.println("Format string is null");
		}
		}
	
	public void closeFile()
	{
		if (input != null)
			try {
				input.close();
			} catch (IOException e) {
				System.err.println("Error in closing the file.");
				//e.printStackTrace();
			}
		if(output != null)
			output.close();
		
	}

}
