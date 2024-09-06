import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Productos.Producto;

class productostest {


    // 1. Probar agregar stock correctamente
    @Test
    public void testAgregarStock() {
        Producto producto = new Producto("Laptop", 10);
        producto.agregarStock(5);
        assertEquals(15, producto.getCantidad(), "El stock debería ser 15 después de agregar 5 unidades");
    }

    // 2. Probar vender productos correctamente
    @Test
    public void testVenderProducto() {
        Producto producto = new Producto("Mouse", 10);
        producto.vender(3);
        assertEquals(7, producto.getCantidad(), "El stock debería ser 7 después de vender 3 unidades");
    }

    // 3. Probar excepción al vender más productos de los que hay en stock
    @Test
    public void testVenderProductoSinStock() {
        Producto producto = new Producto("Teclado", 5);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            producto.vender(10);  // Intentar vender más del stock disponible
        });

        String mensajeEsperado = "No hay suficiente stock";
        assertTrue(exception.getMessage().contains(mensajeEsperado), "Debería lanzar excepción de stock insuficiente");
    }

    // 4. Probar excepción al agregar cantidad de stock negativa
    @Test
    public void testAgregarStockInvalido() {
        Producto producto = new Producto("Monitor", 10);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            producto.agregarStock(-5);  // Intentar agregar una cantidad negativa
        });

        String mensajeEsperado = "Cantidad no válida";
        assertTrue(exception.getMessage().contains(mensajeEsperado), "Debería lanzar excepción por cantidad negativa");
    }

    // 5. Probar creación de producto con cantidad negativa
    @Test
    public void testProductoConCantidadNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Producto("Tablet", -5);  // Intentar crear un producto con cantidad negativa
        });

        String mensajeEsperado = "La cantidad no puede ser negativa";
        assertTrue(exception.getMessage().contains(mensajeEsperado), "Debería lanzar excepción al crear producto con cantidad negativa");
    }

}
