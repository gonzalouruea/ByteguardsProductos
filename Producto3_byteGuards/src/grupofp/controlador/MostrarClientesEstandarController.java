package grupofp.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class MostrarClientesEstandarController {

    @FXML
    private ListView<String> listViewClientesEstandar;

    private final ControladorCliente controladorCliente;

    public MostrarClientesEstandarController() {
        this.controladorCliente = new ControladorCliente();
    }

    @FXML
    public void initialize() {
        cargarClientesEstandar();
    }

    @FXML
    public void cargarClientesEstandar() {
        ArrayList<String> clientes = controladorCliente.recogerClienteEstandar();
        listViewClientesEstandar.getItems().setAll(clientes);
    }
}
