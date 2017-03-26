Sample spring boot application that works with protobuf.

Uses ProtobufHttpMessageConverter to convert protobuf to JSON message to be consumed in the API.

In this API also content management features are used for example

- http http://localhost:8080/api.json -: will return json 
- http http://localhost:8080/api.xml  -: will return xml
- http http://localhost:8080/api?format=xml :- will return xml
- http http://localhost:8080/api?format=json :- will return json

TODO
---
- gRPC Server and client
- metrics
- spring boot dev reload
