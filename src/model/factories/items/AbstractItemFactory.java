package model.factories.items;

import java.util.Map;

/**
 * Abstract class that defines some common information and behaviour between all item factories.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public abstract class AbstractItemFactory implements IItemFactory{

    protected String NAME = "name";
    protected String POWER = "power";
    protected String MIN_RANGE = "minRange";
    protected String MAX_RANGE = "maxRange";

    /**
     * @return the Map used as dictionary to store the item parameters
     * */
    protected abstract Map<String, String > getItemsDictionary();

    @Override
    public String getName(){
        return getItemsDictionary().get(NAME);
    }

    @Override
    public int getPower(){
        return Integer.parseInt(getItemsDictionary().get(POWER));
    }

    @Override
    public int getMinRange(){
        return Integer.parseInt(getItemsDictionary().get(MIN_RANGE));
    }

    @Override
    public int getMaxRange(){
        return Integer.parseInt(getItemsDictionary().get(MAX_RANGE));
    }
}
