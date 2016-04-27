var map;
/*labels for markers*/
var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
var labelIndex = 0;

function initMap() {
    var uluru = {lat: -25.363, lng: 131.044};
    map = new google.maps.Map(document.getElementById('myMap'), {
        center: uluru,
        zoom: 8
    });

    var element1 = document.createElement("input");
    element1.type = "radio";

    var infoDOM = '<div class="modal fade" tabindex="-1" role="dialog">' +
        '<div class="modal-dialog">' +
        '<div class="modal-content">' +
        '<div class="modal-header">' +
        '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
        '<h4 class="modal-title">Modal title</h4>' +
        '</div>' +
        '<div class="modal-body">' +
        '<p>One fine body&hellip;</p>' +
        '</div>' +
        '<div class="modal-footer">' +
        '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>' +
        '<button type="button" class="btn btn-primary">Save changes</button>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</div>';
    var stringHTML = '<div id="content">' +
        '<button type="button" class="btn btn-primary" onclick="myFunction()" id="b">Save changes</button>' +
        '</div>';


    /* add to info window element */
    var infoWindow = new google.maps.InfoWindow({
        content: stringHTML
    });


    var marker = new google.maps.Marker({
        position: uluru,
        map: map,
        title: 'Uluru (Ayers Rock)'
    });
    /*show info window on click*/
    marker.addListener('click', function() {
        infoWindow.open(map, marker);

    });

    
    // This event listener calls addMarker() when the map is clicked.
    google.maps.event.addListener(map, 'click', function(event) {
        addMarker(event.latLng, map);
    });


    // Adds a marker to the map.
    function addMarker(location, map) {
        // Add the marker at the clicked location, and add the next-available label
        // from the array of alphabetical characters.

        if(labelIndex > 3){
            window.alert("Oh my God!!!" +
                "You reached allowed count of the markers");
        }else{
            var marker = new google.maps.Marker({
                position: location,
                label: labels[labelIndex++ % labels.length],
                map: map
            });
        }

    }


    google.maps.event.addDomListener(window, 'load', initialize);
}
