package tutor.programacion;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Carmelo Marín Abrego
 */
public class Principal extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Persona> tableView = new TableView();
        TableColumn<Persona, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Persona, String> colApellido = new TableColumn<>("Apellido");
        TableColumn<Persona, String> colPersona = new TableColumn<>("Persona");
        colPersona.getColumns().addAll(colNombre, colApellido);
        
        TableColumn<Persona, LocalDate> colFechaNacimiento = new TableColumn<>("Fecha de Nacimiento");
        tableView.getColumns().addAll(colPersona, colFechaNacimiento);

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));

        Persona p1 = new Persona("Juan", "Perez", LocalDate.parse("2012-11-01"));
        Persona p2 = new Persona("Maria", "Loza", LocalDate.parse("2013-01-15"));
        Persona p3 = new Persona("Adriana", "Mendez", LocalDate.parse("2014-07-20"));

        tableView.getItems().addAll(p1, p2, p3);
        tableView.setTableMenuButtonVisible(true);
        tableView.setPlaceholder(new Label("El TableView no contiene datos."));

        StackPane root = new StackPane();
        root.setPadding(new Insets(10));
        root.getStylesheets().add(getClass().getResource("table-view.css").toExternalForm());
        root.getChildren().add(tableView);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("TableView - Tutor de Programación");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
