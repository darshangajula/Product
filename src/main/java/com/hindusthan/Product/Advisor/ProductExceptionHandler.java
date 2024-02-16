package com.hindusthan.Product.Advisor;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@Log4j2
public class ProductExceptionHandler {
@ExceptionHandler(UpdateException.class)

    public ResponseEntity<ExceptionDetail> handleUpdateException(UpdateException updateException , WebRequest webRequest){
    ExceptionDetail exceptionDetail= new ExceptionDetail(new Date(),updateException.getResponseName(),"there is no such id to update");
    return new ResponseEntity<>(exceptionDetail,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(DeleteException.class)
    public ResponseEntity<ExceptionDetail> handleDeleteException(DeleteException deleteException, WebRequest webRequest){
    ExceptionDetail exceptionDetail = new ExceptionDetail(new Date(),deleteException.getResponseName(),"no such id is found to delete");
   return new ResponseEntity<>(exceptionDetail,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(FindException.class)
    public ResponseEntity<ExceptionDetail> handlesFindException(FindException findException,WebRequest webRequest){
    ExceptionDetail exceptionDetail = new ExceptionDetail(new Date(), findException.getResponseHandler(), "could'nt find the id you have entered");
   return new  ResponseEntity<>(exceptionDetail,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(SaveException.class)
    public ResponseEntity<ExceptionDetail> handlesSaveException(SaveException saveException,WebRequest webRequest){
   ExceptionDetail exceptionDetail= new ExceptionDetail(new Date(), saveException.getResponseName(), "Error saving data to the database ");
    return new ResponseEntity<>(exceptionDetail,HttpStatus.BAD_REQUEST);
}
}

