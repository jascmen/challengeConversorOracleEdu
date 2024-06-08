public class MonedaConversion {
    private String monedaOrigen;
    private String monedaDestino;
    private double monto;
    private double resultado;

    private double tasaConversion;

    public MonedaConversion(MonedaDTO monedaDTO, double monto) {
        this.monedaOrigen = monedaDTO.base_code();
        this.monedaDestino = monedaDTO.target_code();
        this.monto = monto;
        this.resultado = monedaDTO.conversion_result();
        this.tasaConversion = monedaDTO.conversion_rate();
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "El resultado de la conversion de " +getMonto() +"["+getMonedaOrigen()+"]" + " a " + getMonedaDestino()+ " es: " + getResultado()+ "\n";
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getTasaConversion() {
        return tasaConversion;
    }

    public void setTasaConversion(double tasaConversion) {
        this.tasaConversion = tasaConversion;
    }
}
