package grupofp.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AltaArticuloController {

    @FXML
    private TextField tfCodigoArticulo;

    @FXML
    private TextField tfDescripcion;

    @FXML
    private TextField tfPrecio;

    @FXML
    private TextField tfGastosEnvio;

    @FXML
    private TextField tfTiempoPreparacion;

    private final ControladorArticulo controladorArticulo;

    public AltaArticuloController() {
        controladorArticulo = new ControladorArticulo();
    }

    @FXML
    private void añadirArticulo() {
        String codigoArticulo = tfCodigoArticulo.getText().trim();
        String descripcion = tfDescripcion.getText().trim();
        int precio = Integer.parseInt(tfPrecio.getText().trim());
        int gastosEnvio = Integer.parseInt(tfGastosEnvio.getText().trim());
        int tiempoPreparacion = Integer.parseInt(tfTiempoPreparacion.getText().trim());

        if (codigoArticulo.isEmpty() || descripcion.isEmpty()) {
            mostrarAlerta("Campos requeridos", "Por favor, completa todos los campos obligatorios.", Alert.AlertType.WARNING);
            return;
        }


        try {
            controladorArticulo.entradaArticulo(codigoArticulo, descripcion, precio, gastosEnvio, tiempoPreparacion);
            mostrarAlerta("Éxito", "Articulo añadido correctamente.", Alert.AlertType.INFORMATION);
            limpiarCampos();
        } catch (Exception e) {
            mostrarAlerta("Error inesperado", "Error al añadir articulo: " + e.getMessage(), Alert.AlertType.ERROR);
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
        tfCodigoArticulo.clear();
        tfDescripcion.clear();
        tfPrecio.clear();
        tfGastosEnvio.clear();
        tfTiempoPreparacion.clear();
    }
}