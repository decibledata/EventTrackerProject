console.log('script.js loaded');

window.addEventListener('load', function(e){
	console.log('Document loaded');
	init();
});

function init(){
	console.log ('In init()');
	
	loadMenuList();

}

function loadMenuList() {
	console.log("Fetching users...");
	//XHR to hit my list API endpoints
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/users');
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === xhr.DONE){
			console.log("XHR done. Status: ", xhr.status);
			if(xhr.status === 200){
				console.log("Response:", xhr.responseText);
				displayUserList(JSON.parse(xhr.responseText));
			} else {
				console.error("Error fetching users:",xhr.status, xhr.statusText);
			}
		}
	};
	xhr.send();
} 

function displayUserList(users){
	//DOM to build table rows, append to tbody
	let table = document.getElementById('userTable')
	let tbody = document.getElementById('menuListBody');
	tbody.textContent = '';
	
	table.style.opacity = '0';
	setTimeout(() => {
		table.classList.add('fade-in');
	}, 100);
	
	users.forEach((user, index) => {
		let tr = document.createElement('tr');
		
		let tdId = document.createElement('td');
		tdId.textContent = user.id;
		tr.appendChild(tdId);
		
		let tdName = document.createElement('td');
		tdName.textContent = user.username;
		tr.appendChild(tdName);
		
		let tdInventory = document.createElement('td');
		let inventoryButton = document.createElement('a');
		inventoryButton.textContent = 'View Inventory';
		inventoryButton.classList.add('btn-inventory');
		tdInventory.appendChild(inventoryButton);
		tr.appendChild(tdInventory);
		
		tbody.appendChild(tr);
		
		setTimeout(() => {
			tr.classList.add('fade-in');
		}, index * 200);
	});
}