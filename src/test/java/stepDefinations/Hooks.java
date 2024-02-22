package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		// write code get place id 
		// only run when place id is null
		
		stepDefination m = new stepDefination();
		if (stepDefination.place_id == null)
		{
			m.add_place_playload_with("Arun", "English", "Asia");
			m.user_calls_with_https_request("addPlaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("Arun", "GET");
			
		}
		
	}
	

}
