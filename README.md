Welcome to Tracker
==================

Swagger URL: [Swagger](http://tracker.haseeb.co/swagger-ui.html)
----------------------------------------------------------------

**Action**

**Sample URL**

Vehicle by VIN /vehicles/{vin}

[http://tracker.haseeb.co/vehicles/1HGCR2F3XFA027534](http://tracker.haseeb.co/vehicles/1HGCR2F3XFA027534)

All Vehicles /vehicles

[http://tracker.haseeb.co/vehicles](http://tracker.haseeb.co/vehicles)

Alerts by Priority and Time Sort by Time DESC/alerts

[http://tracker.haseeb.co/alerts?priority=MEDIUM&start=1528175820000&end=1528176000000&sort=time,desc](http://tracker.haseeb.co/alerts?priority=MEDIUM&start=1528175820000&end=1528176000000&sort=time,desc)

MEDIUM Alerts in last two hours /alerts

[http://tracker.haseeb.co/alerts?priority=MEDIUM](http://tracker.haseeb.co/alerts?priority=MEDIUM)

All Alerts /alerts/all

[http://tracker.haseeb.co/alerts/all](http://tracker.haseeb.co/alerts/all)

Readings Geolocation by Vehicle and Time /readings

[http://tracker.haseeb.co/readings?vin=1HGCR2F3XFA027534&start=1528175820000&end=1528176000000](http://tracker.haseeb.co/readings?vin=1HGCR2F3XFA027534&start=1528175820000&end=1528176000000)

Readings default to last 30 mins if no start and end parameters are passed /readings

[http://tracker.haseeb.co/readings?vin=1HGCR2F3XFA027534](http://tracker.haseeb.co/readings?vin=1HGCR2F3XFA027534&start=1528175820000&end=1528176000000)

All Readings /readings/all

[http://tracker.haseeb.co/readings](http://tracker.haseeb.co/readings)
