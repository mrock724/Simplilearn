package eva_units;

import java.io.Serializable;

public class EvaUnit implements Serializable{
	String pilot;
	
	public EvaUnit(String pilot) {
        this.pilot = pilot;
    }
	
	public String getPilot() {
        return pilot;
    }
}
