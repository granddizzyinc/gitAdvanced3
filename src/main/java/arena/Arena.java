package arena;

import units.*;
import units.abstractUnits.*;
import view.View;

import java.util.*;
import java.util.concurrent.TimeUnit;

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

    private View view;

    public Arena(int sizeX, int sizeY, View view) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.view = view;
    }

    public void createTeam(String name, int teamSize) {
        teams.add(new Team(name));
        Team team = teams.get(teams.size() - 1);
        generateTeam(team, teamSize);
        placeUnits(team);
    }
//    public void giveInitiative(ArrayList<units.Team> teammates){
//        for (int i = 0; i < teams.size(); i++) {
//            getTeam(i).se
//        }
//    }

    /**
     * генерирует команду из случайных юнитов
     *
     * @param team
     * @param teamSize
     */
    private static void generateTeam(Team team, int teamSize) {
        for (int i = 0; i < teamSize; i++) {
            switch (new Random().nextInt(10)) {
                case 0 -> team.addUnit(new Crossbowman(Unit.getRandomUnitName()));
                case 1 -> team.addUnit(new Druid(Unit.getRandomUnitName()));
                case 2 -> team.addUnit(new Monk(Unit.getRandomUnitName()));
                case 3 -> team.addUnit(new Palladine(Unit.getRandomUnitName()));
                case 4 -> team.addUnit(new Peasant(Unit.getRandomUnitName()));
                case 5 -> team.addUnit(new Robber(Unit.getRandomUnitName()));
                case 6 -> team.addUnit(new Sniper(Unit.getRandomUnitName()));
                case 7 -> team.addUnit(new Spearman(Unit.getRandomUnitName()));
                case 8 -> team.addUnit(new Wizard(Unit.getRandomUnitName()));
                case 9 -> team.addUnit(new Sorcerer(Unit.getRandomUnitName()));
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

    public void returningPointActivities() {

    }

    /**
     * запускает раунды
     */
    public void startTheBattle() throws InterruptedException {
        if (teams.size() < 2) {
            view.errorNumberCommands();
            return;
        }

        view.showStartBattle();

        //если нужен следующий раунд то запускаем
        while (checkTheNeedForTheNextRound()) {
            round += 1;

            view.showRaund(round);

            //выбираем команду которая будет ходить
            for (Team team : teams) {
                // если всех уже замочили
                if (team.getNumberOfUnits() == 0) continue;

                // рандомно задаем инициативу
                setTheInitiative(team);

                //каждый юнит делает ход в порядке уменьшения инициативы
                for (Unit unit : team) {
                    view.showWhoseMove(unit);

                    //восстанавливаем очки активности
                    //одно очко тратит на ходьбу
                    //второе очко тратит на действие
                    unit.setPointActivites(2);

                    // персонаж делает ход в игре
                    unit.step(this);

                    // пауза для наглядности
                    TimeUnit.SECONDS.sleep(1);

                    view.showVoid();

////                        Ближники: копейщик (у него исключение в 2 клетки), разбойник, друид, паладин, крестьянин
////                        Дальники: Арбалетчик, монах, снайпер, чародей (ему уменьшить дальности на 1 клетку), волшебник

                }
            }
        }

        // проверяем победителя
        Team winner = getWinner();
        if (winner != null) {
            view.reportWinner(winner);
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

    public Unit findTheNearestTeamUnit(Team ourTeam, Unit unit, boolean alien) {
        Unit nearestUnit = null;
        double minDistance = this.sizeX + this.sizeY;
        for (Team tmpTeam : teams) {
            if ((alien && tmpTeam.equals(ourTeam)) || (!alien && !tmpTeam.equals(ourTeam))) {
                continue;
            }

            for (Unit tmpUnit : tmpTeam) {
                //главное в любом расследовании не выйти на самого себя
                if (tmpUnit.equals(unit)) continue;

                double distance = unit.getCoordinates().calculateDistance(tmpUnit.getCoordinates());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestUnit = tmpUnit;
                }
            }
        }
        return nearestUnit;
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

    /**
     * Находит ближайшего персонажа с минимальным здоровьем
     *
     * @return
     */
    public Unit findAUnitWithMinimumHealth(Team ourTeam, Unit unit, boolean alien) {
        Unit minHealthUnit = null;
        int minHealth = 100;
        for (Team teamTmp : teams) {
            if ((alien && teamTmp.equals(ourTeam)) || (!alien && !teamTmp.equals(ourTeam))) {
                continue;
            }

            for (Unit unit_tmp : teamTmp) {
                //главное в любом расследовании не выйти на самого себя
                if (unit_tmp.equals(unit)) continue;

                if (unit_tmp.getHealth() < minHealth) {
                    minHealth = unit_tmp.getHealth();
                    minHealthUnit = unit_tmp;
                }
            }
        }

        return minHealthUnit;
    }

    /**
     * Перемешивает команду в порядке инициативы
     *
     * @param team
     */
    private void setTheInitiative(Team team) {
        ArrayList<Unit> tmp = new ArrayList<>(team.teamList.size());

        while (team.teamList.size() > 0) {
            int i = new Random().nextInt(team.teamList.size());
            tmp.add(team.teamList.get(i));
            team.teamList.remove(i);
        }

        team.teamList = tmp;
    }

    public void removeTheCorpse(Unit unit) {
        for (Team team : teams) {
            for (int i = 0; i < team.teamList.size(); i++) {
                if (team.teamList.get(i).equals(unit)) {
                    team.teamList.remove(i);
                    view.reportDeath(team, unit);
                    break;
                }
            }
        }
    }

    public Coordinates getNextStepPosition(Coordinates beginCoordinates, Coordinates endCoordinates) {
        Coordinates stepCoordinates = new Coordinates(beginCoordinates.x, beginCoordinates.y);
        //если по прямой
        if (beginCoordinates.x == endCoordinates.x) {
            if (endCoordinates.y > beginCoordinates.y) {
                stepCoordinates.y += 1;
            } else {
                stepCoordinates.y -= 1;
            }
        } else if (beginCoordinates.y == endCoordinates.y) {
            if (endCoordinates.x > beginCoordinates.x) {
                stepCoordinates.x += 1;
            } else {
                stepCoordinates.x -= 1;
            }
        } else {
            //иначе вычисляем угол
            double angle = Math.asin(Math.abs(endCoordinates.y - beginCoordinates.y) / beginCoordinates.calculateDistance(endCoordinates)) * 180 / Math.PI;

            if (endCoordinates.y > beginCoordinates.y && endCoordinates.x > beginCoordinates.x) {
                // 1 четверть

                if (angle <= 33) {
                    stepCoordinates.x += 1;
                } else if (angle >= 66) {
                    stepCoordinates.y += 1;
                } else {
                    stepCoordinates.x += 1;
                    stepCoordinates.y += 1;
                }
            } else if (endCoordinates.y > beginCoordinates.y && endCoordinates.x < beginCoordinates.x) {
                // 2 четверть

                if (angle <= 33) {
                    stepCoordinates.x -= 1;
                } else if (angle >= 66) {
                    stepCoordinates.y += 1;
                } else {
                    stepCoordinates.x -= 1;
                    stepCoordinates.y += 1;
                }
            } else if (endCoordinates.y < beginCoordinates.y && endCoordinates.x < beginCoordinates.x) {
                // 3 четверть

                if (angle <= 33) {
                    stepCoordinates.x -= 1;
                } else if (angle >= 66) {
                    stepCoordinates.y -= 1;
                } else {
                    stepCoordinates.x -= 1;
                    stepCoordinates.y -= 1;
                }
            } else if (endCoordinates.y < beginCoordinates.y && endCoordinates.x > beginCoordinates.x) {
                // 4 четверть

                if (angle <= 33) {
                    stepCoordinates.x += 1;
                } else if (angle >= 66) {
                    stepCoordinates.y -= 1;
                } else {
                    stepCoordinates.x += 1;
                    stepCoordinates.y -= 1;
                }
            }

        }

        return stepCoordinates;
    }

    public Team getUnitTeam(Unit unit) {
        for (Team tmpTeam : teams) {
            for (Unit tmpUnit : tmpTeam) {
                if (unit.equals(tmpUnit)) {
                    return tmpTeam;
                }
            }
        }
        return null;
    }
}