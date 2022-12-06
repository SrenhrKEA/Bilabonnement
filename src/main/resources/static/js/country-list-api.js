const xhttp = new XMLHttpRequest();
const select = document.getElementById("country");
/*
const flag = document.getElementById("flag");
*/

let countries;

xhttp.onreadystatechange = function() {
    console.log('this.status', this.status);
    if (this.readyState == 4 && this.status == 200) {
        countries = JSON.parse(xhttp.responseText);
        assignValues();
        handleCountryChange();
    }
};
xhttp.open("GET", "https://restcountries.com/v3.1/all", true);
xhttp.send();

function assignValues() {
    countries.forEach(country => {
        const option = document.createElement("option");
        console.log('country',country)
        option.value = country.cioc;
        option.textContent = country.name.common;
        select.appendChild(option);
    });
}

function handleCountryChange() {
    const countryData = countries.find(
        country => select.value === country.alpha2Code
    );
    flag.style.backgroundImage = `url(${countryData.flag})`;
}

select.addEventListener("change", handleCountryChange.bind(this));
