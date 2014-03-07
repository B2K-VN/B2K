package b2k.help;


import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class JCheckList extends JList {

	private static final long serialVersionUID = 1L;

	public static final int SINGLE_CHECKING = 100;
	public static final int MULTIPLE_CHECKING = 101;

	public static final int ACTION_BTN_DETAIL = 102;
	public static final int ACTION_BTN_STATUS = 103;
	public static final int ACTION_LIST_CHECKING = 104;

	private ActionListener actionListener = null;

	private Vector<Integer> rowsSelected = new Vector<Integer>();
	private Vector<Integer> uneditableRows = new Vector<Integer>();
	private boolean isEditable = true;
	private JCheckBox chkBox = null;

	private Component btnDetail = null;
	private Component btnStatus = null;

	private JRadioButton rCheck = null;

	private int checkingMode = MULTIPLE_CHECKING;

	/**
	 * This is the default constructor
	 */
	public JCheckList() {
		super();
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addKeyListener(getKeySpaceAction(this));
		addMouseMotionListener(getMouseMotionListener(this));
		addMouseListener(getMouseAction(this));
		addFocusListener(getFocusListener(this));
		setCellRenderer(new DefaultCheckListRenderer());

	}

	private FocusListener getFocusListener(final JCheckList list) {
		FocusListener focusListener = new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (list.getSelectedIndex() == -1) {
					if (list.getModel().getSize() > 0)
						list.setSelectedIndex(0);
				}
			}
		};
		return focusListener;
	}

	protected void updatePoint(ListCellRenderer renderer) {
		if (btnDetail == null || btnStatus == null) {
			if (renderer instanceof Container) {
				Container panel = (Container) renderer;
				Component[] c = panel.getComponents();
				for (int i = 0; i < c.length; i++) {
					if (c[i].getName() != null) {
						if (c[i].getName().equalsIgnoreCase("DETAIL"))
							btnDetail = c[i];
						else if (c[i].getName().equalsIgnoreCase("STATUS"))
							btnStatus = c[i];
						if (btnDetail != null && btnStatus != null)
							break;
					}
				}
			}
		}

	}

	private void updateCursor(MouseEvent e) {
		updatePoint(getCellRenderer());

		if ((btnDetail != null && btnDetail.isVisible())
				|| (btnStatus != null && btnStatus.isVisible())) {
			Rectangle rectangle = getCellBounds(0, 0);
			if (rectangle == null)
				return;
			if (rectangle.getHeight() == 0)
				return;
			Point p = new Point(e.getX(), e.getY() % rectangle.height);

			if ((btnDetail != null && btnDetail.getBounds().contains(p))
					|| (btnStatus != null && btnStatus.getBounds().contains(p))) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}

	}

	public MouseMotionAdapter getMouseMotionListener(final JList list) {
		MouseMotionAdapter mouseAdapter = new MouseMotionAdapter() {
			boolean isExits = false;

			public void mouseMoved(MouseEvent e) {
				// System.out.println("e: " + e);
				if (list != null) {
					updateCursor(e);
					if (isEditable) {
						if (uneditableRows.lastIndexOf(list.getSelectedIndex()) == -1) {

							updatePoint(list.getCellRenderer());

							if (btnDetail != null) {
								if (btnDetail.isVisible()) {
									Rectangle rectangle = list.getCellBounds(
											list.getSelectedIndex(),
											list.getSelectedIndex());
									// System.out.println("r: " + rectangle);
									if (rectangle == null)
										return;
									Point p = new Point(e.getX(), e.getY()
											- rectangle.y);
									if (btnDetail.getBounds().contains(p)) {
										// setCursor(new
										// Cursor(Cursor.HAND_CURSOR));
										if (!isExits) {
											btnDetail.requestFocus();
											updateSelected();
											isExits = !isExits;
										}
									} else {
										// setCursor(new
										// Cursor(Cursor.DEFAULT_CURSOR));
										if (isExits) {
											updateSelected();
											isExits = !isExits;
										}
									}
								}
							}

							if (btnStatus != null) {
								if (btnStatus.isVisible()) {
									Rectangle rectangle = list.getCellBounds(
											list.getSelectedIndex(),
											list.getSelectedIndex());
									if (rectangle == null)
										return;
									Point p = new Point(e.getX(), e.getY()
											- rectangle.y);
									if (btnStatus.getBounds().contains(p)) {
										if (!isExits) {
											btnStatus.requestFocus();
											updateSelected();
											isExits = !isExits;
										}
									} else {
										if (isExits) {
											updateSelected();
											isExits = !isExits;
										}
									}
								}
							}
						}
					}
				}
			}

		};
		return mouseAdapter;
	}

	public MouseAdapter getMouseAction(final JList list) {

		MouseAdapter mouseAdapter = new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				if (list != null) {
					updateCursor(e);

					if (isEditable) {

						if (e.getButton() == MouseEvent.BUTTON1) {
							if (uneditableRows.lastIndexOf(list
									.getSelectedIndex()) == -1) {
								updatePoint(list.getCellRenderer());

								if (btnDetail != null) {
									if (btnDetail.isVisible()) {
										Rectangle rectangle = list
												.getCellBounds(
														list.getSelectedIndex(),
														list.getSelectedIndex());
										if (rectangle == null)
											return;
										Point p = new Point(e.getX(), e.getY()
												- rectangle.y);
										if (btnDetail.getBounds().contains(p)
												&& actionListener != null) {

											Object o = "";
											String s = "";
											if (list.getSelectedValue() != null) {
												o = list.getSelectedValue();
											} else {
												s = "null";
											}

											actionListener
													.actionPerformed(new ActionEvent(
															o,
															ACTION_BTN_DETAIL,
															s));
										}
									}
								}

								if (btnStatus != null) {
									if (btnStatus.isVisible()) {
										Rectangle rectangle = list
												.getCellBounds(
														list.getSelectedIndex(),
														list.getSelectedIndex());
										if (rectangle == null)
											return;
										Point p = new Point(e.getX(), e.getY()
												- rectangle.y);

										if (btnStatus.getBounds().contains(p)
												&& actionListener != null) {

											Object o = "";
											String s = "";
											if (list.getSelectedValue() != null) {
												o = list.getSelectedValue();
											} else {
												s = "null";
											}

											actionListener
													.actionPerformed(new ActionEvent(
															o,
															ACTION_BTN_STATUS,
															s));
											// addBtnStatusListener.run(list
											// .getSelectedValue());
										}
									}
								}

								if (chkBox == null) {
									ListCellRenderer renderer = list
											.getCellRenderer();
									if (renderer instanceof Container) {
										Container panel = (Container) renderer;
										Component[] c = panel.getComponents();
										for (int i = 0; i < c.length; i++) {
											if (c[i] instanceof JCheckBox) {
												chkBox = (JCheckBox) c[i];
												break;
											}
										}
									}
								}

								if (chkBox != null) {
									if (chkBox.isVisible()) {
										Rectangle rectangle = list
												.getCellBounds(
														list.getSelectedIndex(),
														list.getSelectedIndex());
										if (rectangle == null)
											return;
										Point p = new Point(e.getX(), e.getY()
												- rectangle.y);
										if (chkBox.getBounds().contains(p)) {
											selectIndex(list.getSelectedIndex());
										}
									}
								}

								if (rCheck == null) {
									ListCellRenderer renderer = list
											.getCellRenderer();
									if (renderer instanceof Container) {
										Container panel = (Container) renderer;
										Component[] c = panel.getComponents();
										for (int i = 0; i < c.length; i++) {
											if (c[i] instanceof JRadioButton) {
												rCheck = (JRadioButton) c[i];
												break;
											}
										}
									}
								}

								if (rCheck != null) {
									if (rCheck.isVisible()) {
										Rectangle rectangle = list
												.getCellBounds(
														list.getSelectedIndex(),
														list.getSelectedIndex());
										if (rectangle == null)
											return;
										Point p = new Point(e.getX(), e.getY()
												- rectangle.y);
										if (rCheck.getBounds().contains(p)) {
											selectIndex(list.getSelectedIndex());
										}
									}
								}
							}
						}
					}
				}
			}
		};
		return mouseAdapter;
	}

	public KeyAdapter getKeySpaceAction(final JList list) {
		KeyAdapter keyAdapter = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (list != null)
					if (isEditable) {
						if (uneditableRows.lastIndexOf(list.getSelectedIndex()) == -1) {
							if (chkBox == null) {
								ListCellRenderer renderer = list
										.getCellRenderer();
								if (renderer instanceof Container) {
									Container panel = (Container) renderer;
									Component[] c = panel.getComponents();
									for (int i = 0; i < c.length; i++) {
										if (c[i] instanceof JCheckBox) {
											chkBox = (JCheckBox) c[i];
											break;
										}
									}
								}
							}

							if (chkBox != null) {
								if (chkBox.isVisible())
									if (e.getKeyCode() == KeyEvent.VK_SPACE)
										selectIndex(list.getSelectedIndex());
							}

							if (rCheck == null) {
								ListCellRenderer renderer = list
										.getCellRenderer();
								if (renderer instanceof Container) {
									Container panel = (Container) renderer;
									Component[] c = panel.getComponents();
									for (int i = 0; i < c.length; i++) {
										if (c[i] instanceof JRadioButton) {
											rCheck = (JRadioButton) c[i];
											break;
										}
									}
								}
							}

							if (rCheck != null) {
								if (rCheck.isVisible())
									if (e.getKeyCode() == KeyEvent.VK_SPACE)
										selectIndex(list.getSelectedIndex());
							}
						}
					}
			}
		};
		return keyAdapter;
	}

	public void addUneditableRow(int row) {
		if (uneditableRows.lastIndexOf(row) == -1)
			uneditableRows.add(row);
	}

	public void removeUneditableRow(int row) {
		int index = uneditableRows.lastIndexOf(row);
		if (index != -1)
			uneditableRows.remove(index);
	}

	public Vector<Integer> getUneditableRows() {
		return uneditableRows;
	}

	public void setUneditableRows(Vector<Integer> uneditableRows) {
		this.uneditableRows = uneditableRows;
	}

	public void addActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	public void removeActionListener() {
		actionListener = null;
	}


	private void selectIndex(int index) {
		if (rowsSelected.lastIndexOf(index) != -1)
			removeRow(index);
		else
			addRow(index);

		updateSelected();
		if (actionListener != null)
			actionListener.actionPerformed(new ActionEvent(index,
					ACTION_LIST_CHECKING, ""));
		// if (listCheckingListener != null)
		// listCheckingListener.run(index);
	}

	public Object[] getSelectedValues() {
		Object[] objs = new Object[rowsSelected.size()];
		for (int i = 0; i < rowsSelected.size(); i++) {
			if (rowsSelected.get(i) < getModel().getSize())
				objs[i] = getModel().getElementAt(rowsSelected.get(i));
		}
		return objs;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllValues() {
		List objs = new ArrayList();
		if (getModel().getSize() != 0)
			for (int i = 0; i < getModel().getSize(); i++) {
				objs.add(getModel().getElementAt(i));
			}
		return objs;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getListSelectedValues() {
		List objs = new ArrayList();
		if (getModel().getSize() != 0)
			for (int i = 0; i < rowsSelected.size(); i++) {
				if (rowsSelected.get(i) < getModel().getSize())
					objs.add(getModel().getElementAt(rowsSelected.get(i)));
			}
		return objs;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getListSelectedValues(Class clazz) {
		List objs = new ArrayList();
		if (getModel().getSize() != 0)
			for (int i = 0; i < rowsSelected.size(); i++) {

				if (rowsSelected.get(i) < getModel().getSize())
					objs.add(clazz.cast(getModel().getElementAt(
							rowsSelected.get(i))));
			}
		return objs;
	}

	@SuppressWarnings({ "rawtypes" })
	public List getListUnSelectedValues() {
		List values = getAllValues();
		if (getModel().getSize() != 0)

			for (int i = 0; i < rowsSelected.size(); i++) {
				// System.out.println(values.contains(getModel().getElementAt(rowsSelected.get(i))));
				if (values.contains(getModel()
						.getElementAt(rowsSelected.get(i)))) {
					values.remove(getModel().getElementAt(rowsSelected.get(i)));
				}
			}
		return values;
	}

	public void setAllChecked() {
		rowsSelected.clear();
		if (getModel().getSize() != 0)
			for (int i = 0; i < getModel().getSize(); i++)
				rowsSelected.add(i);

		updateSelected();

		if (actionListener != null)
			actionListener.actionPerformed(new ActionEvent("",
					ACTION_LIST_CHECKING, ""));
	}

	public void setAllUnchecked() {
		rowsSelected.clear();

		updateSelected();

		if (actionListener != null)
			actionListener.actionPerformed(new ActionEvent("",
					ACTION_LIST_CHECKING, ""));
	}

	public void setModel(ListModel model) {
		super.setModel(model);
		model.addListDataListener(new ListDataListener() {
			public void contentsChanged(ListDataEvent e) {
			}

			public void intervalAdded(ListDataEvent e) {
				int index = e.getIndex0();
				for (int i = 0; i < rowsSelected.size(); i++)
					if (rowsSelected.get(i) >= index)
						rowsSelected.set(i, rowsSelected.get(i) + 1);
				updateUnEditable(index, true);
				if (actionListener != null)
					actionListener.actionPerformed(new ActionEvent("",
							ACTION_LIST_CHECKING, ""));
			}

			public void intervalRemoved(ListDataEvent e) {
				int index = e.getIndex0();

				for (int i = rowsSelected.size() - 1; i >= 0; i--) {
					if (rowsSelected.get(i) == index)
						rowsSelected.remove(i);
					else if (rowsSelected.get(i) >= index)
						rowsSelected.set(i, rowsSelected.get(i) - 1);
				}
				updateUnEditable(index, false);
				if (actionListener != null)
					actionListener.actionPerformed(new ActionEvent("",
							ACTION_LIST_CHECKING, ""));
			}
		});
	}

	/**
	 * Cap nhat lai gia tri cho phep chinh sua
	 * 
	 * @param index
	 * @param b
	 */
	protected void updateUnEditable(int index, boolean b) {
		int size = uneditableRows.size();
		for (int i = 0; i < size; i++) {
			Integer integer = uneditableRows.get(i);
			if (integer >= index) {
				if (b) {
					integer++;
				} else {
					integer--;
				}
				uneditableRows.set(i, integer);
			}
		}
	}


	public void setSelectedIndices(Vector<Integer> v) {
		if (v == null)
			rowsSelected.clear();
		else
			rowsSelected = v;

		updateSelected();

		if (actionListener != null)
			actionListener.actionPerformed(new ActionEvent("",
					ACTION_LIST_CHECKING, ""));
	}

	private void updateSelected() {
		try {
			ListCellRenderer renderer = getCellRenderer();
			setCellRenderer(null);
			setCellRenderer(renderer);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		isEditable = enabled;
		updateSelected();
	}

	public void setEditable(boolean b) {
		this.isEditable = b;
		updateSelected();
	}

	public boolean isEditable() {
		return isEditable;
	}

	public boolean isRowChecked(int index) {
		return (rowsSelected.lastIndexOf(index) != -1);
	}

	public void clearSelected() {
		rowsSelected.clear();
		updateSelected();
		if (actionListener != null)
			actionListener.actionPerformed(new ActionEvent("",
					ACTION_LIST_CHECKING, ""));
	}

	private void addRow(Integer index) {
		if (checkingMode == SINGLE_CHECKING)
			rowsSelected.clear();

		if (rowsSelected.lastIndexOf(index) == -1)
			rowsSelected.add(index);
	}

	private void removeRow(Integer index) {
		if (rowsSelected.lastIndexOf(index) != -1)
			rowsSelected.remove(index);
	}

	public Vector<Integer> getSelectedRows() {
		return rowsSelected;
	}

	public void setSelectedRow(Integer index) {
		addRow(index);
		updateSelected();

		if (actionListener != null)
			actionListener.actionPerformed(new ActionEvent("",
					ACTION_LIST_CHECKING, ""));
	}

	public void removeSelectedRow(Integer index) {
		removeRow(index);
		updateSelected();

		if (actionListener != null)
			actionListener.actionPerformed(new ActionEvent("",
					ACTION_LIST_CHECKING, ""));
	}

	public int getCheckingMode() {
		return checkingMode;
	}

	public void setCheckingMode(int checkingMode) {
		this.checkingMode = checkingMode;
	}

	public boolean isRowEditable(int index) {
		return uneditableRows.lastIndexOf(index) == -1;
	}

}
