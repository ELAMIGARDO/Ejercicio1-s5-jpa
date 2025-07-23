package com.usmp.fia.sem5.models.dao;

import java.util.List;

import com.usmp.fia.sem5.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);

}
