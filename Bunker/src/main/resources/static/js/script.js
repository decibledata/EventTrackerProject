console.log('script.js loaded');

window.addEventListener('load', function(e) {
	console.log('Document loaded');
	init();
});

function init() {
	console.log('In init()');

	loadMenuList();

}

function loadMenuList() {
	console.log("Fetching users...");
	//XHR to hit my list API endpoints
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/users');

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			console.log("XHR done. Status: ", xhr.status);
			if (xhr.status === 200) {
				console.log("Response:", xhr.responseText);
				displayUserList(JSON.parse(xhr.responseText));
			} else {
				console.error("Error fetching users:", xhr.status, xhr.statusText);
			}
		}
	};
	xhr.send();
}

function displayUserList(users) {
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

		inventoryButton.onclick = function() {
			(user.id);
		};

		tdInventory.appendChild(inventoryButton);
		tr.appendChild(tdInventory);

		tbody.appendChild(tr);

		setTimeout(() => {
			tr.classList.add('fade-in');
		}, index * 200);
	});



}

//---------------------------------------------------------------------------------

function loadInventory() {
	console.log("Fetching all inventories...");

	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/inventory', true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			console.log("XHR done. Status: ", xhr.status);
			if (xhr.status === 200) {
				console.log("Response:", xhr.responseText);
				displayInventoryList(JSON.parse(xhr.responseText));
			} else {
				console.error("Error fetching inventory: ", xhr.status, xhr.statusText);
			}
		}
	};
	xhr.send();
}


function displayInventoryList(inventories) {
	let inventoryList = document.getElementById('inventory-list');
	inventoryList.innerHTML = '';

	if (inventories.length === 0) {
		inventoryList.innerHTML = '<li class="list-group-item">No items in inventory</li>';
		return;
	}

	inventories.forEach(inv => {

		let userId = inv.id;
		let username = inv.username;

		let userHeader = document.createElement('li');
		userHeader.classList.add('list-group-item', 'list-group-item-primary');
		userHeader.textContent = `User ID: ${userId} - ${user}'s Inventory`;
		inventoryList.appendChild(userHeader);

		if (!inv.items || inv.items.length === 0) {
			let emptyItem = document.createElement('li');
			emptyItem.classList.add('list-group-item');
			emptyItem.textContent = 'No items in inventory';
			inventoryList.appendChild(emptyItem);
		} else {
			inv.items.forEach(item => {
				let listItem = document.createElement('li');
				listItem.classList.add('list-group-item');
				listItem.textContent = `Item: ${item.name}, Quantity: ${item.quantity}`;
				inventoryList.appendChild(listItem);
			});
		}
	});
}