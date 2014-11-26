package gc.cs.comp1011.writingtextfiles;

public class TesterCreateTextFile {

	public static void main(String[] args) {

		CreateTextFile app = new CreateTextFile();
		app.openFile();
		app.addRecords();app.closeFiles();


	}

}
