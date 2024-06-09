/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.persistence.elastic.exception;

/**
 *
 * @author mguer
 */
public class ElasticSearchNotEnabledException extends RuntimeException {

    public ElasticSearchNotEnabledException() {
        super("ElasticSearch is not enabled");
    }
}
