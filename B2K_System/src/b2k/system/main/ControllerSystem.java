package b2k.system.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import b2k.system.menu.ControllerCompanyInfo;

import com.l2fprod.common.swing.JLinkButton;
import com.l2fprod.common.swing.JTaskPaneGroup;

public class ControllerSystem extends LayoutSystem{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4393222259383176574L;
	
	final String COMPANY_INFO = "COMPANY_INFO";
	private ButtonGroup btg = new ButtonGroup();

	private ActionListener viewListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent action) {
			String actionCommand = action.getActionCommand();
			System.out.println(actionCommand);
			switch (actionCommand) {
			case COMPANY_INFO:
				getScrLayoutContent().setViewportView(getControllerCompanyInfo());
				break;

			default:
				break;
			}
		}
	};

	private ControllerCompanyInfo controllerCompanyInfo;
	
	public ControllerSystem() {
		super();
		initDatas();
	}

	protected ControllerCompanyInfo getControllerCompanyInfo() {
		if(controllerCompanyInfo == null){
			controllerCompanyInfo = new ControllerCompanyInfo();
		}
		return controllerCompanyInfo;
	}

	private void initDatas() {
		initDataMenuAdmin();
	}

	
	
	private void initDataMenuAdmin() {
		pnLayoutMenuAdmin.add(getSystemInfo());
	}

	private JTaskPaneGroup getSystemInfo() {
		JTaskPaneGroup pn = new JTaskPaneGroup();
		pn.setTitle("Thiết đặt hệ thống");
		pn.add(newButton("Thông tin chung", COMPANY_INFO));
		pn.add(newButton("Thông tin 1", ""));
		pn.add(newButton("Thông tin c", ""));
//		pn.setSize(pn.getPreferredSize());
		return pn;
	}


	private JLinkButton newButton(
			String title, String action) {
		JLinkButton linkLabel = new JLinkButton();
//		linkLabel.setContentAreaFilled(false);
//		linkLabel.setBorderPainted(false);
//		linkLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		linkLabel.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				((JToggleButton) e.getSource()).setForeground(e.getStateChange() == ItemEvent.SELECTED ? Color.red : new Color(80,100,255));
			}
		});
		linkLabel.addActionListener(viewListener );
		linkLabel.setHorizontalAlignment(SwingConstants.LEADING);
//		linkLabel.setForeground(new Color(80,100,255));
		linkLabel.setText(title);
		linkLabel.setActionCommand(action);
		btg.add(linkLabel);
		return linkLabel;
	}
	
	
}
