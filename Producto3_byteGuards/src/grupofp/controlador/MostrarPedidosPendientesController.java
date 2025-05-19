package grupofp.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import grupofp.modelo.Datos;

import java.util.ArrayList;

public class MostrarPedidosPendientesController {

    @FXML
    private ListView<String> listaPedidos;

    private ControladorPedido controladorPedido;

    @FXML
    public void initialize() {
        controladorPedido = new ControladorPedido();
        cargarPedidosPendientes();  // carga automática al iniciar
    }

    @FXML
    public void cargarPedidosPendientes() {
        ArrayList<String> pedidos = controladorPedido.todosPendientes();
        listaPedidos.getItems().setAll(pedidos);
    }
}
