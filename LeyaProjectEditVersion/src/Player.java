public class Player {

    public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry}

    ;

    private PlayerType type;    //Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage, or Phoenix
    private double maxHP;        //Max HP of this player
    private double currentHP;    //Current HP of this player
    private double atk;        //Attack power of this player

    private double specialTurns;
    private double currentTurn = 0;


    private boolean isAlive = true;
    private boolean isCursed = false;
    private boolean isSleeping = false;
    private boolean isTaunting = false;
    private Player cursedTarget = null;

    private int numPosition;
    private Arena.Row Row;
    private Arena.Team Team;


    /**
     * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns,
     * as specified in the given table. It also reset the internal turn count of this player.
     *
     * @param _type
     */
    public Player(PlayerType _type) {
        //INSERT YOUR CODE HERE
        switch (_type) {
            case Healer:
                this.maxHP = 4790;
                this.atk = 238;
                this.specialTurns = 4;
                break;
            case Tank:
                this.maxHP = 5340;
                this.atk = 255;
                this.specialTurns = 3;
                break;
            case Samurai:
                this.maxHP = 4175;
                this.atk = 368;
                this.specialTurns = 4;
                break;
            case BlackMage:
                this.maxHP = 4175;
                this.atk = 303;
                this.specialTurns = 4;
                break;
            case Phoenix:
                this.maxHP = 4175;
                this.atk = 209;
                this.specialTurns = 4;
                break;

        }
        this.currentHP = this.maxHP;
    }

    /**
     * Returns the current HP of this player
     *
     * @return
     */

    public double getCurrentHP() {
        //INSERT YOUR CODE HERE
        return currentHP;
    }

    /**
     * Returns type of this player
     *
     * @return
     */
    public Player.PlayerType getType() {
        //INSERT YOUR CODE HERE
        return type;
    }

    /**
     * Returns max HP of this player.
     *
     * @return
     */
    public double getMaxHP() {
        //INSERT YOUR CODE HERE

        return maxHP;
    }

    /**
     * Returns whether this player is sleeping.
     *
     * @return
     */
    public boolean isSleeping() {
        //INSERT YOUR CODE HERE
        if (isSleeping == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns whether this player is being cursed.
     *
     * @return
     */
    public boolean isCursed() {
        //INSERT YOUR CODE HERE
        if (isCursed == true) {
        	{
        	    return this.isCursed;
        	}
    

    /**
     * Returns whether this player is alive (i.e. current HP > 0).
     *
     * @return
     */
    public boolean isAlive() {
        //INSERT YOUR CODE HERE
        if (currentHP > 0) {
            isAlive = true;
            return true;
        } else {
            isAlive = false;
            isTaunting = false;
            isSleeping = false;
            isCursed = false;
            currentHP = 0;
            return false;

        }

        return true;
    }

    /**
     * Returns whether this player is taunting the other team.
     *
     * @return
     */
    public boolean isTaunting() {
        //INSERT YOUR CODE HERE
        if (isTaunting == true) {
            return true
        }
        return false;
    }

    public boolean isTaunting(boolean target) {
        target.currentHP = target.currentHP - atk;
        if (target.getCurrentHP() <= 0) {
            target.currentHP = 0;
            target.isAlive = false;
            target.isTaunting = false;
            target.isSleeping = false;
            target.isCursed = false;
        }

    }

    public void attack(Player target) {
        //INSERT YOUR CODE HERE
        target.currentHP = target.currentHP - atk;
        if (target.getCurrentHP() <= 0) {
            target.getCurrentHP() = 0;
            target.isAlive = false;
            target.isTaunting = false;
            target.isSleeping = false;
            target.isCursed = false;
        }

    }


    public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam) {
        //INSERT YOUR CODE HERE
        Player Target = null;
        switch (this.type) {
            case Healer:
                Target = FindLowHP(myTeam);
                if (Target.isCursed == false && target.currentHP < Target.maxHP && Target != null) {
                    double Heal = (0.25) * Target.maxHP;
                    Target.currentHP = Target.currentHP + Heal;
                    if (Target.currentHP > Target.maxHP) {
                        Target.currentHP = Target.maxHP;
                    }
                    System.out.println("# " + this.playerInfo() + " Heals " + target.playerInfo());
                }
                break;
            case Pheonix:
                Target = FindDeadMan(myTeam);
                if (Target != null) {
                    Target.currentHP = (0.30) * Target.maxHP;
                    Target.isAlive = true;
                    Target.currentTurn = 0;
                    System.out.println("# " + this.playerInfo() + " Revives " + target.playerInfo());
                }
                break;
            case Cherry:
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < theirTeam[i].length; j++) {
                        if (theirTeam[i][j].isAlive) {
                            theirTeam[i][j].isSleeping = true;
                            System.out.println("# " + this.playerInfo() + " Feed a fortune cookie to " + theirTeam[i][j].playerInfo());
                        }
                    }
                }
                break;
            case BlackMage:
                Target = FindTarget(theirTeam);
                if (Target != null) {
                    this.cursedTarget = Target;
                    Target.isCursed = true;
                    System.out.println("# " + this.plyerInfo() + " Curses " + Target.playerInfo());
                }
                break;
            case Tank:
                this.isTaunting = true;
                System.out.println("# " + this.playerInfo() + " is Taunting! ");
                break;
            case Samurai:
                if (Target != null) {
                    attack(Target);
                    System.out.println("# " + this.playerInfo() + " Double Slashes! " + Target.playerInfo());
                }
                break;
        }

    }

    public static boolean aliveTeam(Player[][] Team) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < Team[i].length; g++) {
                if (Team[i][j].isAlive()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static checkFrontDead(Player[][] Team) {
        for (int i = 0; i < Team[0].length; i++) {
            if (Team[0][i].isAlive()) {
                return false;
            }
        }
        return true;
    }

    public static Player tEnemy(Player[][] Team) {
        Player Target = null;
        boolean foundTauntbody = false;
        if (foundTauntbody) {
            break;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < Team[i].length; j++) {
                if (Team[i][j].isTaunting() && Team[i][j].isAlive) {
                    Target = Team[i][j];
                    foundTauntbody = true;
                    break;
                }
            }
            return Target;
        }
    }

    public static Player TargetFound(Player[][] teamEnemy) {
        Player Target = null;
        if (teamEnemy((teamEnemy)) != null){
            Target = teamEnemy(teamEnemy);
        }
        else if(!checkFrontDead(teamEnemy)) {
            for (int i = 0; i < teamEnemy[0].length; i++) {
                if (teamEnemy[0][i].isAlive()) {
                    Target = teamEnemy[0][i];
                    break;
                }
            }
            for (int i = 0; i < teamEnemy[0].length; i++) {
                if (teamEnemy[0][i].isAlive() && Target.getCurrentHP() > tEnemy[0][i].getCurrentHP()) {
                    Target = teamEnemy[0][i];
                    break;
                }
            }
        }
        else{
            for(int i=0; i<teamEnemy[1].length; i++){
                if(teamEnemy[1][i].isAlive()){
                    Target = teamEnemy[1][i];
                    break;
                }
            }
            for(int i=0; i<teamEnemy[1].length; i++){
                if(teamEnemy[1][i].isAlive() && Target.getCurrentHP() > teamEnemy[1][i].getCurrentHP()){
                    Target = teamEnemy[1][i];
                }
            }
        }
        return Target;

    }

    public static Player FindDeadBody(Player[][] Team) {
        Player Target = null;
        boolean foundDeadBody = false;
        if (foundDeadBody) {
            break;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < Team[i].length; j++) {
                if (!Team[i][j].isAlive()) {
                    Target = Team[i][j];
                    foundDeadBody = true;
                    break;
                }
            }
        }
        return Target;
    }

    public static Player FindLowHP(Player[][] Team) {
        Player Target = null;
        boolean injuredMan = false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < Team[i].length; j++) {
                if (Team[i][j].isAlive()) {
                    Target = Team[i][j];
                    injuredMan = true;
                    break;
                }
            }
            if (injuredMan) {
                break;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (Target.getCurrentHP() / Target.getMaxHP() > team[i][j].getCurrentHP() / Team[i][j].getMaxHP() && Team[i][j].isAlive()) {
                    Target = Team[i][j];
                }
            }
        }
        return Target;
    }


    /**
     * This method is called by Arena when it is this player's turn to take an action.
     * By default, the player simply just "attack(target)". However, once this player has
     * fought for "numSpecialTurns" rounds, this player must perform "useSpecialAbility(myTeam, theirTeam)"
     * where each player type performs his own special move.
     *
     * @param arena
     */
    public void takeAction(Arena arena) {
        //INSERT YOUR CODE HERE
        Player Target;
        if (this.type == PlayerType.Tank) {
            this.isTaunting = false;
        }
        if (this.type == PlayerType.BlackMage && this.cursedTarget != null) {
            this.cursedTarget.isCursed = false;
        }
        if (( != this.isSleeping)&&this.isAlive){
            this.currentTurn++;
            switch (this.team) {
                case 1:
                    if (this.currentTurn == this.specialTurns) {
                        switch (this.type) {
                            case Healer:
                                useSpecialAbility(arena.getTeam(Arena.Team.A), arena.getTeam(Arena.Team.B));
                                break;
                            case BlackMage:
                                useSpecialAbility(arena.getTeam(Arena.Team.A), arena.getTeam(Arena.Team.B));
                                break;
                            case Cherry:
                                useSpecialAbility(arena.getTeam(Arena.Team.A), arena.getTeam(Arena.Team.B));
                                break;
                            case Samurai:
                                useSpecialAbility(arena.getTeam(Arena.Team.A), arena.getTeam(Arena.Team.B));
                                break;
                            case Tank:
                                useSpecialAbility(arena.getTeam(Arena.Team.A), arena.getTeam(Arena.Team.B));
                                break;
                            case Phoenix:
                                useSpecialAbility(arena.getTeam(Arena.Team.A), arena.getTeam(Arena.Team.B));
                                break;
                        }
                        this.currentTurn = 0;
                    } else {
                        Target = FindTarget(arena.getTeam(Arena.Team.B));
                        if (Target != null) {
                            System.out.println("# " + this.playerInfo() + " Attack " + target.playerInfo());
                            attack(Target);
                        }
                    }
                    break;
                case 2:
                    if (this.currentTurn == this.specialTurns) {
                        switch (this.type) {
                            case Healer:
                                useSpecialAbility(arena.getTeam(Arena.Team.B), arena.getTeam(Arena.Team.A));
                                break;
                            case BlackMage:
                                useSpecialAbility(arena.getTeam(Arena.Team.B), arena.getTeam(Arena.Team.A));
                                break;
                            case Cherry:
                                useSpecialAbility(arena.getTeam(Arena.Team.B), arena.getTeam(Arena.Team.A));
                                break;
                            case Samurai:
                                useSpecialAbility(arena.getTeam(Arena.Team.B), arena.getTeam(Arena.Team.A));
                                break;
                            case Tank:
                                useSpecialAbility(arena.getTeam(Arena.Team.B), arena.getTeam(Arena.Team.A));
                                break;
                            case Phoenix:
                                useSpecialAbility(arena.getTeam(Arena.Team.B), arena.getTeam(Arena.Team.A));
                                break;
                        }
                        this.currentTurn = 0;
                    }
                    else{
                        Target = FindTarget(arena.getTeam(Arena.Team.A));
                        if (Target != null) {
                            System.out.println("# " + this.playerInfo() + " Attack " + Target.playerInfo());
                            attack(Target);
                        }
                    }

                    break;
            }
        }
        if(this.isSleeping)

        {
            this.isSleeping = false;
        }



        /**
         * This method overrides the default Object's toString() and is already implemented for you.
         */
        private String playerInfo(){
            return this.Team+"["+this.row+"]["+this.numPosition+"] {"+this.type+"}";
        }
        @Override
        public String toString()
        {
            return "["+this.type.toString()+" HP:"+this.currentHP+"/"+this.maxHP+" ATK:"+this.atk+"]["
                    +((this.isCursed())?"C":"")
                    +((this.isTaunting())?"T":"")
                    +((this.isSleeping())?"S":"")
                    +"]";
        }

        public Arena.Team getTeam(){
            return Team;
        }

        public void setTeam(Arena.Team Team){
            this.Team = Team;
        }

        public Arena.Row getRow(){
            return Row;
        }

        public void setRow(Arena.Row Row){
            this.Row = Row;
        }

        public int getNumPosition(){
            return numPosition;
        }

        public void setNumPosition(int numPosition){
            this.numPosition = numPosition;
        }
    }
