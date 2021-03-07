 This BhavaURLApp is a REST API which converts longurl to shorturl in a POST endpoint. And also forward the shorturl to longurl in a GET endpoint.
 
 **POST endpoint**
 
 http://localhost:9080/BhavaURLApp/v1/rest/create
 
 Content-Type: Application/json
 
 Body:
 {
    "longUrl":"http://google.com"
 }
 
 Respone it gives -> http://localhost:9080/BhavaURLApp/v1/rest/VQ2PAL
 
 
 **GET endpoint:**
 
 http://localhost:9080/BhavaURLApp/v1/rest/VQ2PAL
 forwards to longurl.
 
 
 
