/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author a618081
 */
@ManagedBean
@SessionScoped
public class CarBean implements Serializable{
    
    private List<Car> cars;
    private Car selectedCar;
    
    public CarBean(){
        cars=new ArrayList<Car>();
        //cars.add(new Car("model1",2014,"atos1","blue","Développeur en java"));
        cars.add(new Car("model2",2015,"atos2","red","Spécialité en gestion de projet"));
        //cars.add(new Car("model3",2012,"atos3","write","Développeur php"));
//        cars.add(new Car("model4",2016,"atos4","black","Développeur php"));
//        cars.add(new Car("model5",2013,"atos2","yellow","Développeur php"));
//        cars.add(new Car("model6",2016,"atos1","brow","Développeur php"));
    
    }
    public List<Car> getCars(){
    
        return cars;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
    
    
}
