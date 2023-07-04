package units;

import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithWeapons;
import units.abstractUnits.UnitsTypes;

/**
 * Копейщик
 */
public class Spearman extends UnitAttackingWithWeapons {
    public Spearman(String name) {
        super(Equipment.spear_and_cuirass.getHealth(), Equipment.spear_and_cuirass.getAttack(),
                Equipment.spear_and_cuirass.getDefend(), UnitsTypes.Spearman,  name);
    }
    public void stun(Unit target){
        if (getAbilityPoints() == 2 && getPointActivites() == 1) {
            super.useAbility();
            super.performAnAttack(target);
            target.skipAMove();
        }
    }

//    @Override
//    public void performAnAttack(Unit target1, Unit target2) {
//        super.performAnAttack(target1);
//        if () {      /**здесь нужно вписать, что если дистанция между юнитами равно 1
//                                    * и три х или три у равны, то тогда таргет2 получает +урон
//                                    */
//
//        }
//    }

}
