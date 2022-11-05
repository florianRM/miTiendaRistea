/**
 * 
 */
const dropMenu = document.querySelector('.drop-menu');
const userIcon = document.querySelector('.fa-user');
const logOut = document.querySelector('.logout');

userIcon.addEventListener('click', () => {
	dropMenu.classList.toggle('drop-menu-down');
})

logOut.addEventListener('click', () => {
	location.replace('index.jsp');
})


