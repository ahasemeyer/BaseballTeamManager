
package Data;

/**
 *
 * @author hasmy
 */

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "player")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
//    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
//    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
//    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
//    @NamedQuery(name = "Users.findBySalt", query = "SELECT u FROM Users u WHERE u.salt = :salt"),
//    @NamedQuery(name = "Users.findByEnabled", query = "SELECT u FROM Users u WHERE u.enabled = :enabled")})
//})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerID;
    private String fName;
    private String lName;
    private String position;
    
    
    public Player()
    {
        fName = "John";
        lName = "Doe";
        position = "unassigned";
    }
    
    public Player(String first, String last, String pos)
    {
        fName = first;
        lName = last;
        position = pos; 
    }
    
    public void setFname(String inName)
    {
        fName = inName;
    }
    
    public void setLname(String inName)
    {
        lName = inName;
    }
    
    public void setPosition(String inPosition)
    {
        position = inPosition;
    }
    
    public Integer getPlayerID()
    {
        return playerID; 
    }
    
    
}
