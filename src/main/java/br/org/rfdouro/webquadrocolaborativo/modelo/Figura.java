/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.rfdouro.webquadrocolaborativo.modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author romulo.douro
 */
public class Figura {
 private String shape;
 private String color;
 private Coordenadas coords;

 public String getShape() {
  return shape;
 }

 public void setShape(String shape) {
  this.shape = shape;
 }

 public String getColor() {
  return color;
 }

 public void setColor(String color) {
  this.color = color;
 }

 public Coordenadas getCoords() {
  return coords;
 }

 public void setCoords(Coordenadas coords) {
  this.coords = coords;
 }
 
 @Override
 public String toString(){
  String json = new GsonBuilder().create().toJson(this);
  return json;
 }
}
