package ua.daywalk.rest;


import ua.daywalk.dao.Factory;
import ua.daywalk.model.Point;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/points")
public class PointResourceImpl {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Point> findAll() {
        return Factory.getPointDAO().getAllPoint();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Point findById(@PathParam("id") Integer id) {
        return Factory.getPointDAO().getPointWithId(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Point create(Point object) {

        Factory.getPointDAO().addPoint(object);
        return object;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Point update(Point object) {

        Factory.getPointDAO().updatePoint(object);
        return object;
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(Integer id) {

        Factory.getPointDAO().deletePoint(id);
        return Response.status(200).build();
    }
}
