/**
 * 
 */
const container = document.querySelector('.container_cart');

container.forEach(val => {
	if(val.querySelector('.amount').value == 1) {
		val.querySelector('.removeItem').setAttribute('disabled', 'true');
	}
	val.addEventListener('click', (ev) => {
		val.querySelector('#operation').value = ev.target.textContent + "1";
	})
	
	val.addEventListener('input', (ev) => {
		val.querySelector('#operation').value = ev.target.value;
})
})
