package simplilearn;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class MainMenu {
	
	protected static void showMainMenu() throws IOException {
		System.out.println("\n1: show files [ascending order]");
		System.out.println("2: access file operations");
		System.out.println("3: close the application");
		collectMainMenuOption();
	}
	
	private static void collectMainMenuOption() throws IOException {
		System.out.println("Select an option by pressing 1, 2, or 3");
		String option = App.scanner.nextLine();
		switch (option) {
			case "1":
				showFilesInAscOrder();
				break;
			case "2":
				FileOperations.showFileOperation();
				break;
			case "3":
				System.out.println("\nThank you for using LockedMe.com\nClosing application...");
				System.exit(0);
				break;
			default:
				System.out.println("\nInvalid input, try again");
				break;
		}
		showMainMenu();
	}
	
	private static void showFilesInAscOrder() {
		System.out.println("\nShowing files in ascending order");
		File[] files = new File(App.FOLDER).listFiles();
		Set<String> sorted = new TreeSet<>(); // creates TreeSet in which the files are placed
		for(File file: files) {
			if(!file.isFile()) {
				continue; // skips items which are not files
			}
			sorted.add(file.getName()); // add current file to TreeSet
		}
		sorted.forEach(System.out::println);
	}
	
}
