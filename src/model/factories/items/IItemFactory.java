package model.factories.items;

import model.items.IEquipableItem;


/**
 * This interface represents the <i>factories</i> that can be used to generate items
 *  * <p>
 *  * The signature for all the common methods of the factories are defined here.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public interface IItemFactory {

    /**
     * @return an standard item created by factory
     * */
    IEquipableItem createItem();

    /**
     * Return the name that will be used when generating an item
     * */
    String getName();

    /**
     * Return the power that will have every generated item
     * */
    int getPower();

    /**
     * Return the min range that will have every generated item
     * */
    int getMinRange();

    /**
     * Return the max range that will have every generated item
     * */
    int getMaxRange();


}
