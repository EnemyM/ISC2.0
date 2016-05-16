var map;
/*labels and indexes for markers*/
var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
var labelIndex = 0;

var markers = [];

function initMap() {
    var Ukraine = {lat: 50.45466, lng: 30.5238};
    var  map = new google.maps.Map(document.getElementById('myMap'), {
        center: Ukraine,
        zoom: 7
    });

    /* init geocoder to get location via add marker on map or input into the field in route form*/
    var geocoder = new google.maps.Geocoder();
    /* add to info window element */
    var infoWindow = new google.maps.InfoWindow;


    /* when the button 'Add' in route form is clicked, get location and add marker via input address field */
    document.getElementById('search-spot-location-butt').addEventListener('click', function(){
        if(markers.length > 3){
            window.alert("Oh my God!!!" +
                "You have reached allowed count of markers");
        }else {
            /* get searched location and add marker*/
            geocodeAddress(geocoder, map);
        }
    });

    /* when the delete all button is clicked */
    document.getElementById('delete-all-spot-butt').addEventListener('click',function(){
        deleteAllMarkers();
    });

    // This event listener calls addMarker() when the map is clicked.
    google.maps.event.addListener(map, 'click', function(event) {
        if(markers.length > 3){
            window.alert("Oh my God!!!" +
                "You have reached allowed count of markers");
        }else {
            geocodeLatLng(event.latLng, geocoder, map, infoWindow);
        }
        /* add information from added marker on the map by click*/
    });

    // Adds a marker to the map.
    function addMarker(location, map) {
        // Add the marker at the clicked location, and add the next-available label
        // from the array of alphabetical characters.
        if(labelIndex > 3){
            window.alert("Oh my God!!!" +
                "You have reached allowed count of markers");
        }else{
            var marker = new google.maps.Marker({
                position: location,
                draggable: true,//makes marker to be draggable
                label: labels[labelIndex++ % labels.length],
                map: map
            });
            markers.push(marker);
        }
    }
    /* get location  */
    function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('search-spot-location-in').value;
        geocoder.geocode({'address': address}, function(results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                resultsMap.setCenter(results[0].geometry.location);
                resultsMap.setZoom(11);
                var address = document.getElementById('search-spot-location-in').value = '';
            } else {
                alert('Geocode was not successful for the following reason: ' + status);
            }
        });
    }
    /* create marker with infowindow and add address, latitude, longitude into the route form*/
    function geocodeLatLng(location,geocoder, map, infowindow) {

        geocoder.geocode({'location': location}, function(results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                if (results[1]) {
                    var marker = new google.maps.Marker({
                        position: location,
                        map: map,
                        draggable: true,//makes marker to be draggable
                        label: labels[labelIndex++ % labels.length]
                    });
                    /* add address into the field address in route form */
                    var address = document.getElementById('spot-address-in').value = results[1].formatted_address;
                    /* add latitude, longitude into appropriate fields in the route form */
                    var latitude = document.getElementById('spot-lat-in').value = results[0].geometry.location.lat();
                    var longitude = document.getElementById('spot-lng-in').value = results[0].geometry.location.lng();
                    /* add marker into array */
                    markers.push(marker);
                    /* add address into the info window */
                    infowindow.setContent(results[1].formatted_address);
                    /*open info window */
                    infowindow.open(map, marker);

                    /* add listener to all added markers */
                    for (var i = 0; i < markers.length; i++) {
                        var data = markers[i];
                        //Attach click event to the marker.
                        (function (marker, data) {
                            /* click marker listener*/
                            google.maps.event.addListener(marker, "click", function (e) {
                                alert(e.latLng);
                                /* add address into the field address in route form */
                                var address = document.getElementById('spot-address-in').value = results[1].formatted_address;
                                /* add latitude, longitude into appropriate fields in the route form */
                                var latitude = document.getElementById('spot-lat-in').value = results[0].geometry.location.lat();
                                var longitude = document.getElementById('spot-lng-in').value = results[0].geometry.location.lng();
                                /* add address into the info window */
                                infowindow.setContent(results[1].formatted_address);
                                /* open info window */
                                infowindow.open(map, marker);
                                /* when the delete button is clicked */
                                document.getElementById('delete-spot-butt').addEventListener('click',function(){
                                    deleteMarker(marker);
                                });
                                /* save marker */
                                document.getElementById('save-spot-butt').addEventListener('click',function(){
                                    var select = document.getElementById('spot-type-s').value;

                                });
                            });
                            /* */
                            google.maps.event.addListener(marker, 'dragend', function (event) {
                                /* create new Geocoder*/
                                var g = new google.maps.Geocoder();
                                g.geocode({'location': event.latLng}, function(results, status) {
                                    if (status === google.maps.GeocoderStatus.OK) {
                                        if (results[1]) {
                                            /* fill address field on drag event*/
                                            var address = document.getElementById('spot-address-in').value = results[1].formatted_address;
                                        } else {
                                            window.alert('No results found');
                                        }
                                    } else {
                                        window.alert('Geocoder failed due to: '+ status);
                                    }
                                });
                                /* add latitude, longitude into appropriate fields in the route form */
                                var latitude = document.getElementById('spot-lat-in').value = event.latLng.lat();
                                var longitude = document.getElementById('spot-lng-in').value = event.latLng.lng();
                                /* add new position into the marker*/
                                marker.setPosition(event.latLng);

                            });

                        })(marker, data);
                    }
                } else {
                    window.alert('No results found');
                }
            } else {
                window.alert('Geocoder failed due to: ' + status);
            }
        });
    }

    // Deletes all markers in the array by removing references to them.
    function deleteAllMarkers() {
        for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(null);
        }
        /* after delete make the values of markers and labels of indexes nullable */
        markers = [];
        labelIndex = 0;
        /* clean all route input fields */
        var address = document.getElementById('spot-address-in').value = '';
        var latitude = document.getElementById('spot-lat-in').value = '';
        var longitude = document.getElementById('spot-lng-in').value = '';
        /* switch button add to update*/
        var addUpdateButt = document.getElementById('add-spot-butt').value = 'Add';
    }
    /* delete marker by latitude and longitude*/
    function deleteMarker(marker){
        for(var i = 0; i < markers.length;i++){
            if(markers[i].getPosition() === marker.getPosition()){
                markers[i].setMap(null);
                markers.splice(i,1);// delete i marker from the array
                --labelIndex;
                alert(labelIndex);
                /* clean all route input fields */
                var address = document.getElementById('spot-address-in').value = '';
                var latitude = document.getElementById('spot-lat-in').value = '';
                var longitude = document.getElementById('spot-lng-in').value = '';
                var addUpdateButt = document.getElementById('add-spot-butt').value = 'Add';
            }
        }
    }

    google.maps.event.addDomListener(window, 'load', initialize);
}
