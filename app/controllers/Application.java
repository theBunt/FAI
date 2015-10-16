package controllers;

import play.*;
import play.mvc.*;

// import the Contact Class
import models.Contact;

// Play Framework dependencies
import play.data.Form;
import play.mvc.Result;
import play.mvc.Controller;

import views.html.*;

import java.util.List;
import com.avaje.ebean.*;



public class Application extends Controller {

	// Declare a static instance of a Form
	// This is based on the Contact class
	private static final Form<Contact> contactForm = Form.form(Contact.class);
	
	// The action method which displays an empty form
    public static Result join() {
		// Pass the form instance to the form view template
        return ok(FanClub.render(contactForm));
    }

	// The action method which displays deals with a submitted form
    public static Result contactSubmit() {
		// The values entered in the form are passed back
		// and 'bound' to a form of object based on the Contact class. 
		// Check validation constraints and store errors in the contactForm object
		Form<Contact> boundForm = contactForm.bindFromRequest();
		
		// Go back to the form if errors
		if(boundForm.hasErrors()) {
		  return badRequest(FanClub.render(boundForm));
		}
		// Otherwise read the values and store as a Contact object 
		Contact contact = boundForm.get();
		
		//Save contact to the DB
		contact.save();
		
		// Open a page to confirm the message was sent
		return ok(contactSubmitted.render(contact));
		}
		
	public static Result showContacts() {
	//Retrieve the list of contacts 
        List<Contact> contacts = Contact.findAll();
	//render the show Contacts view,passing the list of contacts
		return ok(showContacts.render(contacts));
    }

    public static Result index() {
        return ok("hello World");
    }
	
	public static Result contactus() {
        return ok(ContactUs.render());
    }
	
	public static Result fanzone() {
	    List<Contact> contacts = Contact.findAll();
		return ok(fanZone.render(contacts));
    }
	
	public static Result team() {
        return ok(Squad.render());
    }
	
	public static Result home() {
        return ok(HomePage.render());
    }

	public static Result shop() {
        return ok(Shop.render());
    }
	
	public static Result player() {
        return ok(Player.render());
    }
	
	
	
}
