package org.example;


import org.openapitools.client.ApiException;
import org.openapitools.client.api.StudentControllerApi;
import org.openapitools.client.model.Student;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ApiException {
        StudentControllerApi studentControllerApi = new StudentControllerApi();
        List<Student> students = studentControllerApi.getStudents();
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
