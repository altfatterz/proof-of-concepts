package com.infohubble.oauth.provider;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/organisations")
public class OrganisationController {

    private static Logger LOGGER = Logger.getLogger(OrganisationController.class);

    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Organisation> getOrganisations() {
        List<Organisation> organisations = new ArrayList<Organisation>();
		organisations.add(new Organisation(1234L, "dummy organisation"));
		return organisations;
	}
}
