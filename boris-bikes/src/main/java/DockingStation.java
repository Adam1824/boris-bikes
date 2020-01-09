import java.util.ArrayList;
import java.util.List;

public class DockingStation {
    public List<Bike> bikes;
    public final int CAPACITY = 20;

    public DockingStation() {
        this.bikes = new ArrayList<>();
    }

    public void dock(Bike bike) {
        if(this.bikes.size() == 20) {
            throw new IllegalArgumentException("Capacity has been reached! Cannot dock anymore bikes.");
        }
        this.bikes.add(bike);
    }

    public void release(Bike bike) {
        if(bike.broken != true) {
            this.bikes.remove(0);
        }
    }
}
