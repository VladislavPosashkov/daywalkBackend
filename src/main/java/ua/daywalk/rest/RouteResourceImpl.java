package ua.daywalk.rest;

import ua.daywalk.dao.Factory;
import ua.daywalk.model.Point;
import ua.daywalk.model.Route;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;


@Path("/routes")
public class RouteResourceImpl {

    private final static Logger LOGGER = Logger.getLogger(RouteResourceImpl.class.getSimpleName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Route> findAll() {
        return Factory.getRouteDAO().getAllRoute();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Route findById(@PathParam("id") Integer id) {
        return Factory.getRouteDAO().getRouteWithId(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Route create(Route object) {
        LOGGER.info(object.toString());
        Factory.getRouteDAO().addRoute(object);
        return object;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Route update(Route object) {

        Factory.getRouteDAO().updateRoute(object);
        return object;
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(Integer id) {

        Factory.getRouteDAO().deleteRoute(id);
        return Response.status(200).build();
    }
}
