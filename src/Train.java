/**
 * Created by masti005 on 4/13/16.
 */
public class Train {

    private int trainCars;
    public TrainCar[] cars;
    private String direction;
    private int totalPassengers;
    private int ID;
    public int maxTotalPassengers;

    public Train(String trainDirection, int carCount, int trainNumber){
        direction = trainDirection;
        trainCars = carCount;
        ID = trainNumber;
        cars = new TrainCar[trainCars];
        for (int i = 0; i < trainCars; i++) {
            cars[i] = new TrainCar(ID);
        }
    }

    //accessors
    public int getTotalPassengers(){
        totalPassengers = 0;
        for (int i = 0; i < cars.length; i++){
            totalPassengers += cars[i].getCurrentCapacity();
        }
        return totalPassengers;
    }
    public void incrementPassengers(){
        if (totalPassengers < 150) {
            totalPassengers += 1;
        }
    }
    public void decrementPassengers() {
        if (totalPassengers != 0){
            totalPassengers -= 1;
        }
    }
//    public void setCarCount(int carCount){
//        trainCars = carCount;
//        cars = new TrainCar[trainCars];
//    }
    public String getDirection(){
        return direction;
    }

    //modifier
    public void changeDirection(){
        if (direction.equals("East")){
            direction = "West";
        }
        else if (direction.equals("West")){
            direction = "East";
        }
        else{
            System.out.println("An error has occurred in Train.java! The location of the train was not changed, which means the train did not have a direction equal to east or west!");
        }
    } //turns the train around once it reaches the end of the track

    public String toString() {
        return "Train " + ID + " going " + direction + " transporting " + getTotalPassengers() + " passengers.";
    }
    public boolean isEmpty(){
        for (int i = 0; i < this.trainCars; i++){
            if (!cars[i].isEmpty()){
                return false;
            }
        }
        return true;
    }

}
