package fr.univnantes.julestar.uima.resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.apache.uima.resource.DataResource;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.SharedResourceObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.univnantes.julestar.uima.Constants;

public abstract class MultilineResource implements SharedResourceObject {
	
	protected boolean readOnly = true;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MultilineResource.class);
	
	@Override
	public void load(DataResource data) throws ResourceInitializationException {
		InputStream inputStream = null;
		try {
			inputStream = data.getInputStream();
			Scanner scanner = null;
			try {
				String line;
				int lineNum = 0;
				scanner = new Scanner(inputStream, "UTF-8");
				scanner.useDelimiter(Constants.LINE_BREAK);
				while (scanner.hasNext()) {
					lineNum++;
					line = scanner.next().trim();
					if(line.startsWith(Constants.DIESE))
						continue;
					else if(line.isEmpty())
						continue;
						
					doLine(lineNum, line);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ResourceInitializationException(e);
			} finally {
				IOUtils.closeQuietly(scanner);
			}
		} catch (IOException e) {
			LOGGER.error("Could not load file {}",data.getUrl());
			throw new ResourceInitializationException(e);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}

	}
	
	protected abstract void doLine(int lineNum, String line);
	
	
	public boolean isReadOnly() {
		return readOnly;
	}
	
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
}
