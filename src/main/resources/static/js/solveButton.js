$(document).ready(function() {
	var solveButton = document.getElementById("solveButton");
	solveButton.addEventListener("click", solveSudoku);
});

var solveSudoku = function() {
	console.log("solved");
	
	$.ajax({
		type : "POST",
		data : JSON.stringify(getSudokuGridData()),
		contentType : "application/json",
		dataType : 'json',
		url : window.location + "solver",
		success : function(result) {
			console.log(result)
		},
		error : function(e){
			console.log(window.location+ "solver");
			console.log("ERROR: ", e);
		}
	});
}

function getSudokuGridData() {
	console.log("get grid data");
	var squareValues = []
	for (i = 0; i < 81; i++) {
		var square = document.getElementById("square"+i);
		squareValues.push(square.value);
	}
	console.log(squareValues)
	return {"squares": squareValues};
}