package model;
import excepciones.Notificador;

/**
 * Representa la leche fresca disponible en la máquina expendedora.
 * Se dispensa en formato líquido desde un tanque interno.
 * * @author Antonio Cornejo Jimenez
 * @version 1.0
 */
public class Leche extends Producto{
    private int tanqueLecheml;

    /**
     * Crea una instancia de Leche configurando su precio por unidad de medida 
     * y la capacidad total del tanque de almacenamiento.
     * * @param precio Precio base (para 500ml).
     * @param capacidadInicial Volumen inicial del tanque en mililitros.
     * @param n Notificador para alertas de nivel.
     */
    public Leche(double precio, int capacidadInicial, Notificador n) {
        super("Leche Fresca", precio, n);
        this.tanqueLecheml = capacidadInicial;
    }

    /**
     * Verifica si el tanque contiene el volumen de leche solicitado.
     * * @param ml Mililitros que se desean extraer.
     * @return true si hay suficiente líquido disponible.
     */
    @Override
    public boolean hayStock(int ml) {
        return tanqueLecheml >= ml;
    }

    /**
     * Extrae el volumen de leche del tanque y lanza una notificación 
     * si el nivel restante cae por debajo del umbral de seguridad (2000ml).
     * * @param ml Volumen a servir.
     */
    @Override
    public void dispensar(int ml) {
        this.tanqueLecheml -= ml;
        System.out.println("[DISPENSADOR] Sirviendo " + ml + "ml de leche fresca de la Sierra.");
        if (tanqueLecheml < 2000) {
            notificador.notificar("NIVEL CRITICO: Deposito de LECHE por debajo de 2L.");
        }
    }

    /**
     * Calcula el precio final basándose en el volumen solicitado.
     * Soporta formatos de 500ml y 1000ml (1 Litro).
     * * @param ml Volumen en ml (500 o 1000).
     * @return Precio final en euros calculado proporcionalmente.
     * @throws IllegalArgumentException si el tamaño solicitado no es 500 o 1000.
     */
    public double getPrecio(int ml) {
        double precioFinal;
        switch (ml) {
            case 500:  
                precioFinal = precio;       
                break;
            case 1000: 
                precioFinal = precio*2; 
                break;
            default: throw new IllegalArgumentException(
                "Tamaño no disponible para Leche: " + ml + "ml. Use 500 o 1000.");
        }
        return precioFinal;
    }
}