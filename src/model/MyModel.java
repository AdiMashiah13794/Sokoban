package model;

import java.util.Observable;

import commands.Command;
import commands.LoadFileCommand;
import commands.MoveDownCommand;
import commands.MoveLeftCommand;
import commands.MoveRightCommand;
import commands.MoveUpCommand;
import commands.SaveFileCommand;
import model.data.Level;

public class MyModel extends Observable implements Model   {
	private Level level;
	private Command command;
	private LoadFileCommand load;
	private SaveFileCommand save;
	private MoveUpCommand up;
	private MoveDownCommand down;
	private MoveLeftCommand left;
	private MoveRightCommand right;
	private String filePath;

	public MyModel(String filePath) {
		this.filePath=filePath;
		this.load= new LoadFileCommand(this.filePath);
	}


	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		notifyObservers();
	}

	public LoadFileCommand getLoad() {
		return load;
	}

	public void setLoad(LoadFileCommand load) {
		this.load = load;
		notifyObservers();

	}

	public SaveFileCommand getSave() {
		return save;
	}

	public void setSave(SaveFileCommand save) {
		this.save = save;
		notifyObservers();

	}

	public MoveUpCommand getUp() {
		return up;
	}

	public void setUp(MoveUpCommand up) {
		this.up = up;
		notifyObservers();

	}

	public MoveDownCommand getDown() {
		return down;
	}

	public void setDown(MoveDownCommand down) {
		this.down = down;
		notifyObservers();

	}

	public MoveLeftCommand getLeft() {
		return left;
	}

	public void setLeft(MoveLeftCommand left) {
		this.left = left;
		notifyObservers();

	}

	public MoveRightCommand getRight() {
		return right;
	}

	public void setRight(MoveRightCommand right) {
		this.right = right;
		notifyObservers();

	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
		notifyObservers();

	}

	public MyModel(Command command,Level level) {
		this.command=command;
		this.level=level;
	}


	@Override
	public Level getcCurrentLevel() {
		return this.level;

		}



}
