package designpatterns.chainofresponsibility.cor;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author liuyi27
 */
@Getter
@Setter
@AllArgsConstructor
public class Trouble {

    private int number;


       public String toString(){
           return "问题编号：["+number+"]";
      }
}
