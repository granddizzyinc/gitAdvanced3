package Units.Abstract;

public abstract class UnitAttackingWithMagician extends UnitAttacking {

    private int mana;
    public int baseSpell;

    private static final int MANACONC = 20;
    public UnitAttackingWithMagician() {
        super();
        mana = 100;
        baseSpell = 15;
    }

    @Override
    public void concentration() {
        super.concentration();
        if (mana + MANACONC < 100) {
            mana += MANACONC;
        } else {
            mana = 100;
        }
    }

    @Override
    public void performAnAttack(Unit unit) {
        if (mana - baseSpell > 0) {
            super.performAnAttack(unit);
            mana -= baseSpell;
        }

    }
}
