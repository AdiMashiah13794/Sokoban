package levels;

import java.io.Serializable;

public class Box extends Element implements Serializable  {

	public Box() {
		this.pos.setX(0);
		this.pos.setY(0);
		
			}
	public Box(Position pos){
		this.setPos(pos);
		
	}

	@Override
	public String toString()
	{
		return "@";
	}
}
