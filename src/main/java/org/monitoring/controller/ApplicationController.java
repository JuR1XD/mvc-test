package org.monitoring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class ApplicationController
{

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView monitoring() throws IOException, URISyntaxException
	{

		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");

		return mav;
	}

}

