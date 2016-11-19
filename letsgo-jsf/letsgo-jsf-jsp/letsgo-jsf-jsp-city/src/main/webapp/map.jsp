<%-- 
    Document   : map
    Created on : 19.11.2016, 12:32:04
    Author     : pl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <link rel="stylesheet" href="https://openlayers.org/en/v3.19.1/css/ol.css" type="text/css">
        <!-- The line below is only needed for old environments like Internet Explorer and Android 4.x -->
        <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=requestAnimationFrame,Element.prototype.classList,URL"></script>
        <script src="https://openlayers.org/en/v3.19.1/build/ol.js"></script><title>Карт городов</title>
    </head>
    <body>
        <h2>Тут играют в Го.</h2>
        <div id="map" class="map" style="width:100%; height:400px;" ></div>
        <div id="info" style="display: none;"></div>
        <label for="track">
            track position
            <input id="track" type="checkbox"/>
        </label>
        <p>
            position accuracy : <code id="accuracy"></code>&nbsp;&nbsp;
            altitude : <code id="altitude"></code>&nbsp;&nbsp;
            altitude accuracy : <code id="altitudeAccuracy"></code>&nbsp;&nbsp;
            heading : <code id="heading"></code>&nbsp;&nbsp;
            speed : <code id="speed"></code>
        </p>
        <script>
            var view = new ol.View({
                center: [0, 0],
                zoom: 2
            });

            var map = new ol.Map({
                layers: [
                    new ol.layer.Tile({
                        source: new ol.source.OSM()
                    })
                ],
                target: 'map',
                controls: ol.control.defaults({
                    attributionOptions: /** @type {olx.control.AttributionOptions} */ ({
                        collapsible: false
                    })
                }),
                view: view
            });

            var geolocation = new ol.Geolocation({
                projection: view.getProjection()
            });

            function el(id) {
                return document.getElementById(id);
            }

            el('track').addEventListener('change', function () {
                geolocation.setTracking(this.checked);
            });

            // update the HTML page when the position changes.
            geolocation.on('change', function () {
                el('accuracy').innerText = geolocation.getAccuracy() + ' [m]';
                el('altitude').innerText = geolocation.getAltitude() + ' [m]';
                el('altitudeAccuracy').innerText = geolocation.getAltitudeAccuracy() + ' [m]';
                el('heading').innerText = geolocation.getHeading() + ' [rad]';
                el('speed').innerText = geolocation.getSpeed() + ' [m/s]';
            });

            // handle geolocation error.
            geolocation.on('error', function (error) {
                var info = document.getElementById('info');
                info.innerHTML = error.message;
                info.style.display = '';
            });

            var accuracyFeature = new ol.Feature();
            geolocation.on('change:accuracyGeometry', function () {
                accuracyFeature.setGeometry(geolocation.getAccuracyGeometry());
            });

            var positionFeature = new ol.Feature();
            positionFeature.setStyle(new ol.style.Style({
                image: new ol.style.Circle({
                    radius: 6,
                    fill: new ol.style.Fill({
                        color: '#3399CC'
                    }),
                    stroke: new ol.style.Stroke({
                        color: '#fff',
                        width: 2
                    })
                })
            }));

            geolocation.on('change:position', function () {
                var coordinates = geolocation.getPosition();
                positionFeature.setGeometry(coordinates ?
                        new ol.geom.Point(coordinates) : null);
            });

            new ol.layer.Vector({
                map: map,
                source: new ol.source.Vector({
                    features: [accuracyFeature, positionFeature]
                })
            });
        </script>
    </body>
</html>
