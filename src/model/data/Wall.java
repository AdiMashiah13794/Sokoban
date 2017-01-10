package model.data;

import java.io.Serializable;

public class Wall extends Element implements Serializable {

	public Wall(){
		this.pos.setX(0);
		this.pos.setY(0);
	}
	
public Wall(Position pos) {
	this.setPos(pos);
	
	}
@Override
public String toString()
{
	return "#";
}

}
