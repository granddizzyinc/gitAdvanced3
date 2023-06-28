package Units.Abstract;

public abstract class UnitAttackingWithWeapons extends UnitAttacking {


    public UnitAttackingWithWeapons() {
        super();
    }

    @Override
    public void performAnAttack(Unit unit) {
//        super.performAnAttack(unit);
        super.decreaseStamina(10);
    }
}
