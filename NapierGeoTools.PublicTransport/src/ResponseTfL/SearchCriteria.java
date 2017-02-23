package ResponseTfL;

public  class SearchCriteria {
    private  String dateTime;
    private  String dateTimeType;
    private  TimeAdjustments timeAdjustments;

    public SearchCriteria(String dateTime, String dateTimeType, TimeAdjustments timeAdjustments){
        this.dateTime = dateTime;
        this.dateTimeType = dateTimeType;
        this.timeAdjustments = timeAdjustments;
    }

	public String getDateTime() {
		return dateTime;
	}

	public String getDateTimeType() {
		return dateTimeType;
	}

	public TimeAdjustments getTimeAdjustments() {
		return timeAdjustments;
	}
}