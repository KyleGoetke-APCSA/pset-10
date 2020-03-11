public class Definitions {

    private String definition;
    private String partOfSpeech;

    public Definitions(String string, String string2) {
    	this.definition = definition;
        this.partOfSpeech = partOfSpeech;
	}

	public void definitions(String definition, String partsOfSpeech) {
        this.definition = definition;
    }

    public String getDefinition() {
        return this.definition;
    }

    public String getPartOfSpeech() {
        return this.partOfSpeech;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }
}
