package model;

/**
 * Gestiona el flujo monetario de la máquina expendedora.
 * Se encarga de la validación de efectivo, la autorización simulada de tarjetas 
 * y el cálculo preciso del cambio a devolver al cliente.
 * * @author Eduardo Puyo Calvo
 * @version 1.0
 */
public class Monedero {
    private double saldoAcumulado = 0;

    /**
     * Simula la comunicación con un terminal bancario para autorizar el cobro.
     * * @param importe Cantidad total a cargar en la tarjeta del cliente.
     * @return true si la operación es autorizada por el banco (simulado).
     */
    public boolean pagarConTarjeta(double importe) {
        System.out.println("[TARJETA] Conectando con el terminal bancario...");
        System.out.println("[TARJETA] Operacion autorizada por " + importe + " euros.");
        return true; 
    }

    /**
     * Valida y procesa la entrada de dinero físico en el sistema.
     * Solo permite denominaciones que el lector de monedas/billetes puede procesar 
     * (0.50€, 1€, 2€ y 5€).
     * * @param cantidad Valor de la moneda o billete introducido.
     * @return true si el dinero ha sido aceptado y sumado al saldo acumulado.
     */
    public boolean pagarConEfectivo(double cantidad) {
        if (cantidad < 0.50) {
            System.out.println("[MONEDERO] Error: No se aceptan monedas inferiores a 0.50 euros.");
            return false;
        }

        if (cantidad > 5.0) {
            System.out.println("[MONEDERO] Error: No se aceptan billetes superiores a 5 euros.");
            return false;
        }

        if (cantidad == 0.50 || cantidad == 1.0 || cantidad == 2.0 || cantidad == 5.0) {
            saldoAcumulado += cantidad;
            System.out.printf("[MONEDERO] Dinero aceptado. Saldo actual: %.2f euros.\n", saldoAcumulado);
            return true;
        } else {
            System.out.println("[MONEDERO] Error: Denominacion no reconocida por el lector.");
            return false;
        }
    }
    

    /**
     * Calcula el remanente de la transacción y reinicia el saldo del monedero.
     * Informa al usuario si el cambio incluye fracciones menores a la moneda 
     * mínima aceptada (0.50€).
     * * @param precioProducto Coste total del producto adquirido para calcular la resta.
     */
    public void darCambio(double precioProducto) {

        double cambio = saldoAcumulado - precioProducto;
        
        if (cambio <= 0) {
            this.saldoAcumulado = 0;
            return;
        }

        System.out.printf("[MONEDERO] Su cambio es de %.2f euros.\n", cambio);

        if (cambio % 0.50 != 0) {
            System.out.println("[AVISO] El cambio incluye fracciones menores a 0.50 euros.");
            System.out.println("[AVISO] Por favor, recoja sus monedas");
        } else {
            System.out.println("[MONEDERO] Cambio entregado en monedas de curso legal (min. 0.50e).");
        }
        
        this.saldoAcumulado = 0; // Resetear saldo tras la compra
    }

    /**
     * Proporciona el estado actual del dinero introducido por el cliente.
     * * @return El total de euros acumulados en la sesión de compra actual.
     */
    public double getSaldoAcumulado() {
        return saldoAcumulado;
    }
}