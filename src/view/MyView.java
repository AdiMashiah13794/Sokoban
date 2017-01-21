package view;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Scanner;

import commands.DisplayLevelCommand;
import commands.Printer;
import common.Common;
import model.Model;



public class MyView extends Observable implements View  {

	private DisplayLevelCommand dis;
	private  Printer p;
private Model model;

	public DisplayLevelCommand getDis() {
		return dis;
	}

	public void setDis(DisplayLevelCommand dis) {
		this.dis = dis;
	}

	public Printer getP() {
		return p;
	}

	public void setP(Printer p) {
		this.p = p;
	}

	@Override
	public void start() {

		Scanner s= new Scanner(System.in);

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("test");
				while(true){
				System.out.println("Enter the command >");
				LinkedList<String>params= new LinkedList<String>();
				String str= s.nextLine();
				if(str.equals("exit")|| str.equals("Exit"))
						break;
				if(str.contains("move")||str.contains("Move"))
					params.add(str);
				else{
					String[] list=str.split(" ");
					for(String s:list)
						params.add(s);

				}
				setChanged();
				notifyObservers(params);

			}
			}
		}).start();

	}

	public void display(){
this.p.print(this.model.getLevel());

	}

	@Override
	public void getModel(Model model) {
this.model=model;
	}



}





