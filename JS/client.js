let signupBtn = document.querySelector("#sign-up");
let signinBtn = document.querySelector("#sign-in");
const signup = async  ()=>{
    
    let name = document.getElementById("rusername").value;
    let pass = document.getElementById("rpassword").value;
    
    let resp = await fetch('http://localhost:9999/clients', {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: name,
            password: pass
        })
    })
    if (resp.ok){
        window.location.href = "http://127.0.0.1:5500/HTML/clientlogin.html";
    }else {
        alert("This username is already used");
    }

}
const signin = async ()=>{
    let name = document.getElementById("lusername").value;
    let pass = document.getElementById("lpassword").value;
    const resp = await fetch('http://localhost:9999/clients/auth', {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: name,
            password: pass
        })
    })
    if (resp.ok){
        
        let data = await resp.text();
        console.log(data);
        sessionStorage.setItem("id", data);
        setTimeout(() => {
            
        window.location.href = "http://127.0.0.1:5500/HTML/order.html";
        }, 1000);
        
    
    }else {
          alert("login failed");
    }
    
}
$(document).ready( function () {
    
    
    $('#logout').on('click', function (e) {
        
        window.location.href = "http://127.0.0.1:5500/HTML/index.html";
    });


});
signupBtn.addEventListener('click',signup);
signinBtn.addEventListener('click',signin);