var map;
/*labels and indexes for markers*/
var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

var storeLable = "Store";
var destinationLable = "Destination";
var labelIndex = 0;

var markers = [];

function initMap() {
    var usRoadMapType = new google.maps.StyledMapType([
        {
            featureType: 'road.highway',
            elementType: 'geometry',
            stylers: [
                {hue: '#ff0022'},
                {saturation: 60},
                {lightness: -20}
            ]
        }, {
            featureType: 'road.arterial',
            elementType: 'all',
            stylers: [
                {hue: '#2200ff'},
                {lightness: -40},
                {visibility: 'simplified'},
                {saturation: 30}
            ]
        }, {
            featureType: 'road.local',
            elementType: 'all',
            stylers: [
                {hue: '#f6ff00'},
                {saturation: 50},
                {gamma: 0.7},
                {visibility: 'simplified'}
            ]
        }, {
            featureType: 'water',
            elementType: 'geometry',
            stylers: [
                {saturation: 40},
                {lightness: 40}
            ]
        }, {
            featureType: 'road.highway',
            elementType: 'labels',
            stylers: [
                {visibility: 'on'},
                {saturation: 98}
            ]
        }, {
            featureType: 'administrative.locality',
            elementType: 'labels',
            stylers: [
                {hue: '#0022ff'},
                {saturation: 50},
                {lightness: -10},
                {gamma: 0.90}
            ]
        }, {
            featureType: 'transit.line',
            elementType: 'geometry',
            stylers: [
                {hue: '#ff0000'},
                {visibility: 'on'},
                {lightness: -70}
            ]
        }
    ], {name: 'US Road Atlas'});
    var customMapType = new google.maps.StyledMapType([
        {
            stylers: [
                {hue: '#890000'},
                {visibility: 'simplified'},
                {gamma: 0.5},
                {weight: 0.5}
            ]
        },
        {
            elementType: 'labels',
            stylers: [{visibility: 'off'}]
        },
        {
            featureType: 'water',
            stylers: [{color: '#890000'}]
        }
    ], {
        name: 'Red Style'
    });
    var VictorianBlue = new google.maps.StyledMapType([
        {
            "featureType": "all",
            "elementType": "all",
            "stylers": [
                {
                    "visibility": "on"
                },
                {
                    "hue": "#002aff"
                },
                {
                    "saturation": "0"
                },
                {
                    "lightness": "0"
                },
                {
                    "gamma": "1.00"
                },
                {
                    "invert_lightness": true
                }
            ]
        }
    ],{
            name: 'Victorian blue'
        }
    );
    var brainstorm = new google.maps.StyledMapType([
        {
            "featureType": "all",
            "elementType": "labels.text.fill",
            "stylers": [
                {
                    "color": "#6f6f6f"
                }
            ]
        },
        {
            "featureType": "all",
            "elementType": "labels.text.stroke",
            "stylers": [
                {
                    "visibility": "on"
                },
                {
                    "color": "#202020"
                }
            ]
        },
        {
            "featureType": "all",
            "elementType": "labels.icon",
            "stylers": [
                {
                    "visibility": "simplified"
                },
                {
                    "hue": "#ff000a"
                }
            ]
        },
        {
            "featureType": "administrative",
            "elementType": "geometry.fill",
            "stylers": [
                {
                    "color": "#000000"
                }
            ]
        },
        {
            "featureType": "administrative",
            "elementType": "geometry.stroke",
            "stylers": [
                {
                    "color": "#505050"
                }
            ]
        },
        {
            "featureType": "landscape",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#2d2d2d"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "all",
            "stylers": [
                {
                    "visibility": "off"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#252525"
                }
            ]
        },
        {
            "featureType": "road.highway",
            "elementType": "geometry.fill",
            "stylers": [
                {
                    "color": "#202020"
                }
            ]
        },
        {
            "featureType": "road.highway",
            "elementType": "geometry.stroke",
            "stylers": [
                {
                    "color": "#000000"
                },
                {
                    "lightness": 29
                },
                {
                    "weight": 0.2
                }
            ]
        },
        {
            "featureType": "road.arterial",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#202020"
                }
            ]
        },
        {
            "featureType": "road.local",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#202020"
                }
            ]
        },
        {
            "featureType": "transit",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#252525"
                }
            ]
        },
        {
            "featureType": "water",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#252525"
                }
            ]
        }
    ],{name: 'Brainstorm'}
    );
    var behie = new google.maps.StyledMapType([
        {
            "featureType": "all",
            "elementType": "labels.text.fill",
            "stylers": [
                {
                    "color": "#ffffff"
                }
            ]
        },
        {
            "featureType": "all",
            "elementType": "labels.text.stroke",
            "stylers": [
                {
                    "visibility": "on"
                },
                {
                    "color": "#5a0025"
                },
                {
                    "weight": 2
                },
                {
                    "gamma": 0.84
                }
            ]
        },
        {
            "featureType": "all",
            "elementType": "labels.icon",
            "stylers": [
                {
                    "visibility": "off"
                }
            ]
        },
        {
            "featureType": "administrative",
            "elementType": "geometry",
            "stylers": [
                {
                    "weight": 0.6
                },
                {
                    "color": "#5b1d37"
                }
            ]
        },
        {
            "featureType": "landscape",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#883357"
                }
            ]
        },
        {
            "featureType": "poi",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#a35174"
                }
            ]
        },
        {
            "featureType": "poi.park",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#883357"
                }
            ]
        },
        {
            "featureType": "road",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#b2225f"
                },
                {
                    "lightness": -37
                }
            ]
        },
        {
            "featureType": "transit",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#965570"
                }
            ]
        },
        {
            "featureType": "water",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#606060"
                }
            ]
        }
    ],{ name: 'behie'}
    );

    var SnazzyMaps = new google.maps.StyledMapType([
        {
            "featureType": "water",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#333739"
                }
            ]
        },
        {
            "featureType": "landscape",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#2ecc71"
                }
            ]
        },
        {
            "featureType": "poi",
            "stylers": [
                {
                    "color": "#2ecc71"
                },
                {
                    "lightness": -7
                }
            ]
        },
        {
            "featureType": "road.highway",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#2ecc71"
                },
                {
                    "lightness": -28
                }
            ]
        },
        {
            "featureType": "road.arterial",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#2ecc71"
                },
                {
                    "visibility": "on"
                },
                {
                    "lightness": -15
                }
            ]
        },
        {
            "featureType": "road.local",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#2ecc71"
                },
                {
                    "lightness": -18
                }
            ]
        },
        {
            "elementType": "labels.text.fill",
            "stylers": [
                {
                    "color": "#ffffff"
                }
            ]
        },
        {
            "elementType": "labels.text.stroke",
            "stylers": [
                {
                    "visibility": "off"
                }
            ]
        },
        {
            "featureType": "transit",
            "elementType": "geometry",
            "stylers": [
                {
                    "color": "#2ecc71"
                },
                {
                    "lightness": -34
                }
            ]
        },
        {
            "featureType": "administrative",
            "elementType": "geometry",
            "stylers": [
                {
                    "visibility": "on"
                },
                {
                    "color": "#333739"
                },
                {
                    "weight": 0.8
                }
            ]
        },
        {
            "featureType": "poi.park",
            "stylers": [
                {
                    "color": "#2ecc71"
                }
            ]
        },
        {
            "featureType": "road",
            "elementType": "geometry.stroke",
            "stylers": [
                {
                    "color": "#333739"
                },
                {
                    "weight": 0.3
                },
                {
                    "lightness": 10
                }
            ]
        }
    ],{name: 'Snazzy Maps'}
    );

    /* center Ukraine coords */
    var Ukraine = {lat: 50.45466, lng: 30.5238};
    var  map = new google.maps.Map(document.getElementById('myMap'), {
        center: Ukraine,
        zoom: 7,
        mapTypeControl: true,
        mapTypeControlOptions: {
            style: google.maps.MapTypeControlStyle.DROPDOWN_MENU,
            mapTypeIds: [
                google.maps.MapTypeId.ROADMAP,
                google.maps.MapTypeId.TERRAIN,
                google.maps.MapTypeId.SATELLITE,
                google.maps.MapTypeId.HYBRID ,
                'usroadatlas',
               'custom_style',
                'Brainstorm',
                'Behie',
                'SnazzyMaps',
                'Victorian_blue'
            ]
        }
    });
    /* set maps styles */
    map.mapTypes.set('usroadatlas', usRoadMapType);
    map.setMapTypeId('usroadatlas');
    map.mapTypes.set('Brainstorm', brainstorm);
    map.setMapTypeId('Brainstorm');
    map.mapTypes.set('custom_style', customMapType);
    map.setMapTypeId('custom_style');
    map.mapTypes.set('Behie', behie);
    map.setMapTypeId('Behie');
    map.mapTypes.set('SnazzyMaps', SnazzyMaps);
    map.setMapTypeId('SnazzyMaps');
    map.mapTypes.set('Victorian_blue', VictorianBlue);
    map.setMapTypeId('Victorian_blue');


    /* Instantiate a renderer for directions and bind it to the map. */
    var directionsDisplay = new google.maps.DirectionsRenderer({
        draggable: true,
        map: map,
        panel: document.getElementById('right-panel')
    });
    // Instantiate a directions service.
    var directionsService = new google.maps.DirectionsService;

    /* init geocoder to get location via add marker on map or input into the field in route form*/
    var geocoder = new google.maps.Geocoder();
    /* add to info window element */
    var infoWindow = new google.maps.InfoWindow;


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
    /* delete marker */
    document.getElementById('delete-spot-butt').addEventListener('click',function(){
        var address = document.getElementById('spot-address-in').value;
        for(var i = 0; i <  markers.length; i++){
            if(markers[i].get('address') ===  address){
                alert("Delete marker");
                deleteMarker(markers[i]);
            }
        }
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

    /* when create-route is slicked */
    document.getElementById('save-route-butt').addEventListener('click', function () {
        if(markers.length === 0){
            alert('Please, add order spot');
        }
    });

    // This event listener calls addMarker() when the map is clicked.
    google.maps.event.addListener(map, 'click', function(event) {
        if(markers.length > 3){
            window.alert("Oh my God!!!" +
                "You have reached allowed count of spots");
        }else {
            var address = document.getElementById('spot-address-in').value;
            if(address === ''){
                geocodeLatLng(event.latLng, geocoder, map, infoWindow);
            }else{
                alert('Save current spot or delete it to create new one');
            }

        }
    });

    /* add the spot type */
    document.getElementById('spot-type-s').addEventListener('change', function(){
        var address = document.getElementById('spot-address-in').value;
        if(address === ''){
            alert("Please, add spot to chose the type")
        }else{
            for(var i = 0; i < markers.length; i++){
                if(markers[i].get("address") === address) {
                    if (document.getElementById('spot-type-s').value === storeLable) {
                        markers[i].set("type", storeLable);
                        alert(markers[i].get("type"));
                        break;
                    } else if (document.getElementById('spot-type-s').value === destinationLable) {
                        markers[i].set("type", destinationLable);
                        alert(markers[i].get("type"));
                        break;
                    }
                }
            }
        }
    });

   /* google.maps.event.addDomListener(window, 'load', initialize);*/
}

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
                marker.set("address",results[1].formatted_address);

                /* add address into the field address in route form */
                var address = document.getElementById('spot-address-in').value = results[1].formatted_address;
                /* add latitude, longitude into appropriate fields in the route form */
                var latitude = document.getElementById('spot-lat-in').value = results[0].geometry.location.lat();
                var longitude = document.getElementById('spot-lng-in').value = results[0].geometry.location.lng();


                /* add address into the info window */
                infowindow.setContent(results[1].formatted_address);
                /*open info window */
                infowindow.open(map, marker);
                /* push marker into array */
                markers.push(marker);

                /*/!* when the delete button is clicked *!/
                 document.getElementById('delete-spot-butt').addEventListener('click',function(){
                 deleteMarker(marker);
                 });*/
                /* add listener to all added markers */
                for (var i = 0; i < markers.length; i++) {
                    //Attach click event to the marker.
                    (function (marker) {

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
                            /*/!* update marker *!/
                             document.getElementById('save-spot-butt').addEventListener('click',function(){
                             var spotType = document.getElementById('spot-type-s').value;
                             if(spotType === 'Store'){
                             data.set("type",storeLable);
                             }else{
                             data.set("type",destinationLable);
                             }

                             });*/
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

                    })(marker);

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


/* calculate and display route */
function calculateAndDisplayRoute(directionsService, directionsDisplay) {
    var start;
    var end;
    alert(markers.length);
    for(var i = 0; i < markers.length;i++){
        if(markers[i].get("type") === storeLable){
            alert(markers[i].get("type"));
            start = markers[i].getPosition();
        }else{
            alert(markers[i].get("type"));
            end = markers[i].getPosition();
        }
    }
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
