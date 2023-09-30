package Main;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootTest
public class testDataBaseController {

	@Autowired
    private DataSource dataSource;

    @GetMapping("/test-database")
    public ResponseEntity<String> testDatabaseConnection() {
    	try (Connection connection = dataSource.getConnection()) {
            // La conexión fue exitosa
            return ResponseEntity.ok("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            // Hubo un error en la conexión
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error en la conexión a la base de datos: " + e.getMessage());
        }
    }
}


