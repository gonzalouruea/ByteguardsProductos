package grupofp.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AltaClienteController {

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfDomicilio;

    @FXML
    private TextField tfNif;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfDescuento;

    private final ControladorCliente controladorCliente;

    public AltaClienteController() {
        controladorCliente = new ControladorCliente();
    }

    @FXML
    private void crearCliente() {
        String nombre = tfNombre.getText().trim();
        String domicilio = tfDomicilio.getText().trim();
        String nif = tfNif.getText().trim();
        String email = tfEmail.getText().trim();
        String descuentoStr = tfDescuento.getText().trim();
        Float descuento = null;

        if (nombre.isEmpty() || domicilio.isEmpty() || nif.isEmpty() || email.isEmpty()) {
            mostrarAlerta("Campos requeridos", "Por favor, completa todos los campos obligatorios.", Alert.AlertType.WARNING);
            return;
        }

        if (!descuentoStr.isBlank()) {
            try {
                descuento = Float.parseFloat(descuentoStr);
                if (descuento < 0 || descuento > 1) {
                    mostrarAlerta("Valor inválido", "El descuento debe estar entre 0 y 1 (ej. 0.15 para 15%).", Alert.AlertType.ERROR);
                    return;
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Error de formato", "El descuento debe ser un número decimal.", Alert.AlertType.ERROR);
                return;
            }
        }

        try {
            controladorCliente.entradaCliente(nombre, domicilio, nif, email, descuento);
            mostrarAlerta("Éxito", "Cliente creado correctamente.", Alert.AlertType.INFORMATION);
            limpiarCampos();
        } catch (Controlador.NIFValidationException | Controlador.EmailValidationException e) {
            mostrarAlerta("Error de validación", e.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception e) {
            mostrarAlerta("Error inesperado", "Error al crear cliente: " + e.getMessage(), Alert.AlertType.ERROR);
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
        tfNombre.clear();
        tfDomicilio.clear();
        tfNif.clear();
        tfEmail.clear();
        tfDescuento.clear();
    }
}
