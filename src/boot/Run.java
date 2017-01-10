package boot;

import java.util.Scanner;

import commands.CLI;
import commands.LevelPrinter;
import controller.Controller;
import controller.MyController;
import model.MyModel;
import model.policy.MySokobanPolicy;
import view.MyView;

public class Run {

	public static void main(String[] args) {
		MySokobanPolicy msp= new MySokobanPolicy();
		String str;
		System.out.print("load: ");
	    Scanner s = new Scanner(System.in);
	    str = s.nextLine();	
		MyView v = new MyView();
		MyModel m= new MyModel(str);
		MyController c= new MyController(v,m);
		v.addObserver(c);
		m.addObserver(c);
		c.start();
 		System.out.print("> ");
		 str = s.nextLine();
	    
		s.close();	


	}

}
