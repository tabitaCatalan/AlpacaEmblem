package model.factories.items;

import model.items.nonMagic.Bow;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a Bow Factory. It produces items of the class Bow.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public class BowFactory extends AbstractItemFactory {
    private Map<String, String> itemsDict;

    @Override
    protected void setUpDictionary(){
        itemsDict =  new HashMap<>();
        getItemsDictionary().put(NAME, "Long Bow");
        getItemsDictionary().put(POWER, "40");
        getItemsDictionary().put(MIN_RANGE, "2");
        getItemsDictionary().put(MAX_RANGE, "4");
    }

    public Map<String, String> getItemsDictionary(){
        return itemsDict;
    }

    @Override
    public Bow createItem() {
        return new Bow(getName(), getPower(), getMinRange(), getMaxRange());
    }
}
