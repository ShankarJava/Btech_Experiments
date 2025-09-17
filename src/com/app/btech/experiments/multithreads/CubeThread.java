package com.app.btech.experiments.multithreads;

class CubeThread extends Thread {
    private int number;

    CubeThread(int number) {
        this.number = number;
    }

    public void run() {
        int cube = number * number * number;
        System.out.println("Cube of " + number + " = " + cube);
    }
}
