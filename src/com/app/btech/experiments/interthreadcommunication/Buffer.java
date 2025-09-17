package com.app.btech.experiments.interthreadcommunication;

public class Buffer {
	private int data;
	private boolean available = false; // flag to track buffer state

	// Producer puts data
	public synchronized void produce(int value) {
		while (available) {
			try {
				wait(); // wait if buffer already has data
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		data = value;
		available = true;
		System.out.println("Produced: " + value);
		notify(); // notify consumer
	}

	// Consumer gets data
	public synchronized int consume() {
		while (!available) {
			try {
				wait(); // wait if buffer is empty
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		available = false;
		System.out.println("Consumed: " + data);
		notify(); // notify producer
		return data;
	}
}
