
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


class Result extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private pan_Result pan;
	private JScrollPane defil;
	private Dimension d;
   
	public Result(ArrayList<String> list) {
		
		setTitle("-:Results");
		setBounds(45, 115, 400, 621);

		// Création du panneau.
		pan = new pan_Result(list);

		// Création de la barre de défilement.
		defil = new JScrollPane(pan);
		getContentPane().add(defil);
	}
	
	
	
	
	// Cette fonction permet de rendre visible ou non le JFrame.
	void setVoir(boolean B) {
		if (B) {
			setVisible(true);
		} else {
			setVisible(false);
		}
	}
	
	void setResult(ArrayList<String> list) {
		pan.setResult(list);
	}

	public void setAff(int num){
		pan.setAff(num);
	}
	
}


class pan_Result extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static  ArrayList<String> list_r = new ArrayList<String>();
	 private int numAff=-1; 
	 
	public pan_Result(ArrayList<String> list) {
		list_r = list;
	}

	// Fonction appelée lors d'un rafraichissement.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Fonction d'écriture.
		Ecrire(list_r, g);
	}

	public void setAff(int num){
		numAff=num;
	}
	
	public void setResult(ArrayList<String> list) {
		list_r = list;
	}
	
	
	void Ecrire(ArrayList<String> list, Graphics g) {
		int xligne = 30;
		int yligne = 20;

		g.setColor(Color.black);
		g.drawString(".: results :", xligne, yligne);
		xligne = xligne + 20;
		yligne = yligne + 20;

		g.setColor(Color.white);
		xligne = 50;

		g.drawString(
				"------------------------------------------------------------",
				xligne, yligne);
		yligne = yligne + 20;

		g.setColor(Color.black);

		if (list.size() != 0) {

			int num = 0;
			while (num < list.size()) {

				if (numAff == 0) {//afiichage 1
					if (num % 4 == 0 && num >= 8) {

						yligne += 30;
					}

					if (num >= 5) {
						if (num % 4 == 0 && num >= 8) {
							xligne -= 240;
						} else
							xligne += 80;
					}

					g.drawString(list.get(num), xligne, yligne);
					if (num <= 3) {
						yligne = yligne + 30;

					}

				} else if (numAff == 1) {//afichage 2

					g.drawString(list.get(num), xligne, yligne);
						yligne = yligne + 30;

				}
				
				num++;
			}

		} else {

			xligne = 70;

			g.setColor(Color.red);
			g.drawString("no result !", xligne, yligne);
			yligne = yligne + 20;

		}

		// Mise à l'échelle de la JScrollPane.
		setPreferredSize(new Dimension(250, yligne));
		revalidate();

	}

}