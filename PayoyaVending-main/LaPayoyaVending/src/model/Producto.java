package model;
import excepciones.Notificador;

/**
 * Clase abstracta que representa un producto genérico de la máquina expendedora.
 * Define la estructura básica y el contrato que deben cumplir todos los 
 * productos derivados para la gestión de stock y dispensado.
 * * @author Jose Francisco Sevilla Arevalo
 * @version 1.0
 */
public abstract class Producto {
    protected String nombre;
    protected double precio;
    protected Notificador notificador;

    /**
     * Inicializa un nuevo producto con su nombre, precio base y el 
     * sistema de notificaciones para alertas de inventario.
     * * @param nombre Nombre descriptivo del producto.
     * @param precio Precio inicial de venta en euros.
     * @param n Instancia del notificador para avisos de stock.
     */
    public Producto(String nombre, double precio, Notificador n) {
        this.nombre = nombre;
        this.precio = precio;
        this.notificador = n;
    }

    /**
     * Evalúa si existe disponibilidad suficiente del producto en el inventario.
     * * @param cantidad Unidades o mililitros solicitados por el cliente.
     * @return true si el inventario actual es mayor o igual a la cantidad solicitada.
     */
    public abstract boolean hayStock(int cantidad);

    /**
     * Ejecuta el proceso físico de entrega del producto al cliente.
     * Cada clase hija debe implementar su propia lógica de reducción de stock.
     * * @param cantidad Unidades o mililitros que se van a servir.
     */
    public abstract void dispensar(int cantidad);
    
    /**\
     * Proporciona el nombre identificativo del producto.
     * * @return Cadena de testo con el nombre del producto.
     */
    public String getNombre() { 
        return nombre;
    }
}