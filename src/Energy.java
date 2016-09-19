
public class Energy {
	
	private int num_depot;
	private int cord_depot_X;
	private int cord_depot_Y;
	private int mat_client[][];
	private int cord[]= new int[2];
	
	public 	Energy(int mat_client1[][],int num_depot1,int cord_depot_X1,int cord_depot_Y1){

		mat_client=mat_client1;
		num_depot=num_depot1;
		cord_depot_X=cord_depot_X1;
		cord_depot_Y=cord_depot_Y1;
	}

	public double calEnergy(int mat_tourne[][]) {
		cord[0] = -1;
		cord[1] = -1;
		double distance = 0;
		int source_X, source_Y;

		for (int i = 0; i < mat_tourne.length; i++) {

			source_X = cord_depot_X;
			source_Y = cord_depot_Y;

			for (int j = 0; j < mat_tourne[i].length; j++) {

				int client = mat_tourne[i][j];
				
				if (client != -1) {
					distance += arcDistance(client, source_X, source_Y);
					source_X = cord[0];
					source_Y = cord[1];
				}

			}
			
			distance +=getDistance(source_X, source_Y, cord_depot_X,cord_depot_Y);
			
		}
		return distance;
	}
	
	private double arcDistance(int client, int source_X, int source_Y) {
		double distance = 0;
		cord[0] = -1;
		cord[0] = -1;

		for (int j = 0; j < mat_client.length; j++) {

			if (client == mat_client[j][0]) {

				int client_X = mat_client[j][2];
				int client_Y = mat_client[j][3];
				cord[0] = client_X;
				cord[1] = client_Y;
				distance = getDistance(source_X, source_Y, client_X, client_Y);
				break;
			}
		}

		return distance;
	}
	
	
	private double getDistance(int source_X, int source_Y, int client_X,int client_Y) {

		int xDistance = Math.abs(source_X - client_X);
		int yDistance = Math.abs(source_Y - client_Y);
		double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));

		return distance;
	}

	
	
	
}
