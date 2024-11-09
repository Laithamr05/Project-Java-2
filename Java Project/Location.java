//Laith Amro
//1230018
//Dr. Mamoun Nawahda
//Section 3
public class Location { // Location class for storing address information
	private String street; // street name
	private String district; // district name
	private String city; // city name

	public Location() { // default constructor
	}

	public Location(String street, String district, String city) { // constructor to initialize location details
		super(); // calling the parent constructor
		this.street = street; // setting street name
		this.district = district; // setting district name
		this.city = city; // setting city name
	}

	public String getStreet() { // getter for street
		return street;
	}

	public void setStreet(String street) { // setter for street
		this.street = street;
	}

	public String getDistrict() { // getter for district
		return district;
	}

	public void setDistrict(String district) { // setter for district
		this.district = district;
	}

	public String getCity() { // getter for city
		return city;
	}

	public void setCity(String city) { // setter for city
		this.city = city;
	}

	@Override
	public String toString() { // method to return location details as a string
		return "Location [street=" + street + ", district=" + district + ", city=" + city + "]"; // returning location
																									// details
	}

}
