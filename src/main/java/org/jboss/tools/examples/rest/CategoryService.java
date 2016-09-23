package org.jboss.tools.examples.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.tools.examples.model.Category;


@Path("/categories")
@RequestScoped 
public class CategoryService {
	
	@Inject
	private EntityManager em;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategories(){
		final List<Category> results = 
				em.createQuery(
						"select c from Category c order by c.name").getResultList();
		return results;
	}
	
	
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
		TypedQuery<Category> findIdByQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM Category c WHERE c.id = :entityId ORDER BY c.id",
						Category.class);
		findIdByQuery.setParameter("entityId", id);
		Category entity;
		try{
			entity = findIdByQuery.getSingleResult();
		} catch (NoResultException nre) { 
			entity = null;
		}
		if(entity == null){
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}
	
	
	
}


