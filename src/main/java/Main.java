import arena.Arena;
import units.Team;
import units.abstractUnits.Unit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Arena arena = new Arena(50, 50);

        arena.createTeam("Команда Добра", 2);
        arena.createTeam("Команда Зла", 2);

        for (Team team : arena.getTeams()) {
            //team.showUnits(team);
            System.out.println(team.name);
            for (Unit unit : team) {
                System.out.println(unit.getInfo());
            }

            System.out.println();
        }

       arena.startTheBattle();

    }
}
