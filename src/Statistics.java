/**
 * Created by masti005 on 4/15/16.
 */
public class Statistics {
    public static void Time(double time) {
        busyTime = time;
    }
    public static void averagePassengerCount() {
        for (int i = 0; i < TrainSim.trainList.length; i++) {
            totalPassengers += TrainSim.trainList[i].maxTotalPassengers;
        }
        averagePassengerCount = (totalPassengers / TrainSim.trainList.length);
    }
    public static void maxPassengerCount() {
        for (int i = 0; i < TrainSim.trainList.length; i++) {
            for (int j = 1; j < TrainSim.trainList.length; j++) {
                int temp = Math.max(TrainSim.trainList[i].getTotalPassengers(), TrainSim.trainList[j].getTotalPassengers());
                if (maxPassengerCount < temp) {
                    maxPassengerCount = temp;
                }
            }
        }
    }
    public static void maxQueueLength() {
        for (int i = 0; i < TrainSim.stopList.length; i++) {
            if (maxEastboundQLength == 0) {
                maxEastboundQLength = TrainSim.stopList[i].eastbound.length();
            } else if (TrainSim.stopList[i].eastbound.length() > maxEastboundQLength) {
                TrainSim.stopList[i].eastbound.length();
            }

            if (maxWestboundQLength == 0) {
                maxWestboundQLength = TrainSim.stopList[i].westbound.length();
            } else if (TrainSim.stopList[i].westbound.length() > maxWestboundQLength) {
                TrainSim.stopList[i].westbound.length();
            }
        }
    }
    public static void averageQueueLength() {

        for (int i = 0; i < TrainSim.stopList.length; i++) {
            averageEastboundQ += TrainSim.stopList[i].eastbound.length();
            averageWestboundQ += TrainSim.stopList[i].westbound.length();
        }
        averageEastboundQ /= 23;
        averageWestboundQ /= 23;
    }
    public static void displayStats() {
        totalTime = TrainSim.agenda.getCurrentTime();
        idleTime = totalTime - busyTime;
        System.out.println("\n** Simulation Results **\n");
        System.out.println(" Calculated Simulation Time: " + TrainSim.agenda.getCurrentTime());
        System.out.println(" Total Time: " + totalTime);
        System.out.println(" Idle Time: " + idleTime);
        System.out.println(" Busy Time: " + busyTime + "\n");
        System.out.println(" Maximum Eastbound Queue Length: " + maxEastboundQLength);
        System.out.println(" Maximum Westbound Queue Length: " + maxWestboundQLength);
        System.out.println(" Avg. Eastbound Queue Length: " + averageEastboundQ);
        System.out.println(" Avg. Westbound Queue Length: " + averageWestboundQ);
        System.out.println(" Maximum Waiting Time: " + maxWait);
        System.out.println(" Avg. Service Time: " + averageServiceTime / totalPassengers);
        System.out.println(" Avg. Wait Time: " + waitTime / totalPassengers);
        System.out.println(" Total Passenger Count: " + totalPassengers);
        System.out.println(" Avg. Passenger Count per Train: " + averagePassengerCount);
        System.out.println(" Number of trains in system: " + TrainSim.trainList.length);
        System.out.println(" Number of train cars: " + TrainSim.trainList[0].cars.length);
        System.out.println("\n");

    }

    public void run() {
        maxPassengerCount();
        averageQueueLength();
        maxQueueLength();
        averagePassengerCount();
        displayStats();
    }

    public static double waitTime;
    private static double totalTime;
    private static double busyTime;
    private static double idleTime;
    public static double maxWait = TrainSim.maxWait;
    private static int maxEastboundQLength;
    private static int maxWestboundQLength;
    private static int averageEastboundQ;
    private static int averageWestboundQ;
    private static int maxPassengerCount;
    private static int averagePassengerCount;
    public static double averageServiceTime;
    private static int totalPassengers;

}
