
public class BooleanSource {
	private double probability;
	private double testing;
	public BooleanSource(double probability) throws IllegalArgumentException{
		if(probability<0 || probability >1) {
			throw new IllegalArgumentException();
		}else
			this.probability = probability;
	}
	
	public boolean occurs() {
		return (Math.random() < probability);
	}
	
	
}
