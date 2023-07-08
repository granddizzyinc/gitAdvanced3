package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitSupportiveHealer;
import units.abstractUnits.UnitsTypes;

import java.util.ArrayList;

/**
 * Друид
 */
public class Druid extends UnitSupportiveHealer {

    public Druid(String name) {
        super(Equipment.frogfoot_and_bearskin.getHealth(), Equipment.frogfoot_and_bearskin.getAttack(),
                Equipment.frogfoot_and_bearskin.getDefend(), UnitsTypes.Druid, name);
    }


    @Override
    public void step(int speed, Unit target, Arena arena, Coordinates stepCoordinates) {
        this.setCoordinates(stepCoordinates);
    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {
        // ищем ближайшего своего
        return arena.findTheNearestTeamUnit(ourTeam, this, false);
    }

}
