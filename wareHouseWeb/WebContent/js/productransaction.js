
	
	var param1var;
	window.onload = function() {
		param1var = getQueryVariable("name");
		 LoadJson(param1var);
		};
		
		
		
		//var param1var = getQueryVariable("name");

		function getQueryVariable(variable) {
		  var query = window.location.search.substring(1);
		  var vars = query.split("&");
		  for (var i=0;i<vars.length;i++) {
		    var pair = vars[i].split("=");
		    if (pair[0] == variable) {
		      return pair[1];
		    }
		  } 
		  alert('Query Variable ' + variable + ' not found');
		}
	
		function LoadJson(variable) {
			var chartVariables2 = []
			chartVariables=chartVariables2;
			 var dataFiled="<table id='t01' border='5' align=center'>";
				dataFiled+="<tr align='center'> "
						+ "<th>ID </th>"
						+ "<th>Product Group </th>"
						+ "<th>Product Name</th>"
						+ "<th>Transaciton</th>"
						+ "<th>Date</th>"
						+ "<th>Actions</th>"
						+ "</tr>";
			var i;
			var flickerAPI = "http://localhost:8080/wareHouseWeb/rest/allTransactionsWebService/"+variable;
			  $.getJSON( flickerAPI, {
			    format: "json"
			  })
			    .done(function( data ) {
			    	
			    	 for(i = 0; i < data.length; i++) {
			    		 
			    		 dataFiled+="<tr align='center' > <td> "+data[i].id+" </td> "
			    		 		  +"<td> "+data[i].productGroup+" </td> "
			    		 		  +"<td> "+data[i].productName+" </td> "
			    		 		  +"<td> "+data[i].transaction+" </td> "
			    		 		  +"<td> "+data[i].date+" </td> "
			    		 		  +"<td> <input type='button' value='Delete' id='"+data[i].id+"' onclick='deleteProduct(this.id)'> </td> "
			    		 		  +"</tr>";
			    		 		
			    	 }
			 	    dataFiled+="</table>";
	
				  document.getElementById("transactions_Table").innerHTML = dataFiled;
			    
			    });
		}
		
		function deleteProduct(clicked_id){
			var message = allTransactionsWebService.deleteService({id:clicked_id });
			LoadJson(param1var);
		}
		