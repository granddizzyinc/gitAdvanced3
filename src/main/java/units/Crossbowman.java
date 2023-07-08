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
    public void performAnAttack(Unit unit) {

        if (extraActivities > 0) {
//            if (getAttack() - getDefense() > 0) {
//                unit.decreaseHealth(getAttack() - getDefense());
//            }
            super.performAnAttack(unit);
        } else {
            System.out.println("extraActivites <= 0");
        }
    }
    public void arrow_to_the_knee(Unit unit){
        if (getAbilityPoints() == 2) {
            super.useAbility();
            decreaseSpeed(1);
        }
    }

    @Override
    public void step(Arena arena) {
        Unit targetUnit = findTarget(arena, arena.getUnitTeam(this));

        if (targetUnit == null) {
            System.out.println("Цель: не найдена");
        } else {
            System.out.println("Цель: " + targetUnit + " " + targetUnit.getCoordinates());
            //если в диапазоне то если соответсвует условию атаки то атакует или действует
            if (this.distanceSkill >= this.getCoordinates().calculateDistance(targetUnit.getCoordinates())) {
                System.out.println("Цель в диапазоне");

                this.performAnAttack(targetUnit);

                //проверяем убили ли
                if (targetUnit.getHealth() == 0) {
                    arena.removeTheCorpse(targetUnit);
                }
            } else {

                System.out.print("Хожу: " + this.getCoordinates());
                Coordinates stepCoordinates = arena.getNextStepPosition(this.getCoordinates(), targetUnit.getCoordinates());
                this.setCoordinates(stepCoordinates);
                System.out.println(" -> " + stepCoordinates);
            }
        }
    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {
        // ищем чужого с минимальным здоровьем
        return arena.findAUnitWithMinimumHealth(ourTeam, true);
    }
}
