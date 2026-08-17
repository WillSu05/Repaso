public class Automovil extends Vehiculo {

    private int numeroPuertas;
    private String tipoCombustible;

    public Automovil(String placa, String marca, String modelo, int anio, double precioBase,
                     int numeroPuertas, String tipoCombustible) {
        super(placa, marca, modelo, anio, precioBase);
        setNumeroPuertas(numeroPuertas);
        setTipoCombustible(tipoCombustible);
    }

    public int getNumeroPuertas() {

        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        if (numeroPuertas < 2 || numeroPuertas > 5) {
            System.out.println("Error: el número de puertas debe estar entre 2 y 5. No se modificó el atributo.");
            return;
        }
        this.numeroPuertas = numeroPuertas;
    }

    public String getTipoCombustible() {

        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        if (tipoCombustible == null ||
                !(tipoCombustible.equalsIgnoreCase("Gasolina")
                        || tipoCombustible.equalsIgnoreCase("Diésel")
                        || tipoCombustible.equalsIgnoreCase("Eléctrico"))) {
            System.out.println("Error: el tipo de combustible debe ser Gasolina, Diésel o Eléctrico. No se modificó el atributo.");
            return;
        }
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public double calcularPrecioFinal() {
        double porcentajeImpuesto = tipoCombustible.equalsIgnoreCase("Eléctrico") ? 0.04 : 0.08;
        return getPrecioBase() + (getPrecioBase() * porcentajeImpuesto);
    }

    @Override
    public String mostrarFicha() {
        return super.mostrarFicha()
                + "\nTipo: Automóvil | Puertas: " + numeroPuertas + " | Combustible: " + tipoCombustible;
    }
}
