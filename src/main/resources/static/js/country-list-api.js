/*Fundet på Codepen:*/
/*https://codepen.io/nikitahl/pen/PVVrYg*/

const xhttp = new XMLHttpRequest();
/*
const select = document.getElementById("country");
*/
const elements = document.getElementsByClassName("country");

/*
const flag = document.getElementById("flag");
*/

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

/*function assignValues() {
    countries.forEach(country => {
        const option = document.createElement("option");
        console.log('country',country)
        option.value = country.cioc;
        option.textContent = country.name.common;
        select.appendChild(option);
    });
}*/

/*function handleCountryChange() {
    const countryData = countries.find(
        country => select.value === country.alpha2Code
    );
/!*    flag.style.backgroundImage = `url(${countryData.flag})`;*!/
}*/

/*
select.addEventListener("change", handleCountryChange.bind(this));
*/
