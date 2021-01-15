package simplilearn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {
	
	protected static void showFileOperation() throws IOException {
		System.out.println("\n1: add file");
		System.out.println("2: delete file");
		System.out.println("3: search file");
		System.out.println("4: return to main menu");
		collectFileOperation();
	}
	
	private static void collectFileOperation() throws IOException {
		System.out.println("Select an option by pressing 1, 2, 3, or 4");
		String option = App.scanner.nextLine();
		switch (option) {
			case "1":
				addFile();
				break;
			case "2":
				deleteFile();
				break;
			case "3":
				searchFile();
				break;
			case "4":
				MainMenu.showMainMenu();
				break;
			default:
				System.out.println("\nInvalid input, try again");
				break;
		}
		showFileOperation();
	}
	
	private static void addFile() throws IOException {
		System.out.println("\nProvide a file path");
		String filePath = App.scanner.nextLine();
		Path path = Paths.get(filePath);
		if(!Files.exists(path)) {
			System.out.println("\nFile does not exist in " + filePath);
			return;
		}
		String newFilePath = App.FOLDER + "/" + path.getFileName();
		int inc = 0;
		while(Files.exists(Paths.get(newFilePath))) {
			inc++;
			newFilePath = App.FOLDER + "/" + path.getFileName() + "_" + inc;
		}
		try {
			Files.copy(path, Paths.get(newFilePath));
		}catch(IOException e) {
			System.out.println("\nUnable to copy " + filePath + " into " + newFilePath);
		}
		System.out.println("\nSuccessfully copied " + filePath + " into " + newFilePath);
	}
	
	private static void deleteFile() {
		System.out.println("\nProvide a file path");
		String filePath = App.scanner.nextLine();
		Path path = Paths.get(filePath);
		if(!Files.exists(path)) {
			System.out.println("\nFile does not exist in " + filePath);
			return;
		}
		try {
			Files.delete(path);
		}catch(IOException e) {
			System.out.println("\nUnable to delete " + filePath);
		}
		System.out.println("\nSuccessfully deleted " + filePath);
	}
	
	private static void searchFile() {
		System.out.println("\nProvide a file path");
		String filePath = App.scanner.nextLine();
		Path path = Paths.get(filePath);
		if(!Files.exists(path)) {
			System.out.println("\nFile does not exist at " + filePath);
			return;
		}
		System.out.println("\nFile was found at " + filePath);
	}
	
}
