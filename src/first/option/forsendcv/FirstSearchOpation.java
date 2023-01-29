package first.option.forsendcv;
import java.io.IOException;
import search.SearchJob;

public class FirstSearchOpation implements SearchJob{
	
	/*
	 * private static void sendEmailsTocompanies(int numberCompaniesWantToSend)
	 * throws Exception {
	 * 
	 * ///read number of companies we want to send /// send email to the number of
	 * companies we get
	 * 
	 * 
	 * }
	 */
	@Override
	public void search() {
		// TODO Auto-generated method stub	
		 // read data indexes 
		  int[] result = null;
		try {
			result = ReadSvedDataExeclSheet.readFromIndexesFile();	  
		  /// read data with indexes 
		String[] companiesEmail = null;
		 companiesEmail= ReadFromExcel.readDataFromExcelSheet(result);		
       /// send data that got 
	  	SendMail.sendMails(companiesEmail);
		Synchronized.synchronize(companiesEmail);
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
