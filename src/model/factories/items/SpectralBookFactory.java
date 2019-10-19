package model.factories.items;


import model.items.magic.LightBook;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an Spectral Book Factory. It produces items of the class SpectralBook.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public class SpectralBookFactory extends AbstractItemFactory{

    private Map<String, String> itemsDict;

    @Override
    protected void setUpDictionary(){
        itemsDict =  new HashMap<>();
        getItemsDictionary().put(NAME, "Spectral Book");
        getItemsDictionary().put(POWER, "50");
        getItemsDictionary().put(MIN_RANGE, "1");
        getItemsDictionary().put(MAX_RANGE, "3");
    }

    public Map<String, String> getItemsDictionary(){
        return itemsDict;
    }

    @Override
    public LightBook createItem() {
        return new LightBook(getName(), getPower(), getMinRange(), getMaxRange());
    }
}
