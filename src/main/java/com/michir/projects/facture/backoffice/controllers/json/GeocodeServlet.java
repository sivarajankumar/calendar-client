package com.michir.projects.facture.backoffice.controllers.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.michir.projects.facture.backoffice.data.Geometry;
import com.michir.projects.facture.backoffice.data.Location;
import com.michir.projects.facture.backoffice.data.Result;

public class GeocodeServlet extends HttpServlet {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 6853527452422296800L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setCharacterEncoding(Charset.forName("UTF-8").toString());
		resp.setContentType("application/json");
		resp.setHeader("Cache-Control", "public, max-age=86400");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		
		String address = req.getParameter("address");
		
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
		PrintWriter writer = resp.getWriter();
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("location", result);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(writer, result);
		
		writer.flush();
		writer.close();
		
	}
	
}
