
$(document).ready(function(){
    
    
    $("#submit-button").click(function(e){
        var inputdata = document.getElementsByClassName("colinput");
        var status = true;
        // alert(inputdata.length);
        $("#staticBackdrop").modal("hide");
        for(var i =0; i<inputdata.length; i++){
            if(inputdata[i].value===""){
                status =false;
            }
           
        }
        if(status){
            var datacontent = document.getElementsByClassName("datacontent");
            var mLetters = datacontent.length;
            var inputtags;
            // alert(mLetters)
            $("#staticBackdrop").modal("show");
            for(var i = 0; i<mLetters; i++){
                if(i>0){
                var temp = document.getElementById("tempLetters").content;
                // console.log(datacontent[0].getElementsByTagName("input")[0].value);
                var copy = document.importNode(temp, true);
                document.getElementById("caurousel-content").appendChild(copy);
                }
                inputtags = datacontent[i].getElementsByTagName("input");
                console.log(inputtags);
                console.log($(".carousel-item h2.letterHeader>label")[i].innerHTML);
                console.log(inputtags[0].value);

                $(".carousel-item h2.letterHeader>label")[i].innerHTML = inputtags[0].value;
                $(".carousel-item p.lettersubject>label")[i].innerText = inputtags[0].value;

                $(".carousel-item p.letterbody3>label")[i].innerText = inputtags[0].value;
                $(".carousel-item p.lettersignature")[i].innerText =  inputtags[0].value.charAt(0).toUpperCase() + inputtags[0].value.slice(1) + " " +inputtags[1].value;
            }
            e.preventDefault();  
        }   
    })
    $("#button-send").click(function(){
        e.preventDefault(false);
    });
    $("input[name$='radios']").click(function(){
        var test = $(this).val();
        // alert(test);
        $("div.textarea").hide();
        $(".editor" + test).show();
    });

    var mail_form = document.getElementById("form");
    
    if(mail_form){
    mail_form.addEventListener("click", function(e){
        e.preventDefault();
        var datacontent = document.getElementsByClassName("datacontent");
    var mLetters = datacontent.length;
        alert (mLetters);
        var inputtags;
            var firstname;
            var lastname;
            var empID;
            var to_address;
            var mailBody;

            var Mailer = new Array;

        for(var i=0; i<mLetters;i++){
            inputtags = datacontent[i].getElementsByTagName("input");

            firstname = inputtags[0].value;
            lastname = inputtags[1].value;
            empID = inputtags[2].value;
            to_address = inputtags[3].value;
            mailBody = document.getElementsByClassName("editoroption1")[i].innerText;

            Mailer[i] = {firstname,lastname,empID,to_address,mailBody}

        }
        console.log(JSON.stringify(Mailer))
        fetch("http://localhost:8080/api/v1/mailer/sendemail",{
            method:'POST',
            body:JSON.stringify(Mailer),
            headers:{"Content-Type":"application/json; charset=UTF-8"}
        }).then(function(reponse){
            return reponse.json();
        }).then(function(data){
            console.log(data);
        })

        console.log(Mailer);
    })
    
}

});

function datamanupulator(first, last, empid, extra){
    alert(document.querySelectorAll("h2.letterHeader").innerHTML);
    document.getElementsByClassName("letterHeader").innerHTML = document.getElementsByClassName("letterHeader").innerHTML + first;
}


function template1() {
    var employee_containers = document.getElementsByClassName("datacontent");
    // alert(employeeData.length);
    var employee_data = new Array();
    for (var i = 0; i < employee_containers.length; i++) {
        var temp_data = employee_containers[i].getElementsByTagName("input");
        // console.log(temp_data.length);
        employee_data[i] = new Array(temp_data[0].value, temp_data[1].value, temp_data[2].value, temp_data[3].value);
    }
    console.log(employee_data);

}



function mailtrigger(){
    // Element(by.getElementsByTagName("data-bs-target")).innerHTML = "#staticBackdrop";
    $("#staticBackdrop").modal("hide");
    var input_data = document.getElementsByClassName("colinput");
    
    $("#staticBackdrop").modal("show");
   
}

function headerdata(firstname){
    

}

function subjectdata(firstname){
    var data = "Subject: Construction work in my (<b>"+ firstname + "<\/b>) locality during monsoon season causing us difficulties."  
    return data;
}

function bodydata1(){
    var data ="Through the medium of your esteemed and respected daily, I wish to inform the municipal authorities of the difficulties the residents of my locality are facing due to the construction and repair work currently happening in our area. Monsoon season has started a few days ago and is compounding our problems.";
    return data;
}
function bodydata2(){
    var data = "The repair work has been ongoing for five weeks now and is falling way behind schedule. And now with the current weather conditions, we are having persistent problems of water logging and flooding in our area. Another worry is about the accidents that may occur due to the debris lying around the road. Diseases caused due to waterlogging are another one of our concerns."
    return data;
}
function bodydata3(firstname){
    var data = " Therefore I(<b>"+firstname+"<\/b>) wish to draw the attention of the concerned authorities with the help of your newspaper. Hopefully, you will be able to help us in drawing their attention and resolving this matter at the earliest."
    return data;
}

function signaturedata(firstname, lastname){
    var data = firstname + " " + lastname + ".";
    return data;
}

function sendEmail() {
    Email.send({
      Host: "smtp.gmail.com",
      Username: "bibinagarvinaybabu@gmail.com",
      Password: "Imagine143$&+",
      To: 'bibinagarvinaybabu@gmail.com',
      From: "bibinagarvinaybabu@gmail.com",
      Subject: "Sending Email using javascript",
      Body: "Well that was easy!!",
    })
      .then(function (message) {
        alert("mail sent successfully")
      });
  }

