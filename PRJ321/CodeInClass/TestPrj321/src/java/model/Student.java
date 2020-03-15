/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Lenovo
 */
@Getter
@Setter
@Builder
public class Student {
    private int id;
    private String name;
    private Subject sub;
    private Exam ex;
}
