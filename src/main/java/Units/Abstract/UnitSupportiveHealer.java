package Units.Abstract;

public abstract class UnitSupportiveHealer extends UnitSupportive {


    public UnitSupportiveHealer() {
        super();
    }

    /**
     * лечить
     *
     * @param unit
     */
    public void smallHeal(Unit unit) {
        unit.addHealth(10);
    }
}
