import medleySimulation.SwimTeam;

public class Test {
	public static void main(String args[]) {
		finishLine = new FinishCounter(); //counters for people inside and outside club
		 
		stadiumGrid = new StadiumGrid(gridX, gridY, numTeams,finishLine); //setup stadium with size     
		SwimTeam.stadium = stadiumGrid; //grid shared with class
		Swimmer.stadium = stadiumGrid; //grid shared with class
	    peopleLocations = new PeopleLocation[numTeams*SwimTeam.sizeOfTeam]; //four swimmers per team
		teams = new SwimTeam[numTeams];
		for (int i=0;i<numTeams;i++) {
        	teams[i]=new SwimTeam(i, finishLine, peopleLocations);        	
		}
		System.out.println();
	}
}
