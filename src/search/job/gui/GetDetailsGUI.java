package search.job.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import first.option.forsendcv.SendMail;
import store.user.data.StoreUserDataLocal;
import three.option.forsendcv.SearchIntoLinkedIn;
import javax.swing.JPasswordField;

public class GetDetailsGUI {
	private static JTextField LinkedInEmail;
	private static JPasswordField LinkedInPassword;
	private static JTextField EmailUser;
	private static JPasswordField PasswordUser;
	private static JButton submitButton;
	
public static void main(String[] args)	
{
showScreen();
}		
    private static void showScreen() {
	JFrame frame = new JFrame();
	frame.setBounds(150, 150, 727, 467);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Insert Your Detials");
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
	JLabel insetEmail=new JLabel("insert your LinkedIn Email and Password");
	insetEmail.setBounds(49,210,199,37);
	frame.getContentPane().add(insetEmail);	
	LinkedInEmail = new JTextField();
	LinkedInEmail.setBounds(365, 101, 160, 30);
	//emailInput.setForeground(Color.GRAY);
	//emailInput.setText("Enter your Email");
	frame.getContentPane().add(LinkedInEmail);
	LinkedInEmail.setColumns(10);
	LinkedInPassword = new JPasswordField();
	// Set the hint text and text color
    //emailPassword.setForeground(Color.GRAY);
    //emailPassword.setEchoChar((char) 0);
    //emailPassword.setText("Enter your password"); 
	LinkedInPassword.setBounds(365, 158, 160, 30);
	frame.getContentPane().add(LinkedInPassword);
	//// fields for linkedIn and the password 
	JLabel lblNewLabel = new JLabel("Insert Your email and Password");
	lblNewLabel.setBounds(46, 92, 220, 37);
	frame.getContentPane().add(lblNewLabel);	
	EmailUser = new JTextField();
	EmailUser.setBounds(365, 219, 160, 28);
	//linkedInEmailField.setForeground(Color.GRAY);
	//linkedInEmailField.setText("Enter your LinkedIn Email");
	frame.getContentPane().add(EmailUser);
	EmailUser.setColumns(10);
	PasswordUser = new JPasswordField();
	PasswordUser.setBounds(365, 264, 160, 30);
	//linkedInPasswordField.setForeground(Color.GRAY);
	//linkedInPasswordField.setEchoChar((char) 0);
	//linkedInPasswordField.setText("Enter your LinkedIn  password");
	frame.getContentPane().add(PasswordUser);
	//// submit button 
	submitButton=new JButton("SUBMIT");
	submitButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {		
	//// store sensitive data about email and the password 			
		String emailString=EmailUser.getText();	
		char[] passwordChars = PasswordUser.getPassword();
		String password = new String(passwordChars);
		StoreUserDataLocal.storeEncrptyData(emailString, password);
		SendMail.setFrom(emailString);
		SendMail.setEmailPassword(password);
		//// store sensitive data about linkedIn 
		String emailLinkedinString=LinkedInEmail.getText();
		char[] passwordCharLinkedin = LinkedInPassword.getPassword();
		String passwordLinkedin = new String(passwordCharLinkedin);
		StoreUserDataLocal.storeEncrptyData(emailLinkedinString, passwordLinkedin);
		SearchIntoLinkedIn.setLinkedInEmailString(emailLinkedinString);
		SearchIntoLinkedIn.setLinkedInPasswordString(passwordLinkedin);
		
		
		// Update the data inside the send email class 
		frame.setVisible(false);
		AutomationJobSearchGUI.main(null);
		}
	});
	submitButton.setBounds(292,351,146,58);	
	frame.getContentPane().add(submitButton);	
	frame.setVisible(true);		
 }
public static JTextField getEmailInput() {
	return LinkedInEmail;
}
@SuppressWarnings("unused")
private static void setEmailInput(JTextField emailInput) {
	GetDetailsGUI.LinkedInEmail = emailInput;
}
public static JPasswordField getEmailPassword() {
	return LinkedInPassword;
}
@SuppressWarnings("unused")
private static void setEmailPassword(JPasswordField emailPassword) {
	GetDetailsGUI.LinkedInPassword = emailPassword;
}

public static JTextField getEmailUser() {
	return EmailUser;
}

@SuppressWarnings("unused")
private static void setEmailUser(JTextField linkedInEmailField) {
	GetDetailsGUI.EmailUser = linkedInEmailField;
}

public static JPasswordField getPasswordUser() {
	return PasswordUser;
}

@SuppressWarnings("unused")
private static void setPasswordUser(JPasswordField linkedInPasswordField) {
	GetDetailsGUI.PasswordUser = linkedInPasswordField;
}	


}
