class Point {
    // inlcude the properties of a point 
    private final double x;
    private final double y; 

    // constructor 
    public Point(double x, double y) {
        this.x = x; 
        this.y = y;
    }

    // toString method 
    @Override 
    public String toString() {
        return "point (" + String.format("%.3f", this.x) + ", " + String.format("%.3f", this.y) + ")";
    }

    public Point midPoint(Point q) {  
        Point m = new Point((this.x + q.x)/2, (this.y + q.y)/2);
        return m;
    }


    public double angleTo(Point q) {
        // In degrees 
        // double angle = Math.toDegrees(Math.atan2(q.y - this.y, q.x - this.x));
        
        // In radians
        double angle = Math.atan2(q.y - this.y, q.x - this.x);
        return angle; 
    }

    public Point moveTo(double theta, double d) {
        double addX = d * Math.cos(theta);
        double addY = d * Math.sin(theta);
        /*
        if (addX < 0.00001) {
            addX = 0;
        };

        if (addY < 0.00001) {
            addY = 0;
        };
        */
        return new Point(this.x + addX, this.y + addY);
    }

    double distanceTo(Point q) {
        double dispX = q.x - this.x;
        double dispY = q.y - this.y;
        return Math.sqrt(dispX * dispX + dispY * dispY);
    }
    

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
