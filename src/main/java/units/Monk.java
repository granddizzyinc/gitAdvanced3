package units;

import units.Abstract.UnitProtectiveWithoutShild;

/**
 * Монах
 */
public class Monk extends UnitProtectiveWithoutShild {
    public Monk(String name) {
        super(UnitsTypes.Monk, name);
    }
}
