package units;

import units.Abstract.UnitAttackingWithMagician;

/**
 * Маг
 */
public class Wizard extends UnitAttackingWithMagician {

    Equipment mantle_and_wand = Equipment.mantle_and_wand;
    int extraHealth = mantle_and_wand.getHealth();
    int extraAttack = mantle_and_wand.getAttack();
    int extraDefence = mantle_and_wand.getDefend();
    public Wizard(String name) {
        super(UnitsTypes.Wizard, name);
    }
}
