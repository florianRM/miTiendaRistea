/**
 * 
 */
const formulario = document.querySelectorAll('form');
const operation = document.getElementById('operation');
const amount = document.querySelector('.amount');

formulario.forEach(val => {
	val.addEventListener('click', (ev) => {
		val.querySelector('#operation').value = ev.target.textContent + "1";
	})
	
	val.addEventListener('input', (ev) => {
		val.querySelector('#operation').value = ev.target.value;
})
})
