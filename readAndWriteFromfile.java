package com.douglasrezendetest.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class App 
{
	public static void main( String[] args ) throws Exception{

	/*	String input = "C:\\\\douglas\\\\systemLog.log";
		String output ="C:\\\\douglas\\\\outputLog.txt";
		readAndWriteFromfile(input, output);

		createJSON();*/
		
		
		createFile();
	}




	private static void readAndWriteFromfile(String input, String output) throws Exception {

		BufferedReader inputStream = new BufferedReader(new FileReader(input));
		File UIFile = new File(output);
		// if File doesnt exists, then create it
		if (!UIFile.exists()) {
			UIFile.createNewFile();
		}
		FileWriter filewriter = new FileWriter(UIFile.getAbsoluteFile());
		BufferedWriter outputStream= new BufferedWriter(filewriter);
		String line;
		try {
			while ((line = inputStream.readLine()) != null) {
				line = readStringAndCreateNewString(line);
				outputStream.write(line + System.lineSeparator());
			}
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}finally {
			outputStream.flush();
			outputStream.close();
			inputStream.close();	
		}

	}


	private static String readStringAndCreateNewString(String line) {


		String[] split = line.split("DOWNLOAD DO ARQUIVO:");
		String firstValue = split[0];
		String aux = split[1];
		split = aux.split("REALIZADO PELO USUARIO:");
		String secondValue = split[0];
		aux = split[1];
		split = aux.split("NA MAILBOX:");
		secondValue = " ARQUIVO: " + secondValue +" USUARIO: " +split[0];
		line = firstValue + secondValue;

		return line;

	}


	private static void createJSON() {

		String jsonString = new JSONObject()
				.put("JSON1", "Hello World!")
				.put("JSON2", "Hello my World!")
				.put("JSON3", new JSONObject().put("key1", "value1"))
				.toString();

		System.out.println(jsonString);


	}

	private static void createFile() throws IOException {

		int i= 0;
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(new File("C:\\douglas\\testDouglas.txt"));
			while(i <= 500000) {

				fileWriter.write("DOUGLAS TEST DE TEST                "+i+",40          " + System.lineSeparator());


				i++;
			}
		}catch(Exception ex) {
			ex.getMessage();
		}finally {
			fileWriter.close();
		}






	}
}
