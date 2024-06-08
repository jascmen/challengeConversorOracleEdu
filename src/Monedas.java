import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monedas {
    private Map<String, String> monedas;
    private List<String> monedasLista;

    //monedas disponibles en ExchangeRate API
    public Monedas() {
        this.monedas = new HashMap<String,String> ();
        this.monedasLista = new ArrayList<String>();
        inicializarMonedas();
    }

    public void agregarMoneda(String moneda, String codigo) {
        monedas.put(moneda, codigo);
        monedasLista.add(moneda);
    }

    public void inicializarMonedas() {
        monedas.clear();
        monedasLista.clear();
        agregarMoneda("Dolar", "USD");
        agregarMoneda("Euro", "EUR");
        agregarMoneda("Peso Argentino", "ARS");
        agregarMoneda("Real Brasileño", "BRL");
        agregarMoneda("Peso Chileno", "CLP");
        agregarMoneda("Peso Uruguayo", "UYU");
        agregarMoneda("Peso Mexicano", "MXN");
        agregarMoneda("Peso Colombiano", "COP");
        agregarMoneda("Sol Peruano", "PEN");
        agregarMoneda("Yen Japones", "JPY");
        agregarMoneda("Libra Esterlina", "GBP");
        agregarMoneda("Dolar Canadiense", "CAD");
    }

    public String obtenerCodigo(String nombre){
        return monedas.get(nombre);
    }

    public String obtenerNombreIndice(int indice){
        if(indice >=0 && indice < monedasLista.size()){
            return monedasLista.get(indice);
        } else {
            return null;
        }
    }

    public String obtenerNombreCodigo(String codigo){
        for (String nombre : monedas.keySet()) {
            if (monedas.get(nombre).equals(codigo)) {
                return nombre;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < monedasLista.size(); i++) {
            sb.append(i + 1).append(". ").append(monedasLista.get(i)).append(" - ").append(monedas.get(monedasLista.get(i))).append("\n");
        }
        return sb.toString();
    }


    public int size(){
        return monedasLista.size();
    }
}
