

public class Player {

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};
	
	private PlayerType type; 	//Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage, or Phoenix
	private double maxHP;		//Max HP of this player
	private double currentHP;	//Current HP of this player 
	private double atk;			//Attack power of this player
	private int st; 
	private boolean sleepped,cursed,taunt;
	private int sa=0;
	private Player curses = null;
	private String Tname,teaw;
	private int tumnaeng;
	
	
	/**
	 * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns, 
	 * as specified in the given table. It also reset the internal turn count of this player. 
	 * @param _type
	 */
	
	public Player(PlayerType _type)
	{	
		//INSERT YOUR CODE HERE
		this.type=_type;
		switch (type)
		{
		case  Healer:
		this.maxHP=4790;
		this.currentHP=4790;
		this.atk=238;
		this.st=4;
		break;
		case  Tank:
			this.maxHP=5340;
			this.currentHP=5340;
			this.atk=255;
			this.st=4;
			break;
		case  Samurai:
			this.maxHP=4005;
			this.currentHP=4005;
			this.atk=368;
			this.st=3;
			break;
		case  BlackMage:
			this.maxHP=4175;
			this.currentHP=4175;
			this.atk=303;
			this.st=4;
			break;
		case  Phoenix:
			this.maxHP=4175;
			this.currentHP=4175;
			this.atk=209;
			this.st=8;
			break;
		case  Cherry:
			this.maxHP=3560;
			this.currentHP=3560;
			this.atk=198;
			this.st=4;
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
	 * Returns whether this player is sleeppeding.
	 * @return
	 */
	public boolean issleeppeding()
	{
		//INSERT YOUR CODE HERE
		
		return sleepped;
	}
	
	/**
	 * Returns whether this player is being cursed.
	 * @return
	 */
	public boolean isCursed()
	{
		//INSERT YOUR CODE HERE
		
		return cursed;
	}
	
	/**
	 * Returns whether this player is alive (i.e. current HP > 0).
	 * @return
	 */
	public boolean isAlive()
	{
		//INSERT YOUR CODE HERE
		if (this.currentHP >0) {
		return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns whether this player is taunting the other team.
	 * @return
	 */
	public boolean isTaunting()
	{
		//INSERT YOUR CODE HERE
		
		return taunt;
	}
	
	
	public void attack(Player target)
	{	
		//INSERT YOUR CODE HERE
		target.currentHP=target.currentHP-this.atk;
		if(target.currentHP < 0) {
			target.currentHP = 0;
		}
		
	}
	
	public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam)
	{	
		//INSERT YOUR CODE HERE
		this.sa=0;
		double lowhp=99999;
		Player traget1=null;
		
		
		switch (type)
		{
		case Healer:
			for (int i =0;i<2;i ++) {
				for (int j =0 ;j<myTeam[i].length;j++) {
					if(myTeam[i][j].getCurrentHP() > 0 && myTeam[i][j].getCurrentHP() /(myTeam[i][j].getMaxHP())*100 < lowhp) {
						lowhp=myTeam[i][j].currentHP/(myTeam[i][j].getMaxHP())*100;
						traget1=myTeam[i][j];
						
					}
				}
			}
			if (traget1.cursed==true)
			{
				return;
			}
			 if (traget1.currentHP<traget1.maxHP&&traget1.cursed==false) {
				System.out.println("# "+Tname+"["+this.teaw+"]["+this.tumnaeng+"] {"+this.type.toString()+"} "+"Heals "+traget1.Tname+"["+traget1.teaw+"]["+traget1.tumnaeng+"] {"+traget1.type.toString()+"}");
				traget1.currentHP=traget1.currentHP+(traget1.maxHP*0.25);
				if (traget1.currentHP>traget1.maxHP) {
					traget1.currentHP=traget1.maxHP;
				}
			}
			break;
			case Tank:
				System.out.println("# "+Tname+"["+this.teaw+"]["+this.tumnaeng+"] {"+this.type.toString()+"} "+"is Taunting");
				taunt=true;
				break;
			case Samurai:
				traget1 = FindTarget(theirTeam);
				if(traget1 != null)
                {
                    attack(traget1); attack(traget1);
                    System.out.println("# "+Tname+"["+this.teaw+"]["+this.tumnaeng+"] {"+this.type.toString()+"} "+"Double-Slashes "+traget1.Tname+"["+traget1.teaw+"]["+traget1.tumnaeng+"] {"+traget1.type.toString()+"}");
                }
                break;
			case BlackMage:
				Player cursing = findCurses(theirTeam);
	            if(tauntedby(theirTeam) != null) {
	                cursing = tauntedby(theirTeam);
	            }
	            if (cursing != null) {
	                System.out.println("# "+Tname+"["+this.teaw+"]["+this.tumnaeng+"] {"+this.type.toString()+"} "+"Curses "+cursing.Tname+"["+cursing.teaw+"]["+cursing.tumnaeng+"] {"+cursing.type.toString()+"}");
	                cursing.setCursed(true);
	                this.curses = cursing;
	                
	            }  
	            break;
			case Phoenix:
	            Player notdead = myTeam[0][0];
	            boolean find_walkingdead = false;
	            for (int i = 0; i < 2; i++) {
	                for (int j = 0; j < myTeam[0].length; j++) {
	                    if(!myTeam[i][j].isAlive() && find_walkingdead == false) {
	                    	notdead = myTeam[i][j];
	                        find_walkingdead = true;
	                    }
	                }
	            }
	            System.out.println("# "+Tname+"["+this.teaw+"]["+this.tumnaeng+"] {"+this.type.toString()+"} "+"Revives "+notdead.Tname+"["+notdead.teaw+"]["+notdead.tumnaeng+"] {"+notdead.type.toString()+"}");
	            notdead.currentHP = notdead.currentHP + (notdead.maxHP*0.3);
	            notdead.st = 0;
	            notdead.setTaunting(false);
	            notdead.setCursed(false);
	            notdead.setSleepping(false);
	            break;
			case Cherry:
				for (int i = 0; i < 2; i++) {
	                for (int j = 0; j < theirTeam[0].length; j++) {
	                    if(theirTeam[i][j].isAlive()) {
	                        System.out.println("# "+Tname+"["+this.teaw+"]["+this.tumnaeng+"] {"+this.type.toString()+"} "+"Feeds a Fortune Cookie to "+theirTeam[i][j].Tname+"["+theirTeam[i][j].teaw+"]["+theirTeam[i][j].tumnaeng+"] {"+theirTeam[i][j].type.toString()+"}");
	                        theirTeam[i][j].setSleepping(true);
	                    }
	                }
	            }
				break;
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
		Player target;
		if(this.type == PlayerType.BlackMage && curses != null) {
			curses.setCursed(false);
			curses = null;
		}
		if(this.taunt) {
			this.setTaunting(false);
		}
		if(this.sleepped) {
			this.setSleepping(false);
			return;
		}
       if((!this.sleepped)&& isAlive())
        {
            this.sa++;
            if(Tname == "A") {
                if(this.sa == this.st)
                    {
                        switch(this.type)
                        {
                            case Healer : useSpecialAbility(arena.getTeam(Arena.Team.A),arena.getTeam(Arena.Team.B));
                                         break;
                            case BlackMage : useSpecialAbility(arena.getTeam(Arena.Team.A),arena.getTeam(Arena.Team.B));
                                         break;
                            case Cherry : useSpecialAbility(arena.getTeam(Arena.Team.A),arena.getTeam(Arena.Team.B));
                                         break;
                            case Samurai : useSpecialAbility(arena.getTeam(Arena.Team.A),arena.getTeam(Arena.Team.B));
                                         break;
                            case Tank : useSpecialAbility(arena.getTeam(Arena.Team.A),arena.getTeam(Arena.Team.B));
                                         break;
                            case Phoenix : useSpecialAbility(arena.getTeam(Arena.Team.A),arena.getTeam(Arena.Team.B));
                                         break;
                        }
                        this.sa = 0;
                    }
                else
                {
                    target = FindTarget(arena.getTeam(Arena.Team.B));
                    if(target != null)
                    {
                        System.out.println("# "+Tname+"["+this.teaw+"]["+this.tumnaeng+"] {"+this.type.toString()+"} "+"Attacks "+target.Tname+"["+target.teaw+"]["+target.tumnaeng+"] {"+target.type.toString()+"}");
                        attack(target);
                    }
                }
            }
            else if (Tname == "B") {
            	if(this.sa == this.st)
            	{
            		switch(this.type)
            		{
                    case Healer : useSpecialAbility(arena.getTeam(Arena.Team.B),arena.getTeam(Arena.Team.A));
                                 break;
                    case BlackMage : useSpecialAbility(arena.getTeam(Arena.Team.B),arena.getTeam(Arena.Team.A));
                                 break;
                    case Cherry : useSpecialAbility(arena.getTeam(Arena.Team.B),arena.getTeam(Arena.Team.A));
                                 break;
                    case Samurai : useSpecialAbility(arena.getTeam(Arena.Team.B),arena.getTeam(Arena.Team.A));
                                 break;
                    case Tank : useSpecialAbility(arena.getTeam(Arena.Team.B),arena.getTeam(Arena.Team.A));
                                 break;
                    case Phoenix : useSpecialAbility(arena.getTeam(Arena.Team.B),arena.getTeam(Arena.Team.A));
                                 break;
                }
                this.sa = 0;
            }
            else
            {
                target = FindTarget(arena.getTeam(Arena.Team.A));
                if(target != null)
                {
                	 System.out.println("# "+Tname+"["+this.teaw+"]["+this.tumnaeng+"] {"+this.type.toString()+"} "+"Attacks "+target.Tname+"["+target.teaw+"]["+target.tumnaeng+"] {"+target.type.toString()+"}");
                    attack(target);
                }
            }
        }
            if(this.sleepped) {
    			setSleepping(false);
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
				+((this.issleeppeding())?"S":"")
				+"]";
	}
	public Player FindTarget(Player[][] TeamEnemy) 
    {
        Player target1 = null;

                if(tauntedby(TeamEnemy) != null)
                {
                    target1 = tauntedby(TeamEnemy);
                }
                else if (!died(TeamEnemy))
                {
                    for(int i = 0; i<TeamEnemy[0].length; i ++) 
                    {
                        if(TeamEnemy[0][i].isAlive() )
                        {
                            target1 = TeamEnemy[0][i];
                            break;
                        }
                    }
                    for(int i = 0; i<TeamEnemy[0].length; i++)
                    {
                        if(TeamEnemy[0][i].isAlive() && target1.getCurrentHP() > TeamEnemy[0][i].getCurrentHP())
                        {
                            target1 = TeamEnemy[0][i];
                        }
                    }
                }
                else
                {
                    for(int i = 0; i<TeamEnemy[1].length; i ++) 
                    {
                        if(TeamEnemy[1][i].isAlive() )
                        {
                            target1 = TeamEnemy[1][i];
                            break;
                        }
                    }
                    for(int i = 0; i<TeamEnemy[1].length; i++)
                    {
                        if(TeamEnemy[1][i].isAlive() && target1.getCurrentHP() > TeamEnemy[1][i].getCurrentHP())
                        {
                            target1 = TeamEnemy[1][i];
                        }
                    }
                }
                return target1;
                
    }
	public Player tauntedby(Player[][] Team) {
		Player target = null;
		boolean TauntManFound = false;
				for(int i = 0; i < 2; i++)
				{
					for(int l = 0; l < Team[i].length; l++)
					{
						if(Team[i][l].isTaunting() && Team[i][l].isAlive())
						{
							target = Team[i][l];
							TauntManFound = true;
							break;
						}
					}
					if(TauntManFound)
					{
						break;
					}
				}
		return target;
    }
	public static boolean died(Player [][] Team)
    {
                for(int i = 0; i <Team[0].length;i++)
                {
                    if(Team[0][i].isAlive())
                    {
                        return false;
                    }
                }


        return true;
    }
	public Player findCurses(Player[][] theirTeam) {
        double mininum = 9999;
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
	public void setSleepping(boolean isSleeeping) {
        this.sleepped = isSleeeping;
    }
    public void setTaunting(boolean isTaunting) {
        this.taunt = isTaunting;
    }
    public void setCursed(boolean isCursed) {
        this.cursed = isCursed;
    }

	public void setPosition(int position, String row, String team) {
		this.tumnaeng=position;
		this.teaw=team;
		this.Tname=row;
		
		
	}
}