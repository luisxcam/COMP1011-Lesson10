package gc.cs.comp1011.readobjectserialization;

public class Tester {

	public static void main(String[] args) {
		
		ReadSequentialFile file = new ReadSequentialFile();
		file.openFile();
		file.readRecords();
		file.closeFile();

	}

}
