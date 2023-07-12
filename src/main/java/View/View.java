package View;

//import Game.Units.Hero;

import units.*;
import units.abstractUnits.Unit;

import java.util.ArrayList;
import java.util.Collections;

import arena.map.Map;

public class View {
    private Map map = null;

    //    private static int step = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

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
            if (((Unit) field).getTeam().color.equals("RED"))
                out = "|" + (AnsiColors.ANSI_RED + sym + AnsiColors.ANSI_RESET);
            else if (((Unit) field).getTeam().color.equals("BLUE"))
                out = "|" + (AnsiColors.ANSI_BLUE + sym + AnsiColors.ANSI_RESET);
            else if (((Unit) field).getTeam().color.equals("GREEN"))
                out = "|" + (AnsiColors.ANSI_GREEN + sym + AnsiColors.ANSI_RESET);
            else if (((Unit) field).getTeam().color.equals("WHITE"))
                out = "|" + (AnsiColors.ANSI_WHITE + sym + AnsiColors.ANSI_RESET);

        }

        return out;
    }

    public void view(ArrayList<Team> teams, Integer step) {
        System.out.print(AnsiColors.ANSI_YELLOW + "Step " + step + AnsiColors.ANSI_RESET);

//            step++;
        teams.forEach((v) -> l[0] = Math.max(l[0], v.getSize()));
        System.out.print("_".repeat(l[0] * 2));
        System.out.println();

        //вывод верха таблицы
        System.out.print(formatDiv("a") + formatDiv("-") + String.join("", Collections.nCopies(map.sizeX - 1, formatDiv("-") + formatDiv("-b") + formatDiv("-"))) + formatDiv("-") + formatDiv("-c") + "    ");
        //System.out.print(AnsiColors.ANSI_GREEN + ":\tGreen side" + AnsiColors.ANSI_RESET);
        for (int i = 0; i < l[0] - 9; i++)
            System.out.println(" ".repeat(l[0] - 9));
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
            System.out.println("|    ");
//                System.out.print(Main.team1.get(i-1).getInfo());
//                tabSetter(Main.team1.get(i-1).getInfo().length(), l[0]);
//                System.out.println(Main.team2.get(i-1).getInfo());

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
    }
}
