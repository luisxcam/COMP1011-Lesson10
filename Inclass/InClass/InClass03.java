package InClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

public class InClass03 {
	//variable definition
	static FileInputStream file1 = null;
	static FileInputStream file2 = null;
	static FileOutputStream file3 = null;
	
	static int dataFile1 = 0;
	static int dataFile2 = 0;
	
	public static void main(String[] args){
		openTheFiles();
		readAndOrganize();
		closeTheFiles();
	}
	
	public static void openTheFiles(){
		try {
			file1 = new FileInputStream("File Programs/file1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			file2 = new FileInputStream("File Programs/file2.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			file3 = new FileOutputStream("File Programs/file3.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readAndOrganize(){
		try {
			//Read the files
			dataFile1 = file1.read();
			dataFile2 = file2.read();
			
			do{
				if(dataFile1 != -1 && dataFile2 != -1){
					if(dataFile1 > dataFile2){
						//System.out.println(dataFile2);
						file3.write(dataFile2);
						dataFile2 = file2.read();
					}else{
						//System.out.println(dataFile1);
						file3.write(dataFile1);
						dataFile1 = file1.read();
					}
				}else{
					if(dataFile1 == -1 && dataFile2 != -1){
						//System.out.println(dataFile2);
						file3.write(dataFile2);
						dataFile2 = file2.read();
					}
					
					if(dataFile2 == -1 && dataFile1 != -1){
						//System.out.println(dataFile1);
						file3.write(dataFile1);
						dataFile1 = file1.read();
					}
				}
			}while(dataFile2 != -1 || dataFile1 != -1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeTheFiles(){
		try {
			file1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			file2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			file3.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
