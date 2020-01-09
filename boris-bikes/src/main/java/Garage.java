import java.util.ArrayList;
import java.util.List;

public class Garage {

    public List<Bike> bikes;

    public Garage() {
        this.bikes = new ArrayList<>();
    }

    public void fixBikes() {
        for(int i = 0; i < bikes.size(); i++) {
            bikes.get(i).broken = false;
        }
    }
}
