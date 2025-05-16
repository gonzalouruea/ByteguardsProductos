package grupofp.controlador;

import grupofp.modelo.Datos;
import java.util.ArrayList;

public class ControladorCliente {

    private Datos datos;

    public ControladorCliente() {
        datos = new Datos();
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    /**
     * Método para dar de alta a un cliente, validando su NIF y correo electrónico.
     */
    public void entradaCliente(String nombre, String domicilio, String nif, String email, Float descuento)
            throws Controlador.NIFValidationException, Controlador.EmailValidationException {

        if (nif == null || nif.length() >= 9) {
            throw new Controlador.NIFValidationException("El NIF no puede ser nulo ni tener más de 9 caracteres.");
        }

        if (email == null || !email.contains("@")) {
            throw new Controlador.EmailValidationException("El correo electrónico debe ser válido y contener '@'.");
        }

        datos.addCliente(nombre, domicilio, nif, email, descuento);
    }

    public ArrayList<String> recogerTodosClientes() {
        return datos.recorrerTodosClientes();
    }

    public ArrayList<String> recogerClienteEstandar() {
        return datos.recorrerClienteE();
    }

    public ArrayList<String> recogerClientePremium() {
        return datos.recorrerClienteP();
    }
}
