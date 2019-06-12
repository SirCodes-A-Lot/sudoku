$(document).ready(function() {
	var grid = document.getElementById("sudokuGrid");
	populateGrid(grid);
});

function populateGrid(grid) {
	var count = 0;
    for (var i = 0; i < 9; i++) {
    	var row = document.createElement('div');
    	row.className = "row";
        for (var j = 0; j < 9; j++) {
            var square = document.createElement("input");
            square.type = "text";
            square.maxLength = "1";
            square.className = "square";
            if (j == 2 || j == 5) {
            	square.className += " rightBorder"
            }
            if (i == 2 || i == 5) {
            	square.className += " bottomBorder"
            }
            square.id = "square" + count;
            row.appendChild(square);
            count +=1;
        }
    grid.appendChild(row);
    }
}