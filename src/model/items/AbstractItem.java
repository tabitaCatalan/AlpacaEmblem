package model.items;

import model.units.IUnit;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

  private final String name;
  private final int power;
  protected int maxRange;
  protected int minRange;
  private IUnit owner;

  /**
   * Constructor for a default item without any special behaviour.
   *
   * @param name
   *     the name of the item
   * @param power
   *     the power of the item (this could be the amount of damage or healing the item does)
   * @param minRange
   *     the minimum range of the item
   * @param maxRange
   *     the maximum range of the item
   */
  public AbstractItem(final String name, final int power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

  @Override
  public void equipTo(final IUnit unit) {}

  @Override
  public boolean hasOwner(){
    return owner != null;
  }

  @Override
  public IUnit getOwner() {
    return owner;
  }

  @Override
  public void setOwner(IUnit unit){
    owner = unit;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getPower() {
    return power;
  }

  @Override
  public int getMinRange() {
    return minRange;
  }

  @Override
  public int getMaxRange() {
    return maxRange;
  }

  @Override
  public void actOn(IUnit targetUnit){}

  @Override
  public void reactTo(IUnit unit){}

  public void receiveBowAttack(Bow bow){
    receiveNormalAttack(bow);
  }

  public void receiveAxeAttack(Axe axe){
    receiveNormalAttack(axe);
  }

  public void receiveSpearAttack(Spear spear){
    receiveNormalAttack(spear);
  }

  public void receiveSwordAttack(Sword sword){
    receiveNormalAttack(sword);
  }

  /**
   * Unit receives normal damage from a weapon
   * */
  protected void receiveNormalAttack(IEquipableItem weapon){
    int damage = weapon.getPower();
    owner.receiveDamage(damage);
  }

  /**
   * Unit receives weak damage from a weapon
   * */
  protected void  receiveWeakAttack(IEquipableItem weapon){
    int damage = Math.max(0, weapon.getPower() - 20);
    owner.receiveDamage(damage);
  }

  /**
   * Unit receives strong damage from a weapon
   * */
  protected void receiveStrongAttack(IEquipableItem weapon){
    int damage = (int) Math.round(weapon.getPower() * 1.5);
    owner.receiveDamage(damage);
  }

  @Override
  public boolean isNullItem(){
    return false;
  }

}
