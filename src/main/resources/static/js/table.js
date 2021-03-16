getAllUsers()

function getAllUsers() {
    $.ajax({
        url: "/admin/users",
        method: "GET",
        success: function (data) {
            let output ="";
            for (let i = 0; i < data.length; i++) {
                let user = data[i];
                let userRoles = "";
                for (let j = 0; j < user.roles.length; j++) {
                    userRoles += `${user.roles[j].role} `;
                }
                output += `
                <tr>
                    <td>${user.id}</td>
                    <td id="firstName${user.id}">${user.firstName}</td>
                    <td id="lastName${user.id}">${user.lastName}</td>
                    <td id="age${user.id}">${user.age}</td>
                    <td id="email${user.id}">${user.email}</td>
                    <td id="password${user.id}" style="display:none;">${user.password}</td>
                    <td id="role${user.id}">${userRoles}</td>
                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#modalEdit" onclick="openModalWindow(${user.id})">Edit</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger" data-toggle="modal"
                                    data-target="#modalDelete" onclick="openModalWindowDel(${user.id})">Delete</button>
                    </td>
                </tr>
                `;
            }

            document.getElementById("usersTableBody").innerHTML = output;
        }
    })
}

function openModalWindow(id) {
    document.getElementById("idEdit").value = id;
    document.getElementById("firstNameEdit").value = $("#firstName" + id).text();
    document.getElementById("lastNameEdit").value = $("#lastName" + id).text();
    document.getElementById("ageEdit").value = $("#age" + id).text();
    document.getElementById("emailEdit").value = $("#email" + id).text();
    document.getElementById("passwordEdit").value = $("#password" + id).text();
}

function openModalWindowDel(id) {
    document.getElementById("idDel").value = id;
    document.getElementById("firstNameDel").value = $("#firstName" + id).text();
    document.getElementById("lastNameDel").value = $("#lastName" + id).text();
    document.getElementById("ageDel").value = $("#age" + id).text();
    document.getElementById("emailDel").value = $("#email" + id).text();
    document.getElementById("roleDel").selectedOptions = "ROLE_ADMIN";

}