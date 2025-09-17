package com.app.btech.experiments.multithreads;

class SquareThread extends Thread {
    private int number;

    SquareThread(int number) {
        this.number = number;
    }

    public void run() {
        int square = number * number;
        System.out.println("Square of " + number + " = " + square);
    }
}
