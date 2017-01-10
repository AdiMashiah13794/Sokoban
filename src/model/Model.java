package model;

import commands.Command;
import commands.LoadFileCommand;
import commands.MoveDownCommand;
import commands.MoveLeftCommand;
import commands.MoveRightCommand;
import commands.MoveUpCommand;
import commands.SaveFileCommand;
import model.data.Level;

public interface Model  {
	public Level getLevel();
	public void setLevel(Level level);
	public LoadFileCommand getLoad();
	public void setLoad(LoadFileCommand load);
	public SaveFileCommand getSave();
	public void setSave(SaveFileCommand save);
	public MoveUpCommand getUp();
	public void setUp(MoveUpCommand up);
	public MoveDownCommand getDown();
	public void setDown(MoveDownCommand down);
	public MoveLeftCommand getLeft();
	public void setLeft(MoveLeftCommand left);
	public MoveRightCommand getRight();
	public void setRight(MoveRightCommand right);
	
		
}
