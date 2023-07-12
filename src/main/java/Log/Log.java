package Log;

import units.Team;
import units.abstractUnits.Unit;

import java.util.ArrayList;

public class Log {
    public void showUnits(ArrayList<Team> teams) {
//        for (Team team :teams){
//            System.out.println(team.name);
//            this.showTeamUnits(team);
//            System.out.println();
//        }
    }

    public void showTeamUnits(Team team) {
//        for (Unit unit : team) {
//            System.out.println(unit.getInfo());
//        }
    }

    public void showStartBattle() {
//        System.out.println("Да начнеться бой!");
    }

    public void showRaund(int round) {
//        System.out.println("Раунд: " + round);
    }

    public void showWhoseMove(Team team, Unit unit){

//        System.out.println("ХОД: " + team.name + " " + unit);
    }

    public void showVoid() {
//        System.out.println();
    }

    public void reportDeath(Team team, Unit unit) {
//        System.out.println("Убит: Команда: " + team.name + " " + unit.getInfo());
    }

    public void reportWinner(Team winner) {
//        System.out.println();
//        System.out.println("Победитель: " + winner.name);
    }

    public void errorNumberCommands() {
//        System.out.println("Создайте 2 - 4 команды!");
    }

    public void addLogMessage(String message) {

    }
}
