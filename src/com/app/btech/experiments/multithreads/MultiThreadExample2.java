package com.app.btech.experiments.multithreads;

public class MultiThreadExample2 {
	public static void main(String[] args) {
		NumberGenerator2 generator = new NumberGenerator2();
		generator.start();

		// Stop after 30 seconds (30,000 ms)
		try {
			 Thread.sleep(30_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		generator.stopGenerator();
		System.out.println("Stopped after 30 seconds.");
	}
}
