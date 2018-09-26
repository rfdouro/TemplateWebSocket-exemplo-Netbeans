/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.rfdouro.webquadrocolaborativo.codificadores;

import br.org.rfdouro.webquadrocolaborativo.modelo.Figura;
import com.google.gson.GsonBuilder;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author romulo.douro
 */
public class FiguraDecoder implements Decoder.Text<Figura> {

 @Override
 public Figura decode(String s) throws DecodeException {
  Figura f = new GsonBuilder().create().fromJson(s, Figura.class);
  return f;
 }

 @Override
 public boolean willDecode(String s) {
  try {
   new GsonBuilder().create().fromJson(s, Figura.class);
   return true;
  } catch (Exception ex) {
   ex.printStackTrace();
   return false;
  }
 }

 @Override
 public void init(EndpointConfig config) {
  System.out.println("inicia decoder");
 }

 @Override
 public void destroy() {
  System.out.println("destroi decoder");
 }

}
