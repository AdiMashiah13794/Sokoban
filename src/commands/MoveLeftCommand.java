package commands;

import common.Level;
import model.Model;
import model.data.Player;
import model.policy.MySokobanPolicy;

public class MoveLeftCommand extends Move {

	public MoveLeftCommand(Model model){
		this.model=model;
	}




	@Override
	public void execute() {
		this.setLev(this.model.getLevel());
		this.setMsp(this.model.getPolicy());
		this.setPlayer(this.model.getLevel().getPlayers().get(0));
		this.model.moveLeft();

	}

}
