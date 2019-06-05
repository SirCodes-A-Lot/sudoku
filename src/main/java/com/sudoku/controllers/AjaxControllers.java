package com.sudoku.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudoku.services.RecursiveSolverService;

@RestController
public class AjaxControllers {
	
	private RecursiveSolverService recursiveSolverService;
	
	@Autowired
	public AjaxControllers (RecursiveSolverService recursiveSolverService) {
		this.recursiveSolverService = recursiveSolverService;
	}
	
    @SuppressWarnings("unchecked")
	@PostMapping(value = "/solver")
    public Response solveSudokuApi(@RequestBody HashMap<String,Object> data) {
    	System.out.println("data recieved from post request");
    	System.out.println(data);
    	HashMap<String, Object> responseData = new HashMap<>();
    	ArrayList<String> solvedSquareList = recursiveSolverService.solveBoardFromStringArray((ArrayList<String>) data.get("squares"));
    	responseData.put("squaresList", solvedSquareList);
    	return new Response("200", responseData);
    }
}
