package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class ClericTest extends AbstractTestUnit {

  private Cleric cleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    cleric = new Cleric(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }

  /**
   * Checks if the staff is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipStaffTest() {
    assertNull(cleric.getEquippedItem());
    staff.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(staff);
    staff.equipTo(cleric);
    assertEquals(staff, cleric.getEquippedItem());
  }
}