package Units.Abstract;

public abstract class UnitProtective extends Unit {

    private int stamina;

    public UnitProtective() {
        super();
        stamina = 100;
    }

    public int getStamina() {
        return stamina;
    }
    public void addStamina(int value) {
        stamina += value;
    }

    public void decreaseStamina(int value) {
        stamina -= value;
    }
}
