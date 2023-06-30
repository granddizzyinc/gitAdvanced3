package units;

import units.Abstract.UnitAttackingWithWeapons;

/**
 * Снайпер
 */
public class Sniper extends UnitAttackingWithWeapons {

    Equipment bow_and_arrows = Equipment.bow_and_arrows;
    int extraHealth = bow_and_arrows.getHealth();
    int extraAttack = bow_and_arrows.getAttack();
    int extraDefence = bow_and_arrows.getDefend();
    public Sniper(String name) {
        super(UnitsTypes.Sniper, name);
    }
}
