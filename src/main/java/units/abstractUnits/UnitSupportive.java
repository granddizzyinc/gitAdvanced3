package units.abstractUnits;

import arena.Arena;

public abstract class UnitSupportive extends Unit {

    private int speed;
    private int pointActivites;

    public UnitSupportive(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
        pointActivites = super.getPointActivites() * 2;
    }

    public UnitSupportive(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
    }

    public void actionInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {
        if (this.performAnAttack(targetUnit)) {

            //проверяем убили ли
            if (targetUnit.getHealth() == 0) {
                // выносим труп
                arena.removeTheCorpse(targetUnit);
            }
        }
    }

    @Override
    public void actionNotInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {
        System.out.println("Поддерживающий Не знаю что делать вне диапазона");
    }
}
