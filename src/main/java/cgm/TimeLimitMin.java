package cgm;

public class TimeLimitMin extends Metric{

	public static final String unity = "min";
	
	private int value;
	
	public int getValue(){
		return value;
	}

	public int serialDecomposition(TimeLimitMin t){
		if(t.getValue() < this.getValue()){
			return t.getValue();
		}
		else {
			return this.getValue();
		}
	}
	
	public int parallelDecomposition(TimeLimitMin t){
		if(t.getValue() < this.getValue()){
			return t.getValue();
		}
		else {
			return this.getValue();
		}
	}
}
