$(document).ready(function() {
	var grid = document.getElementById("sudokuGrid");
	populateGrid(grid);
});

function populateGrid(grid) {
    for (var i = 0; i < 9; i++) {
    	var row = document.createElement('div');
    	row.className = "row";
        for (var j = 0; j < 9; j++) {
            var square = document.createElement("input");
            square.type = "text";
            square.maxLength = "1";
            square.setAttribute("row", i);
            square.setAttribute("col", j);
            square.className = "square";
            row.appendChild(square);
        }
    grid.appendChild(row);
    }
}