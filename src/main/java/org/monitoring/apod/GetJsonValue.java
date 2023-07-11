package org.monitoring.apod;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * This class collects the JSON value in the DefaultApplicationService class
 * @author Juri Hofmann
 */
public class GetJsonValue
{
	public final int applicationValue;

	public GetJsonValue(@JsonProperty int applicationValue)
	{
		this.applicationValue = applicationValue;
	}
}
