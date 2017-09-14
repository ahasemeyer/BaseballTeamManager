/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hasmy
 */
@Entity
@Table(name = "team")
public class Team implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teamID;
    private String teamName;
    private int wins;
    private int losses;
    private int ties; 
    private double winPerc;
    
    
    public Team()
    {
    }
    
    public Team(String inTeamName)
    {
        teamName = inTeamName;
        wins = 0;
        losses = 0;
        ties = 0;
        winPerc = 0;
    }
    
    public String getTeamName()
    {
        return teamName; 
    }
    
    public int getTeamID()
    {
        return teamID;
    }
    
    public void updateTeam(int inWins, int inLosses, int inTies)
    {
        updateWins(inWins);
        updateLosses(inLosses);
        updateTies(inTies);
        updateWinPerc(); 
    }
    
    public void updateWinPerc()
    {
        int totalGames = wins + losses + ties; 
        winPerc = wins/(double)totalGames;
    }
    
    public void updateWins(int inWins)
    {
        wins += inWins;
    }
    
    public void updateLosses(int inLosses)
    {
        losses += inLosses;
    }
    
    public void updateTies(int inTies)
    {
        ties += inTies; 
    }
}


