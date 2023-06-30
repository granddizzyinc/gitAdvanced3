package units.Abstract;

import units.UnitsTypes;

public abstract class UnitAttacking extends Unit {

    private int abilityPoints;

    public UnitAttacking(int health, int defense, int attack, UnitsTypes type, String name, int abilityPoints) {
        super(health, defense, attack, type, name);
        this.abilityPoints = abilityPoints;
    }

    public UnitAttacking(UnitsTypes type, String name, int abilityPoints) {
        this(0, 0, 0, type, name, 0);
    }


//    @Override
//    public void performAnAttack(Unit unit) {
//
//    }

    public void concentration() {
//        super.decreasePointActivites(1);
        super.skipAMove();
        if (abilityPoints < 3) {
            abilityPoints += 1;
        }
    }

    public int getAbilityPoints() {
        return abilityPoints;
    }
//    public void addAbilityPoints(int value) {
//        abilityPoints += value;
//    }

    public void useAbility() {
        abilityPoints = 0;
    }
}
