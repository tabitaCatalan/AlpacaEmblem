package model.factories.units;

import model.map.Location;
import model.units.Alpaca;
import model.units.Archer;

import java.util.HashMap;
import java.util.Map;

public class AlpacaFactory extends AbstractUnitFactory{

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
    public Alpaca createUnit(Location location) {
        return new Alpaca(getHitPoints(), getMovement(), location);
    }
}
