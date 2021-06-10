function getSogne() {
    console.log("GET sogn");
    $.ajax({
        url:"/sogn",
        type:"GET",
        contentType:"application/JSON",
        success:function (data) {
            $.each(data, function (index, item) {
                $("#sognList").append("<tr>" +
                    "<td>" + item.id + "</td>" +
                    "<td>" + item.navn + "</td>" +
                    "<td>" + item.smitteniveau + "</td>" +
                    "<td>" + item.nedlukningStart +
                    "</td>"+"<td>1</td>"+"</tr>")
            })
            $("#status").html("Svar fra server OK");
        },
        error:function (data) {
            $("#status").html("Svar fra server ERROR");
        }
    });
}

function getKommuner() {
    console.log("GET kommune");
    $.ajax({
        url:"/kommune",
        type:"GET",
        contentType:"application/JSON",
        success:function (data) {
            $.each(data, function (index, item) {
                $("#kommuneList").append("<tr>" + "<td>" + item.id + "</td>" + "<td>" + item.navn +"</tr>")
            })
            $("#status").html("Svar fra server OK");
        },
        error:function (data) {
            $("#status").html("Svar fra server ERROR");
        }
    });
}