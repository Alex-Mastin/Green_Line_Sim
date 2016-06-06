/**
 * Created by Alex on 4/11/2016.
 */
public class PassengerMaker implements Event{


    public PassengerMaker(Stop currentStop, double currentTime){
        here = currentStop;
        time = currentTime;
    }
    public void run() {
        TrainSim.agenda.add(this, TrainSim.RAND[(int) Math.ceil(Math.random()*20)]);
        Passenger newPassenger = new Passenger(here);
        TrainSim.currentStop.add(newPassenger);
    }

    private Stop here;
    private double time;


}
