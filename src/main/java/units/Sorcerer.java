package units;

import units.Abstract.UnitAttackingWithMagician;

public class Sorcerer extends UnitAttackingWithMagician {
    Equipment runes_and_powders = Equipment.runes_and_powders;
    int extraHealth = runes_and_powders.getHealth();
    int extraAttack = runes_and_powders.getAttack();
    int extraDefence = runes_and_powders.getDefend();
    public Sorcerer(String name) {
        super(UnitsTypes.Sorcerer, name);
    }
}
