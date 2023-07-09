package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithWeapons;
import units.abstractUnits.UnitsTypes;

/**
 * Снайпер
 */
public class Sniper extends UnitAttackingWithWeapons {
    int distanceSkill = 9;
    private boolean using_Hit_the_bulls_eye = false;
    public Sniper(String name) {
        super(Equipment.bow_and_arrows.getHealth(), Equipment.bow_and_arrows.getAttack(),
                Equipment.bow_and_arrows.getDefend(), UnitsTypes.Sniper, name);
    }
    public void Hit_the_bulls_eye(Unit target){
        if (getAbilityPoints() == 2){
            if (using_Hit_the_bulls_eye == false) {
                super.useAbility();
                target.decreaseHealth(getHealth()/2);
                using_Hit_the_bulls_eye = true;
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
