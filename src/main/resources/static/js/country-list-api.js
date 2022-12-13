/*Fundet på Codepen og ændret så det virker klasser i stedet for id*/
/*https://codepen.io/nikitahl/pen/PVVrYg*/

const xhttp = new XMLHttpRequest();
let elements = document.getElementsByClassName("country");

let countries;

xhttp.onreadystatechange = function() {
    for (let i = 0; i < elements.length; i++) {
        console.log('this.status', this.status);
        if (this.readyState === 4 && this.status === 200) {
            countries = JSON.parse(xhttp.responseText);
            countries.forEach(country => {
                const option = document.createElement("option");
                console.log('country',country)
                option.value = country.cioc;
                option.textContent = country.name.common;
                elements[i].appendChild(option);
            });
            const countryData = countries.find(
                country => elements[i].value === country.alpha2Code
            );
        }
    }
};
xhttp.open("GET", "https://restcountries.com/v3.1/all", true);
xhttp.send();
