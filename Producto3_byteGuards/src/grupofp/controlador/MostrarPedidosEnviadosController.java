package grupofp.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import grupofp.modelo.Datos;

import java.util.ArrayList;

public class MostrarPedidosEnviadosController {

    @FXML
    private ListView<String> listaPedidos;

    private ControladorPedido controladorPedido;

    @FXML
    public void initialize() {
        controladorPedido = new ControladorPedido();
        cargarPedidosEnviados();  // carga automática al iniciar
    }

    @FXML
    public void cargarPedidosEnviados() {
        ArrayList<String> pedidos = controladorPedido.todosEnviados();
        listaPedidos.getItems().setAll(pedidos);
    }
}
