Circle createUnitCircle(Point p, Point q) {
    Point m = p.midPoint(q);
    double theta  = p.angleTo(m);
    double d = Math.sqrt((1 * 1) - ((p.distanceTo(m) * p.distanceTo(m))));
   
    // move the mid-point to the centre of the circle of radius r
    Point c = m.moveTo(theta + (Math.PI/2), d);

    return Circle.getCircle(c, 1); 
}


int findCoverage(Circle c, Point[] points) {
    int count = 0;

    for (Point point : points) {
        if (c.contains(point)) {
            count++;
        }
    }
    return count;
}


int findMaxDiscCoverage(Point[] points) {
    int maxDiscCoverage = 0;

    for (int i = 0; i < points.length - 1; i++) {
        for (int j = i + 1; j < points.length; j++) {
            // find coverage with (points[i], points[j])
            Circle circle = createUnitCircle(points[i], points[j]);

            if (findCoverage(circle, points) > maxDiscCoverage) {
                maxDiscCoverage = findCoverage(circle, points);
            }
        }     
    }
    return maxDiscCoverage;
}
