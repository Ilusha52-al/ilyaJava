package geometry2d;

import geometry2d.exceptions.GeometryException;

public class Rectangle implements Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) throws GeometryException {
        if (width <= 0 || height <= 0) {
            throw new GeometryException("Ширина и высота должны быть положительными числами");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник [ширина=%.2f, высота=%.2f]", width, height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}