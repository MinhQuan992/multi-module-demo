# StudentControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteStudent**](StudentControllerApi.md#deleteStudent) | **DELETE** /api/v1/student/{studentId} | 
[**getStudents**](StudentControllerApi.md#getStudents) | **GET** /api/v1/student | 
[**registerNewStudent**](StudentControllerApi.md#registerNewStudent) | **POST** /api/v1/student | 
[**updateStudent**](StudentControllerApi.md#updateStudent) | **PUT** /api/v1/student/{studentId} | 


<a name="deleteStudent"></a>
# **deleteStudent**
> deleteStudent(studentId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StudentControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    StudentControllerApi apiInstance = new StudentControllerApi(defaultClient);
    Long studentId = 56L; // Long | 
    try {
      apiInstance.deleteStudent(studentId);
    } catch (ApiException e) {
      System.err.println("Exception when calling StudentControllerApi#deleteStudent");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentId** | **Long**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getStudents"></a>
# **getStudents**
> List&lt;Student&gt; getStudents()



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StudentControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    StudentControllerApi apiInstance = new StudentControllerApi(defaultClient);
    try {
      List<Student> result = apiInstance.getStudents();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StudentControllerApi#getStudents");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Student&gt;**](Student.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="registerNewStudent"></a>
# **registerNewStudent**
> registerNewStudent(student)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StudentControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    StudentControllerApi apiInstance = new StudentControllerApi(defaultClient);
    Student student = new Student(); // Student | 
    try {
      apiInstance.registerNewStudent(student);
    } catch (ApiException e) {
      System.err.println("Exception when calling StudentControllerApi#registerNewStudent");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **student** | [**Student**](Student.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="updateStudent"></a>
# **updateStudent**
> updateStudent(studentId, name, email)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StudentControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    StudentControllerApi apiInstance = new StudentControllerApi(defaultClient);
    Long studentId = 56L; // Long | 
    String name = "name_example"; // String | 
    String email = "email_example"; // String | 
    try {
      apiInstance.updateStudent(studentId, name, email);
    } catch (ApiException e) {
      System.err.println("Exception when calling StudentControllerApi#updateStudent");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentId** | **Long**|  |
 **name** | **String**|  | [optional]
 **email** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

