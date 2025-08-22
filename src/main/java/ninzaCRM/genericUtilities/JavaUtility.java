package ninzaCRM.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
/**
 * @author Wakchaure Aniket 
 */
	public int GenerateRandomNumber(int size){
		Random r=new Random();
		int rno = r.nextInt(size);
		return rno ;
		
	}
	public String getsystemDate() {
		Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
		String date = s.format(d);
		return date;
		
	}
	
}
