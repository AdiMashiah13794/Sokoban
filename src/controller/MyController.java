package controller;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class MyController implements Controller  {
	
	private View view;
	private Model model;
	
public MyController(View view,Model model) {
	this.view=view;
	this.model=model;

}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
