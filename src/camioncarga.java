public class camioncarga extends Vehiculo {

    private static final double RECARGO_POR_TONELADA = 500_000.0; // COP

    private double capacidadToneladas;

    public camioncarga(String placa, String marca, String modelo, int anio, double precioBase,
                       double capacidadToneladas) {
        super(placa, marca, modelo, anio, precioBase);
        setCapacidadToneladas(capacidadToneladas);
    }

    public double getCapacidadToneladas() {
        return capacidadToneladas;
    }

    public void setCapacidadToneladas(double capacidadToneladas) {
        if (capacidadToneladas <= 0) {
            System.out.println("Error: la capacidad en toneladas debe ser mayor a 0. No se modificó el atributo.");
            return;
        }
        this.capacidadToneladas = capacidadToneladas;
    }

    /**
     * Precio final = precioBase + 5% de impuesto + $500.000 COP por cada
     * tonelada de capacidad de carga.
     */
    @Override
    public double calcularPrecioFinal() {
        double conImpuesto = getPrecioBase() + (getPrecioBase() * 0.05);
        double recargoCarga = capacidadToneladas * RECARGO_POR_TONELADA;
        return conImpuesto + recargoCarga;
    }

    @Override
    public String mostrarFicha() {
        return super.mostrarFicha()
                + "\nTipo: Camión de carga | Capacidad: " + capacidadToneladas + " ton";
    }
}
