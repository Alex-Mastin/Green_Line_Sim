/**
 * Created by Alex on 4/13/2016.
 */
public class TrainEvent implements Event {
    Train train;
    Stop stop;
    int totalTimeLeaving = 0;
    int totalTimeArriving = 0;
    int busyTime = 0;

    public TrainEvent(Train train, Stop stop) {
        this.train = train;
        this.stop = stop;
    }
    public void run() {
        if (train.getTotalPassengers() > 150){
            System.out.println("AN ERROR HAS OCCURRED! " + train + "SHOULD NOT HAVE A CAPACITY GREATER THAN 150! CONSIDER THIS AN OUTLIER!");
            System.out.println("Car 1 CAPACITY: " + train.cars[0].getCurrentCapacity());
            System.out.println("Car 2 CAPACITY: " + train.cars[1].getCurrentCapacity());
            System.out.println("Car 3 CAPACITY: " + train.cars[2].getCurrentCapacity());
        }
        //A train will take 3 minutes (180 seconds) between each stop
        //Train will wait for at least 15 seconds at each stop
        totalTimeArriving += 195;
        busyTime += 180;
        if (stop.equals(TrainSim.stopList[22]) && train.getDirection().equals("East") || stop.equals(TrainSim.stopList[0]) && train.getDirection().equals("West")){
            for (int i = 0; i < train.cars.length; i++){
                while(train.cars[i].getCurrentCapacity()!=TrainCar.MAXCAPACITY) {
                    if (!(stop.eastbound.length() == 0)) {
                        Passenger p = (Passenger) stop.eastbound.remove();
                        train.cars[i].add(p, stop);
                        totalTimeArriving += 1;
                        train.incrementPassengers();
                        p.boardTime = TrainSim.agenda.getCurrentTime();
                        if (Statistics.maxWait == 0){
                            Statistics.maxWait = (p.boardTime - p.arrivalTime);
                        }
                        else if ((p.boardTime - p.arrivalTime) > Statistics.maxWait){
                            Statistics.maxWait = (p.boardTime - p.arrivalTime);
                        }
                    } else {
                        break;
                    }
                }
            }
            train.changeDirection();
        }
        //look at the queue of the train car, check if anyone wants to leave and remove them if they do
        for (int i = 0; i < train.cars.length; i++){
            if (!train.isEmpty()) {
                train.cars[i].remove(stop);
                totalTimeLeaving += 2;
                train.decrementPassengers();
            }
        }
        if (train.getDirection().equals("")){

        }
        else if (train.getDirection().equals("West")) {
            for (int i = 0; i < train.cars.length; i++) {
                while (train.cars[i].getCurrentCapacity() != TrainCar.MAXCAPACITY) {
                    if (!(stop.westbound.length() == 0)) {
                        Passenger p = (Passenger) stop.westbound.remove();
                        train.cars[i].add(p, stop);
                        totalTimeArriving += 1;
                        train.incrementPassengers();
                        p.boardTime = TrainSim.agenda.getCurrentTime();
                        if (Statistics.maxWait == 0) {
                            Statistics.maxWait = (p.boardTime - p.arrivalTime);
                        } else if ((p.boardTime - p.arrivalTime) > Statistics.maxWait) {
                            Statistics.maxWait = (p.boardTime - p.arrivalTime);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        else if (train.getDirection().equals("East")){
            for (int i = 0; i < train.cars.length; i++){
                while(train.cars[i].getCurrentCapacity()!=TrainCar.MAXCAPACITY) {
                    if (!(stop.eastbound.length() == 0)) {
                        Passenger p = (Passenger) stop.eastbound.remove();
                        train.cars[i].add(p, stop);
                        totalTimeArriving += 1;
                        train.incrementPassengers();
                        p.boardTime = TrainSim.agenda.getCurrentTime();
                        if (Statistics.maxWait == 0){
                            Statistics.maxWait = (p.boardTime - p.arrivalTime);
                        }
                        else if ((p.boardTime - p.arrivalTime) > Statistics.maxWait){
                            Statistics.maxWait = (p.boardTime - p.arrivalTime);
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        //if the train is at the end of the track, turn it around
        if (stop.equals(TrainSim.stopList[22]) && train.getDirection().equals("East") || stop.equals(TrainSim.stopList[0]) && train.getDirection().equals("West")){
            train.changeDirection();
        }
        if (train.getDirection().equals("East")){
            TrainSim.agenda.add(new TrainEvent(train, TrainSim.stopList[TrainSim.indexOf(stop)+1]), totalTimeArriving+totalTimeLeaving);
        }
        else if (train.getDirection().equals("West")){
            TrainSim.agenda.add(new TrainEvent(train, TrainSim.stopList[TrainSim.indexOf(stop)-1]), totalTimeArriving+totalTimeLeaving);
        }
        Statistics.Time(totalTimeArriving+totalTimeLeaving);
    }
}
