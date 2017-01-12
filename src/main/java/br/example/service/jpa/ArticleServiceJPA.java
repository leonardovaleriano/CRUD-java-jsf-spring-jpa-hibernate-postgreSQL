/**
 * 
 */
package br.example.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import br.example.model.Article;
import br.example.repository.ArticleRepository;
import br.example.service.ArticleService;

/**
 * @author leonardo
 *
 */
@Service("articleService")
public class ArticleServiceJPA implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	/* (non-Javadoc)
	 * @see br.example.service.ArticleService#create(br.example.model.Article)
	 */
	@Override
	@Transactional
	public Article create(Article article) {
		return this.articleRepository.create(article);
	}

	/* (non-Javadoc)
	 * @see br.example.service.ArticleService#destroy(br.example.model.Article)
	 */
	@Override
	@Transactional
	public void destroy(Article article) throws Exception {
		
		if (article.getId() == null)
			throw new Exception("Article id is null");
		
		this.articleRepository.destroy(article);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Article> findAll() {
		return Lists.newArrayList(this.articleRepository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public Article findById(Long id) {
		return this.articleRepository.findById(id);
	}

	@Override
	@Transactional
	public Article update(Article article) {
		return this.articleRepository.update(article);
	}

}
