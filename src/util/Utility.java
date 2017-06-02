package util;

import java.util.Random;

public class Utility {
	
	public static boolean loggingEnabled = false;

	public Utility() {
	}
	
	public static void setLogging(boolean arg) {
		loggingEnabled = arg;
	}
	
	public static void l(Object arg) {
		if (loggingEnabled)
			System.out.println("<i> " + arg);
	}
	
	public static void l(String c, Object arg) {
		if (loggingEnabled)
			System.out.println("<"+ c +"> " + arg);
	}
	
	public static void p(Object arg) {
		System.out.println(arg);
	}
	
	public static String getRandomName() {
		Random randGen = new Random();
		StringBuilder build = new StringBuilder();
		final String lex = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String[] pre = {"Dr. ", "Uncle ", "Mr. ", "Mrs. ", "Ms. ", "Sir ", "Van ", "O'",
							  "The Maginificent ", "King ", "Queen ", "Prince ", "Princess ",
							  "Duchess ", "Lady ", "Prof. "};
		
		int n = randGen.nextInt(6) + 7;
		
		for (int i = 0; i < n; i++) {
			int boundLex = randGen.nextInt(lex.length() - 1);
			build.append(lex.substring(boundLex, boundLex + 1));
		}
		
		int boundPre = randGen.nextInt(pre.length);
		String out = pre[boundPre] + build.toString().toLowerCase();
		return out;
	}
}
