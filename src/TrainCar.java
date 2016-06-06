
/**
 * Created by masti005 on 4/13/16.
 */
public class TrainCar {

    Passenger[] availableSeats;
    Passenger selectedPassenger;
    Train train;
    private int trainID;

    public TrainCar(int trainID) {
        this.trainID = trainID;
        availableSeats = new Passenger[50];
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    private int findOpenSeat() {
        for (int i = 0; i < availableSeats.length; i++) {
            if (availableSeats[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Stop stop) {
        train = TrainSim.trainList[trainID];
        if (!(train.isEmpty())) {

            for (int i = 0; i < availableSeats.length; i++) {
                selectedPassenger = availableSeats[i];

                if (selectedPassenger == null) {
                    if (i >= getCurrentCapacity()) {
                        break;
                    }

                }
                else if (stop.equals(selectedPassenger.getDestination())) { //Passenger should get off the train
                    selectedPassenger.exitTime = TrainSim.agenda.getCurrentTime(); //Time that the passenger leaves the train
                    Statistics.averageServiceTime += (selectedPassenger.exitTime - selectedPassenger.arrivalTime);
                    currentCapacity -= 1;
                    availableSeats[i] = null;
                }
            }
        }
        return true;
    }

    public boolean add(Passenger passenger, Stop stop) {
        train = TrainSim.trainList[trainID];
        if (passenger != null && currentCapacity != TrainCar.MAXCAPACITY && stop.equals(passenger.getLocation())) {
            if (passenger.getDestination() != null || passenger.getLocation() != null) { //Unnecessary if-statement but it's here to ensure nothing funky happens
                passenger.boardTime = TrainSim.agenda.getCurrentTime();
                train.maxTotalPassengers++;
                Statistics.waitTime += ((passenger.boardTime - passenger.arrivalTime));
                currentCapacity += 1;
                availableSeats[findOpenSeat()] = passenger;
                return true;
            }
        }
        return false;
    }


    public boolean isEmpty() {
        for (int i = 0; i < availableSeats.length; i++) {
            if (availableSeats[i] == null) {
                return false;
            }
        }
        return true;
    }


    //instance variables
    static final int MAXCAPACITY = 50;
    private int currentCapacity;
}
