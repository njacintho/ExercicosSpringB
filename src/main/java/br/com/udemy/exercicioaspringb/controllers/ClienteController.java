 package br.com.udemy.exercicioaspringb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy.exercicioaspringb.models.entities.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping("/qualquer")
	public Cliente obterClient() {
		return new Cliente(28, "Noemi Oliveira Jacntho", "567.967.336-04");
	
	}
	
	@GetMapping("/{id}") //coloca uma vairavel que deseja após a barra
	public Cliente obterClientePorId(@PathVariable int id) {
		return new Cliente(id, "Maria", "567.678.345-03");
		
	}
	
	@GetMapping //coloca uma vairavel que deseja depis de /cliente?id=123
	public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "1") int id) {
		return new Cliente(id, "João Augusto", "567.678.345-31");
	}
}
