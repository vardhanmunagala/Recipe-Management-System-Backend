package com.example.fullstack_backend.exception;

public class RecipeNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecipeNotFoundException(Long id) {
		super("Could not found the recipe with id" + id);
	}
}
