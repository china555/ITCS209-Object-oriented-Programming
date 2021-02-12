
//Name : Nattawipa Saetae
//ID : 6188089
public class Player {

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};
	
	private PlayerType type; 	//Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage, or Phoenix
	private double maxHP;		//Max HP of this player
	private double currentHP;	//Current HP of this player 
	private double atk;			//Attack power of this player
	private int num =0;
	private int specialnumturn;
	private Player curse = null;
	private String Name_of_team;
	private String row_of_team;
	private int position_of_team;
	private boolean Taunting;
	private boolean Cursed;
	private boolean Sleeping;
	
	/**
	 * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns, 
	 * as specified in the given table. It also reset the internal turn count of this player. 
	 * @param _type
	 */
	public Player(PlayerType _type)
	{	
		//INSERT YOUR CODE HERE
		this.type = _type;
		switch(this.type) 
		{
			case Healer:
				this.maxHP = 4790; this.atk = 238; this.currentHP = 4790; this.specialnumturn = 4;
				break;
			case Tank:
				this.maxHP = 5340; this.atk = 255; this.currentHP = 5340; this.specialnumturn = 4;
				break;
			case Samurai:
				this.maxHP = 4005; this.atk = 368; this.currentHP = 4005; this.specialnumturn = 3;
				break;
			case BlackMage:
				this.maxHP = 4175; this.atk = 303; this.currentHP = 4175; this.specialnumturn = 4;
				break;
			case Phoenix:
				this.maxHP = 4175; this.atk = 209; this.currentHP = 4175; this.specialnumturn = 8;
				break;
			case Cherry:
				this.maxHP = 3560; this.atk = 198; this.currentHP = 3560; this.specialnumturn = 4;
				break;
		}
	}
	
	/**
	 * Returns the current HP of this player
	 * @return
	 */
	public double getCurrentHP()
	{
		//INSERT YOUR CODE HERE
		return currentHP;
	}
	
	/**
	 * Returns type of this player
	 * @return
	 */
	public Player.PlayerType getType()
	{
		//INSERT YOUR CODE HERE
		return type;
	}
	
	/**
	 * Returns max HP of this player. 
	 * @return
	 */
	public double getMaxHP()
	{
		//INSERT YOUR CODE HERE
		
		return maxHP;
	}
	
	/**
	 * Returns whether this player is sleeping.
	 * @return
	 */
	public boolean isSleeping()
	{
		//INSERT YOUR CODE HERE
		if(Sleeping) 
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Returns whether this player is being cursed.
	 * @return
	 */
	public boolean isCursed()
	{
		//INSERT YOUR CODE HERE
		if(Cursed) 
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Returns whether this player is alive (i.e. current HP > 0).
	 * @return
	 */
	public boolean isAlive()
	{
		//INSERT YOUR CODE HERE
		if(currentHP>0) 
		{
			return true;
		}
		return false;
		
	}
	
	/**
	 * Returns whether this player is taunting the other team.
	 * @return
	 */
	public boolean isTaunting()
	{
		//INSERT YOUR CODE HERE
		if(Taunting) 
		{
			return true;
		}
		return false;
	}
	
	
	public void attack(Player target)
	{	
		//INSERT YOUR CODE HERE
		target.currentHP = target.currentHP -  this.atk; 
		if(target.currentHP < 0) 
		{
			target.currentHP = 0;
		}
	}
	public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam)
	{	
		//INSERT YOUR CODE HERE
		num =0;
		if(this.type == PlayerType.Healer) 
		{
			double findlowest = 9999;
			Player target = null;
			for(int i =0;i<2;i++) 
			{
				if(i==0) 
				{
					for(int j =0;j<myTeam[i].length;j++) 
					{
						if(myTeam[i][j].getCurrentHP() > 0 && myTeam[i][j].getCurrentHP() /(myTeam[i][j].getMaxHP())*100 < findlowest) 
						{
							findlowest = myTeam[i][j].getCurrentHP()/(myTeam[i][j].getMaxHP())*100;
							target = myTeam[i][j];
						}
					}
				}
				else 
				{
					for (int j = 0; j < myTeam[i].length; j++) 
					{
						if(myTeam[i][j].getCurrentHP() > 0 && myTeam[i][j].getCurrentHP() /(myTeam[i][j].getMaxHP())*100 < findlowest) 
						{
							findlowest = myTeam[i][j].getCurrentHP()/(myTeam[i][j].getMaxHP())*100;
							target = myTeam[i][j];
							
						}
					}
				}
			}
			if(target.Cursed) 
			{
				return;
			}
			if(target.currentHP<target.maxHP && target.currentHP > 0 && target.Cursed == false) 
			{
				System.out.println("# "+playerInfo()+" Heals "+target.playerInfo());
				target.currentHP = target.currentHP + (target.maxHP * 0.25);
				if(target.currentHP > target.maxHP) {
					target.currentHP = target.maxHP;
				}
			}
		}
		else if(this.type == PlayerType.Tank) 
		{
			System.out.println("# "+playerInfo()+" is Taunting");
			setTaunting(true);
		}
		else if(this.type == PlayerType.BlackMage) 
		{
			double min = 9999999;
			Player cursing = null;
			boolean findcurse = false;
			for (int i = 0; i < 2; i++) 
			{
					for (int j = 0; j < theirTeam[i].length; j++) 
					{
						if(theirTeam[i][j].isAlive() && theirTeam[i][j].currentHP < min) 
						{
							min = theirTeam[i][j].currentHP;
							cursing = theirTeam[i][j];
							findcurse = true;
						}
					}
			}
			if(Taunting(theirTeam) != null) 
			{
				cursing = Taunting(theirTeam);
			}
			if (cursing != null) 
			{
				System.out.println("# "+playerInfo()+" Curses "+cursing.playerInfo());
				cursing.setCursed(true);
				this.curse = cursing;
			}
		}
		else if(this.type == PlayerType.Cherry) 
		{
			for (int i = 0; i < 2; i++) 
			{
				for (int j = 0; j < theirTeam[0].length; j++) 
				{
					if(theirTeam[i][j].isAlive()) 
					{
						System.out.println("# "+playerInfo()+" Feeds a Fortune Cookie to "+theirTeam[i][j].playerInfo());
						theirTeam[i][j].setSleeeping(true);
					}
				}
			}
		}
		else if (this.type == PlayerType.Phoenix) 
		{
			Player anglerevive = myTeam[0][0];
			boolean find_anglerevive = false;
			for (int i = 0; i < 2; i++) 
			{
				for (int j = 0; j < myTeam[0].length; j++) 
				{
					if(!myTeam[i][j].isAlive() && find_anglerevive == false) 
					{
						anglerevive = myTeam[i][j];
						find_anglerevive = true;
					}
				}
			}
			System.out.println("# "+playerInfo()+" Revives "+anglerevive.playerInfo());
			anglerevive.currentHP = anglerevive.currentHP + (anglerevive.maxHP*0.3);
			anglerevive.num = 0;
			anglerevive.setTaunting(false);
			anglerevive.setCursed(false);
			anglerevive.setSleeeping(false);
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
		//INSERT YOUR CODE HERE
		if(this.type == PlayerType.BlackMage && curse != null) 
		{
			curse.setCursed(false);
			curse = null;
		}
		if(this.Taunting) 
		{
			this.setTaunting(false);
		}
		if(this.Sleeping)
		{
			this.setSleeeping(false);
			return;
		}
		num++;
		Player[][] myteam = null;
		Player[][] Theirteam = null;
		if(arena.myTeam(this) == arena.getTeamA()) 
		{
			 myteam = arena.getTeamA();
			 Theirteam = arena.getTeamB();	
		}
		else if(arena.myTeam(this) == arena.getTeamB()) 
		{
			 myteam = arena.getTeamB();
			 Theirteam = arena.getTeamA();
		}
		if(this.num == this.specialnumturn) 
		{
		switch(this.type) 
		{
		case Healer:
			useSpecialAbility(myteam, Theirteam);
			break;
		case Tank:
			useSpecialAbility(myteam, Theirteam);
			break;
		case Samurai:
			this.num = 0;
			Player target = arena.findTarget(this);
			if(target == null) 
			{
				return;
			}
				System.out.println("# "+playerInfo()+" Double-Slashes "+target.playerInfo());
				attack(target); attack(target);
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
		else 
		{
			Player target = arena.findTarget(this);
			if(target != null) 
			{
				attack(target);
				
				System.out.println("# "+playerInfo()+" Attacks "+target.playerInfo()/*+target.currentHP*/);
			}
		}
		
		for (int i = 0; i < 2; i++) 
		{
			for (int j = 0; j < Theirteam[i].length; j++) 
			{
				if(Theirteam[i][j].isAlive() ==false) 
				{
					Theirteam[i][j].Cursed = false;
					Theirteam[i][j].Taunting = false;
					Theirteam[i][j].Sleeping = false;
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
	public Player Taunting(Player[][] team) 
	{
		for (int i = 0; i < 2; i++) 
		{
			for (int j = 0; j < team[i].length; j++) 
			{
				if(team[i][j].Taunting) 
				{
					return team[i][j];
				}
			}
		}
		return null;
	}
	public String playerInfo() 
	{
		return this.Name_of_team+"["+this.row_of_team+"]["+this.position_of_team+"] {"+this.type.toString()+"}";
	}
	public void setPosition(int position,String teamName,String Row) 
	{
		this.position_of_team = position;
		this.Name_of_team = teamName;
		this.row_of_team = Row;
	}
	public void setSleeeping(boolean isSleeeping) 
	{
		this.Sleeping = isSleeeping;
	}
	public void setTaunting(boolean isTaunting) 
	{
		this.Taunting = isTaunting;
	}
	public void setCursed(boolean isCursed) 
	{
		this.Cursed = isCursed;
    }
}