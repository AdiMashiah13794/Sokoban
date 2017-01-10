package model;

import java.util.Observable;

import model.data.Level;

public class MyModel extends Observable implements Model  {
	private Level lev;

	public Level getLev() {
		return lev;
	}

	public void setLev(Level lev) {
		this.lev = lev;
	}
	

}
