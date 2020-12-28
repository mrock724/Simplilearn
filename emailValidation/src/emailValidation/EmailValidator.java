package emailValidation;

import java.util.Scanner;

//import emailValidation.EmailAddresses;

public class EmailValidator {
	public static void main(String[] args) {
		EmailAddresses emailAddresses = new EmailAddresses(4);
		emailAddresses.addAddress("bobby@roadrunner.com");
		emailAddresses.addAddress("Petey@gmail.com");
		emailAddresses.addAddress("petey.piranha@mail.edu");
		emailAddresses.addAddress("Bobby.Boucher@hcl.com");
		//santaSuspects.printSuspects();
		System.out.println("Provide an email address to search for");
		Scanner scanner = new Scanner(System.in);
		String searchFor = scanner.nextLine();
		boolean foundMatch = emailAddresses.foundMatch(searchFor);
		if(foundMatch) {
			System.out.println(searchFor + " is a match");
		} else {
			System.out.println(searchFor + " is not a match");
		}
	}
}
