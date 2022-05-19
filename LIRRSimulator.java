
import java.util.Scanner;
public class LIRRSimulator{
	
	protected static Station[] stations = new Station[4];
	protected int passengerServed =0;
	protected static int currentTime=0;
	//protected static int whichStation = 3;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		for(int i=0;i<4&& flag;i++) {
			System.out.println(whichStation(i));
			System.out.println("Please enter first class arrival probability:");
			double probability_1 = scan.nextDouble();
			System.out.println("Please enter second class arrival probability:");
			double probability_2 = scan.nextDouble();
			System.out.println();
	
			stations[i] = new Station (probability_1, probability_2);
				
		}
		
		
		System.out.println("Please enter first class capacity");
		int firstClassCapacity = scan.nextInt();
		System.out.println("Please enter second class capacity");
		int secondClassCapacity = scan.nextInt();
		System.out.println("Please enter number of trains");
		int numTrains = scan.nextInt();
		System.out.println("Please enter last arrival time of passengers");
		int lastArrival = scan.nextInt();
		Train[] trains = new Train[numTrains];
		int arrive=0;
		for(int i=0;i<numTrains;i++) {
			trains[i] = new Train();
			trains[i].setFirstCapacity(firstClassCapacity);
			trains[i].setSecondCapacity(secondClassCapacity);
			trains[i].setTimeUntilNextArrival(arrive);
			arrive+=5;
		}
		
		System.out.println("Begin Simulation:");
		System.out.println("--------------------------------------------");
		for(int i=0;i<lastArrival;i++) {
			System.out.println("Time " + i + ": ");
			System.out.println("Station Overview: ");
			
			for(int j =0;j<4;j++) {
				stations[j].setArrivalTime(i);
				stations[j].simulateTimeStep();

				System.out.println(whichStation(j));
				System.out.println("Queues: ");
				System.out.println("First: " + stations[j].getFirstClass().toString());
				System.out.println("Second: " + stations[j].getSecondClass().toString());
			}
			System.out.println();
			System.out.println("Trains: ");
			for(int h=0;h<numTrains;h++) {
				if(trains[h].getTimeUntilNextArrival()==0){
					System.out.println("\nTrain " + (h+1) + " arrives at " + whichStation(trains[h].getQueueStation()));
					System.out.println("There are " + trains[h].getPeopleInFirst() + " passenger(s) in first class and " 
						+ trains[h].getPeopleInSecond() + " passenger(s) in second class. ");
					trains[h].simulateTimeStep();
					System.out.println("Passenger embarking in first class: " + trains[h].getFirstClassP().toString());
					System.out.println("Passenger emabrking in second class: " + trains[h].getSecondClassP().toString());
					trains[h].getFirstClassP().clear();;
					trains[h].getSecondClassP().clear();
					trains[h].minusQueueStation();

				}else{
					System.out.println("Train "+ (h+1) + " will arrive at " + whichStation(trains[h].getQueueStation())
					+ "in " + trains[h].getTimeUntilNextArrival() + " minutes." );
					trains[h].simulateTimeStep();
				}
				
				currentTime++;
				
			}
			
			System.out.println();
		}
		scan.close();
	}
	
	public static String whichStation(int station) {
		switch(station) {
			case 0:
				return "Mineola:";
			case 1: 
				return "Hicksville:";
			case 2:
				return "Syosset:";
			case 3:
				return "Huntington:";
			default:
				return "Invalid station";
		}
	}
	
}
	
	