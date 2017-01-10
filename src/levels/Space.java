package levels;

import java.io.Serializable;

public class Space extends Element implements Serializable {
	
	public Space(){
		this.pos.setX(0);
		this.pos.setY(0);	
	}
	
public Space(Position pos) {
		this.setPos(pos);	
	}
@Override
public String toString()
{
	return " ";
}
}
