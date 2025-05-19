package grupofp.controlador;



import grupofp.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class MostrarArticulosController {

    @FXML
    private ListView<String> listaArticulos;

    private grupofp.controlador.ControladorArticulo controladorArticulo;

    public MostrarArticulosController() {
        controladorArticulo = new grupofp.controlador.ControladorArticulo();
    }

    @FXML
    private void initialize() {
        actualizarLista(); // Cargar la lista automáticamente al abrir
    }

    @FXML
    private void actualizarLista() {
        List<String> clientes = controladorArticulo.recogerTodosArticulos();
        if (clientes != null) {
            ObservableList<String> clientesObservable = FXCollections.observableArrayList(clientes);
            listaArticulos.setItems(clientesObservable);
        } else {
            System.out.println("No se encontraron articulos en la base de datos.");
        }
    }
}
