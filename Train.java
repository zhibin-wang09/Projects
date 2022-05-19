import java.util.ArrayList;
public class Train {
	private int firstCapacity;
	private int secondCapacity;
	private int timeUntilNextArrival;
	private int peopleInFirst;
	private int peopleInSecond;
	private int queueStation = 3;
	private ArrayList<Passenger> firstClass = new ArrayList<Passenger>();
	private ArrayList<Passenger> secondClass = new ArrayList<Passenger>();

	public void simulateTimeStep() {
		PassengerQueue queue1 = LIRRSimulator.stations[queueStation].getFirstClass();
		PassengerQueue queue2 = LIRRSimulator.stations[queueStation].getSecondClass();
		int size1 = LIRRSimulator.stations[queueStation].getFirstClass().size();
		int size2 = LIRRSimulator.stations[queueStation].getSecondClass().size();

		if(timeUntilNextArrival%5==0 && !queue1.isEmpty()){
			for(int i=0;i<size1 && peopleInFirst!=firstCapacity;i++){
				firstClass.add(queue1.deQueue());
				peopleInFirst++;
			}

			
			size1 = LIRRSimulator.stations[queueStation].getFirstClass().size();
			for(int i=0;i<size1 && peopleInSecond!=secondCapacity;i++){
				secondClass.add(queue1.deQueue());
				peopleInSecond++;
			}
		}

		if(timeUntilNextArrival%5==0 && !queue2.isEmpty()){
			for(int i=0;i<size2 && peopleInSecond!=secondCapacity;i++){
				secondClass.add(queue2.deQueue());
				peopleInSecond++;
			}
		}
		
		if(timeUntilNextArrival==0){
			timeUntilNextArrival = 5;
		}

		timeUntilNextArrival--;
	}
	
	public void setFirstCapacity(int firstCapacity) {
		this.firstCapacity = firstCapacity;
	}
	
	public void setSecondCapacity(int secondCapacity) {
		this.secondCapacity = secondCapacity;
	}
	
	public void setTimeUntilNextArrival(int timeUntilNextArrival) {
		this.timeUntilNextArrival = timeUntilNextArrival;
	}
	
	public int getTimeUntilNextArrival() {
		return  this.timeUntilNextArrival;
	}
	
	public int getFirstCapacity() {
		return this.firstCapacity;
	}
	
	public int getSecondCapacitu() {
		return this.secondCapacity;
	}

	public int getPeopleInFirst(){
		return this.peopleInFirst;
	}
	
	public int getPeopleInSecond(){
		return this.peopleInSecond;
	}
	
	public ArrayList<Passenger> getFirstClassP(){
		return this.firstClass;
	}

	public ArrayList<Passenger> getSecondClassP(){
		return this.secondClass;
	}

	public int getQueueStation(){
		return this.queueStation;
	}

	public void minusQueueStation(){
		this.queueStation--;
	}
}
	
	
