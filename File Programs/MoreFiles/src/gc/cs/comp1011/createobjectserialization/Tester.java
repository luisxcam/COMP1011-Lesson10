package gc.cs.comp1011.createobjectserialization;

public class Tester {

	public static void main(String[] args) {
		CreateSequentialFile file = new CreateSequentialFile();
		file.openFile();
		file.addRecords();
		file.closeFiles();

	}

}
