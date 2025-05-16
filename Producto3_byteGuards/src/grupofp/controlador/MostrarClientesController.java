package grupofp.controlador;

import grupofp.controlador.ControladorCliente;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class MostrarClientesController {

    @FXML
    private ListView<String> listaClientes;

    private ControladorCliente controladorCliente;

    public MostrarClientesController() {
        controladorCliente = new ControladorCliente();
    }

    @FXML
    private void initialize() {
        actualizarLista(); // Cargar la lista automáticamente al abrir
    }

    @FXML
    private void actualizarLista() {
        ArrayList<String> clientes = controladorCliente.recogerTodosClientes();
        listaClientes.getItems().setAll(clientes);
    }
}
