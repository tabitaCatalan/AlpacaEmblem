package model.factories.items;

import model.items.nonMagic.Spear;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an Spear Factory. It produces items of the class Spear.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public class SpearFactory extends AbstractItemFactory{

    private Map<String, String> itemsDict;

    @Override
    protected void setUpDictionary(){
        itemsDict =  new HashMap<>();
        getItemsDictionary().put(NAME, "Spear");
        getItemsDictionary().put(POWER, "10");
        getItemsDictionary().put(MIN_RANGE, "1");
        getItemsDictionary().put(MAX_RANGE, "2");
    }

    public Map<String, String> getItemsDictionary(){
        return itemsDict;
    }

    @Override
    public Spear createItem() {
        return new Spear(getName(), getPower(), getMinRange(), getMaxRange());
    }
}
