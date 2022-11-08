/**
 * 
 */
const formulario = document.querySelector('form');
const fields = document.querySelectorAll('input');
const loginButton = document.querySelector('.login');
const registerButton = document.querySelector('.register');

formulario.addEventListener('input', () => {
	const minLenght = 6;
	if((fields[0].value.length === 0 || fields[1].value.length < minLenght)) {
		loginButton.setAttribute('disabled', 'true');
	} else {
		loginButton.removeAttribute('disabled');
	}
})

registerButton.addEventListener('click', () => {
	location.assign('register.jsp');
})


