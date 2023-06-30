package units.Abstract;

import units.UnitsTypes;

public abstract class UnitProtective extends Unit {

    private int abilityPoints;

    public UnitProtective(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
        this.abilityPoints = 0;
    }

    public UnitProtective(UnitsTypes type, String name) {
        this(0,0,0,type,name);
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

    public void decreaseAttack(int value) {
        //super.d
    }
}
