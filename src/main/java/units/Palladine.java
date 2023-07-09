package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitProtectiveWithShield;
import units.abstractUnits.UnitsTypes;

import java.sql.SQLOutput;

/**
 * Палладин
 */
public class Palladine extends UnitProtectiveWithShield {

    public Palladine(String name) {
        super(Equipment.shield_and_sword.getHealth(), Equipment.shield_and_sword.getAttack(),
                Equipment.shield_and_sword.getDefend(), UnitsTypes.Palladine, name);
    }
    public void defenceCape(Unit target){
        if (getAbilityPoints() == 2) {
            super.useAbility();
            super.decreaseDamage(target.getDefense()*1);   // вот здесь как-то определить тип атаки
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
//                System.out.println("Не знаю что с ним делать");
//            } else {
//                System.out.print("Хожу: " + this.getCoordinates());
//                Coordinates stepCoordinates = arena.getNextStepPosition(this.getCoordinates(), targetUnit.getCoordinates());
//                this.setCoordinates(stepCoordinates);
//                System.out.println(" -> " + stepCoordinates);
//            }
//        }
//    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {
        // ищем ближайшего своего
        return arena.findTheNearestTeamUnit(ourTeam, this, false);
    }
}
