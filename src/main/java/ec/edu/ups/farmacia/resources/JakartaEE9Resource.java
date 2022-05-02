package ec.edu.ups.farmacia.resources;

import ec.edu.ups.farmacia.controlador.AdministradorFacade;
import ec.edu.ups.farmacia.controlador.ClienteFacade;
import ec.edu.ups.farmacia.controlador.EmpleadoFacade;
import ec.edu.ups.farmacia.controlador.SucursalFacade;
import ec.edu.ups.farmacia.modelo.Administrador;
import ec.edu.ups.farmacia.modelo.Cliente;
import ec.edu.ups.farmacia.modelo.Empleado;
import ec.edu.ups.farmacia.modelo.Sucursal;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.GregorianCalendar;

/**
 *
 * @author 
 */
@Path("jakartaee9")
public class JakartaEE9Resource {
    
    @EJB 
    private ClienteFacade ejbCliente;
    @EJB
    private SucursalFacade ejbSucusal;
    @EJB
    private AdministradorFacade ejbAdministrador;
    @EJB
    private EmpleadoFacade ejbEmpleado;
    //
    
    @GET
    public Response ping(){
        
        Administrador a = new Administrador(0, "0106256027", "Adrian", "Angamarca", "edwinz-2@outtlook.com", "Gualacceo", "099862100");
        ejbAdministrador.create(a);
        Sucursal s = new Sucursal(0, "Cuenca", "Principal", "2255485", 1920,300);
        ejbSucusal.create(s);
        Cliente c = new Cliente(new GregorianCalendar(1987,0,31), 0, "0106256035", "Edward", "Angamarca", "e@hotmail.com", "Gualaceo", "0987654321");
        ejbCliente.create(c);
        Empleado e = new Empleado(new GregorianCalendar(1987,0,31), "1", 500, s, 0,"0101967016", "Luis", "P", "lp@gmail.com", "Gualaceo", "0987644321");
        ejbEmpleado.create(e);
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}