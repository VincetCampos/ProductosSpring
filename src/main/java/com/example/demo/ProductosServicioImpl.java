package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class ProductosServicioImpl implements ProductoServicio{
	
	private static AtomicLong aumento = new AtomicLong();
	private static List<Productos> lista = new ArrayList<Productos>();
	
	@Override
	public List<Productos> listarProductos() {		
		return lista;
	}
	
	@Override
	public Productos buscarProductos(long id) {
		
		for(Productos p : lista) {
			if(p.getIdProducto() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void crearProducto(Productos productos) {
		productos.setIdProducto(aumento.incrementAndGet());
		lista.add(productos);
		
	}

	@Override
	public Productos actualizarProducto(Productos producto) {
			for(Productos p : lista) {
				if(p.getIdProducto() == producto.getIdProducto()) {
					p.setNombreProducto(producto.getNombreProducto());
					p.setMarcaProducto(producto.getMarcaProducto());
					p.setDescripcionProducto(producto.getDescripcionProducto());
					p.setPrecioProducto(producto.getPrecioProducto());
					
					
					return p;
				}				
			}
			
		return null;
	}

	@Override
	public void borrarProducto(long id) {
		for(Productos p : lista) {
			if(p.getIdProducto() == id) {
				lista.remove(p);				
			}
		}
		
	}
	
}
