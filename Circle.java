public class Circle {
    public Point point;
    public int radius;

    /*****************Constructeur******************/
    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2.0);
    }

    public boolean containsPoint(Point point) {
        double calcX = Math.pow((this.point.getX() - point.getX()), 2.0);
        double calcY = Math.pow((this.point.getY() - point.getY()), 2.0);

        if ((calcX + calcY) < Math.pow(this.radius, 2.0))
            return true;
        else
            return false;
    }

    public String toString() {
        return "Le centre du cercle : x = " + this.point.getX() + ", y = " + this.point.getY() + ", rayon = " + this.radius;
    }
}