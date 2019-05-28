package org.movie.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.data.domain.Page;

import org.codehaus.jettison.json.JSONObject;
import org.movie.dao.MovieDao;
import org.movie.entity.Movie;

@Path("/movies")
public class Movies {

	

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Map<String, Object> get(@DefaultValue("1") @QueryParam("page") int page,
	    		@DefaultValue("300")@QueryParam("per_page") int per_page, @QueryParam("Title") String movie_sub_str) {
	    	try {
	    		Map<String, Object> map = new HashMap<String, Object>();
	    		int total = new MovieDao().count(movie_sub_str).intValue();
	    		int total_page =(int) Math.ceil(total/per_page);
	    		total_page = (total % per_page) == 0 ? total_page : total_page + 1;
	    		map.put("page", page);
	    		map.put("per_page", per_page);
	    		map.put("total", total);
	    		map.put("total_pages", total_page);
	    		map.put("data", total_page > 0 ? new MovieDao().getMovies(page,per_page, movie_sub_str) : new ArrayList<Object>());
	    		return map;
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	    }

	}
	
