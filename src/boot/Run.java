package boot;

import controller.Controller;
import controller.MyController;
import model.MyModel;
import view.MyView;

public class Run {

	public static void main(String[] args) {
		MyView v = new MyView();
		MyModel m= new MyModel();
		MyController c= new MyController(v,m);
		v.addObserver(c);
		m.addObserver(c);

	}

}
