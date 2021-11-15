public class Point {
    private int x;
    private int y;

    /*****************Constructeur******************/
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*****************Getters et Setters******************/
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "Les coordonnées du Point sont : x = " + this.x + ", y = " + this.y;
    }
}