package org.iiitb.Spec.Controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.Spec.Bean.Course;
import org.iiitb.Spec.Bean.SpecNameJson;
import org.iiitb.Spec.Bean.Specilisation;
import org.iiitb.Spec.Bean.SpecilisationJson;
import org.iiitb.Spec.DAO.DomainDAO;
import org.iiitb.Spec.DAO.SpecialiseDAO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.*;


@Path("/Specilisation")
public class SpecilisationContoller {
	
	@Path("/insert")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addSpec(@FormDataParam("spec_name") String spec_name,
            @FormDataParam("target_domain") String target_domain,
            @FormDataParam("min_credits") String min_credits,@FormDataParam("courseId") List<String> courseid
            ) throws URISyntaxException
	{
		Specilisation special=new Specilisation();
		special.setSpec_min_credit(Integer.parseInt(min_credits));
		special.setSpec_name(spec_name);
		special.setSpec_target_dept(target_domain);
		SpecialiseDAO dao=new SpecialiseDAO();
		dao.insertSpec(special,courseid);
		return Response.seeOther(new URI("/academicerp/studentlist.html")).build();
	}
	
	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addSpec1(SpecilisationJson spec) throws URISyntaxException
	{
		Specilisation special=new Specilisation();
		special.setSpec_min_credit(spec.getSpec_min_credit());
		special.setSpec_name(spec.getSpec_name());
		special.setSpec_target_dept(spec.getSpec_target_dept());
		SpecialiseDAO dao=new SpecialiseDAO();
		DomainDAO ddao=new DomainDAO();
		//Specilisation specl=new Specilisation();
		
		dao.insertSpec(special,spec.getSpec_course());
		return Response.ok().entity("fine").build();
	}
	
	@Path("/view/{spec_name}")
	@GET
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response showDetails(@PathParam("spec_name") String spec_name)
	{
		SpecialiseDAO dao=new SpecialiseDAO();
		Specilisation ret=dao.viewSpec(spec_name);
		if(ret==null)
		{
			return  Response.noContent().build();
		}
		else
			return Response.ok().entity(ret).build();
	}
	

	@Path("/view/all")
	@GET
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response showDetails1()
	{
		SpecialiseDAO dao=new SpecialiseDAO();
		ArrayList<Specilisation> ret=dao.viewSpecAll();
		if(ret==null)
		{
			return  Response.noContent().build();
		}
		else
			return Response.ok().entity(ret).build();
	}
	
	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDetails1(SpecilisationJson spec) throws URISyntaxException
	{
		Specilisation special=new Specilisation();
		special.setSpec_id(spec.getSpec_id());
		special.setSpec_min_credit(spec.getSpec_min_credit());
		special.setSpec_name(spec.getSpec_name());
		special.setSpec_target_dept(spec.getSpec_target_dept());
		SpecialiseDAO dao=new SpecialiseDAO();
		DomainDAO ddao=new DomainDAO();
		//Specilisation specl=new Specilisation();
		
		boolean f=dao.updateSpec(special,spec.getSpec_course());
		if(f==false)
		{
			return Response.noContent().build();
		}
		else
		return Response.seeOther(new URI("/academicerp/studentlist.html")).build();
	}
	
	@Path("/delete")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteSpecId(SpecNameJson spec_name)
	{
		SpecialiseDAO dao=new SpecialiseDAO();
		System.out.print(spec_name);
		boolean ret=dao.deleteSpec(spec_name.getSpec_name());
		if(ret)
		{
			return Response.ok().entity("fine").build();
		}
		else
			return Response.ok().entity("not fine").build();
		
	}
	
	
	
	
			                         



}
