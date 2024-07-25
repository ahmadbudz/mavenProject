package Maven_GID;

import java.io.File;

public class Main{

	public static void main(String[] args) {
		File file = new File("mainTextFile.txt");
		
		Thread writeThread = new Thread(new WriteThread(file));
		writeThread.start();
		
		Thread readThread = new Thread(new ReadThread(file));
		readThread.start();
		
		
	}

}
