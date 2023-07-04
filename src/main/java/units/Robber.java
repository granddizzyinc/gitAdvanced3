package units;

import units.Abstract.UnitAttackingWithWeapons;

/**
 * Разбойник
 */
public class Robber extends UnitAttackingWithWeapons {
    public Robber(String name) {
        super(Equipment.knives_and_cloak.getHealth(), Equipment.knives_and_cloak.getAttack(),
                Equipment.knives_and_cloak.getDefend(), UnitsTypes.Robber, name);
    }
    public void theft(){
        if (getAbilityPoints() == 2) {
            super.useAbility();
            decrease(1);
        }
    }
}
