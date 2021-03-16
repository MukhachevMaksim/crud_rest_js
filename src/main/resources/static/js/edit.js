document.getElementById("editForm").addEventListener("submit", editPost)

function editPost(e){
    e.preventDefault();

    let id = document.getElementById("idEdit").value;
    let firstName = document.getElementById("firstNameEdit").value;
    let lastName = document.getElementById("lastNameEdit").value;
    let age = document.getElementById("ageEdit").value;
    let email = document.getElementById("emailEdit").value;
    let password = document.getElementById("passwordEdit").value;
    let roles = setRoles(Array.from(document.getElementById("roleEdit").selectedOptions)
        .map(option => option.value));

    fetch(
        '/admin/' + id,
        {
            method: 'PATCH',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "firstName": firstName,
                "lastName": lastName,
                "age": age,
                "email": email,
                "password": password,
                "roles": roles
            })
        }
    ).finally(() => {
        $('#modalEdit').modal("hide")
        getAllUsers();
    })
}