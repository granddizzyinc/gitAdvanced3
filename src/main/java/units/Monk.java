package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitProtectiveWithoutShild;
import units.abstractUnits.UnitsTypes;

/**
 * Монах
 */
public class Monk extends UnitProtectiveWithoutShild {
    int distanceSkill = 9;

    public Monk(String name) {
        super(Equipment.kesa_and_beads.getHealth(), Equipment.kesa_and_beads.getAttack(),
                Equipment.kesa_and_beads.getDefend(), UnitsTypes.Monk, name);
    }

    public void defenceCape(Unit target) {
        if (getAbilityPoints() == 2) {
            super.useAbility();
            super.decreaseDamage(target.getDefense() * 1);   // вот здесь как-то определить тип атаки
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

                System.out.println("Не знаю что делать");
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
        // ищем своего с минимальным здоровьем
        return arena.findAUnitWithMinimumHealth(ourTeam, false);
    }
}
