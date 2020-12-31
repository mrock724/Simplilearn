package file_handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.StringBuilder;

import eva_units.Unit00;

public class FileHandler {
	
	public static void main(String[] args) throws Exception{
		saveToFile();
		appendFile();
		restoreFromFile();
	}
	
	public static void restoreFromFile() throws Exception {
        File ourUnit00File = new File("/Users/mrock/myUnit00.txt");
        FileInputStream ourUnit00FileStream = new FileInputStream(ourUnit00File);
        ObjectInputStream ourUnit00FileObject = new ObjectInputStream(ourUnit00FileStream);

        Unit00 ourUnit00 = (Unit00) ourUnit00FileObject.readObject();

        System.out.println(ourUnit00.getPilot());
    }
	
	public static void saveToFile() throws Exception {
        Unit00 Unit00 = new Unit00("123");

        FileOutputStream fos = new FileOutputStream(new File("/Users/mrock/myUnit00.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Unit00);
        oos.flush();

        System.out.println("Done");
    }
	
	public static void appendFile() throws Exception{
		File ourUnit00File = new File("/Users/mrock/myUnit00.txt");
        FileInputStream fis = new FileInputStream(ourUnit00File);
        int r = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while((r = fis.read()) != -1) {
            stringBuilder.append((char)r);
        }
        FileOutputStream fos = new FileOutputStream(new File("/Users/mrock/myUnit00.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Unit00 Unit00 = new Unit00(stringBuilder.toString());
        oos.writeObject(Unit00);
        oos.flush();

        System.out.println("Done");
	}
    /*
    public static void writeObject(Object obj, File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.flush();
    }

    public static Object readObject(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }
    */
}
