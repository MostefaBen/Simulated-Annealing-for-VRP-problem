import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;


public class Interface extends JFrame implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	private JButton jButton0;
	private JLabel jLabel0;
	private JTextField jTextField0;
	private JButton jButton2;
	private int Num_Vis = 0;
	private int Num_Veh = 0;
	private int capacities = 0;
	private double Temperateur;
	private double landa = 0.99;
	private int mat_client[][];
	private int mat_tourne[][];
	private ArrayList<Integer> mat_tourne_capacitie = new ArrayList<Integer>();
	private static int num_depot = 0, cord_depot_X = 0, cord_depot_Y = 0;
	private int sameNeig = -1;
	private static  ArrayList<String> list_result = new ArrayList<String>();//pour les resultates
	private Result boite2;
	private JLabel jLabel2;
	private JTextField jTextField2;
	private JRadioButton jRadioButton1;
	private JLabel jLabel3;
	private JRadioButton jRadioButton0;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel1;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.nimbus.NimbusLookAndFeel";

	//constroctor 
	public Interface() {
		initComponents();
		// Création de la fenêtre.
		Toolkit  tool=	getToolkit();//get size of screen
		int X=(int)(tool.getScreenSize().getWidth()-1005);
		int Y=(int)(tool.getScreenSize().getHeight()-200);
		
		boite2 = new Result(list_result);
		boite2.setBounds(X,Y/2, 350, 400);	
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJLabel2(), new Constraints(new Leading(31, 12, 12), new Leading(122, 12, 12)));
		add(getJTextField2(), new Constraints(new Leading(176, 106, 12, 12), new Leading(126, 12, 12)));
		add(getJButton2(), new Constraints(new Leading(176, 102, 12, 12), new Leading(215, 10, 10)));
		add(getJLabel3(), new Constraints(new Leading(9, 12, 12), new Leading(174, 10, 10)));
		add(getJRadioButton0(), new Constraints(new Leading(212, 50, 12, 12), new Leading(170, 12, 12)));
		add(getJRadioButton1(), new Constraints(new Leading(280, 12, 12), new Leading(170, 12, 12)));
		add(getJLabel5(), new Constraints(new Leading(294, 12, 12), new Leading(128, 12, 12)));
		add(getJLabel0(), new Constraints(new Leading(12, 12, 12), new Leading(77, 10, 10)));
		add(getJTextField0(), new Constraints(new Leading(174, 106, 12, 12), new Leading(75, 12, 12)));
		add(getJLabel4(), new Constraints(new Leading(292, 12, 12), new Leading(77, 12, 12)));
		add(getJLabel1(), new Constraints(new Leading(28, 10, 10), new Leading(225, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(253, 112, 10, 10), new Trailing(12, 206, 206)));
		ButtonGroup bg = new ButtonGroup();
		bg.add(jRadioButton0);
		bg.add(jRadioButton1);
		setSize(389, 314);
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Load file");
		}
		return jLabel1;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("default 0.99");
		}
		return jLabel5;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText(" default 10000");
		}
		return jLabel4;
	}

	private JRadioButton getJRadioButton0() {
		if (jRadioButton0 == null) {
			jRadioButton0 = new JRadioButton();
			jRadioButton0.setText("YES");
			jRadioButton0.addActionListener(this);
		}
		return jRadioButton0;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Genere neighbor in the same turn");
		}
		return jLabel3;
	}

	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setSelected(true);
			jRadioButton1.setText("NO");
		}
		return jRadioButton1;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
		}
		return jTextField2;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Landa");
		}
		return jLabel2;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("File");
			jButton2.setBackground(new java.awt.Color(80, 80, 144));
		    jButton2.setForeground(new java.awt.Color(255, 255, 255));
		    jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			jButton2.addActionListener(this);
		}
		return jButton2;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
		}
		return jTextField0;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Temperature");
		}
		return jLabel0;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Execute");
			jButton0.setBackground(new java.awt.Color(80, 80, 144));
		    jButton0.setForeground(new java.awt.Color(255, 255, 255));
		    jButton0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			jButton0.addActionListener(this);
		}
		return jButton0;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	private static void dimensionScreen(Frame frame) {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2
					- frame.getHeight() / 2);
	}
	
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Interface frame = new Interface();
				try {
					javax.swing.UIManager
							.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setDefaultCloseOperation(Interface.EXIT_ON_CLOSE);
				frame.setTitle("Recuit Simuler for VRP problem");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				dimensionScreen(frame);
				frame.setResizable(false);
				frame.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		if (source == jButton2) {
		boite2.setVoir(false);
		boite2.setAff(0);
		list_result.clear();
			Scanner sc = null;
			try {
				sc = new Scanner(new File("saves/c100.vrp"));

				while (sc.hasNext()) {

					String str = (String) sc.next();

					if (str.equalsIgnoreCase("NUM_VISITS:")) {

						Num_Vis = sc.nextInt();
						mat_client = new int[Num_Vis][4];
						// initailisation de matrix qui contient tous les
						// clients
						initialMat(mat_client);

					} else if (str.equalsIgnoreCase("NUM_VEHICLES:")) {

						Num_Veh = sc.nextInt();

					} else if (str.equalsIgnoreCase("CAPACITIES:")) {

						capacities = sc.nextInt();

					} else if (str.equalsIgnoreCase("DEMAND_SECTION")) {

						for (int i = 0; i < mat_client.length; i++) {
							for (int j = 0; j < 2; j++) {
								str = (String) sc.next();
								mat_client[i][j] = Integer.parseInt(str);
							}
						}

					} else if (str.equalsIgnoreCase("LOCATION_COORD_SECTION")) {

						str = (String) sc.next();
						num_depot = Integer.parseInt(str);
						str = (String) sc.next();
						cord_depot_X = Integer.parseInt(str);
						str = (String) sc.next();
						cord_depot_Y = Integer.parseInt(str);

						for (int i = 0; i < mat_client.length; i++) {
							str = (String) sc.next();

							for (int j = 2; j < 4; j++) {

								str = (String) sc.next();
								mat_client[i][j] = Integer.parseInt(str);

							}
						}

						break;// pour casser la boucle(si toutes les données obtenus de fichier)
					}
				}

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				sc.close();
			}

			System.out.println("Number of Customers= " + Num_Vis
					+ "\nNumber of Vehicles= " + Num_Veh
					+ "\nCapacity of Vehicle = " + capacities + "\n");
            
			list_result.add("Number of Customers= " + Num_Vis);
		    list_result.add("\n Number of Vehicles= " + Num_Veh);
			list_result.add("\n Capacity of  Vehicle = " + capacities + "\n");
			System.out
					.println("Customers    demande        cord X        cord Y");

			list_result.add("Customers     demande         cord X         cord Y");		
			
			//list_result.add(""+mat_client[0][0]);
			//list_result.add(""+mat_client[0][1]);
			for (int i = 0; i < mat_client.length; i++) {

				for (int j = 0; j < mat_client[i].length; j++) {
					System.out.print(mat_client[i][j] + "             ");
					list_result.add(mat_client[i][j]+"               ");
				}
				System.out.println();
			}

			
			jButton0.setEnabled(true);
			boite2.setResult(list_result);
	        boite2.setVoir(true);

		}// end button 2(fichier) section

		if (source == jButton0) {
			boite2.setVoir(false);
			boite2.setAff(1);
			list_result.clear();
			
			Temperateur = 10000;
			String text = getJTextField0().getText().trim();
			if (!text.equals("")) {
				Temperateur = Double.parseDouble(text);
			}

			landa = 0.99;
			String text3 = getJTextField2().getText().trim();
			if (!text3.equals("")) {
				landa = Double.parseDouble(text3);
			}

			if (jRadioButton0.isSelected())
				sameNeig = 1;
			else
				sameNeig = 0;

			System.out.println("\n Recuit Simuler Start:");
			list_result.add("\n Recuit Simuler Start:");
			
			System.out.println("\n Genere neighbor in the same turn : "
					+ jRadioButton0.isSelected());
			list_result.add("\n Genere neighbor in the same turn : "
					+ jRadioButton0.isSelected());
			RecuitSimule();
			boite2.setResult(list_result);
	        boite2.setVoir(true);
		}// end button 0(executer) section

	}

	private void initialMat(int mat[][]) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = -1;
			}
		}

	}
	
	private void affichage(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] != -1){
					System.out.print(mat[i][j] + "    ");
				}	
				
				
			}
			System.out.println();
		}
	}
	
	private int[][] copy(int mat1[][], int mat2[][]) {

		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[i].length; j++) {
				mat2[i][j] = mat1[i][j];
			}
		}

		return mat2;
	}
    private int mat_best[][]=new int[10][20];

	private void Initailization() {

		mat_tourne = new int[10][20];
		mat_tourne_capacitie.clear();
		initialMat(mat_tourne);
		// genere S0 pour commence l'algorithme de RS
		getFirstSo();

		System.out.println("\nTemperature = " + Temperateur);
		list_result.add("\nTemperature = " + Temperateur);
		
		System.out.println("landa = " + landa);
		list_result.add("landa = " + landa);

		System.out.println("\nCapacity of Subturn :");
		list_result.add("\nCapacity of Subturn :");
		for (int i = 0; i < mat_tourne_capacitie.size(); i++) {
			System.out.println("turn N°:" + i + "     "
					+ mat_tourne_capacitie.get(i));
			list_result.add("turn N°:" + i + "     "
					+ mat_tourne_capacitie.get(i));
					
		}

		System.out.println();
		list_result.add("\n");
	}

	//Recuit Simuler algorithem
	private void RecuitSimule() {

		Initailization();
		System.out.println(" initailization (S0):");
		list_result.add(" initailization (S0):");
		affichage(mat_tourne);
		
		Energy e = new Energy(mat_client, num_depot, cord_depot_X, cord_depot_Y);
		double energy = e.calEnergy(mat_tourne);
		System.out.println("\nEnergy(globel distance) of  S0= " + energy);
		list_result.add("\nEnergy(globel distance) of  S0= " + energy+"\n\n");
		System.out.println("\n");

		mat_best = copy(mat_tourne, mat_best);
		double energy_best = energy;

		int Newmat_tourne[][] = null;
		double Newenergy;

		while (Temperateur > 1) {

			if (sameNeig == 1)
				Newmat_tourne = genNeighbour(mat_tourne);
			else if (sameNeig == 0)
				Newmat_tourne = genNeighbour2(mat_tourne);

			Newenergy = e.calEnergy(Newmat_tourne);

			if (Newenergy < energy_best) {

				System.out.println(" best =  " + Newenergy);
				list_result.add(" best =  " + Newenergy);
				mat_tourne = copy(Newmat_tourne, mat_tourne);
				mat_best = copy(Newmat_tourne, mat_best);
				energy = Newenergy;
				energy_best = Newenergy;

			} else if (getProbabilt(energy, Newenergy, Temperateur) > Math
					.random()) {

				mat_tourne = copy(Newmat_tourne, mat_tourne);
				energy = Newenergy;

			}
			Temperateur = landa * Temperateur;
		}

		System.out.println("\nRecuit Simuler (End)\n ");
		list_result.add("\nRecuit Simuler (End)\n ");
		System.out.println("Best energy= " + energy_best);
		list_result.add("Best energy= " + energy_best);
		System.out.println("\n all Turns :");
		affichage(mat_best);
		System.out.println("\n");
		list_result.add("\n");
	}

	
	
	
	private double getProbabilt(double e, double enew, double t) {
		double de = ((e - enew) / t);
		return Math.exp(de);//exp((e-newe)/t)
	}
	

//genere neighbor from two turns different
	private int[][] genNeighbour2(int[][] mat) {

		boolean b = true;
		int it = (int) Math.round(Math.random() * 10);
		int par = 0;

		while (par < it) {
			while (b == true) {

				int rand = (int) Math.round(Math.random() * Num_Vis);
				int rand2 = (int) Math.round(Math.random() * Num_Vis);

				int rand_i = 0, rand_j = 0, rand2_i = 0, rand2_j = 0;
				int dem1 = 0, dem2 = 0;

				for (int i = 0; i < mat_client.length; i++) {
					if (mat_client[i][0] == rand) {
						dem1 = mat_client[i][1];
					}

					if (mat_client[i][0] == rand2) {
						dem2 = mat_client[i][1];
					}

					if (dem2 != 0 && dem1 != 0)// pour casser la boucle(si toutes les données obtenus )
						break;
				}

				for (int i = 0; i < mat.length; i++) {
					for (int j = 0; j < mat[i].length; j++) {
						if (mat[i][j] == rand) {
							rand_i = i;
							rand_j = j;
						}

						if (mat[i][j] == rand2) {
							rand2_i = i;
							rand2_j = j;

						}
					}

				}

				int dT = 0, dT2 = 0;
				dT = mat_tourne_capacitie.get(rand_i);
				dT = (dT - dem1) + dem2;

				dT2 = mat_tourne_capacitie.get(rand2_i);
				dT2 = (dT2 - dem2) + dem1;

				if (dT <= capacities && dT2 <= capacities) {

					mat_tourne_capacitie.remove(rand_i);
					mat_tourne_capacitie.add(rand_i, dT);

					mat_tourne_capacitie.remove(rand2_i);
					mat_tourne_capacitie.add(rand2_i, dT2);

					int permut = mat[rand_i][rand_j];
					mat[rand_i][rand_j] = mat[rand2_i][rand2_j];
					mat[rand2_i][rand2_j] = permut;

					b = false;
				}

			}

			par++;
		}

		return mat;
	}
	
	//genere neighbor in the same turn 
	private int[][] genNeighbour(int[][] mat) {
		int pos=0;

		int  r=(int ) Math.round( Math.random()*10);
		int it =0;
		while (it < r) {
		
			for (int i = 0; i < mat.length; i++) {

				pos = 0;

				for (int j = 0; j < mat[i].length; j++) {

					if (mat[i][j] == -1) {
						pos = j - 1;
						break;
					}

				}
				if (pos <= 0)
					break;

				double rand = Math.random() * pos;
				double rand2 = Math.random() * pos;
				int permut = mat[i][(int) rand];
				mat[i][(int) rand] = mat[i][(int) rand2];
				mat[i][(int) rand2] = permut;

			}
		   
			it++;
		}
		return mat;
	}

	//initailization (S0) 
	private void getFirstSo() {
		int some = 0, j = 0, pos = 0, some_capacit = 0;

		for (int i = 0; i < mat_client.length; i++) {

			some = mat_client[i][1] + some_capacit;

			if (some <= capacities) {

				mat_tourne[pos][j] = mat_client[i][0];
				j++;
				some_capacit = some;
			} else if (some > capacities) {

				mat_tourne_capacitie.add(some_capacit);
				i--;
				pos++;
				j = 0;
				some_capacit = 0;
			}

		}

		mat_tourne_capacitie.add(some_capacit);

	}

}
