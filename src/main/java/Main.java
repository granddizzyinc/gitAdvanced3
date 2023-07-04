import units.abstractUnits.Unit;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Unit> team1 = new ArrayList<>(10);
        ArrayList<Unit> team2 = new ArrayList<>(10);

        Arena arena = new Arena(100, 100);

        arena.createTeam("Команда Добра", 1);
        arena.createTeam("Команда Зла", 1);

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
