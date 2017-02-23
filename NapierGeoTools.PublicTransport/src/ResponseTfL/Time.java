package ResponseTfL;

public  class Time {
    private  String date;
    private  String time;
    private  String timeIs;
    private  String uri;

    public Time(String date, String time, String timeIs, String uri){
        this.date = date;
        this.time = time;
        this.timeIs = timeIs;
        this.uri = uri;
    }

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getTimeIs() {
		return timeIs;
	}

	public String getUri() {
		return uri;
	}
	public void print(){
		System.out.println(date + " " + time + " " + timeIs + " " + uri);
	}
    
}