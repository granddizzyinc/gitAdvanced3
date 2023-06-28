package Units.Abstract;

public abstract class UnitAttacking extends Unit {

    private int stamina;
    private int attack;

    public UnitAttacking() {
        super();
        stamina = 100;
        attack = 10;
    }

    public void performAnAttack(Unit unit) {

    }

    public int getStamina() {
        return stamina;
    }
    public void addStamina(int value) {
        stamina += value;
    }

    public void decreaseStamina(int value) {
        stamina -= value;
    }
}
