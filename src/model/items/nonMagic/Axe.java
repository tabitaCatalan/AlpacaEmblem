package model.items.nonMagic;

import model.items.AbstractDamageItem;
import model.units.IUnit;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Axe extends AbstractWeapon {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Axe(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public void equipTo(IUnit unit) {
    unit.equipAxe(this);
  }

  @Override
  public void receiveSwordAttack(Sword sword){
    receiveStrongAttack(sword);
  }

  @Override
  public void receiveSpearAttack(Spear spear){
    receiveWeakAttack(spear);
  }

  @Override
  public void attack(IUnit targetUnit){
    targetUnit.receiveAxeAttack(this);
  }
}
