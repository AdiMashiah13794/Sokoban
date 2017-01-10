package model.data;

import java.io.Serializable;

public abstract class Element implements Serializable {
Position pos = new Position();

public Position getPos() {
	return pos;
}

public void setPos(Position pos) {
	this.pos = pos;
}

	

}
