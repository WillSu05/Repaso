public class Motocicleta extends Vehiculo {

    private int cilindraje;

    public Motocicleta(String placa, String marca, String modelo, int anio, double precioBase, int cilindraje) {
        super(placa, marca, modelo, anio, precioBase);
        setCilindraje(cilindraje);
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        if (cilindraje <= 0) {
            System.out.println("Error: el cilindraje debe ser mayor a 0. No se modificó el atributo.");
            return;
        }
        this.cilindraje = cilindraje;
    }

    /**
     * Precio final = precioBase + 3% de impuesto de matrícula.
     * Si el cilindraje supera 500 c.c., se suma un recargo adicional del 2%.
     */
    @Override
    public double calcularPrecioFinal() {
        double porcentaje = 0.03;
        if (cilindraje > 500) {
            porcentaje += 0.02;
        }
        return getPrecioBase() + (getPrecioBase() * porcentaje);
    }

    @Override
    public String mostrarFicha() {
        return super.mostrarFicha()
                + "\nTipo: Motocicleta | Cilindraje: " + cilindraje + " c.c.";
    }
}
