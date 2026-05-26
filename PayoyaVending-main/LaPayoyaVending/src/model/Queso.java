package model;
import excepciones.Notificador;

/**
 * Representa el queso Payoyo disponible en formato de cuñas pre-empaquetadas.
 * Gestiona el inventario por unidades discretas y emite alertas de agotamiento.
 * * @author Antonio Cornejo Jimenez
 * @version 1.0
 */
public class Queso extends Producto {
    private int unidades;

    /**
     * Crea una instancia de Queso configurando su precio por cuña, 
     * el stock inicial de unidades y el sistema de notificaciones.
     * * @param precio Precio de venta por cada cuña de 250g.
     * @param stockInicial Número de unidades disponibles al arrancar la máquina.
     * @param n Notificador para alertas cuando el stock se agota.
     */
    public Queso(double precio, int stockInicial, Notificador n) {
        super("Queso Payoyo (Cuna 250g)", precio, n);
        this.unidades = stockInicial;
    }

    /**
     * Verifica si queda el número de cuñas solicitado en el inventario.
     * * @param cantidad Número de cuñas que el cliente desea comprar.
     * @return true si hay unidades suficientes disponibles.
     */
    @Override
    public boolean hayStock(int cantidad) {
        return unidades >= cantidad;
    }

    /**
     * Entrega las cuñas solicitadas y actualiza el contador de unidades.
     * Si el stock llega a cero, envía una notificación de "STOCK AGOTADO".
     * * @param cantidad Número de cuñas a dispensar.
     */
    @Override
    public void dispensar(int cantidad) {
        this.unidades -= cantidad;
        System.out.println("[DISPENSADOR] Entregando " + cantidad + " cuna(s) de queso.");
        if (unidades <= 0) {
            notificador.notificar("STOCK AGOTADO: No quedan cunas de queso.");
        }
    }
}