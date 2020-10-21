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
        var urlnew = url.protocol+"//"+url.host + "/weather/"+name;
        var getPromise = $.get(urlNew);
        getPromise.then(
            function(data){
                var info = JSON.parse(data);
                table_Countries(info);
            }
        );
//        getByName(name);
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
        $("#countries").empty();
        data.map(function(element){
            var markup = "<tr onclick=app.getWeather()> <td>"+ element.descripcion +"</td> <td>"+element.principal+"</td> </tr>";
            $("#countries").append(markup)
        });
    }

    function getByName(name) {
        var url = window.location;
        var urlNew = url.protocol+"//"+url.host + "/coronavirus/"+name;
        var getPromise = $.get(urlNew);
        getPromise.then(
            function(data){
                var info = JSON.parse(data);
                showTableProvinces(info.data.covid19Stats);
            },
            function(){
                console.log('error')
            }
        );
        return getPromise;
    }

    return {
        getWeather: getWeather,
        find:find
    }
})();