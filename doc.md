#Api Document

## reprot

### report host

- method

```text
GET /api/report/host
```

- parameters

| Name |Type|Description|
|---|---|---|
|parent  |String|Requried.Base64 encoded.The prefix of children.|
| children |String|Base64 encoded.A `\u0000` splited string list|
| from |String|Indicated which the request if from|


- response

    - case 1
    
    ```text
    GET /api/report/host
    ```
    
    ```text
    {
      "retcode": -1,
      "msg": "parent is required",
      "count": 0
    }    
    ```
    
    - case 2
    
    ```text
    GET /api/report/host?parent=cGFyZW50Cg==
    ```
    
    ```text
    {
      "retcode":0,
      "count":1
    }   
    ```
   
    - case 3
    
    ```text
    GET /api/report/host?parent=cGFyZW50Cg==&children=MQAy
    ```
    
    ```text
    {
      "retcode":0,
      "count":2
    }   
    ```
