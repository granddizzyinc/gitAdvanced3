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
        if (!this.applyAbility(targetUnit)) {
            // если не смогли применить спобосность
            if (this.performAnAttack(targetUnit)) {
                // если смогли атаковать
                arena.addArenaMessage(this, targetUnit, " атака на ");

                //проверяем убили ли
                if (targetUnit.getHealth() == 0) {
                    // выносим труп
                    arena.removeTheCorpse(targetUnit);
                }

                if (!moveMade) {
                    // если шаг НЕ сделан
                    //this.concentration();
                }
            } else {
                // если не смогли атаковать
                if (!moveMade) {
                    // если шаг НЕ сделан
                    this.clearPointActivites();
                    arena.addArenaMessage(this, null, " пропустил ход");
                } else {
                    arena.addArenaMessage(this, targetUnit, " переместился к ");
                }
            }
        } else {
            arena.addArenaMessage(this, targetUnit, " способности на ");
        }
    }

    @Override
    public void actionNotInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {
        if (moveMade) {
            // если шаг сделан
            //if (!this.concentration()) {
            // если не смогли сконцентрироваться
            this.clearPointActivites();
            arena.addArenaMessage(this, targetUnit, " переместился к ");
            //}
        } else {
            arena.addArenaMessage(this, null, " пропустил ход");
        }
    }
}
