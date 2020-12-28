package emailValidation;

public class EmailAddresses {
	String[] address;
	int nextIndex = 0;
	int arrSize = 0;
	public EmailAddresses(int size) {
		this.arrSize = size;
		this.address = new String[size];
	}
	public void addAddress(String suspect) {
		this.address[this.nextIndex] = suspect;
		this.nextIndex++;
		if(this.nextIndex >= this.arrSize) {
			this.nextIndex = 0;
		}
	}
	public void printAddress() {
		for(int i = 0; i < this.address.length; i++) {
			if(this.address[i] == null) {
				continue;
			}
			System.out.println(this.address[i]);
		}
	}
	public boolean foundMatch(String input) {
		for(int i = 0; i < this.address.length; i++) {
			if(this.address[i] == null) {
				continue;
			}
			if(this.address[i].equals(input)) {
				return true;
			}
		}
		return false;
	}
}
