package b2k.billing.controller;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import b2k.billing.layout.ControllerPerson;

public class ControllerBilling extends LayoutBilling {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerBilling() {
		super();
		initDatas();
	}

	private void initDatas() {

		ControllerPerson _clp = new ControllerPerson();
		addPersonInfoLayout(_clp);
		JLabel jLabel = new JLabel("ABC");
		System.out.println(jLabel.getPreferredSize());
		jLabel.setPreferredSize(new Dimension(200,200));
		addPersonInfoLayout(jLabel);
	}

	public void addPersonInfoLayout(Component panel) {

		Dimension preferredSize = pnPersonLay.getPreferredSize();
		Dimension preferredSize2 = panel.getPreferredSize();
		pnPersonLay.setPreferredSize(new Dimension(preferredSize.width,
				preferredSize.height + preferredSize2.height));
		pnPersonLay.setMinimumSize(pnPersonLay.getPreferredSize());

		int componentCount = pnPersonLay.getComponentCount() + 1;

		pnPersonLay.add(panel, getgb(componentCount));

		if (componentCount > si) {
			si = si + 10;
			pnPersonLay.add(getLblEmp1(), getgbEnd());
		}

		pnPatientInformation.updateUI();

	}
}
