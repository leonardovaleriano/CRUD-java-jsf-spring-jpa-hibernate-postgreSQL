/**
 * 
 */
package br.example.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.example.model.Article;
import br.example.service.ArticleService;

/**
 * @author leonardo
 *
 */
@ManagedBean
@RequestScoped
public class ArticleBean extends SpringBeanAutowiringSupport {

	@Autowired
	private ArticleService articleService;
	
	// Entity Handlers
	private List<Article> items;
	private Article item = new Article();
	private static long id = -1;
	
	public void save() {
		if(this.id > 0) {
			this.item.setId(this.id);
			this.articleService.update(this.item);
			this.id = -1;
		}
		else {
			this.articleService.create(this.item);
		}
		
		this.item = new Article();
	}
	
	public void destroy(Article article) {
		try {
			this.articleService.destroy(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Article> getItems() {
		return this.articleService.findAll();
	}
	public void setItems(List<Article> items) {
		this.items = items;
	}
	public Article getItem() {
		return this.item;
	}
	
	public void setItem(Article article) {
		this.item = article;
		this.setId(article.getId());
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
