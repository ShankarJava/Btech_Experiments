package com.app.btech.experiments.multithreads;

public class CubeThread2 extends Thread {
	private int number;

	CubeThread2(int number) {
		this.number = number;
	}

	public void run() {
		System.out.println("Cube of " + number + " = " + (number * number * number));
	}
}