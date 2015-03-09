package com.FCI.SWE.Controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.User;

@Path("/")
@Produces("text/html")
public class GroupController {

	@GET
	@Path("/group")
	public Response group() {

		if (User.getCurrentActiveUser() == null) {
			return Response.serverError().build();
		}
		return Response.ok(new Viewable("/jsp/GroupViews/createGroup")).build();
	}

	@POST
	@Path("/CreateGroup")
	public String createGroup(@FormParam("name") String name,
			@FormParam("desc") String desc, @FormParam("privacy") String privacy) {

		String serviceUrl = "http://fci-swe-apps.appspot.com/rest/CreateGroupService";
		String urlParameters = "user_id=" + User.getCurrentActiveUser().getId()
				+ "&name=" + name + "&desc=" + desc + "&privacy=" + privacy;
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "Group created Successfully";

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
