import units.Coordinates;
import units.abstractUnits.Unit;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Arena arena = new Arena(50, 50);

        arena.createTeam("Команда Добра", 10);
        arena.createTeam("Команда Зла", 10);

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
