package units;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double calculateDistance(Coordinates coordinates) {
        return Math.sqrt(Math.pow(coordinates.x - this.x, 2) + Math.pow(coordinates.y - this.y, 2));
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
