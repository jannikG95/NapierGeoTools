package ResponseTfL;

public  class ServiceType {
    private  String name;
    private  String uri;

    public ServiceType(String name, String uri){
        this.name = name;
        this.uri = uri;
    }

	public String getName() {
		return name;
	}

	public String getUri() {
		return uri;
	}
}