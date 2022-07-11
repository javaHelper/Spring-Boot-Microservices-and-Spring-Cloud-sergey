# Aggregating Log Files with Elasticsearch

Downloads:

Elasticsearch - https://www.elastic.co/downloads/elasticsearch
Logstash - https://www.elastic.co/downloads/logstash
Kibana - https://www.elastic.co/downloads/kibana

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


