let getSelect = document.getElementById('selectTopic');


getSelect.addEventListener('change', function change(event){
	let integration = document.getElementsByClassName('integration');
	let first = document.getElementsByClassName('first');
	let second = document.getElementsByClassName('second');
	let thirth = document.getElementsByClassName('thirth');
	for(var i=0; i<integration.length; i++){
		first[i].style.display="table-cell";
		second[i].style.display="table-cell";
		thirth[i].style.display="table-cell";
	}
	
	for(var i = 0; i<integration.length; i++){
	if(integration[i].innerHTML != event.target.value){
		first[i].style.display="none";
		second[i].style.display="none";
		thirth[i].style.display="none";
		integration[i].style.display="none";
		}
	}
});
