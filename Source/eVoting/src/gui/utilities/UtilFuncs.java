/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.utilities;

import db.DBManager;
import dbentity.ElectoralPeriphery;
import dbentity.PoliticalParty;
import java.awt.Frame;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;

/**
 *
 * @author Nikos
 */
public class UtilFuncs {

    public static Frame getDialogOwnerFrame() {
        Frame[] frames = JFrame.getFrames();
        for (int i = 0; i < frames.length; i++) {
            Frame frame = frames[i];
            if (frame.isVisible()) {
                return frame;
            }
        }
        return null;
    }
    
    public static ElectoralPeriphery getPeripheryByName(String peripheryName) {
        TypedQuery<ElectoralPeriphery> q = DBManager.em().createNamedQuery("ElectoralPeriphery.findByFldName", ElectoralPeriphery.class);
        q.setParameter("fldName", peripheryName);
        return q.getSingleResult();
    }

    public static PoliticalParty getPoliticalPartyByName(String party) {
        TypedQuery<PoliticalParty> q = DBManager.em().createNamedQuery("PoliticalParty.findByFldTitle", PoliticalParty.class);
        q.setParameter("fldTitle", party);
        return q.getSingleResult();
    }

}
