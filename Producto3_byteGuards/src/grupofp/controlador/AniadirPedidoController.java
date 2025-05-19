package grupofp.controlador;

import grupofp.controlador.ControladorPedido;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;

public class AniadirPedidoController {

    @FXML
    private TextField tfNumPedido;
    @FXML
    private TextField tfCantidad;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfProductoID;

    private ControladorPedido controladorPedido;

    public AniadirPedidoController() {
        controladorPedido = new ControladorPedido();
    }

    @FXML
    private void crearPedido() {
        try {
            int numPedido = Integer.parseInt(tfNumPedido.getText().trim());
            int cantidad = Integer.parseInt(tfCantidad.getText().trim());
            String email = tfEmail.getText().trim();
            String productoID = tfProductoID.getText().trim();

            if (email.isEmpty() || productoID.isEmpty()) {
                mostrarAlerta("Campos requeridos", "Por favor, ingresa todos los datos.", Alert.AlertType.WARNING);
                return;
            }

            LocalDateTime fecha = LocalDateTime.now();
            boolean pedidoRegistrado = controladorPedido.entradaPedido(numPedido, cantidad, fecha, email, productoID);

            if (pedidoRegistrado) {
                mostrarAlerta("Éxito", "Pedido registrado correctamente.", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo registrar el pedido.", Alert.AlertType.ERROR);
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "Número de pedido y cantidad deben ser enteros.", Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        tfNumPedido.clear();
        tfCantidad.clear();
        tfEmail.clear();
        tfProductoID.clear();
    }
}
