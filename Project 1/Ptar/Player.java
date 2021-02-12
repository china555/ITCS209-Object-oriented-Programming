package Ptar;

//Jarupong pajakgo 6088107 section 2
public class Player {

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};
	
	private PlayerType type; 	//Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage, or Phoenix
	private double maxHP;		//Max HP of this player
	private double currentHP;	//Current HP of this player 
	private double atk;			//Attack power of this player
	
	//ADD
	private int internalcount;
	private int special_number;
	private Player player_cursed = null;
	private String teamName;
	private String Row;
	private int position;
	private boolean isTaunt;
	private boolean isCursed;
	private boolean isSleeeping;
	/**
	 * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns, 
	 * as specified in the given table. It also reset the internal turn count of this player. 
	 * @param _type
	 */
	public Player(PlayerType _type)
	{
		this.type = _type;
		if(this.type == Player.PlayerType.Healer) {
			this.special_number = 4;
			this.maxHP = 4790;
			this.currentHP = 4790;
			this.atk = 238;
		}else if(this.type == Player.PlayerType.Tank) {
			this.special_number = 4;
			this.maxHP = 5340;
			this.currentHP = 5340;
			this.atk = 255;
		}else if(this.type == Player.PlayerType.Samurai) {
			this.special_number = 3;
			this.maxHP = 4005;
			this.currentHP = 4005;
			this.atk = 368;
		}else if(this.type == Player.PlayerType.BlackMage) {
			this.special_number = 4;
			this.maxHP = 4175;
			this.currentHP = 4175;
			this.atk = 303;
		}else if(this.type == Player.PlayerType.Phoenix) {
			this.special_number = 8;
			this.maxHP = 4175;
			this.currentHP = 4175;
			this.atk = 209;
		}else if(this.type == Player.PlayerType.Cherry) {
			this.special_number = 4;
			this.maxHP = 3560;
			this.currentHP = 3560;
			this.atk = 198;
		}
	}
	/**
	 * Returns the current HP of this player
	 * @return
	 */
	public double getCurrentHP()
	{
		return this.currentHP;
	}
	
	/**
	 * Returns type of this player
	 * @return
	 */
	public Player.PlayerType getType()
	{
		return this.type;
	}
	
	/**
	 * Returns max HP of this player. 
	 * @return
	 */
	public double getMaxHP()
	{
		
		return this.maxHP;
	}
	
	/**
	 * Returns whether this player is sleeping.
	 * @return
	 */
	public boolean isSleeping()
	{	
		return isSleeeping;
	}
	
	/**
	 * Returns whether this player is being cursed.
	 * @return
	 */
	public boolean isCursed()
	{
		return isCursed;
	}
	
	/**
	 * Returns whether this player is alive (i.e. current HP > 0).
	 * @return
	 */
	public boolean isAlive()
	{
		if(this.currentHP>0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Returns whether this player is taunting the other team.
	 * @return
	 */
	public boolean isTaunting()
	{
		return isTaunt;
	}
	
	
	public void attack(Player target)
	{	
		target.currentHP -= this.atk; 
		if(target.currentHP < 0) {
			target.currentHP = 0;
		}
	}
	public Player IsTaunting(Player[][] team) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < team[i].length; j++) {
				if(team[i][j].isTaunt) {
					return team[i][j];
				}
			}
		}
		return null;
	}
	
	public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam)
	{
		internalcount = 0;
		if(this.type == PlayerType.Healer) {
			Player lowest = findHeal(myTeam);
			if(lowest.isCursed) {
				return;
			}
			if(lowest.currentHP > 0 && lowest.currentHP<lowest.maxHP && lowest.isCursed == false) {
				System.out.println("#"+this.getTeam()+"["+this.getRow()+"]"+"["+this.getPosition()+"]"+" {"+this.type.toString()+"}"+" Heals "+lowest.getTeam()+"["+lowest.getRow()+"]"+"["+lowest.getPosition()+"]"+" {"+lowest.type.toString()+"}");
				lowest.currentHP += (0.25*lowest.maxHP);
				if(lowest.currentHP>lowest.maxHP) {
					lowest.currentHP = lowest.maxHP;
				}
			}
		}else if(this.type == PlayerType.Tank) {
			System.out.println("#"+this.getTeam()+"["+this.getRow()+"]"+"["+this.getPosition()+"]"+" {"+this.type.toString()+"}"+" is Taunting ");
			setTaunt(true);
		}else if(this.type == PlayerType.BlackMage) {
			Player curse = findCurses(theirTeam);
			if(IsTaunting(theirTeam) != null) {
				curse = IsTaunting(theirTeam);
			}
			if (curse != null) {
				System.out.println("#"+this.getTeam()+"["+this.getRow()+"]"+"["+this.getPosition()+"]"+" {"+this.type.toString()+"}"+" Curses "+curse.getTeam()+"["+curse.getRow()+"]"+"["+curse.getPosition()+"]"+" {"+curse.type.toString()+"}");
				curse.setCursed(true);
				player_cursed = curse;
			}
			
		}else if (this.type == PlayerType.Phoenix) {
			Player dead = myTeam[0][0];
			boolean find_dead = false;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < myTeam[0].length; j++) {
					if(!myTeam[i][j].isAlive() && find_dead == false) {
						dead = myTeam[i][j];
						find_dead = true;
					}
				}
			}
			System.out.println("#"+this.getTeam()+"["+this.getRow()+"]"+"["+this.getPosition()+"]"+" {"+this.type.toString()+"}"+" Revives "+dead.getTeam()+"["+dead.getRow()+"]"+"["+dead.getPosition()+"]"+" {"+dead.type.toString()+"}");
			dead.currentHP = dead.currentHP + (dead.maxHP*0.3);
			dead.setTaunt(false);
			dead.setCursed(false);
			dead.internalcount = 0;
		}else if (this.type == PlayerType.Cherry) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < theirTeam[0].length; j++) {
					if(theirTeam[i][j].isAlive()) {
						System.out.println("#"+this.getTeam()+"["+this.getRow()+"]"+"["+this.getPosition()+"]"+" {"+this.type.toString()+"}"+" Feeds a Fortune Cookies to "+theirTeam[i][j].getTeam()+"["+theirTeam[i][j].getRow()+"]"+"["+theirTeam[i][j].getPosition()+"]"+" {"+theirTeam[i][j].type.toString()+"}");
						theirTeam[i][j].setSleeping(true);
					}
				}
			}
		}
	}
	
	
	/**
	 * This method is called by Arena when it is this player's turn to take an action. 
	 * By default, the player simply just "attack(target)". However, once this player has 
	 * fought for "numSpecialTurns" rounds, this player must perform "useSpecialAbility(myTeam, theirTeam)"
	 * where each player type performs his own special move. 
	 * @param arena
	 */
	public void takeAction(Arena arena)
	{	
		if(this.type == PlayerType.BlackMage && player_cursed != null) {
			player_cursed.setCursed(false);
			player_cursed = null;
		}
		if(this.isTaunt) {
			this.setTaunt(false);
		}
		if(this.isSleeeping) {
			this.setSleeping(false);
			return;
		}
		addInternalcount();
		
		Player[][] myteam = null;
		Player[][] opp = null;
		if(arena.getMyTeam(this) == arena.getTeamA()) {
			 myteam = arena.getTeamA();
			 opp = arena.getTeamB();	
		}else if(arena.getMyTeam(this) == arena.getTeamB()) {
			 myteam = arena.getTeamB();
			 opp = arena.getTeamA();
		}
		
		
		if(this.type == PlayerType.Healer && internalcount == this.special_number) {
			useSpecialAbility(myteam, opp);
		}else if(this.type == PlayerType.Tank && internalcount == this.special_number) {
			useSpecialAbility(myteam, opp);
		}else if(this.type == PlayerType.Samurai && internalcount == this.special_number) {
			internalcount = 0;
			Player target = arena.findTarget(this);
			if(target == null) {
				return;
			}
				System.out.println("#"+this.getTeam()+"["+this.getRow()+"]"+"["+this.getPosition()+"]"+" {"+this.type.toString()+"}"+" Double-Slash "+target.getTeam()+"["+target.getRow()+"]"+"["+target.getPosition()+"]"+" {"+target.type.toString()+"}");
				attack(target);
				attack(target);
		}else if (this.type == PlayerType.BlackMage && internalcount == this.special_number) {
			useSpecialAbility(myteam, opp);
		}else if (this.type == PlayerType.Phoenix && internalcount == this.special_number) {
			useSpecialAbility(myteam, opp);
		}else if (this.type == PlayerType.Cherry && internalcount == this.special_number) {
			useSpecialAbility(myteam, opp);
		}else {
			Player target = arena.findTarget(this);
			if(target != null) {
				attack(target);
				
				System.out.println("#"+this.getTeam()+"["+this.getRow()+"]"+"["+this.getPosition()+"]"+" {"+this.type.toString()+"}"+" Attacks "+target.getTeam()+"["+target.getRow()+"]"+"["+target.getPosition()+"]"+" {"+target.type.toString()+"}");
			}
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < opp[i].length; j++) {
				if(!opp[i][j].isAlive()) {
					opp[i][j].isCursed = false;
					opp[i][j].isTaunt = false;
					opp[i][j].isSleeeping = false;
				}
			}
		}
	}
	
	/**
	 * This method overrides the default Object's toString() and is already implemented for you. 
	 */
	@Override
	public String toString()
	{
		return "["+this.type.toString()+" HP:"+this.currentHP+"/"+this.maxHP+" ATK:"+this.atk+"]["
				+((this.isCursed())?"C":"")
				+((this.isTaunting())?"T":"")
				+((this.isSleeping())?"S":"")
				+"]";
	}
	
	//ADD
	public void setTeam(String team) {
		this.teamName = team;
	}
	public String getTeam() {
		return this.teamName;
	}
	public void setRow(String row) {
		this.Row = row;
	}
	public String getRow() {
		return Row;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getPosition() {
		return this.position;
	}
	public void addInternalcount() {
		this.internalcount++;
	}
	public void setTaunt(boolean isTaunt) {
		this.isTaunt = isTaunt;
	}
	public void setCursed(boolean isCursed) {
		this.isCursed = isCursed;
	}
	public void setSleeping(boolean isSleeping) {
		this.isSleeeping = isSleeping;
	}
	public Player findHeal(Player[][] myteam) {
		double mininum = 9999;
		Player target = null;
		
		for (int i = 0; i < 2; i++) {
			if(i==0) {
				for (int j = 0; j < myteam[i].length; j++) {
					if(myteam[i][j].getCurrentHP() > 0 && myteam[i][j].getCurrentHP() /(myteam[i][j].getMaxHP())*100 < mininum) {
						mininum = myteam[i][j].getCurrentHP() /(myteam[i][j].getMaxHP())*100;
						target = myteam[i][j];
						
					}
				}
			}else {
				for (int j = 0; j < myteam[i].length; j++) {
					if(myteam[i][j].getCurrentHP() > 0 && myteam[i][j].getCurrentHP() /(myteam[i][j].getMaxHP())*100 < mininum) {
						mininum = myteam[i][j].getCurrentHP() /(myteam[i][j].getMaxHP())*100;
						target = myteam[i][j];
						
					}
				}
			}
		}
		return target;
	}
	public Player findCurses(Player[][] theirTeam) {
		double mininum = 9999;
		Player target = null;
		boolean findcurse = false;
		for (int i = 0; i < 2; i++) {
			if(i==0) {
				for (int j = 0; j < theirTeam[i].length; j++) {
					if(theirTeam[i][j].isAlive() && theirTeam[i][j].currentHP < mininum) {
						mininum = theirTeam[i][j].currentHP;
						target = theirTeam[i][j];
						findcurse = true;
					}
				}
			}else {
				for (int j = 0; j < theirTeam[i].length; j++) {
					if(theirTeam[i][j].isAlive() && theirTeam[i][j].currentHP < mininum && findcurse == false) {
						mininum = theirTeam[i][j].currentHP;
						target = theirTeam[i][j];
						findcurse = true;
					}
				}
			}
		}
		return target;
	}
}
