
	window.onload = function() {
		LoadJson();
		};
	
	var dbName="liquid_tanks";
	var chartVariables = [];
	
	
	function formController() {

	
		
		
		var nameF = document.getElementById("name").value;
		var amountF = document.getElementById("amount").value;
		
		var message = wareHouseWebService.formController({dbName:dbName , name:nameF   ,  amount:amountF });
		
		document.getElementById("name").value="";
		document.getElementById("amount").value="";
		
		document.getElementById("message").innerHTML = "<h2>" + message + "</h2>";
		
		LoadJson();
		
		//alert(verilecekMesaj);
		
	}
	
	
	function LoadJson() {
		var chartVariables2 = []
		chartVariables=chartVariables2;
		 var dataFiled="<table id='t01' border='5' align=center'>";
			dataFiled+="<tr align='center'> "
					+ "<th>Name </th>"
					+ "<th>Amount </th>"
					+ "<th>Action Buttons</th>"
					+ "</tr>";
		var i;
		var index = 10 ;
		var flickerAPI = "http://localhost:8080/wareHouseWeb/rest/wareHouseWebService/allProductsLiquidTanks";
		  $.getJSON( flickerAPI, {
		    format: "json"
		  })
		    .done(function( data ) {
		    	
		    	 for(i = 0; i < data.length; i++) {
		    		 //load chart
		    		 chartVariables.push( { x:index, y:data[i].amount, label:data[i].name});
		    		 
		    		 
		 	    	dataFiled+="<tr align='center' > <td> "+data[i].name+" </td> ";
		 			dataFiled+=" <td> <label id='label"+data[i].id+"'>"+data[i].amount+" </label></td>";
		 			dataFiled+=" <td> <input type='button' value='Show Transaction' id='"+data[i].id+"' onclick=window.location.href='http://localhost:8080/wareHouseWeb/productTransactions.jsp?name="+data[i].name+"'> "
		 			+ "<input type='button' value='Delete' id='"+data[i].id+"' onclick='deleteProduct(this.id)'> "
		 			+"</td>  </tr>"
		 			+"<tr align='center'><td colspan=2> <input type='text' name='sum'  id='sum"+data[i].id+"' value='' onkeypress='return event.charCode >= 48 && event.charCode <= 57'> </td>"
		 			+"<td>"
		 			+"<input type='button' value='Addition' id='"+data[i].id+"' onclick='addition(this.id)'> "
		 			+"<input type='button' value='Subtraction' id='"+data[i].id+"' onclick='subtraction(this.id)'>"
		 			+"</td>  </tr>";
		 	    index+=10;
		    	 }
		 	    dataFiled+="</table>";
		    	 
			//alert(data.length+dataFiled) 
			chartShow();
			  document.getElementById("allProducts").innerHTML = dataFiled;
		    
		    });
		  
		
	}
	
	
	
function chartShow() {
		
		
		var chart;
	    chart = new CanvasJS.Chart("chartContainer",
	    {
	      title:{
	        text: "Liquid Tanks Statics"
	      },
			axisY: {
				labelFontSize: 20,
				labelFontColor: "dimGrey"
			},
			axisX: {
				labelAngle: -30
			},
	      data: [

	      {type: "column",
	        dataPoints:chartVariables
	      }
	      ]
	    });

	    chart.render();
	  }

function deleteProduct(clicked_id){
	//deleteService
	var message = wareHouseWebService.deleteService({dbName:dbName , id:clicked_id });
	
	document.getElementById("message").innerHTML = "<h2>" + message + "</h2>";
	
	LoadJson();
}
	
function addition(clicked_id){
	var amount = parseInt(document.getElementById("label"+clicked_id).textContent);
	//alert(nameF);sum
	var sum = parseInt(document.getElementById("sum"+clicked_id).value);
	if(sum){
	var amountnew = parseInt(amount+sum);
	
	var message = wareHouseWebService.updateService({dbName:dbName , id:clicked_id,amount:amountnew });
	
	document.getElementById("message").innerHTML = "<h2>" + message + "</h2>";
	
	LoadJson();
	}else{
		alert("empty amount");
	}
	
}

function subtraction(clicked_id){
	var amount = parseInt(document.getElementById("label"+clicked_id).textContent);
	//alert(nameF);sum
	var sum = parseInt(document.getElementById("sum"+clicked_id).value);
	var amountnew = parseInt(amount-sum);
	
	if(sum && amountnew >= 0){
	
	var message = wareHouseWebService.updateService({dbName:dbName , id:clicked_id,amount:amountnew });
	
	document.getElementById("message").innerHTML = "<h2>" + message + "</h2>";
	
	LoadJson();
	} else {
		alert("empty or insufficient amount");
	}
}

	