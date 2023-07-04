import units.*;
import units.abstractUnits.Unit;

import java.util.*;

public class Arena {
    private final int sizeX;
    private final int sizeY;
    int round;
    boolean turns;
    private final ArrayList<Team> teams = new ArrayList<>();

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public Team getTeam(int index) {
        return teams.get(index);
    }

    public Arena(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void createTeam(String name, int teamSize) {
        teams.add(new Team(name));
        generateTeam(teams.get(teams.size() - 1), teamSize);
    }

    private static void generateTeam(Team team, int teamSize) {
        for (int i = 0; i < teamSize; i++) {
            switch (new Random().nextInt(10)) {
                case 0 -> team.addUnit(new Crossbowman(getRandomUnitName()));
                case 1 -> team.addUnit(new Druid(getRandomUnitName()));
                case 2 -> team.addUnit(new Monk(getRandomUnitName()));
                case 3 -> team.addUnit(new Palladine(getRandomUnitName()));
                case 4 -> team.addUnit(new Peasant(getRandomUnitName()));
                case 5 -> team.addUnit(new Robber(getRandomUnitName()));
                case 6 -> team.addUnit(new Sniper(getRandomUnitName()));
                case 7 -> team.addUnit(new Spearman(getRandomUnitName()));
                case 8 -> team.addUnit(new Wizard(getRandomUnitName()));
                case 9 -> team.addUnit(new Sorcerer(getRandomUnitName()));
            }
        }
    }

    private static String getRandomUnitName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    public void returningPointActivities() {

    }

    public void startTheBattle() {
        if (teams.size() < 2) {
            System.out.println("Создайте минимум две команды!");
            return;
        }

        System.out.println("И треснул мир напополам, дымит разлом,\n" +
                "И льётся кровь, идёт война добра со злом..\n");

        while (checkTheNeedForTheNextRound()) {

            //махач :)
            for (Team teamWho : teams) {

                // если всех уже замочили
                if (teamWho.getNumberOfUnits() == 0) continue;

                //выбираем кто будет дубасить
                Unit who = teamWho.teamList.get(new Random().nextInt(teamWho.teamList.size()));

                //выбираем кого дубасить
                for (Team teamWhom : teams) {

                    // если всех уже замочили
                    if (teamWhom.getNumberOfUnits() == 0) continue;

                    if (teamWhom.equals(teamWho)) continue;

                    Unit whom = teamWhom.teamList.get(new Random().nextInt(teamWhom.teamList.size()));

                    System.out.println(teamWho.name + " " + who.getShortInfo() + " атакует " + teamWhom.name + " " + whom.getShortInfo());

                    //дубасим
                    who.performAnAttack(whom);

                    //проверяем убили ли
                    if (whom.getHealth() == 0) {
                        teamWhom.killUnit(whom);
                    }
                }
            }
        }

        //  победитель
        Team winner = getWinner();
        if (winner != null) {
            System.out.println();
            System.out.println("Победитель: " + winner.name);
        }
    }

    private boolean checkTheNeedForTheNextRound() {
        int numberOfActiveTeams = 0;
        for (Team team : teams) {
            if (team.getNumberOfUnits() > 0) {
                numberOfActiveTeams += 1;
            }
        }

        return numberOfActiveTeams > 1;
    }

    private Team getWinner() {
        for (Team team : teams) {
            if (team.getNumberOfUnits() > 0) {
                return team;
            }
        }
        return null;
    }


}