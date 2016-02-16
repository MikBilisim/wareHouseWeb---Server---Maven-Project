<%@ page contentType="text/html;charset=windows-1251" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=windows-1251" />
<title>Example Source Mustafa Ilhan KYAZIM</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="styles.css" rel="stylesheet" type="text/css" media="screen" />
 
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
		
			<li id="button1"><a href="#"  title=""><u>Home</u></a></li>
			<li id="button2"><a href="http://localhost:8080/wareHouseWeb/silos.jsp" title="">Silos</a></li>
			<li id="button3"><a href="http://localhost:8080/wareHouseWeb/tanks.jsp" title="">Tanks</a></li>
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
	
			<div class="left_box">
			<h2>Welcome To Our Example Website</h2>
			<p></p>
			<h4>Как да инсталирате база данни?</h4>
			<p><ul>
					<li class="sub">Отворете MySQL WorkBench</li>
					<li class="sub">Създайте New Connection - name:root, password:root</li>
					<li class="sub">влезте в него</li>
					<li class="sub">за да създадете таблиците, пуснете <a href="./dbQuery.sql">dbQuery.sql</a></li>
					<li class="sub">базата данни е вече готова и сайтът може да се използва</li>			
	        </ul></p>
			    <p>Ако базата данни не е инсталирана и сървърът не работи,мобилното приложение също няма да работи.<br /></p>
			   <p> То чете данните от база данни чрез сайта, който работи с Java EE & JavaScript.</p>
			    <p>Управлението на база данни става чрез Java CRUD Operations. Сайтът съдържа отделни сервизи за мобилно приложение,които са направени от RestFul Web Services</p>
  			</div>
           
           <div class="left_box">

			<p>
			<font color="red">
			Като резултат от тестовете, които проведох докато сайтът се зарежда в сървъра много рядко,
			но дава грешка на бутон "show transaction" и бутон "delete", които се намират в "SILOS" и "TANKS".
			Аko се сблъскате с такъв провлем, изтрийте зареждания сайт и презаредете от ново.
			</font>
			</p>
			<h4><font color="red">* ПРОБЛЕМЪТ НЕ СЕ ДЪЛЖИ НА НАПИСАНИЯ ОТ МЕН КОД , А СЕ ПОЯВЯВА, КОГАТО СЕ ЗАРЕЖДА В СЪРВЪРА.</font></h4>
			                <br />
			
				<div class="left_box">
			<h4><a href="#">Задача</a></h4>
			<p>Разработете мобил приложение за следене на наличности в два земеделски склада – за зърно и за течни торове (препарати). Приложението трябва да изглежда по следния начин:
Складът за зърно трябва да изглежда като силоз, а този за торове – като цистерна;</p>
<p>Под тях трябва да има полета за вкарване и вземане на съответните стоки в и от склада – избор на склад, избор на вид стока (напр. зърно) и въвеждане на количество (напр. 20 тона);
Въведените операции да се съхраняват в база данни;</p><p>
Всяко вкарване и вземане на количества от складовете трябва да се визуализира анимирано – при всяка операция следва нивото на съответната стока да се покачва или да спада. Върху силоза и цистерната да се изписва наличното количество след всяка операция;
Да има справка в табличен вид за всички вкарвания и вземания на стоки от складовете, както и оставащото количество след последната операция. Да има възможност за изтриване на произволен ред. След изтриване на ред, наличното количество да се преизчислява – в таблицата и върху анимираното изображение
			</p>
			
				</div>
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