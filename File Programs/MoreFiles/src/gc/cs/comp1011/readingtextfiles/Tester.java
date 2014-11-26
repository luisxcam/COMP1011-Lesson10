package gc.cs.comp1011.readingtextfiles;

public class Tester {

	public static void main(String[] args) {

		ReadTextFile app = new ReadTextFile();
		app.openFile();
		app.readRecords();app.closeFile();

	}

}
