package model.units;

import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IUnit {

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  void equipItem(IEquipableItem item);

  /**
   * @return hit points of the unit
   */
  int getCurrentHitPoints();

  /**
   * @return the items carried by this unit
   */
  List<IEquipableItem> getItems();

  /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();

  /**
   * @param itemInInventory
   *     the item in inventory to be equipped
   */
  void setEquippedItem(IEquipableItem itemInInventory);

    void equipAxe(Axe axe);

    /**
   * @return the current location of the unit
   */
  Location getLocation();

  /**
   * Sets a new location for this unit,
   */
  void setLocation(final Location location);

  /**
   * @return the number of cells this unit can move
   */
  int getMovement();

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   */
  void moveTo(Location targetLocation);

  void addItem(IEquipableItem item);

  /**
   * @return number of items in inventory
   */
  int getNumberOfItems();

   /**
    * @return true if it's posible to add another item
    */
  boolean hasSpaceInInventory();

   /**
    * Unit tries to equip a Bow. If unit it's an Archer, it successes.
    * If not, nothing happens
    */
   void equipBow(Bow bow);

    /**
     * Unit tries to equip a Staff. If unit it's a Cleric, it successes.
     * If not, nothing happens
     */
    void equipStaff(Staff staff);

    /**
     * Unit tries to equip a Spear. If unit it's the Hero, it successes.
     * If not, nothing happens
     */
    void equipSpear(Spear spear);

    /**
     * Unit tries to equip a Sword. If unit it's a SwordMaster, it successes.
     * If not, nothing happens
     */
    void equipSword(Sword sword);
}
