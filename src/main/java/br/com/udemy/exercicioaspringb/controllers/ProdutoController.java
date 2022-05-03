package br.com.udemy.exercicioaspringb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.udemy.exercicioaspringb.models.entities.Produto;
import br.com.udemy.exercicioaspringb.models.repositories.ProdutoRepository;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {
	
	@Autowired // injeção de dependencia -> adiciona automaticamente um obejto do tipo produto repository
	private ProdutoRepository produtoRepository;

//	@PostMapping
//	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
//		produtoRepository.save(produto);
//		return produto;
//	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
//	@PostMapping a verificar atruto por atributo
//	public @ResponseBody Produto novoProduto(@RequestParam String nome, @RequestParam double preco, @RequestParam double desconto) {
//		Produto produto = new Produto(nome, preco, desconto);
//		produtoRepository.save(produto);
//		return produto;
//	}
	
	@GetMapping // pouco utilizado por ser aberto a quantiodade que o usuario deseja ver
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping(path = "/nome/{parteNome}") // pouco utilizado por ser aberto a quantiodade que o usuario deseja ver
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
		return produtoRepository.searchByNameLike(parteNome);
		//return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
	}
	
	@GetMapping(path="/{id}")
	public Optional<Produto> obterProdutosPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}") // muito utilizado 
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina,@PathVariable int qtdePagina){
		if(qtdePagina >= 3) qtdePagina = 3;
		Pageable page = PageRequest.of(numeroPagina,qtdePagina);
		return produtoRepository.findAll(page);
		
	}
	
	@DeleteMapping(path = "{id}")
	public void deletarProduto(@PathVariable Integer id) {
		produtoRepository.deleteById(id);
	}
	
	
//	@PutMapping // metodos com os mesmo parametros podem ser usado o RequstMapping
//	public Produto alterarProduto(@Valid Produto produto) {
//		produtoRepository.save(produto);
//		return produto;
//	}
}
