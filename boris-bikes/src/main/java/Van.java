import java.util.ArrayList;
import java.util.List;

public class Van {
    public List<Bike> bikes;
    public final int CAPACITY = 5;

    public Van() {
        this.bikes = new ArrayList<>();
    }

    public void getBrokenBikes(List<Bike> dockingStationBikes) {
        for(int i = 0; i < dockingStationBikes.size(); i++) {
            if(dockingStationBikes.get(i).broken) {
                if(dockingStationBikes.size() < this.CAPACITY) {
                    this.bikes.add(dockingStationBikes.get(i));
                    dockingStationBikes.remove(dockingStationBikes.get(i));
                }
                else {
                    throw new IllegalArgumentException("Capacity has been reached! The Van cannot hold anymore bikes.");
                }

            }
        }
    }

    public void getFixedBikesFromGarage(List<Bike> garageBikes) {
        for(int i = 0; i < garageBikes.size(); i++) {
            if(!garageBikes.get(i).broken) {
                this.bikes.add(garageBikes.get(i));
                garageBikes.remove(garageBikes.get(i));
            }
        }
    }

    public void dropOffBikes(List<Bike> storageBikes) {
        for(int i = 0; i < this.bikes.size(); i++) {
            storageBikes.add(this.bikes.get(i));
            this.bikes.remove(this.bikes.get(i));
        }
    }
}
