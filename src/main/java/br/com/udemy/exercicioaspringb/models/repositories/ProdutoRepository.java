package br.com.udemy.exercicioaspringb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; // faz as aplicações simples CRUD
import org.springframework.data.repository.PagingAndSortingRepository; // faz o CRUD consultas paginadas e ordemanção 
import org.springframework.data.repository.query.Param;

import br.com.udemy.exercicioaspringb.models.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{
	
	//criando métodos apartir da converção findByOquequerContaining --> que contenha 
	
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	
	//Outras formas de fazer pela convenção
	
	//findByNomeContaining
	//findByNomeIsContaining
	//findByNomeIsContains
	
	//findByNomeStarstWith
	//findByNomeEndsWith

	
	//findByNomeNotContaining

	// mesma coisa que findByNomeContainingIgnoreCase, porém usando a query, jpql
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param ("nome") String nome);
}
