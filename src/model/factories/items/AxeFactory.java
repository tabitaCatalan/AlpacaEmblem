package model.factories.items;


import model.items.nonMagic.Axe;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an Axe Factory. It produces items of the class Axe.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public class AxeFactory extends AbstractItemFactory{

    private Map<String, String> itemsDict =  new HashMap<>();


    public AxeFactory(){
        addItemParameters();
    }

    private void addItemParameters(){
        getItemsDictionary().put(NAME, "Battle Axe");
        getItemsDictionary().put(POWER, "10");
        getItemsDictionary().put(MIN_RANGE, "1");
        getItemsDictionary().put(MAX_RANGE, "2");
    }

    public Map<String, String> getItemsDictionary(){
        return itemsDict;
    }

    @Override
    public Axe createItem() {
        return new Axe(getName(), getPower(), getMinRange(), getMaxRange());
    }
}
