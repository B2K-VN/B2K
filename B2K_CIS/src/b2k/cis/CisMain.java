package b2k.cis;

import javax.swing.JOptionPane;

public class CisMain {
	public CisMain() {
		System.out.println("hello");

		// System.setProperty("keycis", "CIS0001");
		JOptionPane.showMessageDialog(null, "Phiên làm viêc: CIS0001");
	}

	public static void main(String[] args) {
		new CisMain();
	}
}
