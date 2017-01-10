package model.data;

import java.io.Serializable;

public class Player extends Element implements Serializable  {
	private Wall wall= new Wall();
	private Destination des= new Destination();
	private Box box= new Box();
	private Space space= new Space();
	
	public Wall getWall() {
		return wall;
	}
	public void setWall(Wall wall) {
		this.wall = wall;
	}
	public Destination getDes() {
		return des;
	}
	public void setDes(Destination des) {
		this.des = des;
	}
	public Box getBox() {
		return box;
	}
	public void setBox(Box box) {
		this.box = box;
	}
	public Space getSpace() {
		return space;
	}
	public void setSpace(Space space) {
		this.space = space;
	}
	public Player() {
		this.pos.setX(0);
		this.pos.setY(0);
	}
	public Player (Position pos){
		this.setPos(pos);
	}
	@Override
	public String toString()
	{
		return "A";
	}

}
