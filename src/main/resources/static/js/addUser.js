document.getElementById("newUserForm").addEventListener("submit", addNewUser);

function addNewUser(e){
    e.preventDefault();

    let firstName = document.getElementById("firstNameNew").value;
    let lastName = document.getElementById("lastNameNew").value;
    let age = document.getElementById("ageNew").value;
    let email = document.getElementById("emailNew").value;
    let password = document.getElementById("passwordNew").value;
    let roles = setRoles(Array.from(document.getElementById("roleNew").selectedOptions)
        .map(option => option.value));

    fetch("http://localhost:8080/admin", {
        method: "POST",
        headers: {
            "Accept": "application/json, text/plain, */*",
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            firstName: firstName,
            lastName: lastName,
            age: age,
            email: email,
            password: password,
            roles: roles
        })
    })
        .finally(() => {
            document.getElementById("usersTablePage").click();
            getAllUsers();
            document.getElementById("newUserForm").reset();
        })
}

function setRoles(someRoles) {
    let roles = [];
    if (someRoles.indexOf("ROLE_USER") >= 0) {
        roles.push({"id": 1, "role": "ROLE_USER"});
    }
    if (someRoles.indexOf("ROLE_ADMIN") >= 0) {
        roles.push({"id": 2, "role": "ROLE_ADMIN"});
    }
    return roles;
}