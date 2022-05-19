
public class Passenger {
	private int id;
	private int arrivalTime;
	boolean isFirstClass;
	public static int count;
	

	public int getId() {
		return this.id;
	}
	
	public int arrivalTime() {
		return this.arrivalTime;
	}
	
	public boolean isFirstClass() {
		return this.isFirstClass;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public void setIsFirstClass(boolean isFirstClass) {
		this.isFirstClass = isFirstClass;
	}
	
	public String toString() {
		return "P"+id +"@T" +arrivalTime;
	}
}
