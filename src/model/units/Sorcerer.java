package model.units;

import model.items.IEquipableItem;
import model.items.magic.IMagicBook;
import model.map.Location;

public class Sorcerer extends AbstractUnit{
    /**
     * Creates a new Unit.
     *
     * @param hitPoints
     *     the maximum amount of damage a unit can sustain
     * @param movement
     *     the number of panels a unit can move
     */
    public Sorcerer(final int hitPoints, final int movement, final Location location,
                IEquipableItem... items) {
        super(hitPoints, movement, location, 3, items);
    }

    @Override
    public void equipMagicBook(IMagicBook magicBook) {
        this.setEquippedItem(magicBook);
    }
}
