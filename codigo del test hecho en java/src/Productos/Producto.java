package Productos;

public class Producto {
	 private String nombre;
	    private int cantidad;

	    public Producto(String nombre, int cantidad) {
	        this.nombre = nombre;
	        if (cantidad < 0) {
	            throw new IllegalArgumentException("La cantidad no puede ser negativa");
	        }
	        this.cantidad = cantidad;
	    }

	    public void agregarStock(int cantidad) {
	        if (cantidad < 0) {
	            throw new IllegalArgumentException("Cantidad no válida");
	        }
	        this.cantidad += cantidad;
	    }

	    public void vender(int cantidad) {
	        if (cantidad > this.cantidad) {
	            throw new IllegalStateException("No hay suficiente stock");
	        }
	        this.cantidad -= cantidad;
	    }

	    public int getCantidad() {
	        return cantidad;
	    }

	    public String getNombre() {
	        return nombre;
	    }
}
