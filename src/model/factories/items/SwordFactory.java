 package model.factories.items;

import model.items.nonMagic.Axe;
import model.items.nonMagic.Sword;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an Sword Factory. It produces items of the class Sword.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public class SwordFactory extends AbstractItemFactory{

    private Map<String, String> itemsDict;

    @Override
    protected void setUpDictionary(){
        itemsDict =  new HashMap<>();
        getItemsDictionary().put(NAME, "Sword");
        getItemsDictionary().put(POWER, "10");
        getItemsDictionary().put(MIN_RANGE, "1");
        getItemsDictionary().put(MAX_RANGE, "2");
    }

    public Map<String, String> getItemsDictionary(){
        return itemsDict;
    }

    @Override
    public Sword createItem() {
        return new Sword(getName(), getPower(), getMinRange(), getMaxRange());
    }
}

