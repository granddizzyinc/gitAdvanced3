package units;
import arena.Arena;
import units.abstractUnits.Unit;

import java.util.ArrayList;

public interface UnitInterface {

    String getInfo();

    void die();

    void step(int speed, Unit target, Arena arena, Coordinates stepCoordinates);

    public Unit findTarget(Arena arena, Team ourTeam);
}
