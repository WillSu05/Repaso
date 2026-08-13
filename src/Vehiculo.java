import java.time.Year;

public abstract class Vehiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected int anio;
    protected double precioBase;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String modelo, int anio, double precioBase) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioBase = precioBase;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa == null || placa.isBlank()){
            System.out.println("ERROR: LA PLACA NO PUEDE ESTAR VACIA");
        } else {
            this.placa = placa;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            System.out.println("ERROR: LA MARCA NO PUEDE ESTAR VACIA");
        } else{
            this.marca = marca;
        }

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || marca.isBlank()){
            System.out.println("ERROR: EL MODELO NO PUEDE ESTAR VACIO");
        }else {
            this.modelo = modelo;
        }

    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        int anioActual = Year.now().getValue();
        if (anio < 1990 || anio > anioActual){
            System.out.println("ERROR: EL AÑO DEBE ESTAR ENTRE 1990 Y " + anioActual );
        }else {
            this.anio = anio;
        }
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase <= 0){
            System.out.println("ERROR: EL PRECIO BASE DEBE SER MAYOR A 0");
        }else {
            this.precioBase = precioBase;
        }
    }
    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precioBase=" + precioBase +
                '}';
    }

    public abstract double calcularPrecioFinal();

    public String mostrarFicha(){
        return " PLACA: " + placa + "\n"+
                " MARCA: " + marca + "\n"+
                " MODELO: " + modelo + "\n"+
                " ANIO: " + anio + "\n"+
                " PRECIO: " + precioBase;
    }
}
