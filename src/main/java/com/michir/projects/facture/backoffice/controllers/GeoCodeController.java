package com.michir.projects.facture.backoffice.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.michir.projects.facture.backoffice.data.Geometry;
import com.michir.projects.facture.backoffice.data.Location;
import com.michir.projects.facture.backoffice.data.Result;

@Controller
@RequestMapping("/geocode")
public class GeoCodeController {

	@RequestMapping(value="/json", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> getCoordinates(@RequestParam("address") String address, HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		Location location = new Location();
		location.setLat(2.56);
		location.setLng(48.454);
		
		Geometry geometry = new Geometry();
		geometry.setLocation(location);
		
		Result result = new Result();
		result.setFormatted_address(address);
		result.setGeometry(geometry);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("results", Arrays.asList(result));
		map.put("status", "OK");
		
		return map;
	}
	
}
