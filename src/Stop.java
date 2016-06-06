/**
 * Created by Alex on 4/13/2016.
 */
public class Stop {
    Q1 eastbound = new Q1();
    Q1 westbound = new Q1();
    private int ID;
    public String stopName;

    static int count = 0;

    public Stop(String name, int stopNumber){
        stopName = name;
        ID = stopNumber;
        count++;
    }
    public void add(Passenger p){
        if (p.getDirection().equals("East")){
            eastbound.add(p);
        }
        else if (p.getDirection().equals("West")){
            westbound.add(p);
            //System.out.println(p + " " + westbound.length());
        }
        else{
            System.out.println("An error has occurred in the Stop class under the add method! The cause is the getDirection() method from the Passenger class! The direction of the passenger was not found!");
        }
    }

    public String toString() {
        return stopName;
    }
}
