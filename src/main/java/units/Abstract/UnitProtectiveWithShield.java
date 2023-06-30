package units.Abstract;

import units.UnitsTypes;

public abstract class UnitProtectiveWithShield extends UnitProtective {
    
    public UnitProtectiveWithShield(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
    }
}
