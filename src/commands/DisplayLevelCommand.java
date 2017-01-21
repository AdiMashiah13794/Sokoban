package commands;

import common.Common;
import model.data.Level;
import view.View;

public class DisplayLevelCommand extends Command {

	private  Printer p;
	private Level lev;
	private View v;
	private Common c;

	public DisplayLevelCommand(View v) {
		this.v=v;


}
	public DisplayLevelCommand() {
	this.lev= null;
	}



	public Level getLev() {
		return lev;
	}

	public void setLev(Level lev) {
		this.lev = lev;
	}

	@Override
	public void execute() {
		this.v.display();

	}







}
