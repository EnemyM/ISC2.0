var map;
/*labels and indexes for markers*/
var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
var storeLable = 'S';
var destinationLable = 'D';
var labelIndex = 0;

var markers = [];

function initMap() {
    /* Instantiate a renderer for directions and bind it to the map. */
    var directionsDisplay = new google.maps.DirectionsRenderer;
    // Instantiate a directions service.
    var directionsService = new google.maps.DirectionsService;
    /* center Ukraine coords */
    var Ukraine = {lat: 50.45466, lng: 30.5238};
    var  map = new google.maps.Map(document.getElementById('myMap'), {
        center: Ukraine,
        zoom: 7
    });

    /* init geocoder to get location via add marker on map or input into the field in route form*/
    var geocoder = new google.maps.Geocoder();
    /* add to info window element */
    var infoWindow = new google.maps.InfoWindow;

    directionsDisplay.setMap(map);
    directionsDisplay.setPanel(document.getElementById('right-panel'));

    // Show the lat and lng under the mouse cursor.
    var coordsDiv = document.getElementById('coords');
    map.controls[google.maps.ControlPosition.TOP_CENTER].push(coordsDiv);
    map.addListener('mousemove', function(event) {
        coordsDiv.textContent =
            'lat: ' + Math.round(event.latLng.lat()) + ', ' +
            'lng: ' + Math.round(event.latLng.lng());
    });

    /* get location and via input address field */
    document.getElementById('search-spot-location-butt').addEventListener('click', function(){
            /* get searched location and add marker*/
        geocodeAddress(geocoder,map);
    });

    /* when  delete-all  button is clicked */
    document.getElementById('delete-all-spot-butt').addEventListener('click',function(){
        deleteAllMarkers();
    });

    /* check save button if marker was added */
    document.getElementById('save-spot-butt').addEventListener('click',function(){
        var address = document.getElementById('spot-address-in').value;
        var latitude = document.getElementById('spot-lat-in').value;
        var longitude = document.getElementById('spot-lng-in').value;

        if(markers.length === 0){
            alert('You did not create marker. Please,click on map to create ');
        }

    });
    /* when create-route is slicked */
    document.getElementById('build-route-butt').addEventListener('click', function () {
       if(markers.length === 0){
           alert('Please, add order spot');
       }else{
           var address = document.getElementById('spot-address-in').value;
           var latitude = document.getElementById('spot-lat-in').value;
           var longitude = document.getElementById('spot-lng-in').value;
           if(address !== '' && latitude !== '' && longitude !==''){
                alert('Please, finish work with order spot, to build route');
           }else{
               calculateAndDisplayRoute(directionsService, directionsDisplay);
           }
       }
    });
    /* calculate and display route */
    function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        var start;
        var end;


                end = markers[0];

                start = markers[1];



        directionsService.route({
            origin: start,
            destination: end,
            travelMode: google.maps.TravelMode.DRIVING
        }, function(response, status) {
            if (status === google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
            } else {
                window.alert('Directions request failed due to ' + status);
            }
        });
    }

    // This event listener calls addMarker() when the map is clicked.
    google.maps.event.addListener(map, 'click', function(event) {
        if(markers.length > 3){
            window.alert("Oh my God!!!" +
                "You have reached allowed count of markers");
        }else {
            var address = document.getElementById('spot-address-in').value;
            if(address === ''){
                geocodeLatLng(event.latLng, geocoder, map, infoWindow);
            }else{
                alert('Save current marker or delete it to create new one');
            }

        }
    });

    /* get location  */
    function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('search-spot-location-in').value;
        geocoder.geocode({'address': address}, function(results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                resultsMap.setCenter(results[0].geometry.location);
                resultsMap.setZoom(11);

                /* clean search input */
               address = document.getElementById('search-spot-location-in').value = '';
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
                        position: location,//set position
                        map: map,
                        draggable: true,//makes marker to be draggable
                        /*label: labels[labelIndex++ % labels.length],*/
                        animation: google.maps.Animation.DROP// animation
                    });
                    /* add address into the field address in route form */
                    var address = document.getElementById('spot-address-in').value = results[1].formatted_address;
                    /* add latitude, longitude into appropriate fields in the route form */
                    var latitude = document.getElementById('spot-lat-in').value = results[0].geometry.location.lat();
                    var longitude = document.getElementById('spot-lng-in').value = results[0].geometry.location.lng();
                    /* save marker */
                    document.getElementById('save-spot-butt').addEventListener('click',function(){
                        var spotType = document.getElementById('spot-type-s').value;
                        if(spotType === 'Store'){
                            marker.setLabel(storeLable);
                        }else{
                            marker.setLabel(destinationLable);
                        }

                    });
                    /* push marker into array */
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

                                toggleMarkerBounce(marker);
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
                                /* update marker */
                                document.getElementById('save-spot-butt').addEventListener('click',function(){
                                    var spotType = document.getElementById('spot-type-s').value;
                                    if(spotType === 'Store'){
                                        marker.setLabel(storeLable);
                                    }else{
                                        marker.setLabel(destinationLable);
                                    }

                                });
                            });
                            /* when the marker is dragged  */
                            google.maps.event.addListener(marker, 'dragend', function (event) {

                                /* create new Geocoder*/
                                var g = new google.maps.Geocoder();
                                g.geocode({'location': event.latLng}, function(results, status) {
                                    if (status === google.maps.GeocoderStatus.OK) {
                                        if (results[1]) {
                                            /* fill address field on drag event*/
                                            var address = document.getElementById('spot-address-in').value = results[1].formatted_address;
                                            /* add address into the info window */
                                            infowindow.setContent(results[1].formatted_address);
                                            /* open info window */
                                            infowindow.open(map, marker);
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

    }
    /* delete marker by latitude and longitude*/
    function deleteMarker(marker){
        for(var i = 0; i < markers.length;i++){
            if(markers[i].getPosition() === marker.getPosition()){
                markers[i].setMap(null);
                markers.splice(i,1);// delete i marker from the array
                alert(markers.length);
                /* clean all route input fields */
                var address = document.getElementById('spot-address-in').value = '';
                var latitude = document.getElementById('spot-lat-in').value = '';
                var longitude = document.getElementById('spot-lng-in').value = '';
            }
        }
    }

    /* animation when the marker is clicked */
    function toggleMarkerBounce(marker) {
        if (marker.getAnimation() !== null) {
            marker.setAnimation(null);
        } else {
            marker.setAnimation(google.maps.Animation.BOUNCE);
        }
    }
    google.maps.event.addDomListener(window, 'load', initialize);
}
