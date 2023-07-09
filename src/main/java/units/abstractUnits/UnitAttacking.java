package units.abstractUnits;

import arena.Arena;
import units.*;

public abstract class UnitAttacking extends Unit {
    private float increasingAttack;
    private int abilityPoints;


    public UnitAttacking(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
        this.abilityPoints = 0;
    }

    public UnitAttacking(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
    }

    public void concentration() {
        System.out.println("Концентрируюсь");
        //super.skipAMove();
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

    @Override
    public void actionInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {
        if (this.getAbilityPoints() == 2) {

        } else if (this.getAbilityPoints() == 1) {
            this.performAnAttack(targetUnit);

            //проверяем убили ли
            if (targetUnit.getHealth() == 0) {
                arena.removeTheCorpse(targetUnit);
            }
        } else {
            // пропускаем ход если он еще не сделан
            if (!moveMade) {
                this.skipAMove();
            }
        }
    }

    @Override
    public void actionNotInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {
        if (this.getAbilityPoints() < 2) {
            //концентрация
            this.concentration();
        } else {
            //абилити
            if (kindOfBattle == KindOfBattle.distant) {
                this.applyAbility(targetUnit);
            } else if (kindOfBattle == KindOfBattle.near) {
                if (!moveMade) {
                    this.skipAMove();
                }
            }
        }
    }

    public abstract void applyAbility(Unit targetUnit);
}
