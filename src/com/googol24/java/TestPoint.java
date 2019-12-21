package com.googol24.java;

class Point {
    private double x;

    private double y;

    private double z;

    Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getDistanceOfOrigin() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public double getDistance(Point p) {
        return Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2) + Math.pow(this.z - p.z, 2);
    }
}

public class TestPoint {
    public static void main(String[] args) {
        Point p = new Point(1.0, 2.0, 3.0);
        p.setX(2.0);
        p.setY(3.0);
        p.setZ(4.0);

        System.out.println(p.getDistanceOfOrigin());

        Point q = new Point(1.0, 2.0d, 3.0D);
        System.out.println(p.getDistance(q));
    }
}
