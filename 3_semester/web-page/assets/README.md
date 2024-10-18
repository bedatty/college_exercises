# Zodiac Sign Consultation System

This project is a web application that allows users to look up their zodiac sign based on their birthdate. The application uses **PHP**, **Bootstrap**, e **XML**.

## Features

- Zodiac sign lookup based on birthdate.
- Display of the sign and its description.
- Responsive styling with **Bootstrap** and custom **CSS**.

## Prerequisites

- A web server with PHP (XAMPP, MAMP, etc.).
- `signos.xml` file containing zodiac sign information.


## Installation

1. Clone the repository or download it:

```bash
   git clone git@github.com:bedatty/college_exercises.git
```
2. Place the files in your web server's directory (ex: `htdocs` no XAMPP).

3. Ensure that the `signos.xml` file is present and properly formatted:

   ```xml
   <signos>
       <signo>
           <dataInicio>21/03</dataInicio>
           <dataFim>20/04</dataFim>
           <signoNome>Áries</signoNome>
           <descricao>Impulsivo, corajoso e energético.</descricao>
       </signo>
       <!-- Outros signos -->
   </signos>

5. Start the web server and access `http://localhost/web-page/assets/index.php`  in your browser.

## Estrutura do Projeto
 
```bash
    /zodiac-sign-system/
    ├── style.css                # Custom styles
    ├── signos.xml               # XML file with zodiac sign data
    ├── header.php               # Common header
    ├── index.php                # Lookup form
    ├── show_zodiac_sign.php     # Zodiac sign result
```

## Use

1. Open `index.php` and enter your birthdate.
2. View the corresponding zodiac sign and its description.
3. Click "Back" to look up another date.

## Technologies

- **PHP**: Data and XML handling.
- **Bootstrap**: Responsive design.
- **CSS**: customization.

## Customization

- Edit the `style.css` file to change the interface's appearance.
- Modify `signos.xml` to update zodiac sign information or change descriptions.