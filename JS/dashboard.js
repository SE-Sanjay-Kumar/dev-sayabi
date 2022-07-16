const accessData = async ()=>{
    const resp = await fetch("http://localhost:9999/orders");
    let data = await resp.text();
    let parsedData = JSON.parse(data);
    for (let i=0;i<parsedData.length;i++){
        if (parsedData[i]["status"]===false){
            parsedData[i]["status"]="pending";
        }
        parsedData[i]["username"] = parsedData[i]["client"]["username"];
    }
    return parsedData;
}
$(document).ready(async function () {
    
    mydata = await accessData();;
    $('table').bootstrapTable({
        data: mydata
    })
    
    $('#logout').on('click', function (e) {
        
        window.location.href = "http://127.0.0.1:5500/HTML/index.html";
    });


});



    
