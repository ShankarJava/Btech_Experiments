package com.app.btech.experiments.multithreads;

import java.util.Random;

class NumberGenerator2 extends Thread {
    private volatile boolean running = true;

    public void stopGenerator() {
        running = false;
    }

    public void run() {
        Random rand = new Random();
        try {
            while (running) {
                int num = rand.nextInt(100);
                System.out.println("Generated number: " + num);

                if (num % 2 == 0) {
                    new SquareThread(num).start();
                } else {
                    new CubeThread(num).start();
                }

                Thread.sleep(1000); // 1 second delay
            }
        } catch (InterruptedException e) {
            System.out.println("Generator interrupted");
        }
    }
}
