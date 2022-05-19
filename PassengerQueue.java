
import java.util.LinkedList;

public class PassengerQueue extends LinkedList<Passenger>{
	private static int count =1;
	
	public PassengerQueue() {
		
	}
	
	public void enQueue(Passenger p) {
		add(p);
		p.setId(count++);
	}
	
	public Passenger deQueue() {
		Passenger deQueued= get(0);
		remove(0);
		return deQueued;
	}
	
	public String toString() {
		if(isEmpty()) {
			return "[Empty]";
		}
		
		String output = "[";
		for(int i=0;i<size();i++) {
			output +=  get(i).toString() + ", ";
			
		}
		
		return output +"]";
	}
	
	public Passenger peek() {
		return get(0);
	}
	
	public boolean isEmpty() {
		return size()==0;
	}

	
}
