package model.factories.units;

import model.map.Location;
import model.units.Hero;

import java.util.HashMap;
import java.util.Map;

public class HeroFactory extends AbstractUnitFactory{

    private Map<String, Integer> unitsDict;

    @Override
    protected void setUpDictionary(){
        unitsDict =  new HashMap<>();
        getItemsDictionary().put(HP_KEY, 70);
        getItemsDictionary().put(MOV_KEY, 3);
    }

    @Override
    protected Map<String, Integer> getItemsDictionary() {
        return unitsDict;
    }

    @Override
    public Hero createUnit(Location location) {
        return new Hero(getHitPoints(), getMovement(), location);
    }
}
