package com.test.jersey;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/AuthorService")
public class AuthorService {
	public static final HashSet<Person> persons=new HashSet<Person>();
	@GET
	@Path("/getPerson")
	@Produces(MediaType.APPLICATION_JSON)
	public HashSet<Person> getAllPersons() {
		return persons;
	}
	

    @POST
    @Path("/postPerson")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void postPerson(@FormParam("id") Integer id,
            @FormParam("fName") String fName,
            @FormParam("lName") String lName,
            @FormParam("email") String email,
            @FormParam("birthDate") String birthDate,
            @FormParam("pinCode") String pinCode,
            @FormParam("isActive") String isActive) {
    	try {
			Person p1 = new Person(id, fName, lName, email, pinCode, birthDate, isActive);
			persons.add(p1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
    @POST
    @Path("/putPerson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public void putPerson(@PathParam("id") JSONObject inputJsonObj) {
    	try {
			Integer id = (Integer) inputJsonObj.get("id");
			String fName = (String) inputJsonObj.get("fName");
			String lName = (String) inputJsonObj.get("lName");
			String email = (String) inputJsonObj.get("email");
			String birthDate = (String) inputJsonObj.get("birthDate");
			String pinCode = (String) inputJsonObj.get("pinCode");
			String isActive = (String) inputJsonObj.get("isActive");
			Person putPerson =new Person(id);
			if(persons.contains(putPerson))
			{
				putPerson.setId(id);
				putPerson.setFname(fName);
				putPerson.setLname(lName);
				putPerson.setEmail(email);
				putPerson.setPinCode(pinCode);
				putPerson.setBirthDate(birthDate);
				putPerson.setIsActive(isActive);
			}
			persons.add(putPerson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
