package br.com.udemy.exercicioaspringb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	@GetMapping("somar/{num1}/{num2}")
	public String obterSoma(@PathVariable int  num1, @PathVariable int num2) {
		return "soma = " + (num1 + num2);

	}

	@GetMapping("/subtrair")//("subtrair?a=num1&b=num2")
	public String obterSubtracao(@RequestParam (name = "a")int a , @RequestParam(name = "b") int b) {
		return "subtração = " + (a - b);

	}
	
}
