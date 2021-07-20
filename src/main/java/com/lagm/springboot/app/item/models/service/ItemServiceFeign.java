package com.lagm.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lagm.springboot.app.item.clientes.ProductoClienteRest;
import com.lagm.springboot.app.item.models.Item;

@Service("serviceFeign")
// @Primary // Indica la implementación por defecto a inyectar cuando no se especifica el nombre del componente
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		return this.clienteFeign.listar().stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(this.clienteFeign.detalle(id), cantidad);
	}

}
