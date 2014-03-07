package b2k.action;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import b2k.entity.Action;
import b2k.generic.sqlite.function.MyConnection;
import b2k.generic.sqlite.function.SQLFunction;
import b2k.help.MainData;

//import b2k.reception.controller.ControllerReception;

public class Actions {
	//Menu action header
	private static HashMap<String, ActionListener> hashActionListener = new HashMap<String, ActionListener>();
	
	public static ActionListener callAction(String actionName) throws Exception {
		if (actionName == null)
			return null;
		if (actionName.trim().isEmpty())
			return null;
//		try {
//			Method method = Actions.class.getMethod(actionName);
//			ActionListener invoke = (ActionListener) method.invoke(null);
//		} catch (Exception e) {
//			System.out.println("Không tìm thấy action " + actionName);
//			// CommonMethod.showError(e);
//		}

		ActionListener action = getAction(actionName);
		if(action == null) throw new Exception("Không tìm thấy action " + actionName);
		return action;

	}

	public static ActionListener getAction(final String actionName){
		ActionListener actionListener = hashActionListener.get(actionName);
		if(actionListener == null){
			actionListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//Lấy về container dựa vào tên class.
					Container conainer;
					try {
						conainer = getConainer(getClassNameByAction(actionName));
						if(conainer != null)
							MainData.getController().getBody().addBody(conainer);
					} catch (IllegalArgumentException | SecurityException
							| IllegalAccessException
							| InvocationTargetException | NoSuchMethodException
							| InstantiationException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			};
			hashActionListener.put(actionName, actionListener);
		}
		return actionListener;
	}


	protected static String getClassNameByAction(String actionName) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, SQLException {
		Connection connection = MyConnection.getSQLiteConnection("menu");
		List<Action> selectByWhere = SQLFunction.selectByWhere(connection, Action.class, "name =" +"'"+actionName+"'");
		for(Action action : selectByWhere){
			return action.getClassName();
		}
//		if(actionName.equalsIgnoreCase("getActionReception")){
//			return "b2k.reception.controller.ControllerReception";
//		}else if(actionName.equalsIgnoreCase("getActionBilling")){
//			return "b2k.billing.controller.ControllerBilling";
//		}
		return null;
	}

//	protected static void doActionReception() {
//		MainData.getController().getBody().addBody(getReception());
//
//	}

	private static Container getConainer(String className) {
		if(className == null) return null;
		try {
			
			Class<?> forName = Class
					.forName(className);
			
//			Class<?> forName = Class
//					.forName("b2k.reception.controller.ControllerReception");

			Container newInstance = (Container) forName.newInstance();

			if (newInstance != null)
				return newInstance;

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("ERROR");

		return new JPanel();
	}

}
