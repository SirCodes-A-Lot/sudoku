$(document).ready(function() {
	var solveButton = document.getElementById("solveButton");
	solveButton.addEventListener("click", solveSudoku);
});

var solveSudoku = function(){
	console.log("solved");
	
	var sudokuData = getSudokuGridData();
	
	$.ajax({
		type : "POST",
		data : sudokuData,
		url : window.location + "/solver",
		success : function(result){
			console.log(result)
		},
		error : function(e){
			console.log(window.location+ "/solver");
			console.log("ERROR: ", e);
		}
	});
}