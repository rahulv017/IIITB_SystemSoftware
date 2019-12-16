
var api = "webapi/Specilisation/view/all";
$.get(api, function (student, status) {

    if (status == "success") {
        console.log(student);
        
        $.getJSON("url_with_json_here", function(data){
            $.each(data, function (index, value) {
                console.log(value);
            });
        });

    }

});


$(document).ready(function(){
  // $("#update-specialization-container").hide();
  // $("#create-specialization-container").hide();

  view_spec();

  hide_everyThing();
  $("#cardview").show();

  $("#create-specialization-button-main").click(function(){
  // $("#cardview").hide();
  //  $("#update-specialization-container").hide();
  hide_everyThing();

  $("#create-specialization-container").show();
});


  $("#view-specialization-button-main").click(function(){
 
  $("#create-specialization-container").hide();
    $("#update-specialization-container").hide();

    $("#cardview").show();

});

  

$("#update2").click(function(){
  	   hide_everyThing();
  	  $("#update-specialization-container").show();


  });

// $("#update3").click(function(){
//   	   $("#cardview").hide();
//   	  $("#update-specialization-container").show();


//   });
// $("#update1").click(update);	

// });

// function update(){
//   	   $("#cardview").hide();
//   	  $("#update-specialization-container").show();
// }

// $("#c_specialization_button").click(function(){
//   	  var 

//   });

});
  

function hide_everyThing(){
	$("#update-specialization-container").hide();
  $("#create-specialization-container").hide();
   $("#cardview").hide();

}

// var all_specializations;
function view_spec() {
    // $.ajax({
    //     url: "webapi/Specilisation/view/all",
    //     context: document.body
    // }).done(function() {
    //     console.log("absdkjasndsa");
    // });





}
// function view_spec() {
//     hide_everyThing();
//     $("#cardview").show();
//     $("#specialization_list a").remove();
//     // document.getElementById('specialization_search_id').value = null;
//     $.ajax({
//         url: "webapi/specialization"
//     }).done(function(specializations) {
//         all_specializations = specializations;
//         $.each(specializations, function(index, result) {
//             // var div_html = '<a onclick="show_specialization('+
//             //     result.id+')" class="list-group-item list-group-item-action"><div class="d-flex w-100 justify-content-between">'+
//             //     '<h5 class="mb-1" style="font-size: 1.00rem;">'+result.name+'</h5><small class="text-muted">'+result.code+'</small></div>'+
//             //     '<p class="mb-1" style="font-size: 0.75rem;">Coordinated by - '+result.faculty.name+'</p></a>';
//             // $("#specialization_list").append(div_html);

//             var k='<div class="col-md-4" > <div class="card mb-4 '+
//             'shadow-sm"><img src="4.jpg " height="225px" width="100%" >'+
//             '<div class="card-body"><B><p class="card-text" style>'+System and Computer science+
//             '</p></B><p class="card-text">'+CS 511+'</p><div class="d-flex justify-content-between'+
//             'align-items-center"><div class="btn-group"><button type="button" class="btn btn-primary"'+
//             ' id="update1" style="background-color: DarkSlateGray">Update</button><button '+
//             'type="button" class="btn btn-danger">Delete</button></div><small class="text-muted">'+
//             '9 mins</small></div></div></div></div>';
//             $("#cardview").append(k);
//         });
//     }).fail(function (error) {
//         console.log(error);
//     });
// }




