package units;

import units.abstractUnits.UnitAttackingWithMagician;

public class Sorcerer extends UnitAttackingWithMagician {
    public Sorcerer(String name) {
        super(Equipment.runes_and_powders.getHealth(), Equipment.runes_and_powders.getAttack(),
                Equipment.runes_and_powders.getDefend(), UnitsTypes.Sorcerer, name);
    }
}
