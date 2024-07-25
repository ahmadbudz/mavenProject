package Maven_GID;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;

public class ReadThread implements Runnable {

	private File file;

	public ReadThread(File file) {
		this.file = file;
	}

	@Override
	public void run() {
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
