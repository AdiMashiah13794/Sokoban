package commands;

import levels.Level;
import levels.Player;

public class MoveRightCommand implements Command {
	
	private Level lev;
	private Player player;
	private MySokobanPolicy msp;
	
	public MoveRightCommand(){
		this.lev=null;
	}
	
	public MoveRightCommand(Level lev,Player player,MySokobanPolicy msp){
		this.lev=lev;
		this.player=player;
		this.msp=msp;
	}
	
	

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public MySokobanPolicy getMsp() {
		return msp;
	}

	public void setMsp(MySokobanPolicy msp) {
		this.msp = msp;
	}

	public Level getLev() {
		return lev;
	}


	public void setLev(Level lev) {
		this.lev = lev;
	}

	@Override
	public void execute() {
		this.msp.moveRight(this.lev);
		
	}

}