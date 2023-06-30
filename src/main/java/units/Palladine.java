package units;

import units.Abstract.UnitProtectiveWithShield;

/**
 * Палладин
 */
public class Palladine extends UnitProtectiveWithShield {

    Equipment shield_and_sword = Equipment.shield_and_sword;
    int extraHealth = shield_and_sword.getHealth();
    int extraAttack = shield_and_sword.getAttack();
    int extraDefence = shield_and_sword.getDefend();
    public Palladine(String name) {
        super(UnitsTypes.Palladine, name);
    }
}
