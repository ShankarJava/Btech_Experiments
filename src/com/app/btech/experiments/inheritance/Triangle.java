package com.app.btech.experiments.inheritance;

public class Triangle extends Shape {
	Triangle(int base, int height) {
		super(base, height);
	}

	@Override
	void printArea() {
		double area = 0.5 * dim1 * dim2;
		System.out.println("Area of Triangle: " + area);
	}
}
