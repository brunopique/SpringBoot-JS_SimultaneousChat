user = JSON.parse(sessionStorage.getItem('user'));
document.querySelector("#customHello").innerHTML = `¡Welcome to the chat, ${user.name}!`;
let textArea = document.querySelector("#textArea");
let funMode = false;
document.querySelector("#funModeToggle").addEventListener('click', () => funMode = !funMode);

function createMessage(message) {
    if (!funMode) {
        message = `<strong>${user.name}:</strong> ${message} <br/>`
        postMessage(message);
        textArea.value = '';
    } else {
        getFunMessage();
    }
}

function postMessage(message) {
    fetch('/channels/1', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: message
    })
        .catch(err => console.log(`Error posting message: ${err}`))
}

setInterval(function getMessages() {
    fetch('/getMessages', {
        method: 'GET',
    }).then((responseEntity) =>  responseEntity.text())
        .then((messages) => {
            document.querySelector("#chat").innerHTML = messages;
        })
        .catch(err => console.log(`Error fetching messages: ${err}`))
}, 500);

function getFunMessage() {
    fetch('https://cors-anywhere.herokuapp.com/https://insult.mattbas.org/api/insult', {
        method: 'GET',
    }).then((responseEntity) =>  responseEntity.text())
        .then((funMessage) => {
            funMessage = `<strong>${user.name}:</strong> ${funMessage}. <br/>`
            postMessage(funMessage);
            textArea.value = '';
        })
        .catch(err => console.log(`Error fetching fun message: ${err}`));
}