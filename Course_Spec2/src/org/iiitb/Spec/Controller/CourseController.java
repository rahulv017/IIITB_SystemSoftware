package org.iiitb.Spec.Controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iiitb.Spec.Bean.Course;
import org.iiitb.Spec.DAO.CourseDAO;

@Path("/course")
public class CourseController {
	
	@Path("/view/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response findAllCourse()
	{
		CourseDAO dao=new CourseDAO();
		ArrayList<Course> course=dao.findAll();
		
		return Response.ok().entity(course).build();
	}

}
