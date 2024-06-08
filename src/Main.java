import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Monedas monedas = new Monedas();
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();

        System.out.println("Bienvenido a la aplicación de conversión de monedas");

        boolean continuar = true;

        while (continuar) {
            try {
                int monedaOrigen = solicitarMoneda(scanner, monedas, "origen");
                if (monedaOrigen == -1) {
                    continuar = false;
                    //break;
                }

                System.out.println("Por favor ingrese el monto a convertir");
                double monto = Double.parseDouble(scanner.nextLine());

                int monedaDestino = solicitarMoneda(scanner, monedas, "destino");
                if (monedaDestino == -1) {
                    continuar = false;
                    //break;
                }

                String origen = monedas.obtenerNombreIndice(monedaOrigen - 1);
                String destino = monedas.obtenerNombreIndice(monedaDestino - 1);
                String resultado = consultaMoneda.consultarApi(monedas.obtenerCodigo(origen), monedas.obtenerCodigo(destino), monto);
                MonedaDTO monedaDTO = consultaMoneda.convertFromJson(resultado);

                MonedaConversion monedaConversion = new MonedaConversion(monedaDTO, monto);

                System.out.println(monedaConversion);

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido\n");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int solicitarMoneda(Scanner scanner, Monedas monedas, String tipo) {
        while (true) {
            System.out.println("*******************************************************************");
            System.out.println("Por favor seleccione la moneda de " + tipo);
            System.out.println(monedas);
            System.out.println("*******************************************************************");
            try {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("salir")) {
                    return -1;
                }
                int moneda = Integer.parseInt(input);
                if (moneda < 1 || moneda > monedas.size()) {
                    System.out.println("Ingrese un índice válido, debe estar entre 1 y " + monedas.size());
                } else {
                    return moneda;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número\n");
            }
        }
    }
}
