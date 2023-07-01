package units;

import units.abstractUnits.UnitSupportiveHealer;

/**
 * Друид
 */
public class Druid extends UnitSupportiveHealer {

    public Druid(String name) {
        super(Equipment.frogfoot_and_bearskin.getHealth(), Equipment.frogfoot_and_bearskin.getAttack(),
                Equipment.frogfoot_and_bearskin.getDefend(), UnitsTypes.Druid, name);
    }


}
