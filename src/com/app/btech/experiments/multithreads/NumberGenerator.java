package com.app.btech.experiments.multithreads;

import java.util.Random;

class NumberGenerator extends Thread {
    public void run() {
        Random rand = new Random();
        try {
            while (true) {
                int num = rand.nextInt(100); // 0–99
                System.out.println("Generated number: " + num);

                if (num % 2 == 0) {
                    new SquareThread(num).start();
                } else {
                    new CubeThread(num).start();
                }

                Thread.sleep(1000); // wait 1 second
            }
        } catch (InterruptedException e) {
            System.out.println("Generator interrupted");
        }
    }
}






