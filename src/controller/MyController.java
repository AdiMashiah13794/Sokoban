package controller;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import commands.CLI;
import commands.Command;
import commands.LoadFileCommand;
import commands.MoveDownCommand;
import commands.MoveLeftCommand;
import commands.MoveRightCommand;
import commands.MoveUpCommand;
import commands.SaveFileCommand;
import model.Model;
import view.View;

public class MyController extends Thread implements Controller  {
	private BlockingQueue<Command> commandsQueue;
	private View view;
	private Model model;
	private HashMap<String, Command>commands;
	private Command currentCommand;
	
	public MyController() {
		commands=new HashMap<String,Command>();
		commands.put("Load", this.model.getLoad());
		commands.put("Save", this.model.getSave());
		commands.put("Move Up",this.model.getUp());
		commands.put("Move Down",this.model.getDown());
		commands.put("Move Left",this.model.getLeft());
		commands.put("Move Right",this.model.getRight());
		
		
	}
	
	
public BlockingQueue<Command> getCommandsQueue() {
		return commandsQueue;
	}

	public void setCommandsQueue(BlockingQueue<Command> commandsQueue) {
		this.commandsQueue = commandsQueue;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

public MyController(View view,Model model) {
	this.view=view;
	this.model=model;
	commands=new HashMap<String,Command>();
	commands.put("Load", this.model.getLoad());
	commands.put("Save", this.model.getSave());
	commands.put("Move Up",this.model.getUp());
	commands.put("Move Down",this.model.getDown());
	commands.put("Move Left",this.model.getLeft());
	commands.put("Move Right",this.model.getRight());

}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o== this.model){
			String type =arg.toString();
			Command command= commands.get(type);
			this.currentCommand=command;
			commandsQueue.add(command);	
		}
			
		
	}


	@Override
	public void start() {
		try {
			commandsQueue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		run();
	}
	private void runCommandInThread(){
			new Thread(new Runnable() {
			
			@Override
			public void run() {
				currentCommand.execute();
			}
	}).start();
	}
	
	public void run(){
		runCommandInThread();
	}


	@Override
	public void Stop() {
		Thread.currentThread().interrupt();
		return;
		
	}

	

}
