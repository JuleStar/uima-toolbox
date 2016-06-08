package fr.univnantes.julestar.uima.resources;

import java.util.HashSet;
import java.util.Set;

public class SetResource extends MultilineResource {

	private Set<String> values = new HashSet<String>();
	
	
	public boolean containsValue(String value) {
		return values.contains(value);
	}

	@Override
	protected void doLine(int lineNum, String line) {
		this.values.add(line);
	}

}
