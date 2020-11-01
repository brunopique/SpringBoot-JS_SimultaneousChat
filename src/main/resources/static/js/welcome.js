if (sessionStorage.getItem('user') == null) {
    createNewUser();
} else {
    user = JSON.parse(sessionStorage.getItem('user'));
    document.querySelector("#customHello").innerHTML = `¡Welcome back, ${user.name}!`;
}

function createNewUser() {
    let name = prompt(`Write your name:`);
    saveUser(name);
}

function saveUser(name) {
    fetch('/welcome', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: name
    }).then((responseEntity) => responseEntity.json())
        .then((savedUser) => {
            sessionStorage.setItem('user', JSON.stringify(savedUser));
        })
        .catch(err => console.log(`Error saving user: ${err}`));
}

