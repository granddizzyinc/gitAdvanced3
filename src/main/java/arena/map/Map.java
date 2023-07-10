package arena.map;

import units.Coordinates;
import units.abstractUnits.Unit;

import java.util.ArrayList;
import java.util.Collections;

public class Map {
    private final Object[][] matrix;

    public int sizeX;

    public int sizeY;

    private ArrayList<Pit> pitsList = new ArrayList<>();

    public Map(int sizeX, int sizeY) {
        this.matrix = new Object[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public Object[][] getMatrix() {
        return matrix;
    }

    public Object getObjectOnTheMap(Coordinates coordinates) {
        return matrix[coordinates.x][coordinates.y];
    }

    public void addPit(Pit pit) {
        pitsList.add(pit);
        matrix[pit.coordinates.x][pit.coordinates.y] = pit;
    }

    public void removePit(Pit pit) {
        pitsList.remove(pit);
        matrix[pit.coordinates.x][pit.coordinates.y] = null;
    }

    public void addUnit(Unit unit) {
        matrix[unit.getCoordinates().x][unit.getCoordinates().y] = unit;
    }
}
