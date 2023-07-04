package units;

import units.abstractUnits.Equipment;
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
}
