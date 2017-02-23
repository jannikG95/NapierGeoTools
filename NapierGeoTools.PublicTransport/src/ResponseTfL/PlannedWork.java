package ResponseTfL;

public class PlannedWork {
	private String id;
	private String description;
	private String createdDateTime;
	private String lastUpdateDateTime;

	public PlannedWork(String id, String description, String createdDateTime, String lastUpdateDateTime) {
		this.id = id;
		this.description = description;
		this.createdDateTime = createdDateTime;
		this.lastUpdateDateTime = lastUpdateDateTime;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public String getLastUpdateDateTime() {
		return lastUpdateDateTime;
	}
}