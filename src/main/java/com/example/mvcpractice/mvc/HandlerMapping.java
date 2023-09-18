package com.example.mvcpractice.mvc;

public interface HandlerMapping {
    Object findHandler(HandlerKey handlerKey);
}
