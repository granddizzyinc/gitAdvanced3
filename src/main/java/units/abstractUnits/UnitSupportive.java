package units.abstractUnits;

import arena.Arena;

public abstract class UnitSupportive extends Unit {

    private int speed;
    private int pointActivites;

    public UnitSupportive(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
        pointActivites = super.getPointActivites() * 2;
    }

    public UnitSupportive(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
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
//                this.actionInDiapason(arena, targetUnit);
//            } else {
//                super.doMove(arena, targetUnit);
//
//                if (super.isInDiapason(targetUnit)) {
//                    this.actionInDiapason(arena, targetUnit);
//                } else {
////                    if (this.getAbilityPoints() < 2) {
////                        //концентрация
////                        this.concentration();
////                    } else {
////                        //абилити
////                        if (kindOfBattle == KindOfBattle.distant) {
////                            this.applyAbility(targetUnit);
////                        } else if (kindOfBattle == KindOfBattle.near) {
////                            this.skipAMove();
////                        }
////                    }
//                }
//            }
//        }
//    }

    public void actionInDiapason(Arena arena, Unit targetUnit) {
        this.performAnAttack(targetUnit);

        //проверяем убили ли
        if (targetUnit.getHealth() == 0) {
            arena.removeTheCorpse(targetUnit);
        }
    }

    @Override
    public void actionNotInDiapason(Arena arena, Unit targetUnit) {

    }
}
