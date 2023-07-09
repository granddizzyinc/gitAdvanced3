package units;
import arena.Arena;
import units.abstractUnits.Unit;

import java.util.ArrayList;

public interface UnitInterface {

    String getInfo();

    void die();

    void step(Arena arena);

    Unit findTarget(Arena arena, Team ourTeam);

    void actionInDiapason(Arena arena, Unit targetUnit, boolean moveMade);

    void actionNotInDiapason(Arena arena, Unit targetUnit, boolean moveMade);
}
