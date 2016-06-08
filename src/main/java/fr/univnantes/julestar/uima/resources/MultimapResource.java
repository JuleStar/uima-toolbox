package fr.univnantes.julestar.uima.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultimapResource extends MapResource {

	protected Map<String, List<String>> values = new HashMap<String, List<String>>();
	
	public MultimapResource() {
		super();
	}

	public MultimapResource(String keyValueSeparator) {
		super(keyValueSeparator);
	}

	protected List<String> protectedGetList(String key) {
		if(values.containsKey(key))
			return values.get(key);
		else {
			List<String> v = new ArrayList<String>();
			values.put(key, v);
			return v;
		}
	}
	
	public List<String> getValues(String key) {
		if(isReadOnly())
			return Collections.unmodifiableList(protectedGetList(key));
		else
			return protectedGetList(key);			
	}
}
