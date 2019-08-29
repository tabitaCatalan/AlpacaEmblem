package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected final List<IEquipableItem> items = new ArrayList<>();
  private final int currentHitPoints;
  private final int movement;
  protected IEquipableItem equippedItem;
  private Location location;
  private int maxNumberOfItems;

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit(final int hitPoints, final int movement,
     final Location location, final int maxItems, final IEquipableItem... items) {
    this.currentHitPoints = hitPoints;
    this.movement = movement;
    this.location = location;
    this.location.setUnit(this);
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
    this.maxNumberOfItems = maxItems;
  }

  @Override
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  @Override
  public void addItem(IEquipableItem item){
      if(hasSpaceInInventory()) {
          items.add(item);
          item.setOwner(this);
      }
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public void setEquippedItem(final IEquipableItem itemInInventory) {
    if (items.contains(itemInInventory)) {
        this.equippedItem = itemInInventory;
    }
  }

    @Override
    public void equipItem(IEquipableItem item) {}

    @Override
    public void equipBow(Bow bow) {}

    @Override
    public void equipStaff(Staff staff) {}

    @Override
    public void equipAxe(Axe axe) {}

  @Override
  public void equipSpear(Spear spear) {}

  @Override
  public void equipSword(Sword sword) {}

    @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      location.removeUnit();
      setLocation(targetLocation);
      targetLocation.setUnit(this);
    }
  }

  @Override
  public boolean hasSpaceInInventory(){
      return getNumberOfItems() < maxNumberOfItems;
  }

  @Override
  public int getNumberOfItems(){
      return items.size();
  }



}
