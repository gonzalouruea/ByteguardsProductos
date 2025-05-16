package grupofp.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import grupofp.controlador.ControladorCliente;

import java.util.ArrayList;

public class MostrarClientesPremiumController {

    @FXML
    private ListView<String> listViewClientesPremium;

    private final ControladorCliente controladorCliente;

    public MostrarClientesPremiumController() {
        this.controladorCliente = new ControladorCliente();
    }

    @FXML
    public void initialize() {
        cargarClientesPremium();
    }

    @FXML
    public void cargarClientesPremium() {
        ArrayList<String> clientes = controladorCliente.recogerClientePremium();
        listViewClientesPremium.getItems().setAll(clientes);
    }
}
