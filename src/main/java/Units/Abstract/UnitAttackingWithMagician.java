package Units.Abstract;

public abstract class UnitAttackingWithMagician extends UnitAttacking {

    private int mana;

    public UnitAttackingWithMagician() {
        mana = 100;
    }

    @Override
    public void performAnAttack(Unit unit) {
        mana -= 5;
    }
}
