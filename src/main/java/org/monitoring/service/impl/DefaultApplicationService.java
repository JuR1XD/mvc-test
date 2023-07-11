package org.monitoring.service.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.monitoring.apod.GetJsonValue;
import org.monitoring.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;


/**
 * @author Juri Hofmann
 */
@Service
public class DefaultApplicationService implements ApplicationService
{
	/**
	 * This method collects the necessary data from the monitoring methods of the Extension
	 * @param statusName
	 * @return
	 * @throws IOException
	 */
	@Override
	public int setApplicationStatus(String statusName) throws IOException
	{
		//Creates a new set of properties
		/**
		 * A set of properties containing the config data
		 */
		Properties properties = new Properties();

		ClassLoader classLoader = getClass().getClassLoader();

		//loads the properties from the file config.property into the property set
		properties.load(new FileInputStream(classLoader.getResource("config.property").getFile()));

		/**
		 * The necessary JSON data is being collected with HttpURLConnection and converted to an int for the return
		 */
		URL url = new URL(properties.getProperty("serverURL") + statusName);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		InputStream responseStream = connection.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		GetJsonValue getJsonValue = mapper.readValue(responseStream, GetJsonValue.class);

		return getJsonValue.applicationValue;
	}
}

