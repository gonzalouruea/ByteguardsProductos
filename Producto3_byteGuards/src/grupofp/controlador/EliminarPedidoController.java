package grupofp.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import grupofp.controlador.ControladorPedido;

import java.util.ArrayList;

public class EliminarPedidoController {

    @FXML
    private ListView<String> listaPedidos;

    @FXML
    private TextField tfNumPedido;

    private ControladorPedido controladorPedido;

    public EliminarPedidoController() {
        controladorPedido = new ControladorPedido();
    }

    @FXML
    private void initialize() {
        cargarPedidos();
    }

    private void cargarPedidos() {
        ArrayList<String> pedidos = controladorPedido.todosPendientes(); // Ahora usando ArrayList<String>
        ObservableList<String> pedidosObservable = FXCollections.observableArrayList(pedidos);
        listaPedidos.setItems(pedidosObservable);
    }

    @FXML
    private void eliminarPedido() {
        String input = tfNumPedido.getText().trim();

        if (input.isEmpty()) {
            mostrarAlerta("Error", "Ingrese un número de pedido", Alert.AlertType.WARNING);
            return;
        }

        try {
            int numPedido = Integer.parseInt(input);
            controladorPedido.eliminarPedido(numPedido);
            mostrarAlerta("Éxito", "Pedido eliminado correctamente.", Alert.AlertType.INFORMATION);
            cargarPedidos(); // Actualizar la lista después de eliminar
            tfNumPedido.clear();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El número de pedido no es válido.", Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

