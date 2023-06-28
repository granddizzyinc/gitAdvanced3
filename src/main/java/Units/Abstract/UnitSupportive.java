package Units.Abstract;

public abstract class UnitSupportive extends Unit {

    private int speed;
    private int pointActivites;

    public UnitSupportive() {
        super();
//        speed = super.getSpeed() * 2;
        pointActivites = super.getPointActivites() * 2;
    }
}
