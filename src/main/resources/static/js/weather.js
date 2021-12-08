const boxTempA = document.getElementById('box-a-temp');
const boxTempB = document.getElementById('box-b-temp');
const boxTempC = document.getElementById('box-c-temp');
const boxTempD = document.getElementById('box-d-temp');

const boxTempFeelsLikeA = document.getElementById('box-a-feels-like');
const boxTempFeelsLikeB = document.getElementById('box-b-feels-like');
const boxTempFeelsLikeC = document.getElementById('box-c-feels-like');
const boxTempFeelsLikeD = document.getElementById('box-d-feels-like');

const boxHumidityA = document.getElementById('box-a-humidity');
const boxHumidityB = document.getElementById('box-b-humidity');
const boxHumidityC = document.getElementById('box-c-humidity');
const boxHumidityD = document.getElementById('box-d-humidity');

const boxWindA = document.getElementById('box-a-wind');
const boxWindB = document.getElementById('box-b-wind');
const boxWindC = document.getElementById('box-c-wind');
const boxWindD = document.getElementById('box-d-wind');


const boxImgA = document.getElementById('box-a-img');
const boxImgB = document.getElementById('box-b-img');
const boxImgC = document.getElementById('box-c-img');
const boxImgD = document.getElementById('box-d-img');

const boxDescA = document.getElementById('box-a-desc');
const boxDescB = document.getElementById('box-b-desc');
const boxDescC = document.getElementById('box-c-desc');
const boxDescD = document.getElementById('box-d-desc');

fetch('http://api.openweathermap.org/data/2.5/weather?q=London&appid=8dd1b8c6c70655b59ef4f75b4d9fb753')
    .then(response => response.json())
    .then(info => {

        //Formula Kelvin to Celsius 299K − 273.15 = 25.85°C

        boxTempA.innerText = Math.round(info.main.temp - 273.15);
        boxTempFeelsLikeA.innerText = Math.round(info.main.feels_like - 273.15);
        boxHumidityA.innerText = info.main.humidity;
        boxWindA.innerText = info.wind.speed;
        boxImgA.src = '/images/weather-icons/' + info.weather[0].icon + '.png';
        boxDescA.innerText = info.weather[0].description;
    });

fetch('http://api.openweathermap.org/data/2.5/weather?q=Stockholm&appid=8dd1b8c6c70655b59ef4f75b4d9fb753')
    .then(response => response.json())
    .then(info => {

        boxTempB.innerText = Math.round(info.main.temp - 273.15);
        boxTempFeelsLikeB.innerText = Math.round(info.main.feels_like - 273.15);
        boxHumidityB.innerText = info.main.humidity;
        boxWindB.innerText = info.wind.speed;
        boxImgB.src = '/images/weather-icons/' + info.weather[0].icon + '.png';
        boxDescB.innerText = info.weather[0].description;

    });

fetch('http://api.openweathermap.org/data/2.5/weather?q=Paris&appid=8dd1b8c6c70655b59ef4f75b4d9fb753')
    .then(response => response.json())
    .then(info => {

        boxTempC.innerText = Math.round(info.main.temp - 273.15);
        boxTempFeelsLikeC.innerText = Math.round(info.main.feels_like - 273.15);
        boxHumidityC.innerText = info.main.humidity;
        boxWindC.innerText = info.wind.speed;
        boxImgC.src = '/images/weather-icons/' + info.weather[0].icon + '.png';
        boxDescC.innerText = info.weather[0].description;
    });

fetch('http://api.openweathermap.org/data/2.5/weather?q=Sofia&appid=8dd1b8c6c70655b59ef4f75b4d9fb753')
    .then(response => response.json())
    .then(info => {

        boxTempD.innerText = Math.round(info.main.temp - 273.15);
        boxTempFeelsLikeD.innerText = Math.round(info.main.feels_like - 273.15);
        boxHumidityD.innerText = info.main.humidity;
        boxWindD.innerText = info.wind.speed;
        boxImgD.src = '/images/weather-icons/' + info.weather[0].icon + '.png';
        boxDescD.innerText = info.weather[0].description;
    });