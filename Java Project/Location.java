
public class Location {
	private String street;
	private String district;
	private String city;

	public Location() {

	}

	public Location(String street, String district, String city) {
		super();
		this.street = street;
		this.district = district;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Location [street=" + street + ", district=" + district + ", city=" + city + "]";
	}

}
