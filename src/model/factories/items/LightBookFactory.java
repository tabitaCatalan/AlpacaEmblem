package model.factories.items;


import model.items.magic.LightBook;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an Light Book Factory. It produces items of the class LightBook.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public class LightBookFactory extends AbstractItemFactory{

    private Map<String, String> itemsDict;

    @Override
    protected void setUpDictionary(){
        itemsDict =  new HashMap<>();
        getItemsDictionary().put(NAME, "Light Book");
        getItemsDictionary().put(POWER, "10");
        getItemsDictionary().put(MIN_RANGE, "1");
        getItemsDictionary().put(MAX_RANGE, "2");
    }

    public Map<String, String> getItemsDictionary(){
        return itemsDict;
    }

    @Override
    public LightBook createItem() {
        return new LightBook(getName(), getPower(), getMinRange(), getMaxRange());
    }
}
