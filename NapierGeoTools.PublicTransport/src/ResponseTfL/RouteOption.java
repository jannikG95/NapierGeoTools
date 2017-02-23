package ResponseTfL;

public class RouteOption {
	private String id;
	private String name;
	private String[] directions;
	private LineIdentifier lineIdentifier;

	public RouteOption(String id, String name, String[] directions, LineIdentifier lineIdentifier) {
		this.id = id;
		this.name = name;
		this.directions = directions;
		this.lineIdentifier = lineIdentifier;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String[] getDirections() {
		return directions;
	}

	public LineIdentifier getLineIdentifier() {
		return lineIdentifier;
	}
}