package resourses;
//  emun is special class in java which has collection of constant or method 
public enum APIResources {
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");//,
	//updatePlaceAPI("/maps/api/place/update/json");
	private String resource;
	
	APIResources(String resource) 
	{
		// TODO Auto-generated constructor stub
		this.resource =resource;
	}
	public String getResource()
	{
		return resource;
	}

	

}
