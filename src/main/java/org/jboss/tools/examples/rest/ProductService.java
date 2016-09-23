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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.tools.examples.model.Product;

@Path("/products")
@RequestScoped 
public class ProductService {
	
	@Inject
	private EntityManager em;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts(){
		final List<Product> results = 
				em.createQuery(
						"select p from Product p order by p.name").getResultList();
		return results;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id){
		TypedQuery<Product> findIdByQuery = em
				.createQuery(
						"SELECT DISTINCT p from Product p WHERE p.id = :entityId Order BY p.id", Product.class);
		findIdByQuery.setParameter("entityId", id);
		Product entity;
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


