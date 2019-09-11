package Utils;

import java.util.Random;

public interface RandomMethods {
	
	public static String generateRandomNumber() {	
		int aNumber = (int) ((Math.random () * 900000000) + 100000000);   
		int bNumber = (int) ((Math.random () * 1) + 9);    
		return "Generated Mobile Number for Onboarding: "+(Integer.toString (aNumber) + Integer.toString (bNumber));
		}
	
	public static String Randomnum() {	
		int num = (int) ((Math.random () * 90) + 10);
		return "Generated last num identifier: "+(Integer.toString(num));
	}
	
	public static String RandomString() {
		int n=3;
		String AlphaNumericString = "abcdefghijklmnopqrstuvxyz"; //+0123456789
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
			System.out.println(index);
		}
		return sb.toString();
	}
	
	public static String agentRandom() {	     
		int aNumber = (int) ((Math.random () * 90000000) + 10000000);    
		return "Generated Mobile Number for Onboarding: "+(Integer.toString (aNumber));
		} 
	
	public static String generateRandomEmailID(String username) {
		String email = null; 
		Random rad = new Random();
		for (int j = 1; j <= 1; j++) {
			email = username + rad.nextInt(100) + "@gmail.com";
		}
		return email;
	}
	
	public static String RandomPan() {
		int n=4,c=4,d=1;
		String Char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String Number = "0123456789";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (Char.length() * Math.random());
			sb.append(Char.charAt(index));
		}
		StringBuilder sd = new StringBuilder(c);
		for (int i = 0; i < c; i++) {
			int index1 = (int) (Number.length() * Math.random());
			sd.append(Number.charAt(index1));
		}
		StringBuilder sc = new StringBuilder(d);
		for (int i = 0; i < d; i++) {
			int index2 = (int) (Char.length() * Math.random());
			sc.append(Char.charAt(index2));
		}
		return sb.toString()+sd.toString()+sc.toString();
	}
}
