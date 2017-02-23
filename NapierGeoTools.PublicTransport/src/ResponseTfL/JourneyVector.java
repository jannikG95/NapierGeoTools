package ResponseTfL;

public  class JourneyVector {
    private  String from;
    private  String to;
    private  String via;
    private  String uri;

    public JourneyVector(String from, String to, String via, String uri){
        this.from = from;
        this.to = to;
        this.via = via;
        this.uri = uri;
    }

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getVia() {
		return via;
	}

	public String getUri() {
		return uri;
	}
}