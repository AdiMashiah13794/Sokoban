package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import commands.Command;
import model.Model;
import view.View;

public class MyController implements Observer  {
	private BlockingQueue<Command> commandsQueue;
	private View view;
	private Model model;
	boolean stop=false;
	private HashMap<String, Command>commands;
	private Controller controller;
	//private Server server;
	//private Socket client;

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
	commandsQueue= new PriorityBlockingQueue<Command>(20);
}

	@Override
	public void update(Observable o, Object arg) {
		LinkedList<String> params=(LinkedList<String>)arg;
		String commandKey= params.removeFirst();
		Command c=commands.get(commandKey);
		c.setParams(params);
		controller.insertCommand(c);


		//if(o== this.model){
			//String type =arg.toString();
			//Command command= commands.get(type);

			//this.currentCommand=command;
		//	commandsQueue.add(this.currentCommand);


		}


public void insertCommand(Command c){
	try {
		commandsQueue.put(c);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



	public void start() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(stop==false)
				{
					try {
						Command c=commandsQueue.poll(1,TimeUnit.SECONDS);
						if(c!=null)
							c.execute();

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();
	}


	public void stop(){
		stop=true;


	}
	//public void start(String ip,int port){
		//try {
		//	Socket theServer = new Socket(ip, port);
		//	System.out.println("connected to server");

		//} catch (IOException e) {
	//		// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}

//	}



}
