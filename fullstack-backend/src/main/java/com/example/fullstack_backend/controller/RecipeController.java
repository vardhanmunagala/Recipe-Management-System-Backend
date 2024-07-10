package com.example.fullstack_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fullstack_backend.exception.RecipeNotFoundException;
import com.example.fullstack_backend.model.Recipe;
import com.example.fullstack_backend.repository.RecipeRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@PostMapping("/recipe")
	Recipe newRecipe(@RequestBody Recipe newRecipe) {
		return recipeRepository.save(newRecipe);
	}
	
	@GetMapping("/recipes")
	List<Recipe> getAllRecipes(){
		return recipeRepository.findAll();
	}
	
	@GetMapping("/recipe/{id}")
	Recipe getRecipeById(@PathVariable Long id) {
		return recipeRepository.findById(id)
				.orElseThrow(()-> new RecipeNotFoundException(id));
		
	}
	
	@PutMapping("/recipe/{id}")
	Recipe updateRecipe(@RequestBody Recipe newRecipe, @PathVariable Long id) {
		return recipeRepository.findById(id)
				.map(recipe -> {
					recipe.setName(newRecipe.getName());
					recipe.setDescription(newRecipe.getDescription());
					recipe.setPrep_time_in_mins(newRecipe.getPrep_time_in_mins());
					recipe.setCook_time_in_mins(newRecipe.getPrep_time_in_mins());
					recipe.setTotal_time_in_mins(newRecipe.getTotal_time_in_mins());
					recipe.setServings(newRecipe.getServings());
					recipe.setIngredients(newRecipe.getIngredients());
					recipe.setCategory(newRecipe.getCategory());
					recipe.setAuthor(newRecipe.getAuthor());
					recipe.setReference_url(newRecipe.getReference_url());
					return recipeRepository.save(recipe);
				}).orElseThrow(()->new RecipeNotFoundException(id));
	}
	
	@DeleteMapping("/recipe/{id}")
    String deleteRecipe(@PathVariable Long id){
        if(!recipeRepository.existsById(id)){
            throw new RecipeNotFoundException(id);
        }
        recipeRepository.deleteById(id);
        return  "Recipe with id "+id+" has been deleted success.";
    }

}
