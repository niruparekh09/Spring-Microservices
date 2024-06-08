### REST Versioning 
**URI Versioning - Twitter**
- V1: http://localhost:8080/v1/person
    - @GetMapping("/v1/person")
- V2: http://localhost:8080/v2/person
    - @GetMapping("/v2/person")

**Request Param Versioning - Amazon**
- V1: http://localhost:8080/person?version=1
    - @GetMapping(path = "/person", params = "version=1")
- V2: http://localhost:8080/person?version=2
    - @GetMapping(path = "/person", params = "version=2")

**Header Versioning - Microsoft**
- V1: http://localhost:8080/person/header
    - HEADER - X-API-VERSION:1
    - @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
- V2: http://localhost:8080/person/header
    - HEADER - X-API-VERSION:2
    - @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")

**Content Negotiation Versioning - GitHub**
- V1: http://localhost:8080/person/accept
    - HEADER - Accept:application/vnd.company.app-v1+json
    - @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
- V2: http://localhost:8080/person/accept
    - HEADER - Accept:application/vnd.company.app-v1+json
    - @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")