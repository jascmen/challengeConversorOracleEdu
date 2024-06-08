import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroConversion {
    private String archivo;

    public RegistroConversion(String archivo) {
        this.archivo = archivo;
    }

    public void registrar(String origen, String destino, double monto, double resultado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String tiempo = ahora.format(formatter);

            String registro = String.format("Fecha y Hora: %s, Origen: %s, Destino: %s, Monto: %.2f, Resultado: %.2f\n", tiempo, origen, destino, monto, resultado);
            writer.write(registro);

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public String mostrarRegistros() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            StringBuilder registros = new StringBuilder();
            while ((linea = reader.readLine()) != null) {
                registros.append(linea).append("\n");
            }
            return registros.toString();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

}
