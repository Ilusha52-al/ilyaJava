package geometry2d;

import geometry2d.exceptions.NegativeValueException;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) throws NegativeValueException {
        if (radius <= 0) {
            throw new NegativeValueException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Круг [радиус=%.2f]", radius);
    }

    public double getRadius() {
        return radius;
    }
}