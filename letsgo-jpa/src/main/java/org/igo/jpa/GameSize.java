/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

/**
 *
 * @author pl
 */
public enum GameSize {

    S9(9), S11(11), S13(13), S15(15), S17(17), S19(19), S21(21);

    private final Integer size;

    private GameSize(Integer size) {
        this.size = size;
    }
}
