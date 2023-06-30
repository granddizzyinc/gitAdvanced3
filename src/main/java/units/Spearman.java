package units;

import units.Abstract.UnitAttackingWithWeapons;

/**
 * Копейщик
 */
public class Spearman extends UnitAttackingWithWeapons {

    Equipment spear_and_cuirass = Equipment.spear_and_cuirass;
    int extraHealth = spear_and_cuirass.getHealth();
    int extraAttack = spear_and_cuirass.getAttack();
    int extraDefence = spear_and_cuirass.getDefend();
    public Spearman(String name) {
        super(UnitsTypes.Spearman,  name);
    }
}
