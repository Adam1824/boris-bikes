import org.junit.Test;

import static org.junit.Assert.*;

public class BikeTest {

    public Bike bike = new Bike();

    @Test
    public void canCreateABike() {
        assertEquals(bike.getClass().toString(), "class Bike");
    }

    @Test
    public void canBeWorking() {
        assertEquals(bike.broken, false);
    }

    @Test
    public void canBeBroken() {
        bike.broken = true;
        assertEquals(bike.broken, true);
    }

}