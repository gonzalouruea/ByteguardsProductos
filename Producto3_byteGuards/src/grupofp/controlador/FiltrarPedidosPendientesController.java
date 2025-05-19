package grupofp.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import grupofp.modelo.Datos;

import java.util.ArrayList;

public class FiltrarPedidosPendientesController {

    @FXML
    private TextField emailField;

    @FXML
    private ListView<String> listaPedidos;

    private ControladorPedido controladorPedido;

    public FiltrarPedidosPendientesController() {
        controladorPedido = new ControladorPedido();
    }

    @FXML
    public void filtrarPedidosPendientes() {
        String email = emailField.getText().trim();

        if (email.isEmpty()) {
            mostrarAlerta("Por favor, introduce un email.");
            return;
        }

        if (!controladorPedido.existeC(email)) {
            mostrarAlerta("No existe ningún cliente con ese email.");
            return;
        }

        ArrayList<String> resultados = controladorPedido.filtrarClientePendiente(email);
        listaPedidos.getItems().clear();

        if (resultados.isEmpty()) {
            listaPedidos.getItems().add("No hay pedidos pendientes para este cliente.");
        } else {
            listaPedidos.getItems().addAll(resultados);
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
