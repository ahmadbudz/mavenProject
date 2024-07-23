package Maven_GID;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

public class IOThreads implements Runnable{

	// true if the thread will read from the file
	// false if the thread will write to the file
	private boolean ReadOrWrite;

	public IOThreads(boolean ReadOrWrite) {
		this.ReadOrWrite = ReadOrWrite;
	}

	@Override
	public void run() {
		File file = new File("mainTextFile.txt");
		if (ReadOrWrite) {
			if (file.exists()) {
				Random random = new Random();
				while (true) {
					int number = random.nextInt(40000) + 1;
					try {
						FileUtils.writeStringToFile(file, number + System.lineSeparator(), StandardCharsets.UTF_8,
								true);
						Thread.sleep(3000);
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			while (true) {
				try {
					List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
					lines.stream().map(Integer::parseInt).filter(n -> n % 2 != 0).forEach(System.out::println);
					Thread.sleep(5000);
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
