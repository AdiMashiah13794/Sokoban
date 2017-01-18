package view;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Scanner;



public class MyView extends Observable implements View  {

	@Override
	public void start() {

		Scanner s= new Scanner(System.in);

		new Thread(new Runnable() {

			@Override
			public void run() {
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

}





