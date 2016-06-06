/**
 * Created by Alex on 4/11/2016.
 */
public class Passenger{

    //constructor
        public Passenger(Stop currentStop){
        arrivalTime = TrainSim.agenda.getCurrentTime();
        startStop = currentStop;
        waitTime = Math.abs(boardTime - arrivalTime);
        do {
            endStop = TrainSim.generateDestination();
            direction = getDirection();
        } while (endStop.equals(startStop));
    }

    //accessors
    public String getDirection(){

        if (TrainSim.indexOf(startStop) < TrainSim.indexOf(endStop)){
            direction = "East";
            return "East";
        }
        else if (TrainSim.indexOf(startStop) > TrainSim.indexOf(endStop)){
            direction = "West";
            return "West";
        }
        else{
            while (endStop.equals(startStop)){
                endStop = TrainSim.generateDestination();
            }
            if (TrainSim.indexOf(startStop) < TrainSim.indexOf(endStop)){
                direction = "East";
                return "East";
            }
            else if (TrainSim.indexOf(startStop) > TrainSim.indexOf(endStop)){
                direction = "West";
                return "West";
            }
            else {
                System.out.println("An error has occurred in the Passenger class under the getDirection method! The direction that the passenger is traveling could not be determined!");
            }
        }
        return "Sky"; //Passenger is traveling Skybound, which is clearly an issue. Someone should resolve that.
    }
    public Stop getDestination(){
        return endStop;
    }
    public Stop getLocation(){ return startStop; }
    public String toString(){
        return "Passenger at " + startStop + " going to " + endStop + " waiting at an " + direction + "bound stop";
    }

    //instance variables
    public double arrivalTime;
    private Stop startStop;
    private Stop endStop;
    private String direction;
    public double waitTime;
    public double boardTime;
    public double exitTime;
}
