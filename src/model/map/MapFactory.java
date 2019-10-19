package model.map;


import java.util.ArrayList;

/** Factory with methods to create maps, using the Field class
 *
 * @author Tabita Catalán Muñoz
 * @since v2.0
 * */
public class MapFactory {

    public Field createAllConnectedMap(int size){
        ArrayList<Location> locations = generateSquareOfLocations(size);
        Field map = new Field();
        map.addCells(true, locations.toArray(new Location[locations.size()]));
        return map;
    }

    public Field createRandomMap(int size){
        ArrayList<Location> locations = generateSquareOfLocations(size);
        Field map = new Field();
        map.addCells(false, locations.toArray(new Location[locations.size()]));
        return map;
    }

    private ArrayList<Location> generateSquareOfLocations(int size){
        ArrayList<Location> locations = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                locations.add(new Location(i, j));
            }
        }
        return locations;
    }
}
