
public class Station {
	private PassengerQueue firstClass;
	private PassengerQueue secondClass;
	private BooleanSource firstArrival;
	private BooleanSource secondArrival;
	private int arrivalTime;
	
	public Station(double probability1, double probability2) {
		
		firstClass = new PassengerQueue();
		secondClass = new PassengerQueue();
		
		firstArrival = new BooleanSource(probability1);
		secondArrival = new BooleanSource(probability2);
		
	
	}
	
	public void simulateTimeStep() {
		if(firstArrival.occurs()) {
			Passenger first = new Passenger();
			first.setArrivalTime(arrivalTime);
			first.setId(Passenger.count++);
			first.setIsFirstClass(true);
			firstClass.enQueue(first);
		}
		if(secondArrival.occurs()) {
			Passenger second = new Passenger();
			second.setArrivalTime(arrivalTime);
			second.setId(Passenger.count++);
			secondClass.enQueue(second);
		}
	}
	
	public PassengerQueue getFirstClass() {
		return this.firstClass;
	}
	
	public PassengerQueue getSecondClass() {
		return this.secondClass;
	}
	
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}
