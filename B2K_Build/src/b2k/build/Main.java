package b2k.build;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import b2k.entity.Action;
import b2k.entity.CommandButton;
import b2k.entity.Module;
import b2k.entity.RibbonBand;
import b2k.generic.sqlite.function.MyConnection;
import b2k.generic.sqlite.function.SQLFunction;


public class Main {

	public static void main(String[] args) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException, InstantiationException {
//		Connection connection = MyConnection.getSQLiteConnection("menu");
//		Action action = new Action();
//		action.setName("getActionReception");
//		action.setClassName("b2k.reception.controller.ControllerReception");
//		SQLFunction.save(connection, action);
//		
//		action = new Action();
//		action.setName("getActionBilling");
//		action.setClassName("b2k.billing.controller.ControllerBilling");
//		SQLFunction.save(connection, action);
//		Module module = new Module();
//		module.setHotKey("B");
//		module.setName("Thu ngân");
//		module.setImage("images/customer.png");
//		module = SQLFunction.save(connection, module);
////		RibbonBand ribbonBand = SQLFunction.selectByid(connection, RibbonBand.class, 1);
//		RibbonBand ribbonBand = new RibbonBand();
//		ribbonBand.setName("Thu ngân");
//		ribbonBand.setHotKey("T");
//		ribbonBand.setModuleId(module.id);
//		ribbonBand = SQLFunction.save(connection, ribbonBand);
//		CommandButton commandButton = new CommandButton();
//		commandButton.setName("Thu ngân");
//		commandButton.setHotKey("N");
//		commandButton.setImage( "images/customer.png");
//		commandButton.setAction("getActionReception");
//		commandButton.setRibbonId(ribbonBand.getId());
//		commandButton.setPriority("TOP");
//		SQLFunction.save(connection, commandButton);
		
		new b2k.main.Main(System.getProperty("keysis"));
	}
}
