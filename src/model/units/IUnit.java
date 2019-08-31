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
   * Unit tries to equip item
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
  List<IEquipableItem> getInventory();

   /**
    * @return true is Unit has an item equipped
    */
   boolean hasEquippedItem();

  /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();

  /** Sets the equippedItem
   * @param itemInInventory
   *     the item in inventory to be equipped
   */
  void setEquippedItem(IEquipableItem itemInInventory);



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

  /**
  * Add an item to the inventory. If there's no space, nothing happens.
  */
  void addItem(IEquipableItem item);

  /**
   * @return number of items in inventory
   */
  int getNumberOfItems();

   /**
    * @return true if it's possible to add another item
    */
  boolean hasSpaceInInventory();

   /**
    * Unit tries to equip a Bow. If unit it's an Archer, it successes.
    * If not, nothing happens
    */
   void equipBow(Bow bow);

    /**
     * Unit tries to equip an Axe. If unit it's an Fighter, it successes.
     * If not, nothing happens
     */
    void equipAxe(Axe axe);

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

    /**
     * Unit gives one of her items to targetUnit, if has space in inventory
     * @param targetUnit receptor unit
     * @param item in the inventory yo give away
     */
    void giveItemAwayTo(IUnit targetUnit, IEquipableItem item);

    /**
     * removes item from unit's inventory
     * @param item : the item to remove
     * */
    void removeFromInventory(IEquipableItem item);

    /**
     * true if item is in the inventory
     * @param item : the item you want to know if it is in the inventory
     * */
    boolean isInInventory(IEquipableItem item);

    /**
     * Unit uses her equippedItem on targetUnit.
     * If equippedItem is a weapon, then the targetUnit is attacked.
     * If equippedItem is a item able of heal, then the targetUnit is healed.
     * @param targetUnit : the unit that receives the effect of EquippedItem
     * */
    void useEquippedItemOn(IUnit targetUnit);

    /**
     * Unit receives an attack from a bow
     * @param bow : the bow that attacks
     * */
    void receiveBowAttack(Bow bow);

    /**
     * Unit receives an attack from an axe
     * @param axe : the axe that attacks
     * */
    void receiveAxeAttack(Axe axe);

    /**
     * Unit receives an attack from a spear
     * @param spear : the spear that attacks
     * */
    void receiveSpearAttack(Spear spear);

    /**
     * Unit receives an attack from a sword
     * @param sword : the sword that attacks
     * */
    void receiveSwordAttack(Sword sword);

    /**
     * Unit receives certain amount of damage
     * @param damageAmount :
     * */
    void receiveDamage(int damageAmount);

    /**
     * true if targetUnit is in range of equippedItem.
     * @param targetUnit the unit to use the item on
     *
     * @return true if item is in range
     * */
    boolean isInRange(IUnit targetUnit);
}
