package geometry3d;

import geometry2d.Figure;
import geometry3d.exceptions.VolumeException;

public class Cylinder {
    private Figure base;
    private double height;

    public Cylinder(Figure base, double height) throws VolumeException {
        if (height <= 0) {
            throw new VolumeException("Высота цилиндра должна быть положительной");
        }
        this.base = base;
        this.height = height;
    }

    public double volume() {
        return base.area() * height;
    }

    public Figure getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.format("Цилиндр [основание=%s, высота=%.2f]", base, height);
    }
}