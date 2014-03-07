package b2k.help.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class FooterCmp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel pnRight;
	private JPanel pnLeft;

	/**
	 * This is the default constructor
	 */
	public FooterCmp() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setBorder(BorderFactory.createBevelBorder(0));
		this.setLayout(new BorderLayout());
		this.add(getPnRight(), BorderLayout.EAST);
		this.add(getPnLeft(), BorderLayout.WEST);
	}
	
	private JPanel getPnRight(){
		if(pnRight == null){
			pnRight = new JPanel();
			pnRight.setOpaque(false);
			pnRight.setLayout(new FlowLayout());
		}
		return pnRight;
	}

	private JPanel getPnLeft(){
		if(pnLeft == null){
			pnLeft = new JPanel();
			pnLeft.setOpaque(false);
			pnLeft.setLayout(new FlowLayout());
		}
		return pnLeft;
	}

	public void addRight(Component cmp){
		getPnRight().add(cmp);
	}
	
	public void addLeft(Component cmp){
		getPnLeft().add(cmp);
	}
}
