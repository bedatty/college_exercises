document.addEventListener('DOMContentLoaded', function () {
  document
    .getElementById('emailForm')
    .addEventListener('submit', function (event) {
      event.preventDefault();
      const emailField = document.getElementById('email');
      const errorMessage = document.getElementById('error-message');
      const email = emailField.value;

      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

      if (!emailPattern.test(email)) {
        errorMessage.textContent =
          'Por favor, insira um e-mail válido. Exemplo: usuario@dominio.com';
      } else {
        errorMessage.textContent = '';
        alert('E-mail válido! Formulário enviado.');
      }
    });
});