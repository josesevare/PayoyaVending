package excepciones;

/**
 * Interfaz funcional que define el contrato de notificación del sistema.
 * Permite alertar al supervisor o usuario ante eventos críticos.
 * * @author Jose Francisco Sevilla Arevalo.
 * @version 1.0
 */
public interface Notificador {
    /**
     * Envía una notificación con el mensaje indicado.
     * @param mensaje Texto descriptivo del evento a notificar.
     */
    void notificar(String mensaje);
}
