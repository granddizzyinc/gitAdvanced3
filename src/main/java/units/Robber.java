package units;

import units.Abstract.UnitAttackingWithWeapons;

/**
 * Разбойник
 */
public class Robber extends UnitAttackingWithWeapons {

    Equipment knives_and_cloak = Equipment.knives_and_cloak;
    int extraHealth = knives_and_cloak.getHealth();
    int extraAttack = knives_and_cloak.getAttack();
    int extraDefence = knives_and_cloak.getDefend();
    public Robber(String name) {
        super(UnitsTypes.Robber, name);
    }
}
