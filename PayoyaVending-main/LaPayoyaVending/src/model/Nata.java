package model;
import excepciones.Notificador;

/**
 * Representa la nata fresca disponible en la máquina expendedora.
 * Permite la gestión de stock líquido y el cálculo de precios por volumen.
 * * @author Eduardo Puyo Calvo
 * @version 1.0
 */
public class Nata extends Producto {
    private int tanqueNataml;

    /**
     * Crea una instancia de Nata con su precio base, capacidad de tanque
     * y el sistema de alertas configurado.
     * * @param precio Precio base de referencia (para 250ml).
     * @param capacidadInicial Volumen inicial disponible en el tanque (ml).
     * @param n Notificador para avisos de nivel crítico.
     */
    public Nata(double precio, int capacidadInicial, Notificador n) {
        super("Nata Fresca", precio, n);
        this.tanqueNataml = capacidadInicial;
    }

    /**
     * Determina si el tanque de nata dispone del volumen solicitado.
     * * @param ml Cantidad en mililitros a comprobar.
     * @return true si hay stock suficiente para la operación.
     */
    @Override
    public boolean hayStock(int ml) {
        return tanqueNataml >= ml;
    }

    /**
     * Sirve la cantidad de nata indicada y actualiza el estado del tanque.
     * Emite una notificación si el volumen restante es inferior a 2000ml.
     * * @param ml Volumen exacto a dispensar.
     */
    @Override
    public void dispensar(int ml) {
        this.tanqueNataml -= ml;
        System.out.println("[DISPENSADOR] Sirviendo " + ml + "ml de nata espesa.");
        if (tanqueNataml < 2000) {
            notificador.notificar("NIVEL CRITICO: Deposito de NATA por debajo de 2L.");
        }
    }

    /**
     * Calcula el importe total según el formato de venta seleccionado.
     * Aplica lógica de precios para 100ml, 250ml (base) y 500ml.
     * * @param ml Volumen solicitado (100, 250 o 500).
     * @return Precio calculado en euros.
     * @throws IllegalArgumentException Si el volumen no coincide con los formatos estándar.
     */
    public double getPrecio(int ml) {
        double precioFinal;
        switch (ml) {
            case 100: 
                precioFinal = precio/2; 
                break;
            case 250: 
                precioFinal = precio; 
                break;
            case 500: 
                precioFinal = precio + 1.5;
                break;
            default: throw new IllegalArgumentException(
                "Tamaño no disponible para Nata: " + ml + "ml. Use 100, 250 o 500.");
        }
        return precioFinal;
    }
}