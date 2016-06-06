/**
 * Created by Alex on 4/13/2016.
 */

public class TrainSim {
    public static PQ agenda = new PQ() {
    };
    public static double maxWait;
    public static Stop currentStop;
        public static Train[] trainList = {
            new Train(TrainSim.generateDirection(), 3, 0), new Train(TrainSim.generateDirection(), 3, 1), new Train(TrainSim.generateDirection(), 3, 2), new Train(TrainSim.generateDirection(), 3, 3),
            new Train(TrainSim.generateDirection(), 3, 4), new Train(TrainSim.generateDirection(), 3, 5), new Train(TrainSim.generateDirection(), 3, 6), new Train(TrainSim.generateDirection(), 3, 7),
            new Train(TrainSim.generateDirection(), 3, 8), new Train(TrainSim.generateDirection(), 3, 9), new Train(TrainSim.generateDirection(), 3, 10), new Train(TrainSim.generateDirection(), 3, 11),
            new Train(TrainSim.generateDirection(), 3, 12), new Train(TrainSim.generateDirection(), 3, 13), new Train(TrainSim.generateDirection(), 3, 14), new Train(TrainSim.generateDirection(), 3, 15),
            new Train(TrainSim.generateDirection(), 3, 16), new Train(TrainSim.generateDirection(), 3, 17), new Train(TrainSim.generateDirection(), 3, 18), new Train(TrainSim.generateDirection(), 3, 19),
            new Train(TrainSim.generateDirection(), 3, 20), new Train(TrainSim.generateDirection(), 3, 21), new Train(TrainSim.generateDirection(), 3, 22),
    };
    public static Stop[] stopList = {new Stop("Target Field", 0), new Stop("WareHouse/Hennepin Ave", 1), new Stop("Nicollet Mall", 2), new Stop("Government Plaza", 3),
            new Stop("U.S. Bank Stadium", 4), new Stop("West Bank", 5), new Stop("East Bank", 6), new Stop("Stadium Village", 7), new Stop("Prospect Park", 8),
            new Stop("Westgate", 9), new Stop("Raymond Ave", 10), new Stop("Fairview Ave", 11), new Stop("Snelling Ave", 12), new Stop("Hamline Ave", 13),
            new Stop("Lexington Pkwy", 14), new Stop("Victoria St", 15), new Stop("Dale St", 16), new Stop("Western Ave", 17), new Stop("Capitol/Rice St", 18),
            new Stop("Robert St", 19), new Stop("10th St", 20), new Stop("Central", 21), new Stop("Union Depot", 22)};
    public static final double[] RAND = {52.5, 52.5, 45, 45, 45, 36, 36, 36, 36, 30, 30, 24, 24, 24, 24, 15, 15, 15, 7.5, 7.5, 7.5};

    public static int intRandomInterval(int low, int high) {
        return (int) Math.floor((high - low) * Math.random() + low + 0.5);
    }

    public static Stop generateDestination() {
        return TrainSim.stopList[intRandomInterval(0, 22)];
    }

    public static String generateDirection() {
        double d = Math.random();
        if (d < 0.5) {
            return "East";
        } else if (d >= 0.5) {
            return "West";
        }
        return null;
    }

    public static int indexOf(Stop stop) {
        for (int i = 0; i < stopList.length; i++) {
            if (stopList[i].equals(stop)) {
                return i;
            }
        }
        System.out.println("An error has occurred in TrainSim in the indexOf method! The specified stop was not found in the Stop List!");
        return -1;
    }

    public static void main(String[] args) {
        Statistics stat = new Statistics();

        //Make a PassengerMaker for each stop
        for (int j = 0; j < stopList.length; j++) {
            TrainSim.currentStop = stopList[j];
            double currentTime = agenda.getCurrentTime();
            PassengerMaker passengerMaker = new PassengerMaker(TrainSim.currentStop, currentTime + 1);
            agenda.add(passengerMaker, currentTime);
        }

        TrainEvent trainEvent1 = new TrainEvent(trainList[0], stopList[0]);
        TrainEvent trainEvent2 = new TrainEvent(trainList[1], stopList[1]);
        TrainEvent trainEvent3 = new TrainEvent(trainList[2], stopList[2]);
        TrainEvent trainEvent4 = new TrainEvent(trainList[3], stopList[3]);
        TrainEvent trainEvent5 = new TrainEvent(trainList[4], stopList[4]);
        TrainEvent trainEvent6 = new TrainEvent(trainList[5], stopList[5]);
        TrainEvent trainEvent7 = new TrainEvent(trainList[6], stopList[6]);
        TrainEvent trainEvent8 = new TrainEvent(trainList[7], stopList[7]);
        TrainEvent trainEvent9 = new TrainEvent(trainList[8], stopList[8]);
        TrainEvent trainEvent10 = new TrainEvent(trainList[9], stopList[9]);
        TrainEvent trainEvent11 = new TrainEvent(trainList[10], stopList[10]);
        TrainEvent trainEvent12 = new TrainEvent(trainList[11], stopList[11]);
        TrainEvent trainEvent13 = new TrainEvent(trainList[12], stopList[12]);
        TrainEvent trainEvent14 = new TrainEvent(trainList[13], stopList[13]);
        TrainEvent trainEvent15 = new TrainEvent(trainList[14], stopList[14]);
        TrainEvent trainEvent16 = new TrainEvent(trainList[15], stopList[15]);
        TrainEvent trainEvent17 = new TrainEvent(trainList[16], stopList[16]);
        TrainEvent trainEvent18 = new TrainEvent(trainList[17], stopList[17]);
        TrainEvent trainEvent19 = new TrainEvent(trainList[18], stopList[18]);
        TrainEvent trainEvent20 = new TrainEvent(trainList[19], stopList[19]);
        TrainEvent trainEvent21 = new TrainEvent(trainList[20], stopList[20]);
        TrainEvent trainEvent22 = new TrainEvent(trainList[21], stopList[21]);
        TrainEvent trainEvent23 = new TrainEvent(trainList[22], stopList[22]);


        agenda.add(trainEvent1, 1);
        agenda.add(trainEvent2, 2);
        agenda.add(trainEvent3, 3);
        agenda.add(trainEvent4, 4);
        agenda.add(trainEvent5, 5);
        agenda.add(trainEvent6, 6);
        agenda.add(trainEvent7, 7);
        agenda.add(trainEvent8, 8);
        agenda.add(trainEvent9, 9);
        agenda.add(trainEvent10, 10);
        agenda.add(trainEvent11, 11);
        agenda.add(trainEvent12, 12);
        agenda.add(trainEvent13, 13);
        agenda.add(trainEvent14, 14);
        agenda.add(trainEvent15, 15);
        agenda.add(trainEvent16, 16);
        agenda.add(trainEvent17, 17);
        agenda.add(trainEvent18, 18);
        agenda.add(trainEvent19, 19);
        agenda.add(trainEvent20, 20);
        agenda.add(trainEvent21, 21);
        agenda.add(trainEvent22, 22);
        agenda.add(trainEvent23, 23);

        while (agenda.getCurrentTime() <= 15000) {
            Event e = agenda.remove();
            e.run();
        }
        stat.run();
        System.out.println();
    }
}
