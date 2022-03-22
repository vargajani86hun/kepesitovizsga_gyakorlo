package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit{

    private int attacks = 0;

    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        if (attacks == 0) {
            attacks++;
            return super.doDamage() * 3;
        } else {
            return super.doDamage();
        }
    }
}
