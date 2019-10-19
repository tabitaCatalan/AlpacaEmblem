package model.factories.units;

import model.map.Location;
import model.units.Fighter;

import java.util.HashMap;
import java.util.Map;

public class FighterFactory extends AbstractUnitFactory{

    private Map<String, Integer> unitsDict;

    @Override
    protected void setUpDictionary(){
        unitsDict =  new HashMap<>();
        getItemsDictionary().put(HP_KEY, 90);
        getItemsDictionary().put(MOV_KEY, 1);
    }

    @Override
    protected Map<String, Integer> getItemsDictionary() {
        return unitsDict;
    }

    @Override
    public Fighter createUnit(Location location) {
        return new Fighter(getHitPoints(), getMovement(), location);
    }
}
