package units.Abstract;

import units.UnitsTypes;

public abstract class UnitAttackingWithWeapons extends UnitAttacking {

    private int stamina;
    private static final int STAMINACONC = 20;
    private int baseWeapon;


    public UnitAttackingWithWeapons(UnitsTypes type, String name) {
        super(type, name);
        stamina = 100;
        baseWeapon = 15;
    }

    @Override
    public void performAnAttack(Unit unit) {
        super.performAnAttack(unit);
        // super.decreaseStamina(10);
        if (stamina - baseWeapon > 0) {
            super.performAnAttack(unit);
            stamina -= baseWeapon;
        }
    }

    @Override
    public void concentration() {
        super.concentration();
        if (stamina + STAMINACONC < 100) {
            stamina += STAMINACONC;
        } else {
            stamina = 100;
        }
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
