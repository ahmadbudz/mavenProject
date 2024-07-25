package Maven_GID;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;

public class WriteThread implements Runnable {

	private File file;

	public WriteThread(File file) {
		this.file = file;
	}

	@Override
	public void run() {
		if (file.exists()) {
			Random random = new Random();
			while (true) {
				int number = random.nextInt(40000) + 1;
				try {
					FileUtils.writeStringToFile(file, number + System.lineSeparator(), StandardCharsets.UTF_8, true);
					Thread.sleep(3000);
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
