package Maven_GID;

public class Main{

	public static void main(String[] args) {
		Thread writeThread = new Thread(new IOThreads(false));
		writeThread.start();
		
		Thread readThread = new Thread(new IOThreads(true));
		readThread.start();
		
		
	}

}
