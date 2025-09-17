package com.app.btech.experiments.inheritance;

public class Test {
	public static void main(String[] args) {
		Shape rect = new Rectangle(10, 20);
		Shape tri = new Triangle(10, 15);
		Shape circ = new Circle(7);

		rect.printArea();
		tri.printArea();
		circ.printArea();
	}
}
