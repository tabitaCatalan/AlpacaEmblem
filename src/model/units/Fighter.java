package model.units;

import model.items.nonMagic.Axe;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents a fighter type unit.
 * A fighter is a unit that can only use axe type weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Fighter extends AbstractUnit {

  public Fighter(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   * <p>
   * The <i>Fighter</i> can <b>only equip Axes</b>.
   *
   * @param axe
   *     the axe to equip. If not in the inventory nothing happens
   */
  @Override
  public void equipAxe(Axe axe) {
    this.setEquippedItem(axe);
  }

}
