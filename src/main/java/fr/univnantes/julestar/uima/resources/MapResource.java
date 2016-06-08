package fr.univnantes.julestar.uima.resources;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.univnantes.julestar.uima.Behaviour;
import fr.univnantes.julestar.uima.Constants;

public class MapResource extends TabResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(MapResource.class);

	private Behaviour behaviourOnFormatIssue = Behaviour.FAIL;
	
	public MapResource(String keyValueSeparator) {
		super(keyValueSeparator);
	}

	public MapResource() {
		super(Constants.TAB);
	}

	private Map<String, String> values = new HashMap<String, String>();

	@Override
	protected void doRow(int lineNum, String line, String[] values) {
		if(values.length < 2) 
			doError(String.format(
					NOT_ENOUGH_COLUMNS_PATTERN, 
					lineNum,
					line));
		else if(values.length > 2)
			doError(String.format(
					TOO_MANY_COLUMNS_PATTERN, 
					lineNum,
					line));
		 else 
			doKeyValue(lineNum, line, values[0].trim(), values[1].trim());
	}

	protected void doKeyValue(int lineNum, String line, String key, String value) {
		this.values.put(key, value);
	}

	private static final String TOO_MANY_COLUMNS_PATTERN = "Expected two columns at line %d. Got: \"%s\"";
	private static final String NOT_ENOUGH_COLUMNS_PATTERN = "Expected two columns at line %d. Got: \"%s\"";
	private void doError(String msg) {
		switch(behaviourOnFormatIssue) {
		case FAIL:
			throw new ResourceFormatException(
					msg);
		case WARN:
			LOGGER.warn(msg);
			break;
		case IGNORE:
			// do nothing
			break;
		}
	}
}
