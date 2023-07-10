package units;

import org.jetbrains.annotations.NotNull;
import units.abstractUnits.Unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class Team implements Iterator<Unit>, Iterable<Unit> {
    public final String name;

    private ArrayList<Unit> teamList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public ArrayList<Unit> getUnits() {
        return teamList;
    }

    public void addUnit(Unit unit) {
        teamList.add(unit);
    }

    public int getNumberOfUnits() {
        return teamList.size();
    }

    int index = -1;

    @Override
    public boolean hasNext() {
        index++;
        return index < teamList.size() - 1;
    }

    @Override
    public Unit next() {
        return teamList.get(index);
    }

    @NotNull
    @Override
    public Iterator iterator() {
        Iterator<Unit> it = new Iterator<Unit>() {

            private int index = -1;
            @Override
            public boolean hasNext() {
                index++;
                return index < teamList.size();
            }

            @Override
            public Unit next() {
                return teamList.get(index);
            }
        };

        return it;
    }

    public boolean contains(Unit unit) {
        return teamList.contains(unit);
    }

    public int getSize() {
        return teamList.size();
    }

    public void removeUnit(Unit unit) {
        teamList.remove(unit);
    }

    /**
     * Выстраивает команду в порядке инициативы
     */
    public void setTheInitiative() {
        ArrayList<Unit> tmp = new ArrayList<>(this.teamList.size());

        while (this.getSize() > 0) {
            int i = new Random().nextInt(this.getSize());
            tmp.add(this.getUnits().get(i));
            this.getUnits().remove(i);
        }

        this.teamList = tmp;
    }
}
