/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.backing;

import beans.model.Candidato;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Desarrollo2
 */
@ManagedBean
@RequestScoped
public class VacanteForm {

    /**
     * Creates a new instance of VacanteForm
     */
    public VacanteForm() {
    }

    @ManagedProperty(value = "#{candidato}")
    private Candidato candidato;

    /**
     * @return the candidato
     */
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * @param candidato the candidato to set
     */
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    
    public String enviar(){
        System.out.println("Enviar() nombre= "+candidato.getNombre());  
        System.out.println("Enviar() apellido= "+candidato.getApellido());  
        System.out.println("Enviar() Sueldo deseado= "+candidato.getSueldoDeseado());  
        System.out.println("Enviar() nombre= "+candidato.getFechaNacimiento());
        
        if (this.candidato.getNombre().equals("Juan")) {
            
            if ("Perez".equals( this.candidato.getApellido() ) ) {
                String mensaje = "Gracias pero juan perez ya trabaja con nosotros";
                FacesMessage facemessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje);
                FacesContext faceContext = FacesContext.getCurrentInstance();
                String clienteId = null;  // este es un mensaje global
                faceContext.addMessage(clienteId, facemessage);
                return "index";
            }
            
            return "exito";
        }else{
            return "fallo";
        }
    }
    
    public void codigoPostalListener(ValueChangeEvent valueChangeEven){
        System.out.println("Ejecucion codigoPostalListener()");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        String newCodigoPostal = valueChangeEven.getNewValue().toString();
        if ("03810".equals(newCodigoPostal)) {
            //                                                            idFormulario:idCampo
            UIInput ciudadImputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
            String ciudad = "BG";
            ciudadImputText.setValue(ciudad);
            ciudadImputText.setSubmittedValue(ciudad);
            
            UIInput coloniaImputText = (UIInput) uiViewRoot.findComponent("vacanteForm:colonia");
            String colonia = "Suba";
            coloniaImputText.setValue(colonia);
            coloniaImputText.setSubmittedValue(colonia);
            
            facesContext.renderResponse();
            
        }
    }
    
}
