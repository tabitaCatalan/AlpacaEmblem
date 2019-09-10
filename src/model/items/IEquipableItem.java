package model.items;

import model.items.magic.DarknessBook;
import model.items.magic.LightBook;
import model.items.magic.SpectralBook;
import model.items.nonMagic.Axe;
import model.items.nonMagic.Bow;
import model.items.nonMagic.Spear;
import model.items.nonMagic.Sword;
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
   * @return the name of the item
   */
  String getName();

  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getOwner();

  /**
   * @return sets owner's item
   */
  void setOwner(IUnit testUnit);

  /**
   * @return true if item is in an unit's inventary
   */
  boolean hasOwner();

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
   * Equips this item to a unit.
   *
   * @param unit
   *     the unit that will be quipped with the item
   */
  void equipTo(IUnit unit);

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
   * Item receives an attack from a magic book of type Spectral
   * @param spectralBook : the book that attacks
   * */
  void receiveSpectralAttack(SpectralBook spectralBook);

  /**
   * Item receives an attack from a magic book of type Light
   * @param lightBook : the book that attacks
   * */
  void receiveLightAttack(LightBook lightBook);

  /**
   * Item receives an attack from a magic book of type Darkness
   * @param darknessBook : the book that attacks
   * */
  void receiveDarknessAttack(DarknessBook darknessBook);

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
