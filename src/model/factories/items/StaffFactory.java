package model.factories.items;

import model.items.Staff;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a Staff Factory. It produces items of the class Staff.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public class StaffFactory extends AbstractItemFactory {
    private Map<String, String> itemsDict =  new HashMap<>();


    public StaffFactory(){
        addItemParameters();
    }

    private void addItemParameters(){
        getItemsDictionary().put(NAME, "Staff");
        getItemsDictionary().put(POWER, "10");
        getItemsDictionary().put(MIN_RANGE, "1");
        getItemsDictionary().put(MAX_RANGE, "2");
    }

    public Map<String, String> getItemsDictionary(){
        return itemsDict;
    }

    @Override
    public Staff createItem() {
        return new Staff(getName(), getPower(), getMinRange(), getMaxRange());
    }
}
