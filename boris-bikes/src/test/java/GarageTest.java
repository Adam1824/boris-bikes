import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GarageTest {
    public Garage garage = new Garage();
    public Bike bike = new Bike();
    public Van van = new Van();
    public DockingStation dockingStation = new DockingStation();

    @Before
    public void receiveBrokenBikesFromVan() {
        bike.broken = true;
        dockingStation.dock(bike);
        van.getBrokenBikes(dockingStation.bikes);
        van.dropOffBikes(garage.bikes);
    }

    @Test
    public void isHoldingBrokenBikesReadyToBeFixed() {
        assertTrue(garage.bikes.contains(bike));
    }

    @Test
    public void canFixBikes() {
        garage.fixBikes();
        assertFalse(bike.broken);
    }
}