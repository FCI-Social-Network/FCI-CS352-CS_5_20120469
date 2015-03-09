package com.FCI.SWE.Services;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.FCI.SWE.ServicesModels.GroupEntity;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class GroupServices {

	@POST
	@Path("/CreateGroupService")
	public String createGroup(@FormParam("user_id") String userId,
			@FormParam("name") String name,
			@FormParam("desc") String desc,
			@FormParam("privacy") String privacy) {
		
		GroupEntity groupEntity = new GroupEntity();
		groupEntity.setDescription(desc);
		groupEntity.setName(name);
		groupEntity.setOwnerId(Long.parseLong(userId));
		groupEntity.setPrivacy(privacy);
		JSONObject json = new JSONObject();
		if(groupEntity.saveGroup())
			json.put("Status", "OK");
		else
			json.put("Status", "Failed");
		return json.toJSONString();
	}

}
