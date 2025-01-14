package br.com.codemathsz.dev_path_academy.exceptions;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(String courseId){
        super(String.format("Course[%s] not found", courseId));
    }
}
