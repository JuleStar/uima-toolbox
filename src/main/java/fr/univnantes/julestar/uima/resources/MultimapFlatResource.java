package fr.univnantes.julestar.uima.resources;

public class MultimapFlatResource extends MultimapResource {
	
	public MultimapFlatResource() {
		super();
	}

	public MultimapFlatResource(String keyValueSeparator) {
		super(keyValueSeparator);
	}

	@Override
	protected void doKeyValue(int lineNum, String line, String key, String value) {
		protectedGetList(key).add(value);
	}
}
