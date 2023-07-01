package units.abstractUnits;

import units.UnitsTypes;

public abstract class UnitAttackingWithMagician extends UnitAttacking {

    private int mana;
    public int baseSpell;

    private static final int MANACONC = 20;

    public UnitAttackingWithMagician(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
        this.mana = 100;
        this.baseSpell = 15;
    }

    public UnitAttackingWithMagician(UnitsTypes type, String name, int mana, int baseSpell) {
        this(0,0,0,type, name);
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
