package view;

import commands.Printer;
import model.Model;

public interface View {

	public void start();
	public void display();
	//public Printer getP();
	public void getModel(Model model); //לא לשכוח למחוק!!!
	public void setP(Printer p);
}
