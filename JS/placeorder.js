orderBtn = document.getElementById("add_order");

const addOrder = async()=>{
    let oname = document.getElementById("order_name").value;
    let odescription = document.getElementById("description").value;
    let ocategory = document.querySelector('input[name="category"]:checked').value;
    let odeadline = document.getElementById("dealine").value;
    let oprice = document.getElementById("price").value;
    let ostatus = 0;
    let clientid = sessionStorage.getItem("id");
    const resp = await fetch(`http://localhost:9999/clients/${clientid}/orders`, {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
         
            name: oname,
            deadline: odeadline,
            category: ocategory,
            description: odescription,
            status: ostatus,
            price: oprice
        })
    })
    if (resp.ok){
        alert("Order is placed");
    }else {
        alert("Order is not placed");
    }
}

orderBtn.addEventListener('click',addOrder);