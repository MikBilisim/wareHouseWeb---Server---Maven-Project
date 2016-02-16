
	window.onload = function() {		
		 LoadJson();
		};
	
		function LoadJson() {
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
			var flickerAPI = "http://localhost:8080/wareHouseWeb/rest/allTransactionsWebService/allTransactions";
			  $.getJSON( flickerAPI, {
			    format: "json"
			  })
			    .done(function( data ) {
			    	
			    	 for(i = 0; i < data.length; i++) {
			    		 
			    
			    		 
			    		 dataFiled+="<tr align='center' > <td> "+data[i].id+" </td> "
			    		 		  +"<td> "+data[i].productGroup+" </td> "
			    		 		  +"<td> <div>  <pre style='margin:0; overflow:scroll; width: 100px'>"+data[i].productName+"  </pre></div> </td> "
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
			LoadJson();
		}
		