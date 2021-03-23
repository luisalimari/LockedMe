package com.dell.filesystem;

import java.util.Scanner;

public class Menu {
	
	private Scanner keyboard;
	private FileManager fs = new FileManager();

	public void welcome(){
		System.out.println("Hello, welcome to DELL!");
		System.out.println("Developed by Luis Alimari (luis_alimari@dell.com)");
		System.out.println("---------------------------------------------------");
		operations();
		
	}

	private void operations() {
		System.out.println("Please select one of the options:");
		System.out.println("1) List all files in root directory.");
		System.out.println("2) List File Manager Operations.");
		System.out.println("3) Exit the application.");
		keyboard = new Scanner(System.in);
		
		int option = keyboard.nextInt();
		
		if(option == 1) {
			listAllFilesOperation();
		} else if(option == 2) {
			System.out.println("Please select one of the options:");
			System.out.println("1) Add a file.");
			System.out.println("2) Delete a file.");
			System.out.println("3) Search a file.");
			System.out.println("9) Back to main Menu.");
			keyboard = new Scanner(System.in);
			
			int optionOperation = keyboard.nextInt();
			if(optionOperation == 1) {
				addOperation();
			} else if(optionOperation == 2) {
				deleteOperation();
			} else if(optionOperation == 3) {
				searchOperation();
			} else if(optionOperation == 9) {
				this.operations();
			}
		} else if(option == 3) {
			System.out.println("Thank you for choosing DELL! Bye bye!");
			System.exit(1);
		}
		this.operations();
	}
	
	public void listAllFilesOperation() {
		fs.list();
	}
	
	public void addOperation() {
		keyboard = new Scanner(System.in);
		System.out.print("Please, inform the name and type of the file you wish to add (e.g. test.txt) :");
		String path = keyboard.next();
		fs.add(path);		
	}
	
	public void deleteOperation() {
		keyboard = new Scanner(System.in);
		System.out.print("Please, inform the path of the file you wish to delete:");
		String path = keyboard.next();
		fs.delete(path);
	}
	
	public void searchOperation() {
		//continua na classe FileManager criar algoritmo de busca e ordenar ascndent
		fs.search();
	}

}
