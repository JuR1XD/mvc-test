package org.monitoring.service;

import java.io.IOException;
import java.net.MalformedURLException;


public interface ApplicationService
{

	int setApplicationStatus(String statusName) throws IOException;

}
