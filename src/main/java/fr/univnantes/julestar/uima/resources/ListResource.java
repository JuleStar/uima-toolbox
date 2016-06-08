package fr.univnantes.julestar.uima.resources;

import java.util.ArrayList;
import java.util.List;

public class ListResource extends MultilineResource {

	private List<String> values = new ArrayList<String>();
	
	
	public boolean containsValue(String value) {
		return values.contains(value);
	}


	@Override
	protected void doLine(int lineNum, String line) {
		this.values.add(line);
	}

}
