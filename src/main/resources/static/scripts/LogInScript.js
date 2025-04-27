let socket = new WebSocket("ws://localhost:8080/chess");
document.querySelector(".form").addEventListener("submit", LogIn)

socket.onmessage = function (event)
{
    let output = JSON.parse(event.data);
    if (output < 0)
    {
        document.getElementById("warning").innerText = "Неправильне ім'я користувача або пароль.";
    }
    else if (output > 0)
    {
        document.getElementById("warning").innerText = "Вхід успішний.";
    }
    else
    {
        document.getElementById("warning").innerText = "Виникла помилка. Спробуйте, будь ласка, пізніше.";
    }
}

function LogIn(event)
{
    event.preventDefault();
    let name = document.getElementById("name").value;
    let password = document.getElementById("password").value;

    if (name === "" || password === "")
    {
        document.getElementById("warning").innerText = "Заповніть обидва поля.";
    }
    else
    {
        let message = JSON.stringify({Type: "LogIn", Name: name, Password: password});
        socket.send(message);
    }
}