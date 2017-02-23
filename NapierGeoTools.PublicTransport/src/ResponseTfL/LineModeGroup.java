package ResponseTfL;

public  class LineModeGroup {
    private  String modeName;
    private  String[] lineIdentifier;

    public LineModeGroup(String modeName, String[] lineIdentifier){
        this.modeName = modeName;
        this.lineIdentifier = lineIdentifier;
    }

	public String getModeName() {
		return modeName;
	}

	public String[] getLineIdentifier() {
		return lineIdentifier;
	}
}