import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.*;

public class DockingStationTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public DockingStation dockingStation = new DockingStation();
    public Bike bike = new Bike();

    @Test
    public void canCreateADockingStation() {
        assertEquals(dockingStation.getClass().toString(), "class DockingStation");
    }

    @Test
    public void canDockABike() {
        dockingStation.dock(bike);
        assertTrue(dockingStation.bikes.contains(bike));
    }

    @Test
    public void canReleaseABike() {
        dockingStation.dock(bike);
        dockingStation.release(bike);
        assertFalse(dockingStation.bikes.contains(bike));
    }

    @Test
    public void hasStorageCapacity() {
        assertEquals(dockingStation.CAPACITY, 20);
    }

    @Test
    public void cannotDockABikeWhenDockingStationIsAtCapacity() {
        for(int i = 0; i < 20; i++) {
            dockingStation.dock(new Bike());
        }

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Capacity has been reached! Cannot dock anymore bikes.");

        dockingStation.dock(bike);
    }

    @Test
    public void canDockBikesThatAreBroken() {
        bike.broken = true;
        dockingStation.dock(bike);
        assertTrue(dockingStation.bikes.contains(bike));
    }

    @Test
    public void cannotReleaseABikeThatIsBroken() {
        dockingStation.dock(bike);
        bike.broken = true;
        dockingStation.release(bike);
        assertTrue(dockingStation.bikes.contains(bike));
    }

}