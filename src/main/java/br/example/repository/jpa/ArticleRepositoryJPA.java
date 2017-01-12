/**
 * 
 */
package br.example.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.example.model.Article;
import br.example.repository.ArticleRepository;

/**
 * @author leonardo
 *
 */
@Repository("articleRepository")
public class ArticleRepositoryJPA implements ArticleRepository {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public Article create(Article article) {
		if(article.getId() == null)
			this.em.persist(article);
		else
			return null;
		
		return article;
	}

	@Override
	public void destroy(Article article) {
		if(!this.em.contains(article))
			article = this.em.merge(article);
		
		this.em.remove(article);
	}

	@Override
	public List<Article> findAll() {
		return this.em.createQuery("from Article", Article.class).getResultList();
	}

	@Override
	public Article update(Article article) {
		Article entity = this.em.find(Article.class, article.getId());
		if(entity != null) {
			entity.setTitle(article.getTitle());
			entity.setText(article.getText());
			this.em.flush();
		}
		
		return entity;
	}

	@Override
	public Article findById(Long id) {
		if(id != null)
			return this.em.find(Article.class, id);
		
		return null;
	}
}
