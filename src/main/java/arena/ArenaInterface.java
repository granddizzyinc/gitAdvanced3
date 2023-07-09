package arena;

import units.Team;
import units.abstractUnits.Unit;

public interface ArenaInterface {
    void unit_turning();
    void rounding(); // использовать порядок инициативы
    void initiative();  // инициативу через массив?
    void unit_dying(); // когда хп = 0 то удалять из списка
    void target_choice();   //для атакующих и защищающих одновременно?

    void createTeam(String name, int teamSize);

    void startTheBattle() throws InterruptedException;

    Unit findTheNearestTeamUnit(Team ourTeam, Unit unit, boolean alien);

    Unit findAUnitWithMinimumHealth(Team ourTeam, Unit unit, boolean alien);

    void removeTheCorpse(Unit unit);
}
