package com.FCI.SWE.ServicesModels;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class GroupEntity {
	private String name;
	private String description;
	private String privacy;
	private long ownerId;
	
	public String getName(){
		return name;
	}
	
	public String getDesc(){
		return description;
	}
	
	public String getPrivacy(){
		return privacy;
	}
	
	public long getOwnerId(){
		return ownerId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription(String desc){
		this.description = desc;
	}
	
	public void setPrivacy(String privacy){
		this.privacy = privacy;
	}
	
	public void setOwnerId(long id){
		this.ownerId = id;
	}
	
	public Boolean saveGroup() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("groups");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity group = new Entity("groups", list.size() + 1);

		group.setProperty("name", this.name);
		group.setProperty("description", this.description);
		group.setProperty("privacy", this.privacy);
		group.setProperty("owner_id",this.ownerId);
		
		if(datastore.put(group).isComplete())
			return true;
		else return false;

	}




}
