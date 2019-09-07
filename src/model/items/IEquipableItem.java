package model.items;

import model.units.IUnit;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IEquipableItem {

  /**
   * Equips this item to a unit.
   *
   * @param unit
   *     the unit that will be quipped with the item
   */
  void equipTo(IUnit unit);

  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getOwner();

  /**
   * @return the name of the item
   */
  String getName();

  /**
   * @return the power of the item
   */
  int getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();

  /**
   * @return true if item is in an unit's inventary
   */
  boolean hasOwner();

  /**
   * @return sets owner's item
   */
  void setOwner(IUnit testUnit);


  /**
   * Item receives an attack from a bow
   * @param bow : the bow that attacks
   * */
  void receiveBowAttack(Bow bow);

  /**
   * Item receives an attack from an axe
   * @param axe : the axe that attacks
   * */
  void receiveAxeAttack(Axe axe);

  /**
   * Item receives an attack from a spear
   * @param spear : the spear that attacks
   * */
  void receiveSpearAttack(Spear spear);

  /**
   * Item receives an attack from a sword
   * @param sword : the sword that attacks
   * */
  void receiveSwordAttack(Sword sword);

  /**
   * Item uses it's power on targetUnit
   * @param targetUnit : the unit that receives the effect of item
   * */
  void actOn(IUnit targetUnit);

  /**
   * Item rects to an attack of unit
   * @param unit : the unit that attacked item's owner
   * */
  void reactTo(IUnit unit);

  /**
   * if false, item is a normal one. If true, is a NullItem: an item that does nothing.
   * */
  boolean isNullItem();
}
