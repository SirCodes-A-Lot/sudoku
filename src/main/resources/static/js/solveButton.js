$(document).ready(function() {
	var solveButton = document.getElementById("solveButton");
	solveButton.addEventListener("click", solveSudoku);
});

var solveSudoku = function() {
	$.ajax({
		type : "POST",
		data : JSON.stringify(getSudokuGridData()),
		contentType : "application/json",
		dataType : "json",
		url : window.location + "solver",
		success : function(result) {
			console.log("result recieved, see below");
			console.log(result);
			setSudokuGridData(result.data.squaresList);
		},
		error : function(e){
			console.log(window.location + "solver");
			console.log("ERROR: ", e);
		}
	});
}

//returns a list of values of the squares in the sudoku board
function getSudokuGridData() {
	console.log("get grid data, see array");
	var squareValues = []
	for (i = 0; i < 81; i++) {
		var square = document.getElementById("square"+i);
		squareValues.push(square.value);
	}
	console.log(squareValues)
	return {"squares": squareValues};
}

// takes a list of square values as strings and sets these in grid in order
function setSudokuGridData(squareValues) {
	console.log("set grid data");
	console.log(squareValues);
	for (i = 0; i < 81; i++) {
		var square = document.getElementById("square"+i);
		square.value = squareValues[i];
	}
}