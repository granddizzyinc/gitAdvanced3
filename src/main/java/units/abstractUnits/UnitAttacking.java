package units.abstractUnits;

import arena.Arena;
import units.*;

public abstract class UnitAttacking extends Unit {
    private float increasingAttack;
    private int abilityPoints;

    protected KindOfBattle kindOfBattle;

    public UnitAttacking(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
        this.abilityPoints = 0;

        if (this instanceof Crossbowman || this instanceof Sorcerer || this instanceof Sniper || this instanceof Wizard) {
            this.kindOfBattle = KindOfBattle.distant;
        } else if (this instanceof Robber || this instanceof Spearman) {
            this.kindOfBattle = KindOfBattle.near;
        }

    }

    public UnitAttacking(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
    }

    public void concentration() {
        super.skipAMove();
        if (abilityPoints < 3) {
            abilityPoints += 1;
        }
    }

    public int getAbilityPoints() {
        return abilityPoints;
    }

    public void useAbility() {
        abilityPoints = 0;
    }

    @Override
    public void increaseAttack(int increasingAttack) {
        super.increaseAttack(increasingAttack);
    }

    public float getIncreasingAttack() {
        return increasingAttack;
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
//                this.actionNotInDiapason(arena, targetUnit);
//            }
//        }
//    }

    @Override
    public void actionInDiapason(Arena arena, Unit targetUnit) {
        this.performAnAttack(targetUnit);

        //проверяем убили ли
        if (targetUnit.getHealth() == 0) {
            arena.removeTheCorpse(targetUnit);
        }
    }

    @Override
    public void actionNotInDiapason(Arena arena, Unit targetUnit) {
        if (this.getAbilityPoints() < 2) {
            //концентрация
            this.concentration();
        } else {
            //абилити
            if (kindOfBattle == KindOfBattle.distant) {
                this.applyAbility(targetUnit);
            } else if (kindOfBattle == KindOfBattle.near) {
                this.skipAMove();
            }
        }
    }

    public abstract void applyAbility(Unit targetUnit);
}
