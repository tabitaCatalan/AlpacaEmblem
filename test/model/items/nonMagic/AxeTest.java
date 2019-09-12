package model.items.nonMagic;

import model.items.AbstractTestItem;
import model.items.IAbleOfAttack;
import model.items.IEquipableItem;
import model.items.nonMagic.Axe;
import model.map.Location;
import model.units.Fighter;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

/**
 * Test set for Axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
class AxeTest extends AbstractWeaponTest {

  private Axe axe;
  private Axe wrongAxe;
  private Fighter fighter;

  @Override
  public void setTestItem() {
    expectedName = "Common axe";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 2;
    axe = new Axe(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongAxe = new Axe("Wrong axe", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(unitHP, unitMovement, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongAxe;
  }

  @Override
  public INonMagical getTestItem() {
    return axe;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  @Override
  @Test
  public void beingEquippedByFighter() {
    checkCorrectEquippedItem(getFighter(),getTestItem());
  }
}