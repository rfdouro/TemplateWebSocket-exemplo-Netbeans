/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.rfdouro.webquadrocolaborativo.codificadores;

import br.org.rfdouro.webquadrocolaborativo.modelo.Figura;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author romulo.douro
 */
public class FiguraEncoder implements Encoder.Text<Figura> {

 @Override
 public String encode(Figura object) throws EncodeException {
  return object.toString();
 }

 @Override
 public void init(EndpointConfig config) {
  System.out.println("inicia encoder");
 }

 @Override
 public void destroy() {
  System.out.println("destroi encoder");
 }
 
}
