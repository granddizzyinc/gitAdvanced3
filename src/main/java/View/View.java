package View;

//import Game.Units.Hero;

import arena.ArenaMessage;
import units.*;
import units.abstractUnits.Unit;

import java.util.ArrayList;
import java.util.Collections;

import arena.map.Map;

public class View {
    private Map map;

    //    private static int step = 1;
//    private static final int[] l = {0};
//    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
//    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
//    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    public View(Map map) {
        this.map = map;
    }

    private static void tabSetter(int cnt, int max) {
        int dif = max - cnt + 2;
        if (dif > 0) System.out.printf("%" + dif + "s", ":\t");
        else System.out.print(":\t");
    }

    private static String formatDiv(String str) {
        return str.replace('a', '┌')
                .replace('b', '┬')
                .replace('c', '┐')
                .replace('d', '├')
                .replace('e', '┼')
                .replace('f', '┤')
                .replace('g', '└')
                .replace('h', '┴')
                .replace('i', '┘')
                .replace('-', '─');
    }

    private String getChar(int x, int y) {
        String out = "|   ";
//        for (Unit unit : team) {
//                if (human.getCoords()[0] == x && human.getCoords()[1] == y){
//                    if (human.getHp() == 0) {
//                        out = "|" + (AnsiColors.ANSI_RED + human.toString().charAt(0) + AnsiColors.ANSI_RESET);
//                        break;
//                    }
//                    if (Main.team1.contains(human)) out = "|" + (AnsiColors.ANSI_GREEN + human.toString().charAt(0) + AnsiColors.ANSI_RESET);
//                    if (Main.team2.contains(human)) out = "|" + (AnsiColors.ANSI_BLUE + human.toString().charAt(0) + AnsiColors.ANSI_RESET);
//                    break;
//                }
//        }

        Object field = this.map.getField(x, y);

        String sym = "";

        if (field instanceof Crossbowman)
            sym = "Crb";
        else if (field instanceof Druid)
            sym = "Drd";
        else if (field instanceof Monk)
            sym = "Mnk";
        else if (field instanceof Palladine)
            sym = "Pln";
        else if (field instanceof Peasant)
            sym = "Pst";
        else if (field instanceof Robber)
            sym = "Rbr";
        else if (field instanceof Sniper)
            sym = "Snr";
        else if (field instanceof Sorcerer)
            sym = "Srr";
        else if (field instanceof Spearman)
            sym = "Spn";
        else if (field instanceof Wizard)
            sym = "Wzd";
        else
            sym = "   ";

        if (field instanceof Unit) {
            out = "|" + (getAnsiColor(((Unit) field).getTeam().color) + sym + AnsiColors.ANSI_RESET);
        } else {
            out = "|" + sym;
        }

        return out;
    }

    public void view(Integer step, ArrayList<Team> teams, ArrayList<ArenaMessage> arenaMessages) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        System.out.print(AnsiColors.ANSI_YELLOW + "Step " + step + AnsiColors.ANSI_RESET);
        //teams.forEach((v) -> l[0] = Math.max(l[0], v.getSize()));
        //System.out.print("_".repeat(l[0] * 2));
        System.out.println();

        //вывод верха таблицы
        System.out.print(formatDiv("a") + formatDiv("-") + String.join("", Collections.nCopies(map.sizeX - 1, formatDiv("-") + formatDiv("-b") + formatDiv("-"))) + formatDiv("-") + formatDiv("-c") + "    ");

        for (Team team : teams) {
            //System.out.print(AnsiColors.ANSI_GREEN + ":\tGreen side" + AnsiColors.ANSI_RESET);
            //for (int i = 0; i < l[0] - 9; i++)
            //    System.out.println(" ".repeat(l[0] - 9));
            System.out.print(getAnsiColor(team.color) + team.name + AnsiColors.ANSI_RESET);
            tabSetter(team.name.length(), 70);
        }
        System.out.println();
        //System.out.print(AnsiColors.ANSI_GREEN + ":\tGreen side" + AnsiColors.ANSI_RESET);
        //for (int i = 0; i < l[0] - 9; i++)
        //    System.out.println(" ".repeat(l[0] - 9));
//        System.out.println(AnsiColors.ANSI_BLUE + "Blue side" + AnsiColors.ANSI_RESET);


        for (int i = 0; i < map.sizeX; i++) {
            System.out.print(getChar(i, 0));
        }
        System.out.print("|    ");
        //System.out.print(teams.get(0).name);
        //tabSetter(teams.get(0).getSize(), l[0]);
        //System.out.println(teams.get(1).name);

        System.out.println();

        // вывод серидины таблицы
        System.out.println(formatDiv("d") + formatDiv("-") + String.join("", Collections.nCopies(map.sizeX - 1, formatDiv("-") + formatDiv("-e") + formatDiv("-"))) + formatDiv("-") + formatDiv("-f"));

        for (int i = 1; i < map.sizeY - 1; i++) {
            for (int j = 0; j < map.sizeX; j++) {
                System.out.print(getChar(j, i));
            }
            System.out.print("|    ");

            for (Team team : teams) {
                Unit u = team.getUnit(i - 1);
                if (u != null) {
                    System.out.print(getAnsiColor(team.color) + u.getInfo() + AnsiColors.ANSI_RESET);
                    tabSetter(u.getInfo().length(), 70);
                } else {
                    tabSetter(0, 70);
                }
            }
            System.out.println();

            //вывод серидины таблицы
            System.out.println(formatDiv("d") + formatDiv("-") + String.join("", Collections.nCopies(map.sizeX - 1, formatDiv("-") + formatDiv("-e") + formatDiv("-"))) + formatDiv("-") + formatDiv("-f"));
        }

        for (int j = 0; j < map.sizeX; j++) {
            System.out.print(getChar(j, map.sizeY - 1));
        }
        System.out.println("|    ");
//            System.out.print(Main.team1.get(9).getInfo());
//            tabSetter(Main.team1.get(9).getInfo().length(), l[0]);
//            System.out.println(Main.team2.get(9).getInfo());
        //вывод низа таблицы
        System.out.println(formatDiv("g") + formatDiv("-") + String.join("", Collections.nCopies(map.sizeX - 1, formatDiv("-") + formatDiv("-h") + formatDiv("-"))) + formatDiv("-") + formatDiv("-i"));

        for (ArenaMessage msg: arenaMessages) {
            if (msg.unit != null) System.out.print(getAnsiColor(msg.unit.getTeam().color) +  msg.unit.getType() + " " + msg.unit.getName() + AnsiColors.ANSI_RESET);
            if (msg.message != null) System.out.print(msg.message);
            if (msg.target != null) System.out.print(getAnsiColor(msg.target.getTeam().color) + msg.target.getType() + " " + msg.target.getName() + AnsiColors.ANSI_RESET);
            System.out.println();
        }
        arenaMessages.clear();
    }

    private String getAnsiColor(String color) {
        return switch (color) {
            case "RED" -> AnsiColors.ANSI_RED;
            case "BLUE" -> AnsiColors.ANSI_BLUE;
            case "GREEN" -> AnsiColors.ANSI_GREEN;
            case "WHITE" -> AnsiColors.ANSI_WHITE;
            default -> null;
        };
    }
}
