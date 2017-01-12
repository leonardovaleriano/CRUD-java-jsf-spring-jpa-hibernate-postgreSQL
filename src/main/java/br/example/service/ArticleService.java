/**
 * 
 */
package br.example.service;

import java.util.List;

import br.example.model.Article;

/**
 * @author leonardo
 *
 */
public interface ArticleService {
	public Article create(Article article);
	public Article update(Article article);
	public void destroy(Article article) throws Exception;
	public Article findById(Long id);
	public List<Article> findAll();
}
