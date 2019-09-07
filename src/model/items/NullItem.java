package model.items;

import model.units.IUnit;

/**
 * @author Tabita Catalán Muñoz
 */
public class NullItem extends AbstractItem{

    /**
     * Creates a new NullItem
     * <p>
     * An unit that does not have an equipped Item has a reference to a NullItem. It has range 0,
     * and power 0.
     */
    public NullItem() {
        super("Null Item", 0, 0, 0);
    }

    @Override
    public void equipTo(IUnit unit) {}

    @Override
    public boolean isNullItem(){
        return true;
    }
}
