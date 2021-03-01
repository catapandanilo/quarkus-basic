package curso.projeto;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {
	
	@Inject
	private CategoryRepository categoryRepository; 

//	@GET
//	public List<Category> getAllCategories() {
//		Category category = new Category();
//		return category.listCategories();
//	}
	
	@GET
	public List<Category> getAllCategoriesFromRepository() {
		return categoryRepository.listAll();
	}

	@POST
	@Transactional
	public Category createCategory(Category category) {
		category.persist();
		return category;
	}
}