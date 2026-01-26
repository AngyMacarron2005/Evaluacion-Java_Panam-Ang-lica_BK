package ec.edu.ups.services;

import java.net.URI;
import java.util.List;

import ec.edu.ups.bussines.GestionProductos;
import ec.edu.ups.models.ProductoModel;
import ec.edu.ups.services.Error;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoServices {

    @Context
    private UriInfo uriInfo;

    @Inject
    private GestionProductos gestionProductos;

    @GET
    public Response listar() {
        List<ProductoModel> productos = gestionProductos.getProductos();
        return Response.ok(productos).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") int id) {

        try {
            ProductoModel producto = gestionProductos.getProducto(String.valueOf(id));

            if (producto == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new Error(404, "No encontrado",
                                "Producto con ID " + id + " no existe"))
                        .build();
            }

            return Response.ok(producto).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Error(500, "Error interno", e.getMessage()))
                    .build();
        }
    }

    @POST
    public Response crear(ProductoModel producto) {

        try {
            gestionProductos.crearProducto(producto);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new Error(400, "Datos inválidos", e.getMessage()))
                    .build();
        }

        URI location = uriInfo.getAbsolutePathBuilder()
                .path(String.valueOf(producto.getId()))
                .build();

        return Response.created(location)
                .entity(producto)
                .build();
    }
}
