package commands;

import levels.Level;

public class DisplayLevelCommand implements Command {
	
	private  Printer p;
	private Level lev;
	
	public DisplayLevelCommand(Level lev,Printer p) {
		this.lev=lev;
		this.p=p;
		
		
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
		this.p.print(this.lev);
		
	}

	





}
