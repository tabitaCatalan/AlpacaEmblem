package model.factories.units;

import model.map.Location;
import model.units.Archer;

import java.util.HashMap;
import java.util.Map;

public class ArcherFactory extends AbstractUnitFactory{

    private Map<String, Integer> unitsDict;

    @Override
    protected void setUpDictionary(){
        unitsDict =  new HashMap<>();
        getItemsDictionary().put(HP_KEY, 50);
        getItemsDictionary().put(MOV_KEY, 2);
    }

    @Override
    protected Map<String, Integer> getItemsDictionary() {
        return unitsDict;
    }

    @Override
    public Archer createUnit(Location location) {
        return new Archer(getHitPoints(), getMovement(), location);
    }
}
