package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithMagician;
import units.abstractUnits.UnitsTypes;

/**
 * Маг
 */
public class Wizard extends UnitAttackingWithMagician {
    private boolean using_lightning_storm;
    int distanceSkill = 9;

    public Wizard(String name) {
        super(Equipment.mantle_and_wand.getHealth(), Equipment.mantle_and_wand.getAttack(),
                Equipment.mantle_and_wand.getDefend(), UnitsTypes.Wizard, name);
    }
    public void lightning_storm(Unit target1, Unit target2, Unit target3){
        if (getAbilityPoints() == 2) {
            if (using_lightning_storm == false) {
                super.useAbility();
                target1.decreaseHealth(getHealth() / 2);
                target2.decreaseHealth(getHealth() / 3);
                target3.decreaseHealth(getHealth() / 4);
                using_lightning_storm = true;
            }
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
        return arena.findAUnitWithMinimumHealth(ourTeam, this, true);
    }
}
