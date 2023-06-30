package units;

import units.Abstract.UnitSupportiveBasic;

/**
 * Крестьянин
 */
public class Peasant extends UnitSupportiveBasic {

    Equipment pitchfork_and_robe = Equipment.pitchfork_and_robe;
    int extraHealth = pitchfork_and_robe.getHealth();
    int extraAttack = pitchfork_and_robe.getAttack();
    int extraDefence = pitchfork_and_robe.getDefend();
    public Peasant(String name) {
        super(UnitsTypes.Peasant, name);
    }
}
