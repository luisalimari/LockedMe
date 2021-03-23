package com.dell.filesystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileManager {
	
	public void list(){
		Scanner scan = new Scanner(System.in);
        System.out.print("Enter the directory: ");
        String directory = scan.next();
        
        File file = new File(directory);
		
		File[] list = file.listFiles();
        List<String> files = new ArrayList<String>();
        for(File f : list) {
        	files.add(f.getName());
        }
        
        Collections.sort(files, new IntuitiveStringComparator<String>());
        for(String fileName : files) {
        	System.out.println(fileName);
        }
	}

	
	public boolean delete(String filepath) {
		File file = new File(filepath); 
        
        if(file.delete()) 
        { 
            System.out.println("File deleted successfully"); 
            return true; 
        } 
        else
        { 
            System.out.println("Failed to delete the file"); 
            return false; 
        } 
	}

	public void add(String fileName) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the directory: ");
        String directory = scan.next();
		File file = new File(directory+"\\"+fileName);
		try {
			file.createNewFile();
			System.out.println("File created successfully"); 
		} catch (IOException e) {
			System.out.println("Failed to create the file");
			e.printStackTrace();
		}
	}
	
	public boolean search() {
		boolean fileExists = false;
		Scanner scan = new Scanner(System.in);
        System.out.print("Enter the file name to be searched: " );
        String name = scan.next();
        System.out.print("Enter the directory: ");
        String directory = scan.next();
        
        File file = new File(directory);
		
		File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (name.equalsIgnoreCase(fil.getName())) {
            	System.out.println("The file with name "+ name +" was sucesfully found!");
                fileExists = true;
            }
        }
        
        if(fileExists == false) {
        	System.out.println("The file with name "+ name +" was not found.");
        }
        
        return fileExists;
		
	}
	
	
}
