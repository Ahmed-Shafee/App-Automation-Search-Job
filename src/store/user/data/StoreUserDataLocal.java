package store.user.data;
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

import javax.swing.JFrame;

public class StoreUserDataLocal {
	
	
public static void storeDataLocal() {
	
	cerateFolder();
	storeData();
}	
	

private static void cerateFolder()
{
	
	 // Create a File object for the new folder
    File newFolder = new File("c:/appdata");
    
    // Create the new folder
    boolean success = newFolder.mkdir();
    
    if (success) {
      // The folder was created successfully
      System.out.println("Folder created successfully");
    } else {
      // The folder was not created
      System.out.println("Error creating folder");
    }

}

 public static void storeEncrptyData(String email,String password) {
	 

   
     // Encrypt the data using base64
     String encryptedEmail = Base64.getEncoder().encodeToString(email.getBytes());
     String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());

     // Store the encrypted data in a file
     String filePath = "C:/appdata/encrypted_data.txt";
     try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
         writer.write(encryptedEmail);
         writer.newLine();
         writer.write(encryptedPassword);
         writer.newLine();
     } catch (IOException e) {
         e.printStackTrace();
     }
		 
	
}



  private static void storeData() {
	    // Create a JFrame for the file dialog
	    JFrame frame = new JFrame();
	    
	    // Use the FileDialog class to prompt the user to select a file
	    FileDialog fileDialog = new FileDialog(frame, "Select a file", FileDialog.LOAD);
	    fileDialog.setVisible(true);
	    
	    // Get the selected file path
	    String filePath = fileDialog.getDirectory() + fileDialog.getFile();
	    
	     
	    // Create a File object for the selected file
	    File file = new File(filePath);
	    // Read the contents of the file into a string

	    String fileName = file.getName();
	    String fileExtension = fileName.substring(fileName.lastIndexOf("."));
	    
	       
	 
	 // Read the contents of the file into a string
	 StringBuilder sb = new StringBuilder();
	 try {
	   BufferedReader br = new BufferedReader(new FileReader(filePath));
	   String line;
	   while ((line = br.readLine()) != null) {
	     sb.append(line);
	     sb.append(System.lineSeparator());
	   }
	   br.close();
	 } catch (IOException e) {
	   e.printStackTrace();
	 }
	 String fileData = sb.toString();

	 // Write the contents of the file to the "c:/appdata" directory with the original file extension
	 try {
	   FileWriter writer = new FileWriter("c:/appdata/CV" + fileExtension);
	   writer.write(fileData);
	   writer.close();
	 } catch (IOException e) {
	   e.printStackTrace();
	 }


  }
}
