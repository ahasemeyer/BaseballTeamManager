package Data;

/**
 *
 * @author hasmy
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerID;
    private String fName;
    private String lName;
    private String position;
    private int playerNumber;
    private char throwingArm;
    private char battingStance;
    private int teamID;
    
    
    public Player()
    {
        fName = "John";
        lName = "Doe";
        position = "unassigned";
        playerNumber = 999; 
        throwingArm = 'R';
        battingStance = 'S';
        teamID = 0;
    }
    
    public Player(String first, String last, String pos, int number, char arm, char stance, int team)
    {
        fName = first;
        lName = last;
        position = pos; 
        playerNumber = number;
        throwingArm = arm;
        battingStance = stance; 
        teamID = team; 
    }
    
    public void setFname(String inName)
    {
        fName = inName;
    }
    
    public String getFname()
    {
        return fName;
    }
    
    public void setLname(String inName)
    {
        lName = inName;
    }
    
    public String getLname()
    {
        return lName;
    }
    
    public void setPosition(String inPosition)
    {
        position = inPosition;
    }
    
    public String getPosition()
    {
        return position;
    }
    
    public Integer getPlayerID()
    {
        return playerID; 
    }
    
    public void setPlayerNumber(int inNumber)
    {
        playerNumber = inNumber;
    }
    
    public int getPlayerNumber()
    {
        return playerNumber;
    }
    
    public void setPlayerArm(char inArm)
    {
        throwingArm = inArm;
    }
    
    public char getPlayerArm()
    {
        return throwingArm;
    }
    
    public void setPlayerStance(char inStance)
    {
        battingStance = inStance;
    }
    
    public char getPlayerStance()
    {
        return battingStance; 
    }
    
    public void setTeamID(int inTeamID)
    {
        teamID = inTeamID;
    }
    
    public int getTeamID()
    {
        return teamID; 
    }
}
