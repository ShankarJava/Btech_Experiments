package com.app.btech.experiments.multithreads;

public class MultiThreadExample {
	public static void main(String[] args) {
		NumberGenerator generator = new NumberGenerator();
		generator.start();
	}
}
