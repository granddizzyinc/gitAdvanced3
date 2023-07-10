package units;

import arena.Arena;
import units.abstractUnits.Unit;

import java.util.ArrayList;

public interface UnitInterface {

    String getInfo();

    void die();

    void step(Arena arena);

    /**
     * Находит цель
     * переопределяется каждому персонажу отдельно
     *
     * @param arena
     * @param ourTeam
     * @return
     */
    Unit findTarget(Arena arena, Team ourTeam);

    /**
     * Выполняет действия песонажа если цель в диапазоне
     * может выполнятся До перемещения и После
     *
     * @param arena
     * @param targetUnit
     * @param moveMade   сделал ли персонаж перемещение
     */
    void actionInDiapason(Arena arena, Unit targetUnit, boolean moveMade);

    /**
     * Выполняет действия песонажа если цель в не в диапазоне
     * может выполнятся До перемещения и После
     *
     * @param arena
     * @param targetUnit
     * @param moveMade   сделал ли персонаж перемещение
     */
    void actionNotInDiapason(Arena arena, Unit targetUnit, boolean moveMade);
}
