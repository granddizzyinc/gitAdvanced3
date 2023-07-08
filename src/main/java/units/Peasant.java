package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitSupportiveBasic;
import units.abstractUnits.UnitsTypes;

/**
 * Крестьянин
 */
public class Peasant extends UnitSupportiveBasic {
    public Peasant(String name) {
        super(Equipment.pitchfork_and_robe.getHealth(), Equipment.pitchfork_and_robe.getAttack(),
                Equipment.pitchfork_and_robe.getDefend(), UnitsTypes.Peasant, name);
    }

    @Override
    public void step(int speed, Unit target) {
        // поменяли координаты в напревлении таргета

//        вызвать какую то спобовность


    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {
        // ищем ближайшего чужого
        return arena.findTheNearestTeamUnit(ourTeam, this, true);
    }

//    способности
}
