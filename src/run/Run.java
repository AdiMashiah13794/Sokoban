
package run;
//this is our second commit
import java.io.IOException;
import java.util.Scanner;
import commands.CLI;
import commands.LevelPrinter;
import commands.MySokobanPolicy;

public class Run {

	public static void main(String[] args) throws IOException {
		MySokobanPolicy msp= new MySokobanPolicy();
		String str;
		System.out.print("load: ");
	    Scanner s = new Scanner(System.in);
	    str = s.nextLine();	
		CLI cli= new CLI(str,new LevelPrinter(),msp);
		cli.invoke("load");
 		System.out.print("> ");
		 str = s.nextLine();
	    while(cli.isExitFlag()!=true&& str!="load"&& str!="Load")
	    {
	    	cli.invoke(str);
	    	if(cli.isExitFlag()!=true){
	    		System.out.print("> ");
	    		str=s.nextLine();
	    	}

	    }
		s.close();	

}
}
