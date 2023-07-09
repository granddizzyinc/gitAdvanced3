package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithWeapons;
import units.abstractUnits.UnitsTypes;

/**
 * Разбойник
 */
public class Robber extends UnitAttackingWithWeapons {
    public Robber(String name) {
        super(Equipment.knives_and_cloak.getHealth(), Equipment.knives_and_cloak.getAttack(),
                Equipment.knives_and_cloak.getDefend(), UnitsTypes.Robber, name);
    }
    public void theft(Unit target){
        if (getAbilityPoints() == 2) {
            super.useAbility();
            for (int i = 0; i < 2; i++) {
                target.decreasePointActivities();
            }
        }
    }
    public void jab(Unit target){
        if (getAbilityPoints() == 2){
            super.useAbility();
            target.decreasePointActivities();
            target.decreaseHealth(10);
        }
    }

//    @Override
//    public void step(Arena arena) {
//        Unit targetUnit = findTarget(arena, arena.getUnitTeam(this));
//
//        if (targetUnit == null) {
//            System.out.println("Цель: не найдена");
//        } else {
//            System.out.println("Цель: " + targetUnit + " " + targetUnit.getCoordinates());
//            //если в диапазоне то если соответсвует условию атаки то атакует или действует
//            if (this.distanceSkill >= this.getCoordinates().calculateDistance(targetUnit.getCoordinates())) {
//                System.out.println("Цель в диапазоне");
//
//                this.performAnAttack(targetUnit);
//
//                //проверяем убили ли
//                if (targetUnit.getHealth() == 0) {
//                    arena.removeTheCorpse(targetUnit);
//                }
//            } else {
//
//                System.out.print("Хожу: " + this.getCoordinates());
//                Coordinates stepCoordinates = arena.getNextStepPosition(this.getCoordinates(), targetUnit.getCoordinates());
//                this.setCoordinates(stepCoordinates);
//                System.out.println(" -> " + stepCoordinates);
//            }
//        }
//    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {
        // ищем ближайшего чужого
        return arena.findTheNearestTeamUnit(ourTeam, this, true);
    }

    @Override
    public void applyAbility(Unit targetUnit) {

    }
}
