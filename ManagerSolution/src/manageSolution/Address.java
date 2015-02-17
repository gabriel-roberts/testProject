package manageSolution;

public class Address {

	String address;
	String town;
	String county;

	final String ADDRESS_DATA_FILE = "Address.txt";

	public Address(String add, String tn, String cty) {
		address = add;
		town = tn;
		county = cty;
	}
	
	public boolean isValid() {
		if (getCounty().trim().length() < 2)
			return false;
		return true;
	}
	
	public boolean save() {
		FileUtil futil = new FileUtil();
		String dataLine = getAddress() + "," + getTown() + "," + getCounty();
		return futil.writeToFile(ADDRESS_DATA_FILE, dataLine, true, true);
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getTown() {
		return town;
	}
	
	public String getCounty() {
		return county;
	}

}

