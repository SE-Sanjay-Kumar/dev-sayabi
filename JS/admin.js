let signinBtn = document.querySelector("#sign-in");
const signin = async ()=>{
    let name = document.getElementById("lusername").value;
    let pass = document.getElementById("lpassword").value;
    const resp = await fetch('http://localhost:9999/admin/auth', {
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
        window.location.href = "http://127.0.0.1:5500/HTML/dashboard.html";
    }else {
          alert("login failed");
    }
    
}

signinBtn.addEventListener('click',signin);