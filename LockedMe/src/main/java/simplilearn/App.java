package simplilearn;

import java.io.IOException;
import java.util.Scanner;
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Set;
//import java.util.TreeSet;

public class App {
	
	final static String FOLDER = "C:/Users/mrock/temp";
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		showWelcomeScreen();
		MainMenu.showMainMenu();
	}
	
	private static void showWelcomeScreen() {
		System.out.println("Welcome to LockedMe.com");
		System.out.println("Developed by Michael Rock");
	}
}
