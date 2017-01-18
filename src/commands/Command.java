package commands;

import java.util.LinkedList;

public abstract class Command  {

	private LinkedList<String> params;

	public LinkedList<String> getParams() {
		return params;
	}
	public abstract void execute();
	public void setParams(LinkedList<String> params) {
		this.params = params;
	}


}
