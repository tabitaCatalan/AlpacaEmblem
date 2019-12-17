package model.items.nonMagic;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Hero;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

/**
 * Test set for spears
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SpearTest extends AbstractWeaponTest {

  private Spear testSpear;
  private Spear wrongSpear;
  private Hero testHero;

  @Override
  public void setTestItem() {
    testSpear = new Spear(getExpectedName(), getExpectedPower(), getExpectedMinRange(), getExpectedMaxRange());
  }

  protected String getExpectedName(){return  "Javelin";}

  protected int getExpectedPower() {return 10;}

  protected int getExpectedMinRange(){return 1;}

  protected int getExpectedMaxRange(){return 2;}

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongSpear = new Spear("Wrong spear", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    testHero = new Hero(getUnitHP(), getUnitMovement(), getField().getCell(2,2));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongSpear;
  }

  /**
   * @return the item being tested
   */
  @Override
  public INonMagical getTestItem() {
    return testSpear;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return testHero;
  }

  @Override
  public void equipTestUnit(){
    equipUnit(testHero, testSpear);
  }

  @Override
  @Test
  public void beingEquippedByHero() {
    checkCorrectEquippedItemTest(getHero(),getTestItem());
  }

  @Override
  public void attackEquippedTargetUnitsTest(){
    super.attackEquippedTargetUnitsTest();
    weakDamageTest(fighter);
    normalDamageTest(hero);
    strongDamageTest(swordMaster);
    strongDamageTest(lightSorcerer);
  }

  @Override
  public void attackUnEquippedTargetUnitsTest(){
    super.attackUnEquippedTargetUnitsTest();
    strongDamageTest(lightSorcerer);
  }
}
