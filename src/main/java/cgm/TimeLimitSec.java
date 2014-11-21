package cgm;

public class TimeLimitSec extends Metric{
	
	public static final String unity = "s";
	
	private int value;
	
	public int getValue(){
		return value;
	}
	
	public int parallelCompose(TimeLimitSec t){
		if(t.getValue() < this.getValue()){
			return t.getValue();
		}
		else{
			return this.getValue();
		}
	}
	
	public int serialCompose(TimeLimitSec t){
		if(t.getValue() < this.getValue()){
			return t.getValue();
		}
		else{
			return this.getValue();
		}
	}
}
