package grupofp.controlador;



import grupofp.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class MostrarClientesController {

    @FXML
    private ListView<String> listaClientes;

    private grupofp.controlador.ControladorCliente controladorCliente;

    public MostrarClientesController() {
        controladorCliente = new grupofp.controlador.ControladorCliente();
    }

    @FXML
    private void initialize() {
        actualizarLista(); // Cargar la lista automáticamente al abrir
    }

    @FXML
    private void actualizarLista() {
        List<String> clientes = controladorCliente.recogerTodosClientes();
        if (clientes != null) {
            ObservableList<String> clientesObservable = FXCollections.observableArrayList(clientes);
            listaClientes.setItems(clientesObservable);
        } else {
            System.out.println("No se encontraron clientes en la base de datos.");
        }
    }
}
