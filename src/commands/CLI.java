package commands;

import java.util.HashMap;
import java.util.Scanner;

import levels.Level;

public class CLI {
	
	private HashMap<String, Command> commands;
	private String type;
	private String fileSavePath;
	private String filePath;
	private LoadFileCommand load;
	private MoveUpCommand up;
	private MoveDownCommand down;
	private MoveLeftCommand left;
	private MoveRightCommand right;
	private SaveFileCommand save;
	private ExitCommand exit;
	private Printer print;
	private DisplayLevelCommand dis;
	private Level lev;
	private MySokobanPolicy msp;
	private boolean exitFlag;

	
	
	
	public LoadFileCommand getLoad() {
		return load;
	}
	public void setLoad(LoadFileCommand load) {
		this.load = load;
	}
	public MoveUpCommand getUp() {
		return up;
	}
	public void setUp(MoveUpCommand up) {
		this.up = up;
	}
	public MoveDownCommand getDown() {
		return down;
	}
	public void setDown(MoveDownCommand down) {
		this.down = down;
	}
	public MoveLeftCommand getLeft() {
		return left;
	}
	public void setLeft(MoveLeftCommand left) {
		this.left = left;
	}
	public MoveRightCommand getRight() {
		return right;
	}
	public void setRight(MoveRightCommand right) {
		this.right = right;
	}
	public SaveFileCommand getSave() {
		return save;
	}
	public void setSave(SaveFileCommand save) {
		this.save = save;
	}
	public ExitCommand getExit() {
		return exit;
	}
	public void setExit(ExitCommand exit) {
		this.exit = exit;
	}
	public DisplayLevelCommand getDis() {
		return dis;
	}
	public void setDis(DisplayLevelCommand dis) {
		this.dis = dis;
	}
	public HashMap<String, Command> getCommands() {
		return commands;
	}
	public void setCommands(HashMap<String, Command> commands) {
		this.commands = commands;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public LoadFileCommand getLod() {
		return load;
	}
	public void setLod(LoadFileCommand lod) {
		this.load = lod;
	}
	public Level getLev() {
		return lev;
	}
	public void setLev(Level lev) {
		this.lev = lev;
	}
	public CLI(String filePath,Printer print,MySokobanPolicy msp) {
		
		this.msp=msp;
		this.load =new LoadFileCommand(filePath);
		this.exitFlag=false;
		this.exit= new ExitCommand(this.lev,this.exitFlag);
		this.print= print;
		this.save= new SaveFileCommand();
		this.up= new MoveUpCommand();
		this.left= new MoveLeftCommand();
		this.right= new MoveRightCommand();
		this.down= new MoveDownCommand();
		this.dis =new DisplayLevelCommand(this.lev,this.print);
		commands=new HashMap<String,Command>();
		commands.put("Load", this.load);
		commands.put("Save", this.save);
		commands.put("Display", this.dis);
		commands.put("Move Up",this.up);
		commands.put("Move Down",this.down);
		commands.put("Move Left",this.left);
		commands.put("Move Right",this.right);
		commands.put("Exit",exit);

		
	}
	public void invoke(String command){
		switch (command) {
		case "Load": case "load":
			this.type="Load";
			this.load = (LoadFileCommand) commands.get(this.type);
			commands.get(this.type).execute();
			
			System.out.println("The level loaded successfully");
			this.lev=load.getLev();
			dis.setLev(lev);
			this.msp.setPlayer(this.lev.getPlayers().get(0));
			this.up.setLev(this.lev);
			this.up.setPlayer(this.lev.getPlayers().get(0));
			this.up.setMsp(this.msp);
			this.down.setLev(this.lev);
			this.down.setPlayer(this.lev.getPlayers().get(0));
			this.down.setMsp(this.msp);
			this.left.setLev(this.lev);
			this.left.setPlayer(this.lev.getPlayers().get(0));
			this.left.setMsp(this.msp);
			this.right.setLev(this.lev);
			this.right.setPlayer(this.lev.getPlayers().get(0));
			this.right.setMsp(this.msp);
			this.save.setLev(this.lev);
			this.exit.setLev(this.lev);
			break;
		case "Display": case"display":
			this.type="Display";
			commands.get(this.type).execute();
			break;
		case "Move Up": case "move up":
			this.type="Move Up";
			commands.get(this.type).execute();
			this.lev=up.getLev();
			dis.setLev(lev);
			this.down.setLev(this.lev);
			this.left.setLev(this.lev);
			this.right.setLev(this.lev);
			this.save.setLev(this.lev);
			this.exit.setLev(this.lev);
			break;
		case "Move Down": case "move down":
			this.type="Move Down";
			commands.get(this.type).execute();
			this.lev=down.getLev();
			this.dis.setLev(lev);
			this.up.setLev(this.lev);
			this.left.setLev(this.lev);
			this.right.setLev(this.lev);
			this.save.setLev(this.lev);
			this.exit.setLev(this.lev);
			break;
		case "Move Left": case "move left":
			this.type= "Move Left";
			commands.get(this.type).execute();
			this.lev=left.getLev();
			this.dis.setLev(lev);
			this.up.setLev(this.lev);
			this.up.setPlayer(this.lev.getPlayers().get(0));
			this.down.setLev(this.lev);
			this.down.setPlayer(this.lev.getPlayers().get(0));
			this.right.setLev(this.lev);
			this.right.setPlayer(this.lev.getPlayers().get(0));
			this.save.setLev(this.lev);
			this.exit.setLev(this.lev);
			break;
		case "Move Right": case "move right":
			this.type="Move Right";
			commands.get(this.type).execute();
			this.lev=right.getLev();
			this.dis.setLev(lev);
			this.up.setLev(this.lev);
			this.up.setPlayer(this.lev.getPlayers().get(0));
			this.down.setLev(this.lev);
			this.down.setPlayer(this.lev.getPlayers().get(0));

			this.left.setLev(this.lev);
			this.save.setLev(this.lev);
			this.exit.setLev(this.lev);
			break;
		case "Save": case "save":
			this.type="Save";
			System.out.println("save to:");
			Scanner s= new Scanner(System.in);
			String str= s.nextLine();
			this.fileSavePath=str;
			this.save.setFilePath(this.fileSavePath);
			this.save.setLev(this.lev);
			commands.get(this.type).execute();
			System.out.println("the level saved successfully");
			break;
		case "Exit": case "exit":
			this.type="Exit";
			commands.get(this.type).execute();
			this.exitFlag=this.exit.isFlag();
			System.out.println("bye bye!");
			break;
		default: 
			System.out.println("The command is not found");
			break;
		}
				
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFileSavePath() {
		return fileSavePath;
	}
	public void setFileSavePath(String fileSavePath) {
		this.fileSavePath = fileSavePath;
	}
	public Printer getPrint() {
		return print;
	}
	public void setPrint(Printer print) {
		this.print = print;
	}
	public MySokobanPolicy getMsp() {
		return msp;
	}
	public void setMsp(MySokobanPolicy msp) {
		this.msp = msp;
	}
	public boolean isExitFlag() {
		return exitFlag;
	}
	public void setExitFlag(boolean exitFlag) {
		this.exitFlag = exitFlag;
	}
	

}
