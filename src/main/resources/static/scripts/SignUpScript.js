let socket = new WebSocket("ws://localhost:8080/chess");
document.querySelector(".form").addEventListener("submit", SignUp)
let name;

socket.onmessage = function (event)
{
    let output = JSON.parse(event.data);
    if (output < 0)
    {
        document.getElementById("warning").innerText = "Користувач із таким іменем уже існує.";
    }
    else if (output > 0)
    {
        document.getElementById("warning").innerText = "Реєстрація успішна.";
        localStorage.setItem("username", name);
        window.location.href = '/index.html';
    }
    else
    {
        document.getElementById("warning").innerText = "Виникла помилка. Спробуйте, будь ласка, пізніше.";
    }
}

function SignUp(event)
{
    event.preventDefault();
    name = document.getElementById("name").value;
    let password = document.getElementById("password").value;
    let passwordAgain = document.getElementById("password_again").value;

    if (name === "" || password === "" || passwordAgain === "")
    {
        document.getElementById("warning").innerText = "Заповніть усі поля.";
    }
    else if (password !== passwordAgain)
    {
        document.getElementById("warning").innerText = "Паролі не збігаються";
    }
    else
    {
        let message = JSON.stringify({Type: "SignUp", Name: name, Password: password});
        socket.send(message);
    }
}