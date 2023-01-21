package search.job.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import store.user.data.StoreUserDataLocal;

import javax.swing.JPasswordField;

public class GetDetailsGUI {
	private static JTextField emailInput;
	private static JPasswordField emailPassword;
	
	
	private static JTextField linkedInEmailField;
	private static JPasswordField linkedInPasswordField;
	
	private static JButton submitButton;
	
public static void main(String[] args)	
{
	

showScreen();
}
		
private static void showScreen() {
	

	JFrame frame = new JFrame();
	frame.setBounds(150, 150, 727, 467);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Manual Job Search");
	frame.getContentPane().setLayout(null);
	
	
	////fields for upload CV
	
	JLabel uploadCV = new JLabel("Upload Your CV");
	uploadCV.setBounds(49, 284, 146, 37);
	frame.getContentPane().add(uploadCV);
	
	
	JButton attachButton = new JButton("Attach file");
	attachButton.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	  
		   StoreUserDataLocal.storeDataLocal();
	  }
	});
	
	
	attachButton.setBounds(172,284,94,37);
	frame.getContentPane().add(attachButton);
	

	
	//// fields for email and the password
	
	JLabel insetEmail=new JLabel(" insert your Email and Password");
	insetEmail.setBounds(49,210,199,37);
	frame.getContentPane().add(insetEmail);
	
	
	
	
	emailInput = new JTextField();
	emailInput.setBounds(365, 101, 160, 30);
	//emailInput.setForeground(Color.GRAY);
	//emailInput.setText("Enter your Email");
	
	frame.getContentPane().add(emailInput);
	emailInput.setColumns(10);
	
	emailPassword = new JPasswordField();
	
	 // Set the hint text and text color
	//emailPassword.setForeground(Color.GRAY);
	//emailPassword.setEchoChar((char) 0);
	//emailPassword.setText("Enter your password");
    
	emailPassword.setBounds(365, 158, 160, 30);
	frame.getContentPane().add(emailPassword);
	

	//// fields for linkedIn and the password 
	
	JLabel lblNewLabel = new JLabel("Insert Your LinkedIn email and Password");
	lblNewLabel.setBounds(46, 92, 220, 37);
	frame.getContentPane().add(lblNewLabel);
	
	linkedInEmailField = new JTextField();
	linkedInEmailField.setBounds(365, 219, 160, 28);
	//linkedInEmailField.setForeground(Color.GRAY);
	//linkedInEmailField.setText("Enter your LinkedIn Email");
	frame.getContentPane().add(linkedInEmailField);
	linkedInEmailField.setColumns(10);
	
	linkedInPasswordField = new JPasswordField();
	linkedInPasswordField.setBounds(365, 264, 160, 30);
	
	//linkedInPasswordField.setForeground(Color.GRAY);
	//linkedInPasswordField.setEchoChar((char) 0);
	//linkedInPasswordField.setText("Enter your LinkedIn  password");
	frame.getContentPane().add(linkedInPasswordField);
		
	
	
	//// submit button 
	submitButton=new JButton("SUBMIT");
	submitButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
		//// store sensitive data about email and the password 
			
		String emailString=	emailInput.getText();
		char[] passwordChars = emailPassword.getPassword();
		String password = new String(passwordChars);
		
		StoreUserDataLocal.storeEncrptyData(emailString, password);
			
		
		//// store sensitive data about linkedIn 
		
		String emailLinkedinString=linkedInEmailField.getText();
		char[] passwordCharLinkedin = emailPassword.getPassword();
		String passwordLinkedin = new String(passwordCharLinkedin);
		
		StoreUserDataLocal.storeEncrptyData(emailLinkedinString, passwordLinkedin);
		
		
		
		frame.setVisible(false);
		AutomationJobSearchGUI.main(null);
		
					
			
		}
	});
	submitButton.setBounds(292,351,146,58);
	
	frame.getContentPane().add(submitButton);
	
	
	frame.setVisible(true);
	
	
}	
}
