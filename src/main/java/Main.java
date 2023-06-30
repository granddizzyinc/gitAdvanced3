// 4 персонажа
// создать иерархию классов
//жизни атака защита расстояние атаки мана сила удара
// выстрел принести стрелу кастануть магию

import units.*;
import units.Abstract.Unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

//Проанализировать и описать персонажей: Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин.
// На базе описания персонажей описать простейшую иерархию классов.
// В основной программе создать по одному экземпляру каждого класса.
public class Main {
    public static void main(String[] args) {
        ArrayList<Unit> team1 = new ArrayList<>(10);
        ArrayList<Unit> team2 = new ArrayList<>(10);

        generateTeam(team1);
        generateTeam(team2);

        for (Unit unit : team1) {
            System.out.println(unit.getInfo());
        }

        System.out.println();

        for (Unit unit : team2) {
            System.out.println(unit.getInfo());
        }

    }

    public static void generateTeam(ArrayList<Unit> team) {
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(9)) {
                case 0 -> team.add(new Crossbowman(getRandomName()));
                case 1 -> team.add(new Druid(getRandomName()));
                case 2 -> team.add(new Monk(getRandomName()));
                case 3 -> team.add(new Palladine(getRandomName()));
                case 4 -> team.add(new Peasant(getRandomName()));
                case 5 -> team.add(new Robber(getRandomName()));
                case 6 -> team.add(new Sniper(getRandomName()));
                case 7 -> team.add(new Spearman(getRandomName()));
                case 8 -> team.add(new Wizard(getRandomName()));
            }
        }
    }

    public static String getRandomName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
}
