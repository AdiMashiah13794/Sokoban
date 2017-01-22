package commands;

import common.Level;
import model.Model;
import model.data.Player;
import model.policy.MySokobanPolicy;

public class MoveUpCommand extends Move {

	public MoveUpCommand(Model model) {
		this.model=model;
	}
	public MoveUpCommand() {
		this.lev=null;
	}

	@Override
	public void execute() {
		this.setLev(this.model.getLevel());
		this.setMsp(this.model.getPolicy());
		this.setPlayer(this.model.getLevel().getPlayers().get(0));
		this.model.moveUp();

	}


}
