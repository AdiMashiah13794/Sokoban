package controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import commands.Command;
import commands.ExitCommand;


public  class Controller{
	private BlockingQueue<Command> commandsQueue;
	boolean stop=false;
	private Command ExitCommand;

public Controller() {
	commandsQueue= new ArrayBlockingQueue<Command>(10);
}

public void start() {
	new Thread(new Runnable() {

		
		@Override
		public void run() {
			while(stop==false)
			{
				try {
					System.out.println("jnfnjsdfjksfdgkgjsjgjk");
					Command c=commandsQueue.poll(10,TimeUnit.SECONDS);
					if(c!=null)
						c.execute();
					if(c==ExitCommand)
						stop();
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

public void insertCommand(Command c){

		try {
			commandsQueue.put(c);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


}
}
