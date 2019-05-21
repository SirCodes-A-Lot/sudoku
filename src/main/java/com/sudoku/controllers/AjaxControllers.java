package com.sudoku.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxControllers {
	
    @PostMapping(value = "/solver")
    public Response solveSudokuApi(@RequestBody HashMap<String,Object> data) {
    	System.out.println(data);
    	HashMap<String, Object> responseData = new HashMap<>();
    	return new Response("200", responseData);
    }
}
