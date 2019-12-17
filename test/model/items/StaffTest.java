package model.items;

import model.map.Location;
import model.units.Cleric;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

/**
 * Test set for staffs
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class StaffTest extends AbstractHealerTest {

  private Staff testStaff;
  private Staff wrongStaff;
  private Cleric testCleric;

  @Override
  public void setTestItem() {
    testStaff = new Staff(getExpectedName(), getExpectedPower(), getExpectedMinRange(), getExpectedMaxRange());
  }

  protected String getExpectedName(){return  "Common Staff";}

  protected int getExpectedPower() {return 10;}

  protected int getExpectedMinRange(){return 1;}

  protected int getExpectedMaxRange(){return 2;}

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongStaff = new Staff("Wrong staff", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    testCleric = new Cleric(getUnitHP(), getUnitMovement(), getField().getCell(2,2));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongStaff;
  }

  @Override
  public void equipTestUnit(){
    equipUnit(testCleric, testStaff);
  }

  @Override
  public IHealer getTestItem() {
    return testStaff;
  }

  @Override
  public IUnit getTestUnit() {
    return testCleric;
  }

  @Override
  @Test
  public void beingEquippedByCleric() {
    checkCorrectEquippedItemTest(getCleric(),getTestItem());
  }

}
