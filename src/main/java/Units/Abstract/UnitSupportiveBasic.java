package Units.Abstract;

public abstract class UnitSupportiveBasic extends UnitSupportive {

    public UnitSupportiveBasic() {
        super();
    }

    public void putUpABarrier(Unit unit) {
        unit.decreaseAttack(5);
    }
}
