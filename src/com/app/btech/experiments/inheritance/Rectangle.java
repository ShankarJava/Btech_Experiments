package com.app.btech.experiments.inheritance;

public class Rectangle extends Shape {

	Rectangle(int length, int breadth) {
		super(length, breadth);
	}

	@Override
	void printArea() {
		int area = dim1 * dim2;
		System.out.println("Area of Rectangle: " + area);
	}
}