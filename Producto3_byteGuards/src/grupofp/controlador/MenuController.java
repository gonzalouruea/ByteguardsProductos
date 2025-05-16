package grupofp.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

public class MenuController {

    @FXML
    private AnchorPane contenidoPrincipal;

    @FXML
    private void mostrarAltaCliente() {



        cargarVista("/vistas/crearCliente.fxml");
    }

    @FXML
    private void mostrarClientes() {
        cargarVista("/vistas/mostrarClientes.fxml");
    }

    @FXML
    private void mostrarClientesEstandar() {
        cargarVista("/vistas/mostrarClientesEstandar.fxml");
    }

    @FXML
    private void mostrarClientesPremium() {
        cargarVista("/vistas/mostrarClientesPremium.fxml");
    }

    @FXML
    private void salirAplicacion() {
        System.exit(0);
    }

    private void cargarVista(String rutaFXML) {
        try {

            

            AnchorPane vista = FXMLLoader.load(getClass().getResource(rutaFXML));
            contenidoPrincipal.getChildren().setAll(vista);
            // Ajustar la vista para que ocupe todo el espacio del AnchorPane
            AnchorPane.setTopAnchor(vista, 0.0);
            AnchorPane.setBottomAnchor(vista, 0.0);
            AnchorPane.setLeftAnchor(vista, 0.0);
            AnchorPane.setRightAnchor(vista, 0.0);
        } catch (Exception e) {
            mostrarError("Error al cargar la vista: " + rutaFXML);
            e.printStackTrace();
        }
    }

    private void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
