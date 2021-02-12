
public class Player {

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};
	
	private PlayerType type; 	//Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage, or Phoenix
	private double maxHP;		//Max HP of this player
	private double currentHP;	//Current HP of this player 
	private double atk;			//Attack power of this player
	
	/////////////////////////////////////      ADD       ///////////////////////////////////////
	private int specturn = 0,skillcount = 0;
	private boolean curse;
	private boolean sleep;
	private boolean taunt;
	public Arena.Team team;
	public Arena.Row row;
	public int position;
	/////////////////////////////////////    END ADD    ///////////////////////////////////////
	/**
	 * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns, 
	 * as specified in the given table. It also reset the internal turn count of this player. 
	 * @param _type
	 */
	public Player(PlayerType _type)
	{	
		if(_type == PlayerType.Healer)
		{
			this.type = PlayerType.Healer;
			this.maxHP=4790;
			this.atk = 238;
			this.specturn = 4;
			this.curse = false;
			this.sleep = false;
			
		}
		if(_type == PlayerType.Tank)
		{
			this.type = PlayerType.Tank;
			this.maxHP=5340;
			this.atk = 255;
			this.specturn = 4;
			this.curse = false;
			this.sleep = false;
			this.taunt = false;
		}
		if(_type == PlayerType.Samurai)
		{
			this.type = PlayerType.Samurai;
			this.maxHP=4005;
			this.atk = 368;
			this.specturn = 3;
			this.curse = false;
			this.sleep = false;
			
		}
		if(_type == PlayerType.BlackMage)
		{
			this.type = PlayerType.BlackMage;
			this.maxHP=4175;
			this.atk = 303;
			this.specturn = 4;
			this.curse = false;
			this.sleep = false;
		
		}
		if(_type == PlayerType.Phoenix)
		{
			this.type = PlayerType.Phoenix;
			this.maxHP=4175;
			this.atk = 209;
			this.specturn = 8;
			this.curse = false;
			this.sleep = false;
		
		}
		if(_type == PlayerType.Cherry)
		{
			this.type = PlayerType.Cherry;
			this.maxHP=3560;
			this.atk = 198;
			this.specturn = 4;
			this.curse = false;
			this.sleep = false;
		
		}
		this.currentHP = this.maxHP;
	}
	
	/**
	 * Returns the current HP of this player
	 * @return
	 */
	public double getCurrentHP()
	{
		//INSERT YOUR CODE HERE
		return this.currentHP;
	}
	
	/**
	 * Returns type of this player
	 * @return
	 */
	public Player.PlayerType getType()
	{
		//INSERT YOUR CODE HERE
		return this.type;
	}
	
	/**
	 * Returns max HP of this player. 
	 * @return
	 */
	public double getMaxHP()
	{
		//INSERT YOUR CODE HERE
		return this.maxHP;
	}
	
	/**
	 * Returns whether this player is sleeping.
	 * @return
	 */
	public boolean isSleeping()
	{
		//INSERT YOUR CODE HERE
		if(sleep == true)
			return true;
		else
		return false;
	}
	public void sleep(boolean a)
	{
		this.sleep = a;
	}
	public boolean curse(boolean a)
	{
		boolean curse = a;
		return curse;
	}
	/**
	 * Returns whether this player is being cursed.
	 * @return
	 */
	public boolean isCursed()
	{
		//INSERT YOUR CODE HERE
		if(curse == true)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns whether this player is alive (i.e. current HP > 0).
	 * @return
	 */
	public boolean isAlive()
	{
		//INSERT YOUR CODE HERE
		if(this.currentHP > 0) {
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
		if(taunt == true)
			return true;
		else
		return false;
	}
	
	
	public void attack(Player target)
	{	
		target.currentHP -= atk;
		if(target.currentHP < 0) {
			System.out.println("dxzfddgxgfgffthfhnb");
			target.currentHP = 0;
			target.curse = false;
			target.sleep = false;
			target.taunt = false;
		}
	}
	
	public double cal(double a,double b) {
		double c;
		c = (a/b)*100;
		return c;
	}
	public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam)
	{	
		//INSERT YOUR CODE HERE
		if(getType() == PlayerType.Healer) {
			Player Hero = null;
			double lowest = 0;
			for(int i=0;i<myTeam.length;i++) {
				for(int j=0;j<myTeam[i].length;j++) { Player nowHero = myTeam[i][j];
					if(Hero == null && nowHero.isAlive()) {
						Hero = nowHero;
						lowest = cal(Hero.getCurrentHP(),Hero.getMaxHP());
					}
					else if (Hero != null && nowHero.isAlive() && lowest > cal(nowHero.getCurrentHP(),nowHero.getMaxHP())) {
						Hero = nowHero;
						lowest = cal(nowHero.getCurrentHP(),nowHero.getMaxHP());
					}			
				}
			}
			if(!(Hero.isCursed())) {
				Hero.currentHP += Hero.maxHP*0.25;
				 System.out.println("# " + this.team + "[" + this.row + "][" + this.position + "] {" + this.type + "}" + " Heals " + Hero.team + "[" + Hero.row + "][" + Hero.position + "] {" + Hero.type + "}");
				if(Hero.currentHP > Hero.maxHP)
					Hero.currentHP = Hero.maxHP;
			}
			skillcount = 0 ;
		}
		if(getType() == PlayerType.Tank) {
			
			this.taunt = true;
			System.out.println("# " + this.team + "[" + this.row + "][" + this.position + "] {" + this.type + "}" + " is Taunting ");
			this.skillcount = 0;
		}
		if(getType() == PlayerType.Cherry) {
			for(int i=0;i<theirTeam.length ;i++) {
				for(int j=0;j<theirTeam[i].length ;j++) { 
					if(theirTeam[i][j].isAlive()){
						theirTeam[i][j].sleep(true);
						System.out.println(theirTeam[i][j].isSleeping());
					   	System.out.println("#" + " " + this.team+ "[" + this.row + "]" + "[" + this.position + "]" + " " + "{" + this.type + "}" + " " + "Feeds" + " " + "a" + " " + "Fortune" + " " + "Cookie" + " " + "to" + " " + theirTeam[i][j].team + "[" + theirTeam[i][j].row + "]" + "[" + theirTeam[i][j].position + "]" + " "  + "{" + theirTeam[i][j].type + "}");
					}
				}
			}
		}
		if(getType() == PlayerType.BlackMage) {
			int count = 0 ;
			Player firstTank = null;
			for(int i=0;i<theirTeam.length;i++) {if(count != 0) break;
				for(int j=0 ;j<theirTeam[i].length ;j++) {if(count != 0) break;
					if(theirTeam[i][j].isAlive()==true && theirTeam[i][j].isTaunting()==true) {
						firstTank = theirTeam[i][j];
						count++;
					}
				}
			}
			if(count != 0) {
				firstTank.curse(true);
				System.out.println("# " + this.team + "[" + this.row + "] [" + this.position + "] {" + this.type + "}" + " Curses " + firstTank.team + "[" + firstTank.row + "] [" + firstTank.position + "] {" + firstTank.type + "}");
			}
			else if (count == 0) {
				Player Hero = lowHP(theirTeam);
				if(Hero == null) ;
				else {
						Hero.curse(true);
						System.out.println("# " + this.team + "[" + this.row + "] [" + this.position + "] {" + this.type + "}" + " Curses " + Hero.team + "[" +Hero.row + "] [" + Hero.position + "] {" + Hero.type + "}");
				}
			}
		}
		if(getType() == PlayerType.Phoenix) {
			int count = 0 ;
			for(int i=0;i<myTeam.length;i++) {if(count != 0) break;
				for(int j=0;j<myTeam[i].length;j++) {if(count != 0) break;
					if(myTeam[i][j].isAlive());
					else {
						myTeam[i][j].currentHP += myTeam[i][j].maxHP*0.3;
						System.out.println("# " + this.team + "[" + this.row + "][" + this.position + "] {" + this.type + "}" + " Revives " + myTeam[i][j].team + "[" + myTeam[i][j].row + "][" + myTeam[i][j].position + "] {" + myTeam[i][j].type + "}");
						myTeam[i][j].skillcount = 0;
						count++;
					}
				}
			}
		}
		if(getType() == PlayerType.Samurai) {
			int haveTaunt=0;
			for(int i=0;i<theirTeam.length;i++){
				for(int j=0;j<theirTeam[i].length;j++){
					if(theirTeam[i][j].taunt==true){           
						haveTaunt++;
					}
				}
			 }
			if(haveTaunt!=0){  
				int count = 0;
				for(int i=0;i<theirTeam.length;i++){
					for(int j=0;j<theirTeam[0].length;j++){
					if(theirTeam[i][j].taunt==true && theirTeam[i][j].isAlive()){
						this.attack(theirTeam[i][j]);
						this.attack(theirTeam[i][j]);
						System.out.println("# " + this.team + "[" + this.row + "][" + this.position + "] {" + this.type + "}" + " Double-Slashes " + theirTeam[i][j].team + "[" + theirTeam[i][j].row + "][" + theirTeam[i][j].position + "] {" + theirTeam[i][j].type + "}");
						
						if(theirTeam[i][j].currentHP < 0) {
							//System.out.println("# " + this.team + "[" + this.row + "][" + this.position + "] {" + this.type + "}" + " Double-Slashes " + theirTeam[i][j].team + "[" + theirTeam[i][j].row + "][" + theirTeam[i][j].position + "] {" + theirTeam[i][j].type + "}");
							theirTeam[i][j].currentHP = 0;
							theirTeam[i][j].skillcount=0;
							theirTeam[i][j].curse=false;
							theirTeam[i][j].taunt=false;
							theirTeam[i][j].sleep=false;
							}
							count++;
						}
						if(count!=0)break;
					}
					if(count!=0)break;
				}
			}
			else {
				Player Hero = lowHP(theirTeam);
				if(Hero == null);
				else {
				Hero.currentHP -= atk*2;
				if(Hero.currentHP < 0) {
					Hero.currentHP = 0;
					Hero.skillcount=0;
					Hero.curse=false;
					Hero.taunt=false;
					Hero.sleep=false;
					}
				System.out.println("# " + this.team + "[" + this.row + "][" + this.position + "] {" + this.type + "}" + " Double-Slashes " + Hero.team + "[" + Hero.row + "][" + Hero.position + "] {" + Hero.type + "}");
				
				}
				
			}
		}
		skillcount = 0 ;
	}
	public Player lowHP(Player[][] myTeam)
	{
		Player Hero = null;
		double lowest = 0;
		for(int i=0;i<myTeam.length;i++) {
			if(i==0) {
			for(int j=0;j<myTeam[i].length;j++) { Player nowHero = myTeam[i][j];
				if(Hero == null && nowHero.isAlive()) {
					Hero = nowHero;
					lowest = myTeam[i][j].currentHP;
				}
				else if (Hero != null && nowHero.isAlive() && lowest > myTeam[i][j].currentHP) {
					Hero = nowHero;
					lowest = myTeam[i][j].currentHP;
				}
			}
			if(Hero != null) {
				break;
			}
			}
			else {
				for(int j=0;j<myTeam[i].length;j++) { Player nowHero = myTeam[i][j];
				if(Hero == null && nowHero.isAlive()) {
					Hero = nowHero;
					lowest = myTeam[i][j].currentHP;
				}
				else if (Hero != null && nowHero.isAlive() && lowest > myTeam[i][j].currentHP) {
					Hero = nowHero;
					lowest = myTeam[i][j].currentHP;
				}
			}
		}
		}
		return Hero;
	}
	public void HiTeacher(Player[][] theirTeam)
	{
		int count=0;
		Player firstTank = null;
		for(int i=0;i<theirTeam.length;i++) {if(count != 0) break;
			for(int j=0 ;j<theirTeam[i].length ;j++) {if(count != 0) break;
				if(theirTeam[i][j].isAlive() && theirTeam[i][j].isTaunting()) {
					firstTank = theirTeam[i][j];
					count++;
				}
			}
		}
		if(count != 0) {
			attack(firstTank);
			System.out.println("# " + this.team + "[" + this.row + "][" + this.position + "] {" + this.type + "}" + " Attacks " + firstTank.team + "[" + firstTank.row + "][" + firstTank.position + "] {" + firstTank.type + "}");
			
		}
		else if (count == 0) {
			Player Hero = lowHP(theirTeam);
			if(Hero == null);
			else {
			attack(Hero);
			System.out.println("# " + this.team + "[" + this.row + "][" + this.position + "] {" + this.type + "}" + " Attacks " + Hero.team + "[" + Hero.row + "][" + Hero.position + "] {" + Hero.type + "}");
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
		//INSERT YOUR CODE HERE
		
		this.taunt=false;
		this.sleep = false;
		skillcount++;
		if(skillcount != specturn)
			
			this.HiTeacher(arena.Enemyteam(this.team));
		else this.useSpecialAbility(arena.Myteam(this.team),arena.Enemyteam(this.team));
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
	
	
}
