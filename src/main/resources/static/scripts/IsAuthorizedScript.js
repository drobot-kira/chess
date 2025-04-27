const username = localStorage.getItem("username");
if (username === null)
{
    window.location.replace('/chess/authorization/index.html');
}