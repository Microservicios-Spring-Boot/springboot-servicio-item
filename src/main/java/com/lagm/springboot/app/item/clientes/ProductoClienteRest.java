package com.lagm.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lagm.springboot.app.item.models.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
	// Con esta anotación se declara que esta interfaz es un cliente feign (cliente http)
	// Con el atributo name se indica el nombre del microservicio con el que nos queremos conectar
	
	@GetMapping("/listar")
	public List<Producto>listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);
}
