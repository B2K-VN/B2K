package b2k.system.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.l2fprod.common.swing.JTaskPane;

public class LayoutSystem extends JPanel {

	private static final long serialVersionUID = 1L;
	JPanel pnLayoutInfoSystem = null;
	JTaskPane pnLayoutMenuAdmin = null;
	JScrollPane scrLayoutContent = null;

	/**
	 * This is the default constructor
	 */
	public LayoutSystem() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(795, 357);
		this.setLayout(new BorderLayout());
		this.add(getPnLayoutInfoSystem(), BorderLayout.NORTH);
		this.add(getPnLayoutMenuAdmin(), BorderLayout.WEST);
		this.add(getScrLayoutContent(), BorderLayout.CENTER);
	}

	/**
	 * This method initializes pnLayoutInfoSystem	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnLayoutInfoSystem() {
		if (pnLayoutInfoSystem == null) {
			pnLayoutInfoSystem = new JPanel();
			pnLayoutInfoSystem.setLayout(new FlowLayout());
		}
		return pnLayoutInfoSystem;
	}

	/**
	 * This method initializes pnLayoutMenuAdmin	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JTaskPane getPnLayoutMenuAdmin() {
		if (pnLayoutMenuAdmin == null) {
			pnLayoutMenuAdmin = new JTaskPane();
		}
		return pnLayoutMenuAdmin;
	}

	/**
	 * This method initializes scrLayoutContent	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	public JScrollPane getScrLayoutContent() {
		if (scrLayoutContent == null) {
			scrLayoutContent = new JScrollPane();
		}
		return scrLayoutContent;
	}

}