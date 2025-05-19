package grupofp.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class FiltrarPedidosEnviadosController {

    @FXML
    private TextField emailField;

    @FXML
    private ListView<String> listaPedidos;

    private ControladorPedido controladorPedido;

    @FXML
    public void initialize() {
        controladorPedido = new ControladorPedido();
    }

    @FXML
    public void filtrarPedidos() {
        String email = emailField.getText().trim();

        if (email.isEmpty()) {
            listaPedidos.getItems().setAll("⚠️ Introduce un email.");
            return;
        }

        ArrayList<String> pedidosFiltrados = controladorPedido.filtrarClienteEnviado(email);

        if (pedidosFiltrados.isEmpty()) {
            listaPedidos.getItems().setAll("🔍 No hay pedidos enviados para ese email.");
        } else {
            listaPedidos.getItems().setAll(pedidosFiltrados);
        }
    }
}
