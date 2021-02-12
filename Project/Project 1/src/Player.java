//Kittikorn Keeratikriengkrai
//ID 6188086
public class Player {

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};
	private PlayerType type; // Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage,
								// or Phoenix
	private double maxHP; // Max HP of this player
	private double currentHP; // Current HP of this player
	private double atk; // Attack power of this player
	//ADD
	private int count = 0;
	private int specialturn;
	private Player cursed = null;
	private String teamName;
	private String Row;
	private int position;
	private boolean isTaunting;
	private boolean isCursed;
	private boolean isSleeeping;
	/**
	 * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns, 
	 * as specified in the given table. It also reset the internal turn count of this player. 
	 * @param _type
	 */
	public Player(PlayerType _type)//this constructor will set type and there component of hero
	{							   // HP ATK Specialturn
		//INSERT YOUR CODE HERE
		this.type = _type;
		switch(this.type) 
		{
			case Healer:
				this.maxHP = 4790;
				this.atk = 238;
				this.currentHP = 4790;
				specialturn = 4;
				break;
			case Tank:
				this.maxHP = 5340;
				this.atk = 255;
				this.currentHP = 5340;
				specialturn = 4;
				break;
			case Samurai:
				this.maxHP = 4005;
				this.atk = 368;
				this.currentHP = 4005;
				specialturn = 3;
				break;
			case BlackMage:
				this.maxHP = 4175;
				this.atk = 303;
				this.currentHP = 4175;
				specialturn = 4;
				break;
			case Phoenix:
				this.maxHP = 4175;
				this.atk = 209;
				this.currentHP = 4175;
				specialturn = 8;
				break;
			case Cherry:
				this.maxHP = 3560;
				this.atk = 198;
				this.currentHP = 3560;
				specialturn = 4;
				break;
			default:
		}
	}
	/**
	 * Returns the current HP of this player
	 * 
	 * @return
	 */
	public double getCurrentHP() { //return value of currentHP
		// INSERT YOUR CODE HERE
		return currentHP;
	}
	/**
	 * Returns type of this player
	 * 
	 * @return
	 */
	public Player.PlayerType getType() {//return type 
		// INSERT YOUR CODE HERE
		return type;
	}
	/**
	 * Returns max HP of this player.
	 * 
	 * @return
	 */
	public double getMaxHP() {//return value of MaxHP
		// INSERT YOUR CODE HERE
		return maxHP;
	}
	/**
	 * Returns whether this player is sleeping.
	 * 
	 * @return
	 */
	public boolean isSleeping() { //return  sleeping of each hero to check there are sleep or not
		// INSERT YOUR CODE HERE // if true there are sleep
		return isSleeeping ;
	}
	/**
	 * Returns whether this player is being cursed.
	 * 
	 * @return
	 */
	public boolean isCursed() {//return  cursed of each hero to check there are cursed or not
		// INSERT YOUR CODE HERE // if true there can't heal in this turn
		return isCursed;
	}
	/**
	 * Returns whether this player is alive (i.e. current HP > 0).
	 * 
	 * @return
	 */
	public boolean isAlive() { // to check there are hero alive or not
		// INSERT YOUR CODE HERE
		if(this.currentHP >0) {
		return true;
		}else {
			return false;
		}
	}
	/**
	 * Returns whether this player is taunting the other team.
	 * 
	 * @return
	 */
	public boolean isTaunting() { //return  taunt of each hero to check there are taunt or not
		// INSERT YOUR CODE HERE // if true  enemy team will attack taunted only in this turn
		return isTaunting;
	}
	public void attack(Player target) { //this method can used to attack enemy only
		// INSERT YOUR CODE HERE
		target.currentHP = target.currentHP -  this.atk; 
		if(target.currentHP < 0) {
			target.currentHP = 0;
		}
	}
	public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam) { 
		// INSERT YOUR CODE HERE
		count =0;	   //this method is using for useSpecialAbility for each kind of hero that contain Specialturn of hero.
		if(this.type  == PlayerType.Healer) {
			Player lowest = findHeal(myTeam);// to find the lowest Hp of percentage of my team to heal that hero.
			if(lowest.isCursed) {				// you can see this method in line 300;
				return; // tocheck it cured or not
			}
			if(lowest.currentHP<lowest.maxHP && lowest.currentHP > 0 && lowest.isCursed == false) {
				System.out.println("# "+playerInfo()+" Heals "+lowest.playerInfo());
				lowest.currentHP = lowest.currentHP + (lowest.maxHP * 0.25);// if you have a hero that have lowest HP
				if(lowest.currentHP > lowest.maxHP) { 						//You will heal that hero of MaxHp*0.25
					lowest.currentHP = lowest.maxHP;
				}
			}
		}
		else if(this.type == PlayerType.Tank) {
			System.out.println("# "+playerInfo()+" is Taunting");
			setTaunting(true); // set taunt only
		}
		else if(this.type == PlayerType.BlackMage) {
			Player cursing = findCurses(theirTeam); //to find that hero are lowest hp it can curses
			if(IsTaunting(theirTeam) != null) {
				cursing = IsTaunting(theirTeam);
			}
			if (cursing != null) {
				System.out.println("# "+playerInfo()+" Curses "+cursing.playerInfo());
				cursing.setCursed(true);
				this.cursed = cursing;
			}
		}
		else if(this.type == PlayerType.Cherry) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < theirTeam[0].length; j++) {
					if(theirTeam[i][j].isAlive()) {
						System.out.println("# "+playerInfo()+" Feeds a Fortune Cookie to "+theirTeam[i][j].playerInfo());
						theirTeam[i][j].setSleeeping(true); // all of enemy team will sleep
					}
				}
			}
		}
		else if (this.type == PlayerType.Phoenix) {
			Player zombie = myTeam[0][0];
			boolean find_zombie = false;	
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < myTeam[0].length; j++) {
					if(!myTeam[i][j].isAlive() && find_zombie == false) {
						zombie = myTeam[i][j];
						find_zombie = true;
					}
				}
			}
			System.out.println("# "+playerInfo()+" Revives "+zombie.playerInfo());
			zombie.currentHP = zombie.currentHP + (zombie.maxHP*0.3);
			zombie.count = 0;
			zombie.setTaunting(false);
			zombie.setCursed(false);
			zombie.setSleeeping(false);
		} // can revive hero and all status will disappear
}
	/**
	 * This method is called by Arena when it is this player's turn to take an
	 * action. By default, the player simply just "attack(target)". However, once
	 * this player has fought for "numSpecialTurns" rounds, this player must perform
	 * "useSpecialAbility(myTeam, theirTeam)" where each player type performs his
	 * own special move.
	 * 
	 * @param arena
	 */
	public void takeAction(Arena arena) {
		// INSERT YOUR CODE HERE
		if(this.type == PlayerType.BlackMage && cursed != null) {
			cursed.setCursed(false);
			cursed = null;
		}
		if(this.isTaunting) {			//every turn you will set all of status to be false.
			this.setTaunting(false);	// because all status will have effect for 1 turn
		}
		if(this.isSleeeping) {
			this.setSleeping(false);
			return;
		}
		count++;
		Player[][] myteam = null;
		Player[][] Theirteam = null;
		if(arena.getMyTeam(this) == arena.getTeamA()) {
			 myteam = arena.getTeamA();
			 Theirteam = arena.getTeamB();		//tocheck this turn is Team A attack or team B
		}										// but team A attack first
		else if(arena.getMyTeam(this) == arena.getTeamB()) {
			 myteam = arena.getTeamB();
			 Theirteam = arena.getTeamA();
		}
		if(count == this.specialturn) { //if turn equal to special turn of each character.
		switch(this.type) {
		case Healer:
			useSpecialAbility(myteam, Theirteam);
			break;
		case Tank:
			useSpecialAbility(myteam, Theirteam);
			break;
		case Samurai:
			count = 0;
			Player target = arena.findTarget(this); // double attack for specialability of samurai
			if(target == null) {
				return;
			}
				System.out.println("# "+playerInfo()+" Double-Slashes "+target.playerInfo());
				attack(target);
				attack(target);
				break;
		case BlackMage:
			useSpecialAbility(myteam, Theirteam);
			break;
		case Phoenix:
			useSpecialAbility(myteam, Theirteam);
			break;
		case Cherry:
			useSpecialAbility(myteam, Theirteam);
			break;
		}
		}
		else {
			Player target = arena.findTarget(this);
			if(target != null) {
				attack(target);
				
				System.out.println("# "+playerInfo()+" Attacks "+target.playerInfo()/*+target.currentHP*/);
			} // normal attack  for every hero that turn are not equal to there specialturn
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < Theirteam[i].length; j++) {
				if(Theirteam[i][j].isAlive() ==false) {
					Theirteam[i][j].isCursed = false;
					Theirteam[i][j].isTaunting = false;
					Theirteam[i][j].isSleeeping = false;
				}
			} //end of turn set all status to false 
		}
}
	/**
	 * This method overrides the default Object's toString() and is already
	 * implemented for you.
	 */
	@Override
	public String toString() {
		return "[" + this.type.toString() + " HP:" + this.currentHP + "/" + this.maxHP + " ATK:" + this.atk + "]["
				+ ((this.isCursed()) ? "C" : "") + ((this.isTaunting()) ? "T" : "") + ((this.isSleeping()) ? "S" : "")
				+ "]";
	}
	//=======================//ADD//===============================//
	public String playerInfo() {
		return this.teamName+"["+this.Row+"]["+this.position+"] {"+this.type.toString()+"}"; //can print easy
	}
	public Player findHeal(Player[][] myteam) { //find heal
		double lowest = 9999;
		Player target = null;
		for(int i =0;i<2;i++) {
			if(i==0) {
				for(int j =0;j<myteam[i].length;j++) {
					if(myteam[i][j].getCurrentHP() > 0 && myteam[i][j].getCurrentHP() /(myteam[i][j].getMaxHP())*100 < lowest) {
						lowest = myteam[i][j].getCurrentHP()/(myteam[i][j].getMaxHP())*100;
						target = myteam[i][j];
					}
				}
			}
			else {
				for (int j = 0; j < myteam[i].length; j++) {
					if(myteam[i][j].getCurrentHP() > 0 && myteam[i][j].getCurrentHP() /(myteam[i][j].getMaxHP())*100 < lowest) {
						lowest = myteam[i][j].getCurrentHP()/(myteam[i][j].getMaxHP())*100;
						target = myteam[i][j];
						
					}
				}
			}
		}
		return target;
	}
	public Player findCurses(Player[][] theirTeam) {
		double mininum = 9999;//find curse
		Player target = null;
		boolean findcurse = false;
		for (int i = 0; i < 2; i++) {
				for (int j = 0; j < theirTeam[i].length; j++) {
					if(theirTeam[i][j].isAlive() && theirTeam[i][j].currentHP < mininum) {
						mininum = theirTeam[i][j].currentHP;
						target = theirTeam[i][j];
						findcurse = true;
					}
				}
		}
		return target;
	}
	public Player IsTaunting(Player[][] team) { //find taunt
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < team[i].length; j++) {
				if(team[i][j].isTaunting) {
					return team[i][j];
				}
			}
		}
		return null;
	}
	public String getTeamName() { //return Teamname A,B
		return teamName;
	}
	public String getRow() {//return Front Back
		return Row;
	}
	public int getPosition() { //return position
		return position;
	}
	public void setPosition(int position,String teamName,String Row) {
		this.position = position; //set from class Arena
		this.teamName = teamName; 
		this.Row = Row; 
	}
	public void setSleeeping(boolean isSleeeping) {
		this.isSleeeping = isSleeeping; //set sleep
	}
	public void setTaunting(boolean isTaunting) {
		this.isTaunting = isTaunting;//set taunt
	}
	public void setCursed(boolean isCursed) {
		this.isCursed = isCursed;//set cursed
    }
	public String getTeam() {
		return this.teamName;
	}
	public void setSleeping(boolean isSleeping) {
		this.isSleeeping = isSleeping;
	}
}
