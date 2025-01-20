package temp;

import java.util.Date;

public class Genetaremaildemo {

	public static void main(String[] args) {
		
		Date date = new Date();
		String dateString = date.toString();
		String noSpaceDateString = dateString.replaceAll("\\s", "");
		String noSpaceAndnoColonString = noSpaceDateString.replaceAll("\\:", "");
		String emailwithTimestamp = noSpaceAndnoColonString+"@gmail.com";
		System.out.println(emailwithTimestamp);
		
		
	}

}
