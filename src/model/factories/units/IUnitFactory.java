package model.factories.units;

import model.map.Location;
import model.units.IUnit;


/**
 * This interface represents the <i>factories</i> that can be used to generate units
 *  * <p>
 *  * The signature for all the common methods of the factories are defined here.
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public interface IUnitFactory {

    /**
     * @return an standard unit created by factory
     * */
    IUnit createUnit(Location location);

    /**
     * Return the amount of hit points that will have every generated unit
     * */
    int getHitPoints();

    /**
     * Return the movement that will have every generated unit
     * */
    int getMovement();
}
