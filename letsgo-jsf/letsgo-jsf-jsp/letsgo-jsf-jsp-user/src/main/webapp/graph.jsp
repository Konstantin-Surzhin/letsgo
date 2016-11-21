<%-- 
    Document   : graph
    Created on : 19.11.2016, 13:33:07
    Author     : pl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/libs/highcharts/highcharts.js" type="text/javascript"></script>
        <script src="js/libs/highcharts/themes/gray.js" type="text/javascript"></script>
        <script src="js/libs/jquery/jquery.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            $(function () {
                var myChart = Highcharts.chart('container', {
                    chart: {
                        type: 'bar'
                    },
                    title: {
                        text: 'Fruit Consumption'
                    },
                    xAxis: {
                        categories: ['Apples', 'Bananas', 'Oranges']
                    },
                    yAxis: {
                        title: {
                            text: 'Fruit eaten'
                        }
                    },
                    series: [{
                            name: 'Jane',
                            data: [1, 0, 4]
                        }, {
                            name: 'John',
                            data: [5, 7, 3]
                        }]
                });
            });</script>
    </head>
    <script type="text/javascript">
        var chart1; // globally available
        $(function () {
            chart1 = Highcharts.stockChart('container', {
                rangeSelector: {
                    selected: 1
                },
                series: [{
                        name: 'USD to EUR',
                        data: usdtoeur // predefined JavaScript array
                    }]
            });
        });
    </script>

    <body>
        <h2>Различные графики по городам!</h2>
        <div id="container" style="width:100%; height:400px;"></div>
    </body>
</html>
