<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Example Source Mustafa Ilhan KYAZIM</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="styles.css" rel="stylesheet" type="text/css" media="screen" />
<script lang="javascript" src="./rest-js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script> 
<script type="text/javascript" src="js/tanks.js"></script> 
<script type="text/javascript" src="js/jquery.canvasjs.min.js"></script> 
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
 
</head>
<body>
<div id="content">
<div id="back">
<!-- header begins -->
<div id="header"> 
	<div id="logo">
		
	</div>
  <div id="menu">
		<ul>
		
			<li id="button1"><a href="http://localhost:8080/wareHouseWeb/index.jsp"  title="">Home</a></li>
			<li id="button2"><a href="http://localhost:8080/wareHouseWeb/silos.jsp" title="">Silos</a></li>
			<li id="button3"><a href="#" title=""><u>Tanks</u></a></li>
			<li id="button4"><a href="http://localhost:8080/wareHouseWeb/transaction.jsp" title="">Transactions</a></li>
			<li id="button5"><a href="#" title="">About</a></li>
			
		</ul>
  </div>
</div>

<!-- header ends -->
<!-- content begins -->
 <div id="main">
	<div id="right">	
		  			
			<h3>Nunc pellentesque</h3>
			<div class="title_back">	
			<ul>
					<li class="sub"><a href="#">Vivamus id arcu</a></li>
					<li class="sub"><a href="#">Duis congue ultricies</a></li>
					<li class="sub"><a href="#">Purus in mollis purus</a></li>
					<li class="sub"><a href="#">Orci nonummy fringilla</a></li>
					<li class="sub"><a href="#">Pellentesque at lorem</a></li>			
	        </ul>
		    </div>
			<h3>Company News</h3>
			<div class="title_back">
			<ul>
			  <li>
				  <h4>February 6, 2016</h4>
				  <p><a href="#"> Duis tempor posuere diam. Suspendisse vel tellus quis nunc malesuada porta. &#8230;</a></p></li>
				   <li>
				  <h4>February 12, 2016</h4>
				  <p><a href="#">Tempus Duis tempor posuere diam. Suspendisse vel tellus quis nunc malesuada porta. &#8230;</a></p></li>
				  </ul>
		  </div>
			<h3>Calendar</h3>
			<div class="title_back">
				<div id="calendar">
					<table id="calendar2" summary="Calendar">
						<caption>
						January 2016
						</caption>
						<thead>
							<tr>
								<th abbr="Monday" scope="col" title="Monday">M</th>
								<th abbr="Tuesday" scope="col" title="Tuesday">T</th>
								<th abbr="Wednesday" scope="col" title="Wednesday">W</th>
								<th abbr="Thursday" scope="col" title="Thursday">T</th>
								<th abbr="Friday" scope="col" title="Friday">F</th>
								<th abbr="Saturday" scope="col" title="Saturday">S</th>
								<th abbr="Sunday" scope="col" title="Sunday">S</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td abbr="Des" colspan="3" id="prev"><a href="#">&laquo; Des</a></td>
								<td class="pad">&nbsp;</td>
								<td abbr="Feb" colspan="3" id="next" class="pad"><a href="#">Feb &raquo;</a></td>
							</tr>
						</tfoot>
						<tbody>
							<tr>
								<td colspan="2" class="pad">&nbsp;</td>
								<td>1</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
								<td>5</td>
							</tr>
							<tr>
								<td>6</td>
								<td>7</td>
								<td>8</td>
								<td>9</td>
								<td>10</td>
								<td>11</td>
								<td>12</td>
							</tr>
							<tr>
								<td>13</td>
								<td>14</td>
								<td>15</td>
								<td>16</td>
								<td>17</td>
								<td>18</td>
								<td>19</td>
							</tr>
							<tr>
								<td>20</td>
								<td id="now">21</td>
								<td>22</td>
								<td>23</td>
								<td>24</td>
								<td>25</td>
								<td>26</td>
							</tr>
							<tr>
								<td>27</td>
								<td>28</td>
								<td>29</td>
								<td>30</td>
								<td>31</td>
								<td class="pad" colspan="2">&nbsp;</td>
							</tr>
						</tbody>
					</table>
				</div>
		 </div>
	 
	</div>
	<div id="left">		
	
	
	
	
	
	<form action="silos.jsp" method="post">
<fieldset>
  <legend>Add Product:</legend>
		<table>
			<tr> <td>Name :</td>     <td> <input type="text" name="name"  id="name" value=""> </td>  </tr>
		    <tr> <td>Amount :</td>     <td> <input type="text" name="amount"  id="amount" value="" onkeypress='return event.charCode >= 48 && event.charCode <= 57'> </td>  </tr>
		    
		    <tr> <td></td>     
		    <td> 
		    <input type="button" value="Add" onclick="formController()">  <br>

		    </td>  </tr>
		</table>
</fieldset>
</form>
<br>


<div id="message"></div>
<br>
<div id="allProducts"></div>

<br>

<div id="chartContainer" style="height: 300px; width: 100%;"></div>

</div>
				

				
	<div style="clear: both;">&nbsp;</div>
<!--content ends -->
<!--footer begins -->
	</div>

<div id="footer">
<p>Example Source Mustafa Ilhan KYAZIM</p>
	</div>
</div>
</div>
<!-- footer ends-->
</body>
</html>