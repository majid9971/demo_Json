var uploadForm = document.querySelector('#uploadForm');

/*new code */


$(document).ready(function(){
    $('#select1').on('change', function(){
    	var demovalue = $(this).val(); 
    	console.log(demovalue);
        $("div.search").hide();
        $("#div"+demovalue).show();
    });
});


	function uploadSingleFile(file) 
	 {
	    var formData = new FormData();
	    formData.append("file", file);
	    var xhr = new XMLHttpRequest();
	    xhr.open("POST", "/upload");
	     xhr.onload = function() {
	     if(xhr.status==200)
	     {
	      alert("successful");
	     }
	     else{
	      alert("Something went wrong");
	          }
	    }
	    xhr.send(formData);
     }


        function searchFile()
        {
                 var responseText = document.getElementById('responseText');
                 var key1=document.getElementById('myKeyLine').value;
                 var value1=document.getElementById('myValueLine').value;
                  console.log(key1);
                  var xhr=new XMLHttpRequest();
                 var url="http://localhost:8082/getLine?key="+key1+"&value="+value1;
                 console.log(url);
              xhr.open("GET","http://localhost:8082/getLine?key="+key1+"&value="+value1,true);
              xhr.onload = function()
              {
   
                var data=JSON.parse(this.response);
                console.log(data);
                if(!data.length){
                responseText.innerHTML = "No Data Found";
                   }
                else{
                  responseText.innerHTML = data;
                    }
               };
              xhr.send();
        }
        
        
        
          function getJson(){
           var responseText = document.getElementById('responseText');
                 var key1=document.getElementById('myKey').value;
                 var value1=document.getElementById('myValue').value;
                  console.log(key1);
                  var xhr=new XMLHttpRequest();
                 var url="http://localhost:8082/getJson?key="+key1+"&value="+value1;
                 console.log(url);
              xhr.open("GET","http://localhost:8082/getJson?key="+key1+"&value="+value1,true);
              xhr.onload = function()
              {
   
                var data=JSON.parse(this.response);
                console.log(data);
                
                var result=JSON.stringify(data);
                if(!data.length){
                responseText.innerHTML = "No Data Found";
                   }
                else{
                  responseText.innerHTML = result;
                    }
               };
              xhr.send();
          
          
          }
        
           function getJsonTwo(){
           var responseText = document.getElementById('responseText');
                 var key1=document.getElementById('Keys').value;
                 var value1=document.getElementById('Values').value;
                   var key2=document.getElementById('Keys1').value;
                 var value2=document.getElementById('Values1').value;
                  console.log(key1);
                  var xhr=new XMLHttpRequest();
                 var url="http://localhost:8082/getJsonTwo?key="+key1+"&value="+value1+"&key1="+key2+"&value1="+value2;
                 console.log(url);
              xhr.open("GET","http://localhost:8082/getJsonTwo?key="+key1+"&value="+value1+"&key1="+key2+"&value1="+value2,true);
              xhr.onload = function()
              {
   
                var data=JSON.parse(this.response);
                console.log(data);
                
                var result=JSON.stringify(data);
                if(!data.length){
                responseText.innerHTML = "No Data Found";
                   }
                else{
                  responseText.innerHTML = result;
                    }
               };
              xhr.send();
          
          
          }
          
            function getJsonThree(){
           var responseText = document.getElementById('responseText');
                 var key1=document.getElementById('Key').value;
                 var value1=document.getElementById('Value').value;
                   var key2=document.getElementById('Key1').value;
                 var value2=document.getElementById('Value1').value;
                    var key3=document.getElementById('Key2').value;
                 var value3=document.getElementById('Value2').value;
                  console.log(key1);
                  var xhr=new XMLHttpRequest();
                 var url="http://localhost:8082/getJsonThree?key="+key1+"&value="+value1+"&key1="+key2+"&value1="+value2+"&key2="+key3+"&value2="+value3;
                 console.log(url);
              xhr.open("GET","http://localhost:8082/getJsonThree?key="+key1+"&value="+value1+"&key1="+key2+"&value1="+value2+"&key2="+key3+"&value2="+value3,true);
              xhr.onload = function()
              {
   
                var data=JSON.parse(this.response);
                console.log(data);
                
                var result=JSON.stringify(data);
                if(!data.length){
                responseText.innerHTML = "No Data Found";
                   }
                else{
                  responseText.innerHTML = result;
                    }
               };
              xhr.send();
          
          
          }
	
	uploadForm.addEventListener('submit', function(event)
	{
	    var files = singleFileUploadInput.files;
	    if(files.length === 0) {
	        singleFileUploadError.innerHTML = "Please select a file";
	        singleFileUploadError.style.display = "block";
	    }
	    uploadSingleFile(files[0]);
	    
	    event.preventDefault();
	}, true);
	
	searchForm.addEventListener('submit', function(event)
	{
	   searchFile();
	   event.preventDefault();
	}, true);
	
	getJsonForm.addEventListener('submit', function(event)
	{
	   getJson();
	   event.preventDefault();
	}, true);
	
	getJsonTwoForm.addEventListener('submit', function(event)
	{
	   getJsonTwo();
	   event.preventDefault();
	}, true);
	
	getJsonThreeForm.addEventListener('submit', function(event)
	{
	   getJsonThree();
	   event.preventDefault();
	}, true);
	

	
	
	