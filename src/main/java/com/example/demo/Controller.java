package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")

public class Controller {
	
	@Autowired
	ProductoServicio productoServicio;
	
	@GetMapping()
	
	public List<Productos> listarProductos(){
		List<Productos> lista = productoServicio.listarProductos();
		return lista;
	}
	
	@GetMapping("/{id}")
	public Productos buscarEstudiante(@PathVariable Long id) {
		Productos P = productoServicio.buscarProductos(id);
		
		return P;
	}
	
	@PostMapping("/ingresar")
	public void crearProducto(@RequestBody Productos producto) {
		productoServicio.crearProducto(producto);
	}
	
	@PutMapping("/actualizar")
	public Productos actualizarProducto(@RequestBody Productos producto) {
		Productos p = productoServicio.actualizarProducto(producto);
		
		return p;
	}
	
	
	@DeleteMapping("/borrar/{id}")
	public void borrarProducto(@PathVariable long id) {
		productoServicio.borrarProducto(id);
	}
}
