package levels;

import java.io.Serializable;

public class Destination extends Element implements Serializable {
	
	public Destination() {
		this.pos.setX(0);
		this.pos.setY(0);
	}
	
	public Destination(Position pos){
		this.setPos(pos);
	}
	@Override
	public String toString()
	{
		return "O";
	}


}
