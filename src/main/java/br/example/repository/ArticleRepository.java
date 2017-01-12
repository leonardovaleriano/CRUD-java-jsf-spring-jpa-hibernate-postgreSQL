package br.example.repository;

import java.util.List;

import br.example.model.Article;

public interface ArticleRepository {	
	public Article create(Article article);
	public void destroy(Article article);
	public Article update(Article article);
	public List<Article> findAll();
	public Article findById(Long id);
}
