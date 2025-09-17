package com.app.btech.experiments.multithreads;

public class SquareThread2 extends Thread {
    private int number;

    SquareThread2(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Square of " + number + " = " + (number * number));
    }
}