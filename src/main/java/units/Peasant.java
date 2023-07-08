package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitSupportiveBasic;
import units.abstractUnits.UnitsTypes;

/**
 * Крестьянин
 */
public class Peasant extends UnitSupportiveBasic {
    public Peasant(String name) {
        super(Equipment.pitchfork_and_robe.getHealth(), Equipment.pitchfork_and_robe.getAttack(),
                Equipment.pitchfork_and_robe.getDefend(), UnitsTypes.Peasant, name);
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
        // ищем ближайшего чужого
        return arena.findTheNearestTeamUnit(ourTeam, this, true);
    }

//    способности
}
