package units;

import units.Abstract.UnitSupportiveHealer;

/**
 * Друид
 */
public class Druid extends UnitSupportiveHealer {

    Equipment frogfoot_and_bearskin = Equipment.frogfoot_and_bearskin;
    int extraHealth = frogfoot_and_bearskin.getHealth();
    int extraAttack = frogfoot_and_bearskin.getAttack();
    int extraDefence = frogfoot_and_bearskin.getDefend();
    public Druid(String name) {
        super(UnitsTypes.Druid, name);
    }


}
