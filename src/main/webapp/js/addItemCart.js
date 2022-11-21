/**
 * 
 */
 
 const container = document.querySelector('.grid-container');
 
 container.addEventListener('click', ev => {
	if(ev.target.className === 'addCart') {
		const id = ev.target.previousSibling.value;
		location.assign(`addCart?id=${id}`);
	}
	
})