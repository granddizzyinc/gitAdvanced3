package Units.Abstract;

public abstract class UnitProtective extends Unit {

    private int abilityPoints;

    public UnitProtective() {
        super();
        abilityPoints = 0;

    }

//    @Override
//    public void performAnAttack(Unit unit) {
//
//    }

    public void concentration() {
//        super.decreasePointActivites(1);
        super.skipAMove();
        if (abilityPoints < 3) {
            abilityPoints += 1;
        }
    }

    public int getAbilityPoints() {
        return abilityPoints;
    }
//    public void addAbilityPoints(int value) {
//        abilityPoints += value;
//    }

    public void useAbility(){
        abilityPoints = 0;
    }

    public void decreaseAttack(int value) {
        //super.d
    }
}
