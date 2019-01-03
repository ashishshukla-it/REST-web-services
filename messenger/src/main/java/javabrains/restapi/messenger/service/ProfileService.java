package javabrains.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javabrains.restapi.messenger.database.DatabaseClass;
import javabrains.restapi.messenger.model.Profile;

public class ProfileService {
	private Map<String,Profile> Profiles=DatabaseClass.getProfiles();
	
	public ProfileService()
	{
		Profiles.put("Ashish", new Profile(1,"Ashish","Ashish","One"));
		Profiles.put("Shukla", new Profile(2,"Shukla","Shukla","Two"));
	}
	
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<Profile>(Profiles.values());
	}
	
	public Profile getProfile(String profileName)
	{
		return Profiles.get(profileName);
		
	}
	
	public Profile addProfile(Profile Profile)
	{
		Profile.setId(Profiles.size()+1);
		Profiles.put(Profile.getProfileName(),Profile);
		return Profile;
	}
	
	public Profile updateProfile(Profile Profile)
	{
		if(Profile.getProfileName().isEmpty())
		{
			return null;
		}
	    Profiles.put(Profile.getProfileName(),Profile);
		return Profile;
		
	}
	
	public Profile removeProfile(String profileName)
	{
		return Profiles.remove(profileName);
	}
	
	

}