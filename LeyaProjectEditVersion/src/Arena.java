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

    private int numRounds = 0;	//keep track of the number of rounds so far

    /**
     * Constructor.
     * @param _numRowPlayers is the number of players in each row.
     */
    public Arena(int _numRowPlayers)
    {
        //INSERT YOUR CODE HERE
        numRowPlayers = _numRowPlayers;
        teamA = new Player[2][numRowPlayers];
        teamB = new Player[2][numRowPlayers];



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
        for(int i=0; i<2; i++){
            for(int j=0; j<numRowPlayers; j++){
                if(team == Team.A && teamA[i][j] == player){
                    return true;
                }
                else if(team == Team.B && team[i][j] == player){
                    return true;
                }
            }
        }
        return false;
    }

    public  Player[][] getMyTeam(Player player){
        if(isMemberOf(player, Team.A)){
            return teamA;
        }
        else{
            return teamB;
        }
    }
    public Player[][] getTheirTeam(Player player){
        if(isMemberOf(player, Team.A)){
            return teamB;
        }
        else{
            return teamA;
        }
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
        int[] countA = new int[6];
        int[] countB = new int[6];

        for(int i=0; i<team.length; i++){
            for(int j=0; j<teamA[0].length; j++){
                if(teamA[i][j] == null || teamB[i][j] == null){
                    return false;
                }
                switch (teamA[i][j].getType()){
                    case Healer:
                        countA[0]++;
                        break;
                    case Tank:
                        countA[1]++;
                        break;
                    case Samurai:
                        countA[2]++;
                        break;
                    case BlackMage:
                        countA[3]++;
                        break;
                    case Pheonix:
                        countA[4]++;
                        break;
                    case Cherry:
                        countA[5]++;
                        break;
                }
                switch (teamB[i][j].getType()){
                    case Healer:
                        countB[0]++;
                        break;
                    case Tank:
                        countB[1]++;
                        break;
                    case Samurai:
                        countB[2]++;
                        break;
                    case BlackMage:
                        countB[3]++;
                        break;
                    case Pheoix:
                        countB[4]++;
                        break;
                    case Cherry:
                        countB[5]++;
                        break;
                }
            }
        }
        for(int i=0; i<countA.length; i++){
            if (countA[i] > MAXEACHTYPE || countB[i] > MAXEACHTYPE) {
                return false;
            }
        }
        return true;
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
    public boolean validatePlayers()
    {
        //INSERT YOUR CODE HERE

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
        double SumHP = 0;
        for(int i=0; i<numRows; i++){
            for(int j=0; j<team[0].length; j++){
                if(team[i][j].getCurrentHP()>0){
                    SumHP = SumHP + team[i][j].getCurrentHP();
                }
            }
        }

        return 0;
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
        if(getSumHP(teamA) < getSumHP(teamB)){
            return teamB;
        }
        else{
            return teamA;
        }

        return null;
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
        while (getSumHP(teamA) > 0 && getSumHP(teamB) > 0 && numRounds < MAXROUNDS){
            numRounds++;
            System.out.println("@ Round " +numRounds);
            for(int i=0; i<numRows; i++){
                for(int j=0; j<numRowPlayers; j++){
                    PlayerA = teamA[i][j];
                    if(A.getCurrentHP() > 0){
                        A.takeAction(this);
                    }
                }
            }
            for(int i=0; i<numRows; i++){
                for(int j=0; j<numRowPlayers; j++){
                    PlayerB = teamB[i][j];
                    if(B.getCurrentHP() > 0){
                        B.takeAction(this);
                    }
                }
            }
            logAfterEachRound();
            displayArea(this, true);
        }
        while (allDied(teamB) < (numRowPlayers*2) && allDied(teamA) < numRowPlayers*2) && numRounds<MAXROUNDS);
        if(getWinningTeam().equals(teamA)){
            System.out.println("@@ Team A won.");
        }
        else
            System.out.println("@@ Team B won.");

    }

    private int allDied(Player[][] team){
        int alldied = 0;
        for(int i=0; i<team.length; i++){
            for(int j=0; j<team[i].length; j++){
                if(!team[i][j].isAlive()){
                    alldied++;
                }
            }
        }
        return alldied;
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
        StringBuilder str = new StringBuilder();
        if(verbose)
        {
            str.append(String.format("%43s   %40s","Team A","")+"\t\t"+String.format("%-38s%-40s","","Team B")+"\n");
            str.append(String.format("%43s","BACK ROW")+String.format("%43s","FRONT ROW")+"  |  "+String.format("%-43s","FRONT ROW")+"\t"+String.format("%-43s","BACK ROW")+"\n");
            for(int i = 0; i < arena.numRowPlayers; i++)
            {
                str.append(String.format("%43s",arena.teamA[1][i])+String.format("%43s",arena.teamA[0][i])+"  |  "+String.format("%-43s",arena.teamB[0][i])+String.format("%-43s",arena.teamB[1][i])+"\n");
            }
        }

        str.append("@ Total HP of Team A = "+getSumHP(arena.teamA)+". @ Total HP of Team B = "+getSumHP(arena.teamB)+"\n\n");
        System.out.print(str.toString());


    }

    /**
     * This method writes a log (as round number, sum of HP of teamA, and sum of HP of teamB) into the log file.
     * You are not to modify this method, however, this method must be call by startBattle() after each round.
     *
     * The output file will be tested against the auto-grader, so make sure the output look something like:
     *
     * 1	47415.0	49923.0
     * 2	44977.0	46990.0
     * 3	42092.0	43525.0
     * 4	44408.0	43210.0
     *
     * Where the numbers of the first, second, and third columns specify round numbers, sum of HP of teamA, and sum of HP of teamB respectively.
     */
    private void logAfterEachRound()
    {
        try {
            Files.write(logFile, Arrays.asList(new String[]{numRounds+"\t"+getSumHP(teamA)+"\t"+getSumHP(teamB)}), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
