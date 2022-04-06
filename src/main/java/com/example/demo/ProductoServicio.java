package com.example.demo;

import java.util.List;

public interface ProductoServicio {
	
	public List<Productos> listarProductos();
	public Productos buscarProductos(long id);
	public void crearProducto(Productos productos);
	public Productos actualizarProducto(Productos producto);
	public void borrarProducto(long id);
	
}
