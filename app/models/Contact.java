package models;

// import Play Framework Validation class
import play.data.validation.Constraints;

//import java persistence and Ebean
import javax.persistence.*;
import play.db.ebean.Model;
import play.db.ebean.*;

import java.util.ArrayList;
import java.util.List;

// annotate to mark this class as an entity
// it will be mapped to a Contact table in DB
@Entity
public class Contact extends Model {
//add an ID field mapped to primary key 'Id' in the Contact table
 @Id
 public Long id;
  
 // Annotate Required fields
@Constraints.Required
	public String firstName;
@Constraints.Required
	public String lastName;
@Constraints.Required
	public String userName;
@Constraints.Required
@Constraints.Email
	public String email;
	public String comment;
	public String favouriteTeam;
	
	public Contact(){
	}
	
	public Contact(String firstName, String lastName, String userName, String email, String favouriteTeam){
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.favouriteTeam = favouriteTeam;
		this.comment = comment;
		}
		
	//An Ebean 'helper' which simplifies querying of the model.
	//It specifies that Contacts are identified by the Id field(of type Long).
		public static Finder<Long, Contact>find = new Finder<Long, Contact>(Long.class, Contact .class);
		
	//Call the find.all() method of Contact (inherited from the Ebean Model)
	//Return the List of Contacts found in the database
		public static List<Contact> findAll() {
			return Contact.find.all();
			}
			
	}
	