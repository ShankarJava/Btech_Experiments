package com.app.btech.experiments.interthreadcommunication;

public class Producer extends Thread {
	private Buffer buffer;

	Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			buffer.produce(i);
			try {
				Thread.sleep(500); // simulate work
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
