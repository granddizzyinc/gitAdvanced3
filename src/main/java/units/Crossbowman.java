package units;

import arena.Arena;
import units.abstractUnits.*;


/**
 * Арбалетчик
 */
public class Crossbowman extends UnitAttackingWithWeapons {
    // переопределить очки активности??
    int extraActivities = 1;
    int distanceSkill = 9;

    public Crossbowman(String name) {
        super(Equipment.crossbow_and_helmet.getHealth(), Equipment.crossbow_and_helmet.getAttack(),
                Equipment.crossbow_and_helmet.getDefend(), UnitsTypes.Crossbowman, name);

    }

    @Override
    public boolean performAnAttack(Unit unit) {

        if (extraActivities > 0) {
//            if (getAttack() - getDefense() > 0) {
//                unit.decreaseHealth(getAttack() - getDefense());
//            }
            if (super.performAnAttack(unit)) {
                return true;
            }
            ;
//        } else {
//            System.out.println("extraActivites <= 0");
        }

        return false;
    }

    public void arrow_to_the_knee(Unit unit) {
        if (getAbilityPoints() == 2) {
            super.clearPointAbility();
            decreaseSpeed(1);
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
//
//            //если в диапазоне то если соответсвует условию атаки то атакует или действует
//            if (super.isInDiapason(targetUnit)) {
//                super.actionInDiapason(arena, targetUnit);
//            } else {
//                super.doMove(arena, targetUnit);
//
//                if (super.isInDiapason(targetUnit)) {
//                    super.actionInDiapason(arena, targetUnit);
//                } else {
//                    if (this.getAbilityPoints() < 2) {
//                        //концентрация
//                        this.concentration();
//                    } else {
//                        //абилити
//                        //this.tricks(targetUnit);
//                    }
//                }
//            }
//        }
//    }

    @Override
    public boolean applyAbility(Unit targetUnit) {
        return false;
    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {
        // ищем чужого с минимальным здоровьем
        return arena.findAUnitWithMinimumHealth(ourTeam, this, true);
    }
}
