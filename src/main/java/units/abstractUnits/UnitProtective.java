package units.abstractUnits;

import arena.Arena;

public abstract class UnitProtective extends Unit {
    private float increasingDefence;
    private int abilityPoints;

    public UnitProtective(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
        this.abilityPoints = 0;
    }

    public UnitProtective(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
    }

    public boolean concentration() {
        //super.skipAMove();
        if (abilityPoints < 3) {
            abilityPoints += 1;
            return true;
        }
        return false;
    }

    public int getAbilityPoints() {
        return abilityPoints;
    }

    public void clearAbilityPoints() {
        abilityPoints = 0;
    }

    public void decreaseDamage(int increasingDefence) {
        super.decreaseAttack(increasingDefence);
    }

    public float getIncreasingDefence() {
        return increasingDefence;
    }

    @Override
    public void actionInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {
        if (!this.applyAbility(targetUnit)) {
            // если не смогли применить спобосность
            if (this.performAnAttack(targetUnit)) {
                // если смогли атаковать

                //проверяем убили ли
                if (targetUnit.getHealth() == 0) {
                    // выносим труп
                    arena.removeTheCorpse(targetUnit);
                }

                if (!moveMade) {
                    // если шаг НЕ сделан
                    this.concentration();
                }
            } else {
                // если не смогли атаковать
                if (!moveMade) {
                    // если шаг НЕ сделан
                    this.clearPointActivites();
                }
            }
        }
    }

    @Override
    public void actionNotInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {
        if (moveMade) {
            // если шаг сделан
            if (!this.concentration()) {
                // если не смогли сконцентрироваться
                this.clearPointActivites();
            }
        }
    }
}
