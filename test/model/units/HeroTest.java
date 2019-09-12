package model.units;

import model.items.IEquipableItem;
import model.items.nonMagic.Spear;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 */
public class HeroTest extends AbstractTestUnit {

  private Hero testHero;
  private Spear testSpear;

  @Override
  public void setTestUnit() {
    testHero = new Hero(50, 2, field.getCell(2, 2));
  }

  @Override
  public IUnit getTestUnit() {
    return testHero;
  }

  @Override
  public void setTestItem(){
    testSpear = new Spear("Test Spear", 10, 1, 2);
  }

  @Override
  public IEquipableItem getTestItem(){
    return testSpear;
  }

  @Test
  @Override
  public void equipSpearTest() {
    checkCorrectEquippedItem(testHero, spear);
  }


  @Override
  public void equipTestUnit(){
    getTestUnit().addItem(testSpear);
    getTestUnit().equipItem(testSpear);
  }

  @Override
  public void attackEquippedUnitsTest(){
    normalDamageTest(archer);
    normalDamageTest(cleric);
    weakDamageTest(fighter);
    normalDamageTest(hero);
    strongDamageTest(swordMaster);
  }

  @Test
  @Override
  public void isInRangeTest(){
    super.isInRangeTest();
    assertTrue(getTestUnit().isInRange(lightSorcerer));
  }

}