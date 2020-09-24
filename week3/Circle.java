class Circle {
    private final Point centre;
    private final double radius;

    Circle(Point c, double radius) { 
        this.centre = c;
        this.radius = radius;
    }

    public static Circle getCircle(Point c, double radius) {
        return new Circle(c, radius);
    }


    @Override 
    public String toString() {
        if (this.radius <= 0) {
            return null;
        }

        return "circle of radius " + radius + " centered at point (" + String.format("%.3f", this.centre.getX()) + ", " + String.format("%.3f", this.centre.getY()) + ")";
    }


    public boolean contains(Point p) {
        return centre.distanceTo(p) <= radius;
    }

}

