package ec.edu.ups.services;

import java.net.URI;
import java.util.List;

import ec.edu.ups.bussines.GestionCategoria;
import ec.edu.ups.models.CategoriaModel;
import ec.edu.ups.services.Error;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaServices {

    @Context
    private UriInfo uriInfo;

    @Inject
    private GestionCategoria gestionCategoria;

    @GET
    public Response listar() {
        List<CategoriaModel> categorias = gestionCategoria.getCategoria();
        return Response.ok(categorias).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") int id) {
        try {
            CategoriaModel categoria = gestionCategoria.getCategoria(id);

            if (categoria == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new Error(404, "No encontrado",
                                "Categoría con ID " + id + " no existe"))
                        .build();
            }

            return Response.ok(categoria).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Error(500, "Error interno", e.getMessage()))
                    .build();
        }
    }
    
    @POST
    public Response crear(CategoriaModel categoria) {

        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new Error(400, "Nombre obligatorio",
                            "El nombre no puede estar vacío"))
                    .build();
        }

        try {
            gestionCategoria.crearCategoria(categoria);

            URI location = uriInfo.getAbsolutePathBuilder()
                    .path(String.valueOf(categoria.getId()))
                    .build();

            return Response.created(location)
                    .entity(categoria)
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new Error(400, "Datos inválidos", e.getMessage()))
                    .build();
        }
    }


}
