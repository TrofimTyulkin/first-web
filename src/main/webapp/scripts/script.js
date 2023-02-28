function myFunc() {
  var x = document.getElementById("11");
  x.value = x.value.toUpperCase();
  alert( 'change' );
}
function getComboA(selectObject) {
  var value = selectObject.value;  
  alert(value);
}



function fun1(){
	if(document.getElementById("tarifs").selectedIndex === 0){
		document.getElementById("1").style.display = "block"
		document.getElementById("2").style.display = "none"
		document.getElementById("3").style.display = "none"
	}
	if(document.getElementById("tarifs").selectedIndex === 1){
		document.getElementById("1").style.display = "block"
		document.getElementById("2").style.display = "block"
		document.getElementById("3").style.display = "none"
	}
	if(document.getElementById("tarifs").selectedIndex === 2){
		document.getElementById("1").style.display = "block"
		document.getElementById("2").style.display = "block"
		document.getElementById("3").style.display = "block"
	}
}