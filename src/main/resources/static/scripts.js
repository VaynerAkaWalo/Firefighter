const grid = document.getElementById("wrapper")
let size = 0
let board
let firefighter

function getSize() {
    fetch("/firefighter/boardSize").then(response => {
        if(response.ok)
            return response.text().then( data => {
                size = parseInt(data);
                board = Array.from(Array(size), () => new Array(size))
                grid.style.gridTemplateColumns = ((500/size).toString() + "px ").repeat(size)
                grid.style.gridTemplateRows = ((500/size).toString() + "px ").repeat(size)
                grid.style.height = (size * 10).toString();
                grid.style.width = (size * 10).toString();
                generateCells(size)
            })
    })
}

function generateCells(number) {
    for(let i = 0; i < number; i++) {
        for (let j = 0; j < number; j++) {
            let newCell = document.createElement("div")
            board[i][j] = newCell;
            grid.appendChild(newCell).className = "cell"
        }
    }
    update()
}

function update() {
    fetch("/firefighter/board").then(response => {
        if(response.ok)
            return response.text().then( data => {
            let obj = JSON.parse(data)
            updateColors(obj)
        })
    })
}

function updateColors(status) {
    for (let i = 0; i < size; i++) {
        for (let j = 0; j < size; j++) {
            if (status[i][j] == true)
                board[i][j].style.background = 'red'
            else
                board[i][j].style.background = 'green'
        }
    }
}

function resetBoard() {
    fetch("/firefighter/reset")
}

function randomFirefighter() {
    document.getElementById("stopRandomFirefighter").disabled = false;
    document.getElementById("randomFirefighter").disabled = true;

    firefighter = setInterval(() => {
        let x = Math.floor(Math.random() * size + 1)
        let y = Math.floor(Math.random() * size + 1)

        fetch("firefighter/extinguish?x=" + x + "&y=" + y);
    },25);
}

function stopRandomFirefighter() {
    clearInterval(firefighter);
    document.getElementById("stopRandomFirefighter").disabled = true;
    document.getElementById("randomFirefighter").disabled = false;
}

document.getElementById("extinguish-input").setAttribute("value", `${window.location.host}/firefighter/extinguish?x=#&y=#`)
document.getElementById("board-input").setAttribute("value", `${window.location.host}/firefighter/board`)
getSize()
setInterval(update, 500)