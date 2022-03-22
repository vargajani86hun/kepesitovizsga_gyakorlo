package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<MilitaryUnit> units = new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        units.add(militaryUnit);
    }

    public void damageAll(int damage) {
        sufferDamageAll(damage);

        removeUnarmedUnits();
    }

    public int getArmyDamage() {
        return units.stream().mapToInt(MilitaryUnit::doDamage).sum();
    }

    public int getArmySize() {
        return units.size();
    }

    private void removeUnarmedUnits() {
        units.removeIf(m -> m.getHitPoints() < 25);
    }

    private void sufferDamageAll(int damage) {
        units.forEach(m -> m.sufferDamage(damage));
    }
}
