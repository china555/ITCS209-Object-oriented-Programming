import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;


public class Arena {

	public enum Row {Front, Back};	//enum for specifying the front or back row
	public enum Team {A, B};		//enum for specifying team A or B
	
	private Player[][] teamA = null;	//two dimensional array representing the players of Team A
	private Player[][] teamB = null;	//two dimensional array representing the players of Team B
	private int numRowPlayers = 0;		//number of players in each row
	
	public static final int MAXROUNDS = 100;	//Max number of turn
	public static final int MAXEACHTYPE = 3;	//Max number of players of each type, in each team.
	private final Path logFile = Paths.get("battle_log.txt");
	
	public int numRow = 0;
	public static int numRow1 = 0;
	private int numRounds = 0;	//keep track of the number of rounds so far
	
	/**
	 * Constructor. 
	 * @param _numRowPlayers is the number of players in each row.
	 */
	public Arena(int _numRowPlayers)
	{	
		//INSERT YOUR CODE HERE
		numRow = _numRowPlayers;
		numRow1 = numRow;
		teamA = new Player[2][_numRowPlayers];
		teamB = new Player[2][_numRowPlayers];
		////Keep this block of code. You need it for initialize the log file. 
		////(You will learn how to deal with files later)
		try {
			Files.deleteIfExists(logFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/////////////////////////////////////////
		
	}
	
	/**
	 * Returns true if "player" is a member of "team", false otherwise.
	 * Assumption: team can be either Team.A or Team.B
	 * @param player
	 * @param team
	 * @return
	 */
	public boolean isMemberOf(Player player, Team team)
	{
		//INSERT YOUR CODE HERE
		for(int i=0;i<2;i++){
			for(int j=0;j<numRow;j++){
				if(team==Team.A){
					if(teamA[i][j]==player){
							return true;
						}
					}
				if(team==Team.B){
					if(teamB[i][j]==player){
							return true;
						}
					}
				}
			}
			
		return false;
	}
	
	
	
	/**
	 * This methods receives a player configuration (i.e., team, type, row, and position), 
	 * creates a new player instance, and places him at the specified position.
	 * @param team is either Team.A or Team.B
	 * @param pType is one of the Player.Type  {Healer, Tank, Samurai, BlackMage, Phoenix}
	 * @param row	either Row.Front or Row.Back
	 * @param position is the position of the player in the row. Note that position starts from 1, 2, 3....
	 */
	public void addPlayer(Team team, Player.PlayerType pType, Row row, int position)
	{	
		//INSERT YOUR CODE HERE
		if (team == Team.A){
			if(row == Row.Front){
			teamA[0][position-1] = new Player (pType); 
			teamA[0][position-1].team=Team.A;
			teamA[0][position-1].row=Row.Front;
			teamA[0][position-1].position = position; 
				}
		    else if (row == Row.Back){
					
			teamA[1][position-1] = new Player (pType); 
			teamA[1][position-1].team=Team.A;
			teamA[1][position-1].row=Row.Back;
			teamA[1][position-1].position = position; 
				}
			}
		else if (team == Team.B){
			if(row == Row.Front){
			teamB[0][position-1] = new Player (pType);
			teamB[0][position-1].team=Team.B;
			teamB[0][position-1].row=Row.Front;
			teamB[0][position-1].position = position;
				}
			else if (row == Row.Back){
			teamB[1][position-1] = new Player (pType);
			teamB[1][position-1].team=Team.B;
			teamB[1][position-1].row=Row.Back;
			teamB[1][position-1].position = position;	
				}
			}
	}
	
	
	/**
	 * Validate the players in both Team A and B. Returns true if all of the following conditions hold:
	 * 
	 * 1. All the positions are filled. That is, there each team must have exactly numRow*numRowPlayers players.
	 * 2. There can be at most MAXEACHTYPE players of each type in each team. For example, if MAXEACHTYPE = 3
	 * then each team can have at most 3 Healers, 3 Tanks, 3 Samurais, 3 BlackMages, and 3 Phoenixes.
	 * 
	 * Returns true if all the conditions above are satisfied, false otherwise.
	 * @return
	 */
	public Player[][] Myteam(Team x)
	{
		if(x==Team.A){
			return teamA;
		}
		if(x==Team.B){
			return teamB;
		}
		else {
			return null;
		}
	}
	public Player[][] Enemyteam(Team x)
	{
		if(x==Team.A){
			return teamB;
		}
		if(x==Team.B){
			return teamA;
		}
		else {
			return null;
		}
	}
	public boolean validatePlayers()
	{
		//INSERT YOUR CODE HERE
		int[] countA = {0,0,0,0,0,0}, countB = {0,0,0,0,0,0};
		for(int i=0;i<2;i++){
                    for(int j=0;j<this.numRowPlayers;j++){
                        if(this.teamA[i][j]==null||this.teamB[i][j]==null){
                            return false;
                        }
                        
                        countA[this.teamA[i][j].getType().ordinal()]++;
                        countB[this.teamB[i][j].getType().ordinal()]++;
                    }
                }
                
                for (int i=0;i<6;i++) {
                    if(countA[i]>MAXEACHTYPE||countB[i]>MAXEACHTYPE){
                        return false;
                    }
                }
                
		return true;
	}
	
	
	/**
	 * Returns the sum of HP of all the players in the given "team"
	 * @param team
	 * @return
	 */
	public static double getSumHP(Player[][] team)
	{
		//INSERT YOUR CODE HERE
		double sumHP = 0;
		for(int i=0;i<2;i++){
		for(int j=0; j<numRow1; j++){
		sumHP = sumHP + team[i][j].getCurrentHP();	
		
			}
		}
		return sumHP;
	}
	
	/**
	 * Return the team (either teamA or teamB) whose number of alive players is higher than the other. 
	 * 
	 * If the two teams have an equal number of alive players, then the team whose sum of HP of all the
	 * players is higher is returned.
	 * 
	 * If the sums of HP of all the players of both teams are equal, return teamA.
	 * @return
	 */
	public Player[][] getWinningTeam()
	{
		//INSERT YOUR CODE HERE	
		double sumHPA=getSumHP(teamA);
		double sumHPB=getSumHP(teamB);
		if(sumHPA>sumHPB||sumHPA==sumHPB){
			return teamA;
		}
		else{
			return teamB;
		}
	}
	
	/**
	 * This method simulates the battle between teamA and teamB. The method should have a loop that signifies
	 * a round of the battle. In each round, each player in teamA invokes the method takeAction(). The players'
	 * turns are ordered by its position in the team. Once all the players in teamA have invoked takeAction(),
	 * not it is teamB's turn to do the same. 
	 * 
	 * The battle terminates if one of the following two conditions is met:
	 * 
	 * 1. All the players in a team has been eliminated.
	 * 2. The number of rounds exceeds MAXROUNDS
	 * 
	 * After the battle terminates, report the winning team, which is determined by getWinningTeam().
	 */
	public void startBattle()
	{
		//INSERT YOUR CODE HERE
		while(numRounds < MAXROUNDS && getSumHP(teamA) >0 && getSumHP(teamB)>0){
			this.numRounds++;
			System.out.println("@ Round " + numRounds);
			/*
			 * for(int i=0; i<2; i++){ 
				for(int j=0; j<numRow; j++){ 
					System.out.println(teamB[i][j].isSleeping());
				if(teamA[i][j].isAlive() && teamA[i][j].isSleeping()== false) {
				teamA[i][j].takeAction(this);       
							}
		        if(teamA[i][j].isSleeping()){
		        teamA[i][j].sleep(false);
		                        }
						}
					}
				for(int i=0; i<2; i++){ 
				for(int j=0; j<numRow; j++){ 
				teamA[i][j].curse(false);
					}
				}
				for(int i=0; i<2; i++){ 
				for(int j=0; j<numRow; j++){ 
					
				if(teamB[i][j].isAlive()&&teamB[i][j].isSleeping()== false) {
				teamB[i][j].takeAction(this);
						}
	            if(teamB[i][j].isSleeping()==false){
	            teamB[i][j].sleep(true);
	                    }
					}
				}
				for(int i=0; i<2; i++){ 
				for(int j=0; j<numRow; j++){ 
				teamB[i][j].curse(false);
					}
				}
				
				displayArea(this, true);
				logAfterEachRound();
			}*/
			for(int i=0; i<2; i++){ //switch team
				for(int j=0; j<numRow; j++){ //switch position
			
				teamA[i][j].sleep(false);
					
				if(teamA[i][j].isAlive()&&teamA[i][j].isSleeping()== false) {
				teamA[i][j].takeAction(this);       
							}
						}
					}
				for(int i=0; i<2; i++){ //switch team
				for(int j=0; j<numRow; j++){ //switch position
				teamA[i][j].curse(false);
					}
				}
				for(int i=0; i<2; i++){ //switch team
				for(int j=0; j<numRow; j++){ //switch position
					
				if(teamB[i][j].isAlive()&&teamB[i][j].isSleeping()== false) {
				teamB[i][j].takeAction(this);
						}
					}
				}
				for(int i=0; i<2; i++){ //switch team
				for(int j=0; j<numRow; j++){ //switch position
				teamB[i][j].curse(false);
		        if(teamA[i][j].isSleeping()==true){
		        teamA[i][j].sleep(false);
		                        }
		        if(teamB[i][j].isSleeping()==true){
		            teamB[i][j].sleep(false);
		                    }
					}
				}
				displayArea(this, true);
				logAfterEachRound();
			}
		if(getWinningTeam()==teamA)
			System.out.println("@@@  Team A won.");
		else{
			System.out.println("@@@  Team B won");
		}
	}
	
	
	/**
	 * This method displays the current area state, and is already implemented for you.
	 * In startBattle(), you should call this method once before the battle starts, and 
	 * after each round ends. 
	 * 
	 * @param arena
	 * @param verbose
	 */
	public static void displayArea(Arena arena, boolean verbose)
	{
		if(arena == null) return;
		
		StringBuilder str = new StringBuilder();
		if(verbose)
		{
		str.append(String.format("%38s   %35s","Team A","")+"\t\t"+String.format("%-33s%-35s","","Team B")+"\n");
		str.append(String.format("%38s","BACK ROW")+String.format("%38s","FRONT ROW")+"  |  "+String.format("%-38s","FRONT ROW")+"\t"+String.format("%-38s","BACK ROW")+"\n");
		for(int i = 0; i < arena.teamA[0].length; i++)
			{
		str.append(String.format("%38s",arena.teamA[1][i])+String.format("%38s",arena.teamA[0][i])+"  |  "+String.format("%-38s",arena.teamB[0][i])+String.format("%-38s",arena.teamB[1][i])+"\n");
			}
		}
	
		str.append("@ Total HP of Team A = "+getSumHP(arena.teamA)+". @ Total HP of Team B = "+getSumHP(arena.teamB)+"\n\n");
		System.out.print(str.toString());
		
		
	}

	private void logAfterEachRound()
	{
		try {
			Files.write(logFile, Arrays.asList(new String[]{numRounds+"\t"+getSumHP(teamA)+"\t"+getSumHP(teamB)}), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}