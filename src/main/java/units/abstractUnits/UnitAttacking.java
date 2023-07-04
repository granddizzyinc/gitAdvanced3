package units.abstractUnits;

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

}
