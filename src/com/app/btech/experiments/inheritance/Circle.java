package com.app.btech.experiments.inheritance;

public class Circle extends Shape {
	Circle(int radius) {
		super(radius, 0); // only dim1 is used
	}

	@Override
	void printArea() {
		double area = Math.PI * dim1 * dim1;
		System.out.println("Area of Circle: " + area);
	}
}
