package c13.cooperationBetweenThreads;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;

import c13.Timeout;

class Sender extends Thread {
	private Random rand = new Random();
	private PipedWriter out = new PipedWriter();

	public PipedWriter getPipedWriter() {
		return out;
	}

	public void run() {
		while (true) {
			for (char c = 'A'; c <= 'z'; c++) {
				try {
					out.write(c);
					sleep(rand.nextInt(500));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}

class Receiver extends Thread {
	private PipedReader in;

	public Receiver(Sender sender) throws IOException {
		in = new PipedReader(sender.getPipedWriter());
	}

	public void run() {
		try {
			while (true) {
				// Blocks until characters are there:
				System.out.println("Read: " + (char) in.read());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

public class PipedIO {
	public static void main(String[] args) throws Exception {
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
		sender.start();
		receiver.start();
		new Timeout(8000, "Terminated");
	}
} // /:~ 