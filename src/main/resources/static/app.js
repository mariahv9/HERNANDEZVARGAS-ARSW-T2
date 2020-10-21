var app = (function () {
    function find(apielement) {
        var descripcion = $(apielement).find("td:first-child").text();
        var principal = $(apielement).find("td:nth-child(2)").text();
        $("#countryName").text(name);
        getByName(name);
    }

    function getWeather() {
        name = $("#country").val();
        var url = window.location;
        var urlNew = url.protocol+"//"+url.host + "/weather/"+name;
        var getPromise = $.get(urlNew);
        getPromise.then(
            function(data){
                var info = JSON.parse(data);
                table_Countries(info);
            }
        );
    }

    function map(name){
        var url = window.location;
        var urlNew = url.protocol+"//"+url.host + "/weather/coordinates/"+name;
        var getPromise = $.get(urlNew);
        getPromise.then(
            function(data){
                var info = JSON.parse(data);
                plotMarkers(info[0].latlng);
            },
            function(){
                console.log('error')
            }
        );
        return getPromise;
    }

    function table_Countries(data){
        console.log (data);
        $("#countryName").empty();
        var markup = "<tr><td>"+ data.name +"</td> <td>"+data.base+"</td> <td>"+data.weather[0].main+"</td> <td>"+data.weather[0].description+"</td> <td>"+data.wind.deg+"</td> <td>"+data.wind.speed+"</td> <td>"+data.coord.lon+"</td> <td>"+data.coord.lat+"</td> <td>"+data.clouds.all+"</td> <td>"+data.main.temp+"</td> <td>"+data.main.humidity+"</td> <td>"+data.main.pressure+"</td> </tr>";
        console.log(markup);
        $("#countryName").append(markup)

    }

    return {
        getWeather: getWeather,
        find:find
    }
})();