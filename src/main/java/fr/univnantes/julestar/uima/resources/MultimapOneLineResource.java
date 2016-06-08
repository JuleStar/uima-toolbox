package fr.univnantes.julestar.uima.resources;

import fr.univnantes.julestar.uima.Constants;

public class MultimapOneLineResource extends MultimapResource {
	
	private String multivalueSeparator;
	
	public MultimapOneLineResource() {
		this(Constants.TAB, Constants.COMMA);
	}

	public MultimapOneLineResource(String keyValueSeparator, String multivalueSeparator) {
		super(keyValueSeparator);
		this.multivalueSeparator = multivalueSeparator;
	}

	@Override
	protected void doKeyValue(int lineNum, String line, String key, String value) {
		for(String v:value.split(this.multivalueSeparator)) {
			String trimedValue = v.trim();
			if(trimedValue.isEmpty())
				protectedGetList(key).add(trimedValue);
		}
	}


}
