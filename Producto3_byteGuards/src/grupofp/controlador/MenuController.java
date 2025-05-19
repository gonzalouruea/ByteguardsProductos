package grupofp.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MenuController {

    @FXML
    private AnchorPane contenidoPrincipal;

    @FXML
    private void mostrarAltaCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/crearCliente.fxml"));
            Parent root = loader.load();

            // Crear una nueva ventana (Stage) para la vista de "Crear Cliente"
            Stage stage = new Stage();
            stage.setTitle("Alta Cliente");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            mostrarError("Error al cargar la vista: vistas/crearCliente.fxml\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarClientes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/mostrarClientes.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Lista de Clientes");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la vista: vistas/mostrarClientes.fxml");
        }
    }


    @FXML
    private void mostrarClientesEstandar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/mostrarClientesStandar.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Lista de Clientes Estandar");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la vista: vistas/mostrarClientesStandar.fxml");
        }
    }

    @FXML
    private void mostrarClientesPremium() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/mostrarClientesPremium.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Lista de Clientes Premium");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la vista: vistas/mostrarClientesPremium.fxml");
        }
    }

    @FXML
    private void mostrarAniadirPedido() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/añadirPedido.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Añadir Pedido");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la vista: vistas/añadirPedido.fxml");
        }
    }

    @FXML
    private void mostrarEliminarPedido() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/eliminarPedido.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Eliminar Pedido");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la vista: vistas/eliminarPedido.fxml");
        }
    }

    @FXML
    private void mostrarPedidosEnviados() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/mostrarPedidosEnviados.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Pedidos Enviados");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la vista: vistas/mostrarPedidosEnviados.fxml");
        }
    }

    @FXML
    private void mostrarPedidosPendientes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/mostrarPedidosPendientes.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Pedidos Pendientes");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la vista: vistas/mostrarPedidosPendientes.fxml");
        }
    }

    @FXML
    private void mostrarFiltrarPedidosEnviados() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/filtrarPedidosEnviadosPorCliente.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Filtrar Pedidos Enviados por Email");
            stage.setScene(new Scene(root));
            stage.show();
        } /*catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la vista: vistas/filtrarPedidosEnviados.fxml");
        }*/
        catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("No se pudo cargar la vista");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }


    }

    @FXML
    private void mostrarFiltrarPedidosPendientes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/filtrarPedidosPendientes.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Filtrar Pedidos Pendientes por Email");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("No se pudo cargar la vista");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    private void mostrarAltaArticulo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/AñadirArticulo.fxml"));
            Parent root = loader.load();

            // Crear una nueva ventana (Stage) para la vista de "Crear Cliente"
            Stage stage = new Stage();
            stage.setTitle("Alta Articulo");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            mostrarError("Error al cargar la vista: vistas/AñadirArticulo.fxml" + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarArticulos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/mostrarArticulos.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Lista de Articulos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error al cargar la vista: vistas/mostrarArticulos.fxml");
        }
    }



    @FXML
    private void salirAplicacion() {
        System.exit(0);
    }

    private void cargarVista(String rutaFXML) {
        try {
            URL recurso = getClass().getResource(rutaFXML);
            if (recurso == null) {
                mostrarError("No se encontró el recurso FXML: " + rutaFXML);
                System.err.println("No se encontró el recurso FXML: " + rutaFXML);
                return;
            }

            FXMLLoader loader = new FXMLLoader(recurso);
            Parent vista = loader.load(); // Cambié AnchorPane por Parent para evitar el error

            contenidoPrincipal.getChildren().setAll(vista);

            // Verificar si la vista es un AnchorPane antes de establecer anclajes
            if (vista instanceof AnchorPane) {
                AnchorPane.setTopAnchor(vista, 0.0);
                AnchorPane.setBottomAnchor(vista, 0.0);
                AnchorPane.setLeftAnchor(vista, 0.0);
                AnchorPane.setRightAnchor(vista, 0.0);
            }
        } catch (IOException e) {
            mostrarError("Error al cargar la vista: " + rutaFXML + "\n" + e.getMessage());
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
