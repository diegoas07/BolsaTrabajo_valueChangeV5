/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.cliclodevida;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Desarrollo2
 */
public class DepuracionListener implements  javax.faces.event.PhaseListener{
    
    private static final Log log = LogFactory.getLog(DepuracionListener.class);
    
    @Override
    public void afterPhase(PhaseEvent pe) {
        if (log.isInfoEnabled()) {
            log.info("AFTHER PAHSE: " + pe.getPhaseId().toString());
        }    
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        if (log.isInfoEnabled()) {
            log.info("BEFORE PAHSE: " + pe.getPhaseId().toString());
        } 
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
