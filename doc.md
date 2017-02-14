#Api Document

## reprot

### report host

- Description  


- Method

```text
GET /api/report/host
```

- Parameters

| Name |Type|Description|
|---|---|---|
|parent  |String|Requried.Base64 encoded.The prefix of children.|
| children |String|Base64 encoded.A `\u0000` splited string list|
| src |String|Indicated which the request if from|


- Response

    - Case 1
    
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
    
    - Case 2
    
    ```text
    GET /api/report/host?parent=cGFyZW50Cg==
    ```
    
    ```text
    {
      "retcode":0,
      "count":1
    }   
    ```
   
    - Case 3
    
    ```text
    GET /api/report/host?parent=cGFyZW50Cg==&children=MQAy
    ```
    
    ```text
    {
      "retcode":0,
      "count":2
    }   
    ```


===

### query-host


- Method

```text
GET /api/report/query-host
```

- Parameters

| Name |Type|Description|
|---|---|---|
| time|long|The timestamp of before which the query will perform . Defalut is the current timestamp|
| count|int|The max count of  record . Default is 1|
| src|String|The source the report is from , not supported yet|


- Response

    - Case 1
        ```text
        GET /api/report/query-host?time=1487051478992&count=1
        ```
        
        ```text
         {
           "retcode": 0,
           "data": [
             {
               "timestamp": 1487034407000,
               "hosts": [
                 "192.168.1.1",
                 "192.168.1.252"
               ]
             }
           ]
         }
        ```    
    - Case 2
         ```text
                GET /api/report/query-host?count=2
         ```
         
         ```text
         {
           "retcode": 0,
           "data": [
             {
               "timestamp": 1487034407000,
               "hosts": [
                 "192.168.1.1",
                 "192.168.1.252"
               ]
             },
             {
               "timestamp": 1486979826000,
               "hosts": [
                 "192.168.1.9",
                 "192.168.1.95"
               ]
             }
           ]
         }
         ```