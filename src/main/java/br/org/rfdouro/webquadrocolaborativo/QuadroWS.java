/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.rfdouro.webquadrocolaborativo;

import br.org.rfdouro.webquadrocolaborativo.codificadores.FiguraDecoder;
import br.org.rfdouro.webquadrocolaborativo.codificadores.FiguraEncoder;
import br.org.rfdouro.webquadrocolaborativo.modelo.Figura;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author romulo.douro
 */
@ServerEndpoint(value = "/quadrows", encoders = {FiguraEncoder.class}, decoders = {FiguraDecoder.class})
public class QuadroWS {

 private static Set<Session> pessoas = Collections.synchronizedSet(new HashSet<Session>());

 /*@OnMessage
 public String onMessage(String message) {
  return null;
 }*/
 @OnMessage
 public void broadcastFigure(Figura figura, Session session) throws IOException, EncodeException {
  System.out.println("broadcastFigura: " + figura);
  for (Session peer : pessoas) {
   if (!peer.equals(session)) {
    peer.getBasicRemote().sendObject(figura);
   }
  }
 }

 @OnOpen
 public void onOpen(Session pessoa) {
  System.out.println("Entrando " + pessoa);
  pessoas.add(pessoa);
 }

 @OnClose
 public void onClose(Session pessoa) {
  System.out.println("Saindo " + pessoa);
  pessoas.remove(pessoa);
 }

 @OnError
 public void onError(Throwable t) {
  System.out.println("ERRO " + t.getMessage());
 }

}
