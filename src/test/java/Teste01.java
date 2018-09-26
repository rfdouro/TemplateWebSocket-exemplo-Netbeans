
import br.org.rfdouro.webquadrocolaborativo.modelo.Coordenadas;
import br.org.rfdouro.webquadrocolaborativo.modelo.Figura;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author romulo.douro
 */
public class Teste01 {

 public static void main(String[] args) {
  GsonBuilder builder = new GsonBuilder();
  Gson gson = builder.create();
  Coordenadas c = new Coordenadas(4, 5);
  Figura f = new Figura();
  f.setShape("square");
  f.setColor("#FF0000");
  f.setCoords(c);
  String json = gson.toJson(f);
  System.out.println(json);
  
  f = gson.fromJson(json, Figura.class);
  System.out.println(""+f);
  
 }
}
