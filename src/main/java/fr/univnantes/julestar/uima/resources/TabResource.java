package fr.univnantes.julestar.uima.resources;

public abstract class TabResource extends MultilineResource {
	
	private String separator;
	
	public TabResource(String separator) {
		super();
		this.separator = separator;
	}


	@Override
	protected void doLine(int lineNum, String line) {
		doRow(lineNum, line, line.split(separator));
	}


	protected abstract void doRow(int lineNum, String line, String[] values);
	
}
