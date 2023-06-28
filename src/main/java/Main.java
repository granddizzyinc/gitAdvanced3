// 4 персонажа
// создать иерархию классов
//жизни атака защита расстояние атаки мана сила удара
// выстрел принести стрелу кастануть магию

import Units.*;

//Проанализировать и описать персонажей: Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин.
// На базе описания персонажей описать простейшую иерархию классов.
// В основной программе создать по одному экземпляру каждого класса.
public class Main {
    public static void main(String[] args) {
        Wizard mag1 = new Wizard();
        Monk monk1 = new Monk();
        Robber robber1 = new Robber();
        Spearman spearman1 = new Spearman();
        Sniper sniper1 = new Sniper();
        Crossbowman crossbowman1 = new Crossbowman();
        Peasant peasant1 = new Peasant();
    }
}
