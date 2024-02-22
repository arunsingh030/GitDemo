package resourses;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name, String language, String address)
	{
		
		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(50);
		//System.out.println(addPlace.getAccuracy());
		addPlace.setAddress(address);
		addPlace.setLanguage(language);
		addPlace.setName(name);
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setWebsite("http://google.com");
		
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		
		addPlace.setTypes(myList);
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		addPlace.setLocation(loc);
		return addPlace;
		
	
	}
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n"
				+ "    \"place_id\" : \""+placeId+"\"\r\n"
				+ "}";
	}
	

}
