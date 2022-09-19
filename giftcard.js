$(function() {
    $("#orderButton").click(function() {
        $("#orderModal").modal("show");
     });
    $("#loginButton").click(function() {
        $("#loginModal").modal("show");
    });
});

let content = document.getElementById("content");
let loadButton = document.getElementById("loadButton");
let nameInput = document.getElementById("nameInput");
//let idInput = document.getElementById("idInput");
//let descriptionInput = document.getElementById("descriptionInput");
//let urlInput = document.getElementById("urlInput");
let submitButton = document.getElementById("submitButton");

loadButton.addEventListener("click", apiGetGiftcards);
submitButton.addEventListener("click", apiPostGiftcard);

async function apiGetGiftcards(){
    console.log("button clicked");
    let response = await fetch("http://localhost:9000/giftcards");
    response = await response.json();
    loadGiftcards(response);
}
async function loadGiftcards(response){
    content.innerHTML = "";
    console.log(response)
    let giftcardCard = document.createElement("ul");
    
    for(let i = 0; i < response.length; i++){
        let giftcardName = document.createElement("li");
        giftcardName.innerText = response[i].name;
        giftcardCard.appendChild(giftcardName);
    }
    content.appendChild(giftcardCard);
}
async function apiPostGiftcard(){
    let inputGiftcard = {
        name:nameInput.value,
    //giftID:idInput.value,
    //description:descriptionInput.value,
    //url:urlInput.value
    }
    let response = await fetch("http://localhost:9000/giftcards", {
        method:'POST',
        mode:'cors',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(inputGiftcard)
    });
    apiGetGiftcards();
}