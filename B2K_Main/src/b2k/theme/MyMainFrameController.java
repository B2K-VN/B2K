package b2k.theme;

import images.IconCollection;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.ribbon.AbstractRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority;
import org.pushingpixels.flamingo.api.ribbon.RibbonTask;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;

import b2k.action.Actions;
import b2k.entity.CommandButton;
import b2k.entity.Module;
import b2k.entity.RibbonBand;
import b2k.generic.sqlite.function.MyConnection;
import b2k.generic.sqlite.function.SQLFunction;
import b2k.help.MainFrameController;
import b2k.menu.MyRibbonTask;

public class MyMainFrameController extends MainFrameController {
	
	public static final String LOW 	= "LOW";
	public static final String TOP 	= "TOP";
	public static final String MEDIUM  = "MEDIUM";
	
	static Connection connection = null;
	static{
		connection =  MyConnection.getSQLiteConnection("menu");
		try {
//			Module module = new Module();
//			module.setName("Tiếp nhận");
//			module.setHotKey("T");
//			SQLFunction.save(connection, module);
//			System.out.println(SQLFunction.selectAll(connection, Module.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MyMainFrameController();
	}
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyMainFrameController() {
		super();

	}

	public void initMenus() {
		//Sql config or call bean get config.
		try {
		
			List<Module> selectAll = SQLFunction.selectAll(connection, Module.class);
			for(Module module : selectAll){
				getRibbon().addTask(getRibbon(module));
			}
		
		} catch (IllegalArgumentException | SecurityException
				| IllegalAccessException | InvocationTargetException
				| NoSuchMethodException | InstantiationException | SQLException e) {
			e.printStackTrace();
		}
	}

	private RibbonTask getRibbon(Module module) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, SQLException {
		return new MyRibbonTask(module.getName(), module.getHotKey(), getRibbonBands(module.getId()));
	}

	private AbstractRibbonBand<?>[] getRibbonBands(long id) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, SQLException {
		List<JRibbonBand> ribbonBands = new ArrayList<JRibbonBand>();
		List<RibbonBand> dataRibbonBands = SQLFunction.selectByWhere(connection, RibbonBand.class, "moduleId = " + id);
		for(RibbonBand ribbonBand : dataRibbonBands){
			JRibbonBand jRibbonBand = getJRibbonBand(ribbonBand);

			ribbonBands.add(jRibbonBand);
		}

		return ribbonBands
				.toArray(new AbstractRibbonBand<?>[ribbonBands.size()]);
	}
	
	private static JRibbonBand getJRibbonBand(RibbonBand ribbonBand) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, SQLException {
		JRibbonBand band = new JRibbonBand(ribbonBand.getName(), IconCollection.getIcon(ribbonBand.getImage()));
	
		band.setResizePolicies((List) Arrays
				.asList(new CoreRibbonResizePolicies.Mirror(band
						.getControlPanel())));
		
		List<CommandButton> dataCommandButtons = SQLFunction.selectByWhere(connection, CommandButton.class, "ribbonId = " + ribbonBand.getId());
		for(CommandButton commandButton : dataCommandButtons){
			JCommandButton button = getJCommandButton(commandButton);
			band.addCommandButton(button, getRibbonElementPriority(commandButton.getPriority()));
		}
		
		return band;
	}

	private static RibbonElementPriority getRibbonElementPriority(String priority) {
		switch (priority) {
		case LOW:
			return RibbonElementPriority.LOW;
		case MEDIUM:
			return RibbonElementPriority.MEDIUM;
		case TOP:
			return RibbonElementPriority.TOP;

		}
		return null;
	}

	private static JCommandButton getJCommandButton(
			CommandButton commandButton) {
		JCommandButton btn1 = new JCommandButton(commandButton.getName(),
				IconCollection.getIcon(commandButton.getImage()));
		try {
			btn1.addActionListener(Actions.callAction(commandButton.getAction()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return btn1;
	}

	
	
}
