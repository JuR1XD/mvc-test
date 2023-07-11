package org.monitoring.facettes.impl;

import org.monitoring.facettes.ApplicationFacet;
import org.monitoring.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


/**
 * Collects all methods from the different services
 * @author Juri Hofmann
 */
public class DefaultApplicationFacet implements ApplicationFacet
{
	@Autowired
	ApplicationService service;
	/**
	 * Executes the service method with statusName as parameter attribute
	 * @param statusName
	 * @return
	 * @throws IOException
	 */
	@Override
	public int setApplicationStatus(String statusName) throws IOException
	{
		return service.setApplicationStatus(statusName);
	}
}
