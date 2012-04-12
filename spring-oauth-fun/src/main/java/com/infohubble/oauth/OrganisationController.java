package com.infohubble.oauth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/organisations")
public class OrganisationController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Organisation> getOrganisations() {
		List<Organisation> organisations = new ArrayList<Organisation>();
		organisations.add(new Organisation(1234L, "Boca's in de Jordaan"));
		return organisations;
	}
}
