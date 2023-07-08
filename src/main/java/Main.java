import arena.Arena;
import units.Team;
import units.abstractUnits.Unit;
import view.View;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        View view = new View();
        Arena arena = new Arena(50, 50, view);

        arena.createTeam("Команда Добра", 10);
        arena.createTeam("Команда Зла", 10);

        view.showUnits(arena.getTeams());

        arena.startTheBattle();
    }
}
