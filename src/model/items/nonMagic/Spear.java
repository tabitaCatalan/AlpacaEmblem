package model.items.nonMagic;

import model.items.AbstractDamageItem;
import model.units.IUnit;

/**
 * This class represents a <i>spear</i>.
 * <p>
 * Spears are strong against swords and weak against axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Spear extends AbstractWeapon {

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
  public Spear(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public void equipTo(IUnit unit) {
    unit.equipSpear(this);
  }

  @Override
  public void receiveAxeAttack(Axe axe){
    receiveStrongAttack(axe);
  }

  @Override
  public void receiveSwordAttack(Sword sword){
    receiveWeakAttack(sword);
  }

  @Override
  public void attack(IUnit targetUnit){
    targetUnit.receiveSpearAttack(this);
  }
}
