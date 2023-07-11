package org.monitoring.controller;

import org.monitoring.facettes.ApplicationFacet;
import org.monitoring.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * This class collects all data needed for the creation of a working frontend.
 * @author Juri Hofmann
 */
@Controller
public class ApplicationController
{
	@Autowired
	ApplicationFacet facet;


	/**
	 *@return A new ModelAndView that is resposible for the frontend
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView monitoring() throws IOException, URISyntaxException
	{

		/**
		 * Creates a new Set of properties used for the config properties
		 */
		Properties properties = new Properties();

		ClassLoader classLoader = getClass().getClassLoader();

		properties.load(new FileInputStream(classLoader.getResource("config.property").getFile()));

		/**
		 * The ModelAndView responsible for the frontend
		 */
		ModelAndView mav = new ModelAndView();

		mav.setViewName("monitoring");

		/**
		 * A new List of Strings is being created for extraction of the property data
		 */
		List<String> propertyList = new ArrayList<>();

		System.out.println(properties.keySet());

		//A loop adds every property to the list that starts with "testValue."
		for(Object o : properties.keySet())
		{
			if(o instanceof String)
			{
				String s = (String) o;
				if(s.startsWith("testValue."))
				{
					propertyList.add(properties.getProperty(s));
				}
			}


		}

		/**
		 * An Itemlist containing the splitted properties for the frontend
		 */
		List<Item> items = new ArrayList<>();


		//The properties from the propertylist are being split and added to the Itemlist
			for(String s : propertyList)
			{
				String[] getSelectedAttributes = s.split(";");

				Item item = new Item();

				item.setHeading(getSelectedAttributes[1]);
				item.setResult(facet.setApplicationStatus(getSelectedAttributes[0]));

				items.add(item);
			}

			//The itemlist is being added as an attribute to the ModelAndView
		mav.addObject("items", items);

		return mav;
	}

}

