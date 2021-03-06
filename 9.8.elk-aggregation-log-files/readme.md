# Aggregating Log Files with Elasticsearch

Downloads:

- Elasticsearch - https://www.elastic.co/downloads/elasticsearch
- Logstash - https://www.elastic.co/downloads/logstash
- Kibana - https://www.elastic.co/downloads/kibana

# Start Elasticsearch

Note: You should be able to see something like below - 

```
users@Prateeks-MacBook-Pro elasticsearch-8.3.2 % bin/elasticsearch
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
✅ Elasticsearch security features have been automatically configured!
✅ Authentication is enabled and cluster connections are encrypted.

ℹ️  Password for the elastic user (reset with `bin/elasticsearch-reset-password -u elastic`):
  QtPj6G806lU1a-OPQtMg

ℹ️  HTTP CA certificate SHA-256 fingerprint:
  2c27c82068c6fe5b28383e04fc6efaca2c2b6fb11aa719ee088abaefbf003d1a

ℹ️  Configure Kibana to use this cluster:
• Run Kibana and click the configuration link in the terminal when Kibana starts.
• Copy the following enrollment token and paste it into Kibana in your browser (valid for the next 30 minutes):
  eyJ2ZXIiOiI4LjMuMiIsImFkciI6WyIxOTIuMTY4LjY5LjQyOjkyMDAiXSwiZmdyIjoiMmMyN2M4MjA2OGM2ZmU1YjI4MzgzZTA0ZmM2ZWZhY2EyYzJiNmZiMTFhYTcxOWVlMDg4YWJhZWZiZjAwM2QxYSIsImtleSI6ImRkN2w2NEVCelV3RzNzTlpNY2JSOkRQSGpIVVVkVDVhRlJYcG91MTByMmcifQ==

ℹ️  Configure other nodes to join this cluster:
• On this node:
  ⁃ Create an enrollment token with `bin/elasticsearch-create-enrollment-token -s node`.
  ⁃ Uncomment the transport.host setting at the end of config/elasticsearch.yml.
  ⁃ Restart Elasticsearch.
• On other nodes:
  ⁃ Start Elasticsearch with `bin/elasticsearch --enrollment-token <token>`, using the enrollment token that you generated.
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━`
````

https://localhost:9200/_cat/indices - you will ask for username and password, enter username=elastic, password=QtPj6G806lU1a-OPQtMg, 
whenever you will start elasticsearch, you will get new password

```sh
yellow open users-ws-2022.07.11  9T7it1V9SdSyoWHjg2YOKA 1 1 92 0 215.2kb 215.2kb
yellow open albums-ws-2022.07.11 SSNTi7yyQ3KWDucynGL70w 1 1 38 0  74.5kb  74.5kb
```

- See more details - 

```sh
https://localhost:9200/users-ws-2022.07.11/_search?q=*
https://localhost:9200/albums-ws-2022.07.11/_search?q=*

https://localhost:9200/albums-ws-2022.07.11/_search?q=message:Eureka
```

# simple-config.conf
Note: Your username and password should match with when you actually start the elasticsearch, place this file in 

```sh
input {
	file {
		type=> "users-ws-log"
		path=>"/Users/prats/Documents/Prateek/Spring-Boot-Microservices-and-Spring-Cloud-sergey/9.8.elk-aggregation-log-files/photo-service/users-ws.log"
	}

	file {
		type=> "albums-ws-log"
		path=>"/Users/prats/Documents/Prateek/Spring-Boot-Microservices-and-Spring-Cloud-sergey/9.8.elk-aggregation-log-files/album-service/albums-ws.log"
	}
}

output {
	if[type] == "users-ws-log" {
		elasticsearch {
			hosts => ["https://localhost:9200"]
			index => "users-ws-%{+YYYY.MM.dd}"
			user => "elastic"
			password => "QtPj6G806lU1a-OPQtMg"
			cacert => "/Users/prats/Documents/Software/ELK/elasticsearch-8.3.2/config/certs/http_ca.crt" 
		}
	}else if[type] == "albums-ws-log" {
		elasticsearch {
			hosts => ["https://localhost:9200"]
			index => "albums-ws-%{+YYYY.MM.dd}"
			user => "elastic"
			password => "QtPj6G806lU1a-OPQtMg"
			cacert => "/Users/prats/Documents/Software/ELK/elasticsearch-8.3.2/config/certs/http_ca.crt" 
		}
	}

	stdout { codec => rubydebug}
}
```

<img width="827" alt="Screenshot 2022-07-11 at 1 04 03 PM" src="https://user-images.githubusercontent.com/54174687/178212187-4b5e3e93-0b3f-42d2-a742-2226e01c3862.png">

# Start All the services

<img width="349" alt="Screenshot 2022-07-11 at 1 05 39 PM" src="https://user-images.githubusercontent.com/54174687/178212417-e42e77dc-e413-4a91-ae23-8ebbaeae0db7.png">

# In case your token is expired, create new one 

```sh
bin/elasticsearch-create-enrollment-token --scope kibana
```

# Start logstash

```sh
users@Prateeks-MacBook-Pro logstash-8.3.2 % bin/logstash -f simple-config.conf
```

# Start kibana

```sh
users@Prateeks-MacBook-Pro kibana-8.3.2 % bin/kibana
[2022-07-11T12:38:10.680+05:30][INFO ][plugins-service] Plugin "cloudSecurityPosture" is disabled.
[2022-07-11T12:38:10.769+05:30][INFO ][http.server.Preboot] http server running at http://localhost:5601
[2022-07-11T12:38:10.823+05:30][INFO ][plugins-system.preboot] Setting up [1] plugins: [interactiveSetup]
[2022-07-11T12:38:10.829+05:30][INFO ][preboot] "interactiveSetup" plugin is holding setup: Validating Elasticsearch connection configuration…
[2022-07-11T12:38:10.892+05:30][INFO ][root] Holding setup until preboot stage is completed.

i Kibana has not been configured.

Go to http://localhost:5601/?code=843189 to get started.
```

Note: Steps need to be performed to be able to see data on dashboard

# See Logs in Kibana

<img width="1500" alt="Screenshot 2022-07-11 at 1 10 20 PM" src="https://user-images.githubusercontent.com/54174687/178213199-e4200210-556f-47fe-b524-590785bc56fd.png">

<img width="1489" alt="Screenshot 2022-07-11 at 1 10 51 PM" src="https://user-images.githubusercontent.com/54174687/178213301-1fbaf13c-f3e4-4df1-86a9-ec04b1f5a1f5.png">

