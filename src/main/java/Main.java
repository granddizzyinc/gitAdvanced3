import arena.Arena;
import arena.map.Map;
import view.View;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        View view = new View();
        Map map = new Map(15, 15);
        Arena arena = new Arena(map, view);

        arena.createTeam("Команда Добра", 10);
        arena.createTeam("Команда Зла", 10);

        arena.startTheBattle();
    }
}
