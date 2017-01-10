package view;

import java.util.Observable;

import commands.Command;
import model.data.Level;

public class MyView extends Observable implements View  {
	
	private Level level;
	Command command;
	public MyView() {
	}
	public MyView(Command command,Level level) {
		this.command=command;
		this.level=level;
	}
	
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	
	
	

}
