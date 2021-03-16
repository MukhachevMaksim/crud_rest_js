document.getElementById("deleteForm").addEventListener("submit", deletePost)

function deletePost(e){
    e.preventDefault();

    let id = document.getElementById("idDel").value;

    fetch("http://localhost:8080/admin/" + id, { method:"DELETE"})
        .finally(() => {
        $('#modalDelete').modal("hide")
        getAllUsers();
    })
}