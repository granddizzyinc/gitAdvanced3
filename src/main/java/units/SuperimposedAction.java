package units;

public class SuperimposedAction {
    public String name;
    public int period;
    public int attackChangeNumber;
    public int defendChangeNumber;
    private int startRaund;
    public int speedChangeNumber;

    public SuperimposedAction(String name, int period, int attackChangeNumber, int defendChangeNumber, int speedChangeNumber) {
        this.name = name;
        this.period = period;
        this.attackChangeNumber = attackChangeNumber;
        this.defendChangeNumber = defendChangeNumber;
        this.speedChangeNumber = speedChangeNumber;
    }

    public void setStartRaund(int startRaund) {
        if (startRaund == 0) this.startRaund = startRaund;
    }

    public int getStartRaund() {
        return startRaund;
    }
}
