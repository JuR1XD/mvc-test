package org.monitoring.facettes;

import java.io.IOException;


public interface ApplicationFacet
{
	int setApplicationStatus(String statusName) throws IOException;
}
