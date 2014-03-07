/*
 * DefaultCheckListRenderer.java
 *
 * Project     : yHospitalIE2009
 *
 * Created     : 11:36:25 AM Feb 24, 2009
 * By          : hung.hp
 * Description :
 * 
 * Copyright 2008 by DTAD
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of DTAD. ("Confidential Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with DTAD.
 */
package b2k.help;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author hung.hp
 * @version 1.0.0
 */
public class ListCellRenderer extends JPanel implements
		javax.swing.ListCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int height = 25;
	private MyLabel lblUnitQuantity;
	private MyLabel lblUnitOfMeasure;
	private MyLabel lblManufacturerNo;
	private MyLabel lblModel;
	private MyLabel lblNo;
	private MyLabel lblName;
	private MyLabel lblID = null;
	private MyLabel lblDongiaNoVAT = null;
	private MyLabel lblVAT = null;
	private MyLabel lblDongiaVAT = null;
	private MyLabel lblTotal = null;
	private MyLabel lblemp = null;

	/**
	 * This method initializes
	 * 
	 */

	public ListCellRenderer() {
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.gridx = 15;
		gridBagConstraints6.weightx = 1.0;
		gridBagConstraints6.gridy = 0;
		GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
		gridBagConstraints51.gridx = 14;
		gridBagConstraints51.fill = GridBagConstraints.BOTH;
		gridBagConstraints51.gridy = 0;
		GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
		gridBagConstraints41.gridx = 13;
		gridBagConstraints41.fill = GridBagConstraints.BOTH;
		gridBagConstraints41.gridy = 0;
		GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
		gridBagConstraints31.gridx = 12;
		gridBagConstraints31.fill = GridBagConstraints.BOTH;
		gridBagConstraints31.gridy = 0;
		GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
		gridBagConstraints21.gridx = 11;
		gridBagConstraints21.fill = GridBagConstraints.BOTH;
		gridBagConstraints21.gridy = 0;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 0;
		GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
		gridBagConstraints8.gridx = 10;
		gridBagConstraints8.fill = GridBagConstraints.BOTH;
		gridBagConstraints8.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints8.gridy = 0;
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.gridx = 9;
		gridBagConstraints7.fill = GridBagConstraints.BOTH;
		gridBagConstraints7.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints7.gridy = 0;
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 3;
		gridBagConstraints5.fill = GridBagConstraints.BOTH;
		gridBagConstraints5.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints5.gridy = 0;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 4;
		gridBagConstraints4.fill = GridBagConstraints.BOTH;
		gridBagConstraints4.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints4.gridy = 0;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 2;
		gridBagConstraints2.fill = GridBagConstraints.BOTH;
		gridBagConstraints2.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints2.weightx = 0.0;
		gridBagConstraints2.gridy = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridy = 0;
		this.setSize(new Dimension(1505, 25));
		this.setPreferredSize(this.getSize());
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(getLblNo(), gridBagConstraints);
		this.add(getLblName(), gridBagConstraints2);
		this.add(getLblModel(), gridBagConstraints4);
		this.add(getLblManufacturerNo(), gridBagConstraints5);
		this.add(getLblUnitOfMeasure(), gridBagConstraints7);
		this.add(getLblUnitQuantity(), gridBagConstraints8);
		this.add(getLblID(), gridBagConstraints1);
		this.add(getLblDongiaNoVAT(), gridBagConstraints21);
		this.add(getLblVAT(), gridBagConstraints31);
		this.add(getLblDongiaVAT(), gridBagConstraints41);
		this.add(getLblTotal(), gridBagConstraints51);
		this.add(getLblemp(), gridBagConstraints6);
	}

	protected MyLabel getLblNo() {
		if (lblNo == null) {
			lblNo = new MyLabel();
			lblNo.setText("");
			lblNo.setPreferredSize(new Dimension(32, 21));
			lblNo.setMinimumSize(new Dimension(32, 21));
			lblNo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1,
					Color.gray));
			lblNo.setHorizontalAlignment(SwingConstants.RIGHT);

		}
		return lblNo;
	}

	protected MyLabel getLblName() {
		if (lblName == null) {
			lblName = new MyLabel();
			lblName.setText("");
			lblName.setPreferredSize(new Dimension(350, 21));
			lblName.setMinimumSize(new Dimension(350, 21));
			lblName.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1,
					Color.gray));
		}
		return lblName;
	}

	/**
	 * This method initializes lblModel
	 * 
	 * @return com.dtad.swingx.others.MyLabel
	 */
	protected MyLabel getLblModel() {
		if (lblModel == null) {
			lblModel = new MyLabel();
			lblModel.setText("");
			lblModel.setPreferredSize(new Dimension(100, 21));
			lblModel.setMinimumSize(lblModel.getPreferredSize());
			lblModel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1,
					Color.gray));
		}
		return lblModel;
	}

	/**
	 * This method initializes lblManufacturerNo
	 * 
	 * @return com.dtad.swingx.others.MyLabel
	 */
	protected MyLabel getLblManufacturerNo() {
		if (lblManufacturerNo == null) {
			lblManufacturerNo = new MyLabel();
			lblManufacturerNo.setText("");
			lblManufacturerNo.setPreferredSize(new Dimension(300, 21));
			lblManufacturerNo.setMinimumSize(lblManufacturerNo
					.getPreferredSize());
			lblManufacturerNo.setBorder(BorderFactory.createMatteBorder(0, 0,
					0, 1, Color.gray));
		}
		return lblManufacturerNo;
	}

	/**
	 * This method initializes lblUnitOfMeasure
	 * 
	 * @return com.dtad.swingx.others.MyLabel
	 */
	protected MyLabel getLblUnitOfMeasure() {
		if (lblUnitOfMeasure == null) {
			lblUnitOfMeasure = new MyLabel();
			lblUnitOfMeasure.setText("");
			lblUnitOfMeasure.setPreferredSize(new Dimension(70, 21));
			lblUnitOfMeasure
					.setMinimumSize(lblUnitOfMeasure.getPreferredSize());
			lblUnitOfMeasure.setBorder(BorderFactory.createMatteBorder(0, 0, 0,
					1, Color.gray));
		}
		return lblUnitOfMeasure;
	}

	/**
	 * This method initializes lblUnitQuantity
	 * 
	 * @return com.dtad.swingx.others.MyLabel
	 */
	protected MyLabel getLblUnitQuantity() {
		if (lblUnitQuantity == null) {
			lblUnitQuantity = new MyLabel();
			lblUnitQuantity.setText("");
			lblUnitQuantity.setPreferredSize(new Dimension(70, 21));
			lblUnitQuantity.setMinimumSize(lblUnitQuantity.getPreferredSize());
			lblUnitQuantity.setBorder(BorderFactory.createMatteBorder(0, 0, 0,
					1, Color.gray));
			lblUnitQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblUnitQuantity;
	}

	/**
	 * This method initializes this
	 * 
	 */

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

//		if (isBackGround) {
//			if (isSelected) {
//				if (cellHasFocus) {
//					setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0,
//							ColorCollection.METAL_BLUE));
//					setBackground(ColorCollection.SELECTED_ROW);
//				} else {
//					setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0,
//							ColorCollection.METAL_BLUE));
//					setBackground(ColorCollection.SELECTED_ROW_NO_FOCUS);
//				}
//			} else {
//				setBorder(null);
//				if (index % 2 == 0)
//					setBackground(ColorCollection.BACKCOLOR5);
//				else
//					setBackground(ColorCollection.BACKCOLOR6);
//			}
//		} else {
//			if (index % 2 == 0) {
//				setForeground(Color.BLACK);
//				setBackground(ColorCollection.BACKCOLOR1);
//			} else {
//				setForeground(Color.BLACK);
//				setBackground(ColorCollection.BACKCOLOR2);
//			}
//		}
//		if (value instanceof PartInputSku) {
//			PartInputSku equipInput = EquipMethod.getValue(PartInputSku.class,
//					value);
//
//			lblNo.setText((index + 1) + ". ");
//			PartCatalog catalog = equipInput.getPartCatalog();
//			if (catalog == null) {
//				catalog = EquipDatamanager.getPartCatalogbyNo(equipInput
//						.getPartNo());
//			}
//
//			if (catalog != null) {
//				lblID.setText("  " + catalog.getPartId());
//				lblName.setText("  " + catalog.getProperName());
//				lblModel.setText("  " + catalog.getModelCode());
//				lblManufacturerNo.setText("  "
//						+ DocumentData.getManufacturerName(catalog
//								.getManufacturerNo()));
//				lblUnitOfMeasure.setText("  "
//						+ DocumentData.getUnitOfMeasureName(catalog
//								.getUnitOfMeasure()));
//			}
//			lblUnitQuantity.setText(equipInput.getUnitQuantity() + " ");
//			lblDongiaNoVAT.setText(equipInput.getNoVatUnitPrice() + " ");
//			lblVAT.setText(equipInput.getVatPercent() + " ");
//			lblDongiaVAT.setText(equipInput.getUnitPrice() + " ");
//			lblTotal.setText(equipInput.getTotal() + " ");
//
//		}

		 this.setSize(list.getSize().width - 20, height);
		 this.setPreferredSize(this.getSize());
		this.setToolTipText(value.toString());
		// setText("    " + (index + 1) + ".  " + value.toString());

		return this;

	}

	/**
	 * This method initializes lblID
	 * 
	 * @return com.dtad.swingx.others.MyLabel
	 */
	private MyLabel getLblID() {
		if (lblID == null) {
			lblID = new MyLabel();
			lblID.setMinimumSize(new Dimension(120, 21));
			lblID.setPreferredSize(new Dimension(120, 21));
			lblID.setText("");
			lblID.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1,
					Color.gray));
		}
		return lblID;
	}

	/**
	 * This method initializes lblDongiaNoVAT
	 * 
	 * @return com.dtad.swingx.others.MyLabel
	 */
	private MyLabel getLblDongiaNoVAT() {
		if (lblDongiaNoVAT == null) {
			lblDongiaNoVAT = new MyLabel();
			lblDongiaNoVAT.setMinimumSize(new Dimension(130, 21));
			lblDongiaNoVAT.setPreferredSize(new Dimension(130, 21));
			lblDongiaNoVAT.setText("");
			lblDongiaNoVAT.setBorder(BorderFactory.createMatteBorder(0, 0, 0,
					1, Color.gray));
			lblDongiaNoVAT.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblDongiaNoVAT;
	}

	/**
	 * This method initializes lblVAT
	 * 
	 * @return com.dtad.swingx.others.MyLabel
	 */
	private MyLabel getLblVAT() {
		if (lblVAT == null) {
			lblVAT = new MyLabel();
			lblVAT.setMinimumSize(new Dimension(50, 21));
			lblVAT.setPreferredSize(new Dimension(50, 21));
			lblVAT.setText("");
			lblVAT.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1,
					Color.gray));
			lblVAT.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblVAT;
	}

	/**
	 * This method initializes lblDongiaVAT
	 * 
	 * @return com.dtad.swingx.others.MyLabel
	 */
	private MyLabel getLblDongiaVAT() {
		if (lblDongiaVAT == null) {
			lblDongiaVAT = new MyLabel();
			lblDongiaVAT.setMinimumSize(new Dimension(150, 21));
			lblDongiaVAT.setPreferredSize(new Dimension(150, 21));
			lblDongiaVAT.setText("");
			lblDongiaVAT.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1,
					Color.gray));
			lblDongiaVAT.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblDongiaVAT;
	}

	/**
	 * This method initializes lblTotal
	 * 
	 * @return com.dtad.swingx.others.MyLabel
	 */
	private MyLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new MyLabel();
			lblTotal.setMinimumSize(new Dimension(130, 21));
			lblTotal.setPreferredSize(new Dimension(130, 21));
			lblTotal.setText("");
			lblTotal.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1,
					Color.gray));
			lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblTotal;
	}

	/**
	 * This method initializes lblemp
	 * 
	 * @return javax.swing.MyLabel
	 */
	private MyLabel getLblemp() {
		if (lblemp == null) {
			lblemp = new MyLabel();
			lblemp.setText("");
		}
		return lblemp;
	}

}
