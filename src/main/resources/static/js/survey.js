let getSelect = document.getElementById('selectTopic');
getSelect.addEventListener('change', function change(event){
	console.log(event.target.value);
	let showTopic = document.getElementById('topicShow');
	showTopic.innerHTML = event.target.value
});

