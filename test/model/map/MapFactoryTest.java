package model.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapFactoryTest {

    MapFactory factory;

    @BeforeEach
    public void setUp(){
        factory = new MapFactory();
    }

    @Test
    public void createMapTest(){
        Field aConnectedMap = factory.createRandomMap(5);
        assertEquals(5, aConnectedMap.getSize());
        assertTrue(aConnectedMap.isConnected());
    }
}

