package model.factories.items;


import model.items.magic.DarknessBook;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an Darkness Book Factory. It produces items of the class DarknessBook.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public class DarknessBookFactory extends AbstractItemFactory{

    private Map<String, String> itemsDict;

    @Override
    protected void setUpDictionary(){
        itemsDict =  new HashMap<>();
        getItemsDictionary().put(NAME, "Darkness Book");
        getItemsDictionary().put(POWER, "10");
        getItemsDictionary().put(MIN_RANGE, "1");
        getItemsDictionary().put(MAX_RANGE, "2");
    }

    public Map<String, String> getItemsDictionary(){
        return itemsDict;
    }

    @Override
    public DarknessBook createItem() {
        return new DarknessBook(getName(), getPower(), getMinRange(), getMaxRange());
    }
}
