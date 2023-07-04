import units.*;
import units.abstractUnits.*;

import java.util.*;

public class Arena implements ArenaInterface {
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
        Team team = teams.get(teams.size() - 1);
        generateTeam(team, teamSize);
        placeUnits(team);
    }

    /**
     * генерирует команду из случайных юнитов
     *
     * @param team
     * @param teamSize
     */
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

    /**
     * расставляет команду на арене
     * задает координаты юнитам
     *
     * @param team
     */
    private void placeUnits(Team team) {
        for (Unit unit : team) {
            unit.setCoordinates(getStartCoordinates(team, unit));
        }
    }

    private static String getRandomUnitName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    public void returningPointActivities() {

    }

    /**
     * запускает раунды
     */
    public void startTheBattle() {
        if (teams.size() < 2) {
            System.out.println("Создайте минимум две команды!");
            return;
        }

        System.out.println("");

        while (checkTheNeedForTheNextRound()) {

            //махач :)
            for (Team teamWho : teams) {

                // если всех уже замочили
                if (teamWho.getNumberOfUnits() == 0) continue;

                //выбираем кто будет дубасить
//                Unit who = teamWho.teamList.get(new Random().nextInt(teamWho.teamList.size()));

                // дубасить будет каждый
                for (Unit who : teamWho) {
                    //выбираем команду которую дубасить
                    for (Team teamWhom : teams) {
//                        если всех уже замочили
                        if (teamWhom.getNumberOfUnits() == 0) continue;

                        if (teamWhom.equals(teamWho)) continue;

                        // выбираем юнита из этой команды которого дубасить. Ближнего
                        Unit whom = findTheNearestTeamUnit(who, teamWhom);

                        System.out.println(teamWho.name + " " + who.getShortInfo() + " атакует " + teamWhom.name + " " + whom.getShortInfo());

//                    //дубасим
                        who.performAnAttack(whom);

                        //проверяем убили ли
                        if (whom.getHealth() == 0) {
                            teamWhom.killUnit(whom);
                        }


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

    /**
     * проверяет если ли победитель
     *
     * @return
     */
    private boolean checkTheNeedForTheNextRound() {
        int numberOfActiveTeams = 0;
        for (Team team : teams) {
            if (team.getNumberOfUnits() > 0) {
                numberOfActiveTeams += 1;
            }
        }

        return numberOfActiveTeams > 1;
    }

    /**
     * определяет победителя
     *
     * @return
     */
    private Team getWinner() {
        for (Team team : teams) {
            if (team.getNumberOfUnits() > 0) {
                return team;
            }
        }
        return null;
    }

    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private Unit findTheNearestTeamUnit(Unit unit, Team team) {
        Unit nearest = null;
        double minDistance = this.sizeX + this.sizeY;
        for (Unit u : team) {
            double distance = distance(unit.getCoordinates().x, unit.getCoordinates().y, u.getCoordinates().x, u.getCoordinates().y);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = u;
            }
        }
        return nearest;
    }

    private Coordinates getStartCoordinates(Team team, Unit unit) {
        int side = 0;

        //найдем индекс команды и приравняем к стороне
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).equals(team)) {
                side = i;
                break;
            }
        }

        Coordinates coordinates = null;

        if (side == 0) {
            int y = 0;
            boolean flag = false;
            while (!flag) {
                y = new Random().nextInt(this.sizeY);
                flag = true;

                for (Unit u : team) {
                    if (u.getCoordinates() == null) continue;

                    if (u.getCoordinates().y == y) {
                        flag = false;
                        break;
                    }
                }
            }

            if (unit instanceof UnitAttacking) {
                coordinates = new Coordinates(0, y);
            } else if (unit instanceof UnitProtective) {
                coordinates = new Coordinates(0, y);
            } else if (unit instanceof UnitSupportive) {
                coordinates = new Coordinates(0, y);
            }
        } else if (side == 1) {
            int y = 0;
            boolean flag = false;
            while (!flag) {
                y = new Random().nextInt(this.sizeY);
                flag = true;

                for (Unit u : team) {
                    if (u.getCoordinates() == null) continue;

                    if (u.getCoordinates().y == y) {
                        flag = false;
                        break;
                    }
                }
            }

            if (unit instanceof UnitAttacking) {
                coordinates = new Coordinates(this.sizeX, y);
            } else if (unit instanceof UnitProtective) {
                coordinates = new Coordinates(this.sizeX, y);
            } else if (unit instanceof UnitSupportive) {
                coordinates = new Coordinates(this.sizeX, y);
            }
        }


        return coordinates;
    }


    @Override
    public void unit_turning() {

    }

    @Override
    public void rounding() {

    }

    @Override
    public void initiative() {

    }

    @Override
    public void unit_dying() {

    }

    @Override
    public void target_choice() {

    }
}