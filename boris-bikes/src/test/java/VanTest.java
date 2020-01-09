import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class VanTest {
    public Van van = new Van();
    public Bike bike = new Bike();
    public DockingStation dockingStation = new DockingStation();
    public Garage garage = new Garage();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void transferBrokenBikesIntoDockingStation() {
        bike.broken = true;
        dockingStation.dock(bike);
    }

    @Test
    public void vanCanOnlyHoldAFiniteNumberOfBrokenBikes() {
        for(int i = 0; i < van.CAPACITY; i++) {
            Bike bike = new Bike();
            bike.broken = true;
            dockingStation.dock(bike);
        }
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Capacity has been reached! The Van cannot hold anymore bikes.");

        van.getBrokenBikes(dockingStation.bikes);
    }


    @Test
    public void canGetBrokenBikesFromDockingStation() {
        van.getBrokenBikes(dockingStation.bikes);
        assertTrue(van.bikes.contains(bike));
    }

    @Test
    public void canGiveBrokenBikesToGarage() {
        van.getBrokenBikes(dockingStation.bikes);
        van.dropOffBikes(garage.bikes);
        assertTrue(van.bikes.isEmpty());
    }

    @Test
    public void canGetFixedBikesFromGarage() {
        van.getBrokenBikes(dockingStation.bikes);
        van.dropOffBikes(garage.bikes);
        garage.fixBikes();
        van.getFixedBikesFromGarage(garage.bikes);
        assertFalse(bike.broken);
    }

    @Test
    public void canReturnFixedBikesToDockingStation() {
        van.getBrokenBikes(dockingStation.bikes);
        van.dropOffBikes(garage.bikes);
        garage.fixBikes();
        van.getFixedBikesFromGarage(garage.bikes);
        van.dropOffBikes(dockingStation.bikes);
        assertTrue(dockingStation.bikes.contains(bike));
        assertFalse(dockingStation.bikes.get(0).broken);
    }

}