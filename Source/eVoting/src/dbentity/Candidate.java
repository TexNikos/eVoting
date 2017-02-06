/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nikos
 */
@Entity
@Table(name = "TBL_CANDIDATE")
@XmlRootElement
@NamedQueries(
        {
            @NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c")
            , @NamedQuery(name = "Candidate.findByPkCandidateId", query = "SELECT c FROM Candidate c WHERE c.pkCandidateId = :pkCandidateId")
            , @NamedQuery(name = "Candidate.findByFldSurname", query = "SELECT c FROM Candidate c WHERE c.fldSurname = :fldSurname")
            , @NamedQuery(name = "Candidate.findByFldName", query = "SELECT c FROM Candidate c WHERE c.fldName = :fldName")
            , @NamedQuery(name = "Candidate.findByFkElectoralPeriphery", query = "SELECT c FROM Candidate c WHERE c.fkElectoralPeripheryId = :fkElectoralPeripheryId")
            ,@NamedQuery(name = "Candidate.findByFkPoliticalPartyId", query = "SELECT c FROM Candidate c WHERE c.fkPoliticalPartyId = :fkPoliticalPartyId")
            ,@NamedQuery(name = "Candidate.findByElectPerAndPolParty", query = "SELECT c FROM Candidate c WHERE c.fkElectoralPeripheryId = :fkElectoralPeripheryId AND c.fkPoliticalPartyId = :fkPoliticalPartyId")
        })
public class Candidate implements Serializable
{

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_CANDIDATE_ID")
    private Long pkCandidateId;
    @Basic(optional = false)
    @Column(name = "FLD_SURNAME")
    private String fldSurname;
    @Basic(optional = false)
    @Column(name = "FLD_NAME")
    private String fldName;
    @JoinColumn(name = "FK_ELECTORAL_PERIPHERY_ID", referencedColumnName = "PK_ELECTORAL_PERIPHERY_ID")
    @ManyToOne(optional = false)
    private ElectoralPeriphery fkElectoralPeripheryId;
    @JoinColumn(name = "FK_POLITICAL_PARTY_ID", referencedColumnName = "PK_PARTY_ID")
    @ManyToOne(optional = false)
    private PoliticalParty fkPoliticalPartyId;
    @OneToMany(mappedBy = "fkCandidateId")
    private Collection<Vote> voteCollection;

    public Candidate()
    {
    }

    public Candidate(Long pkCandidateId)
    {
        this.pkCandidateId = pkCandidateId;
    }

    public Candidate(Long pkCandidateId, String fldSurname, String fldName)
    {
        this.pkCandidateId = pkCandidateId;
        this.fldSurname = fldSurname;
        this.fldName = fldName;
    }

    public Long getPkCandidateId()
    {
        return pkCandidateId;
    }

    public void setPkCandidateId(Long pkCandidateId)
    {
        Long oldPkCandidateId = this.pkCandidateId;
        this.pkCandidateId = pkCandidateId;
        changeSupport.firePropertyChange("pkCandidateId", oldPkCandidateId, pkCandidateId);
    }

    public String getFldSurname()
    {
        return fldSurname;
    }

    public void setFldSurname(String fldSurname)
    {
        String oldFldSurname = this.fldSurname;
        this.fldSurname = fldSurname;
        changeSupport.firePropertyChange("fldSurname", oldFldSurname, fldSurname);
    }

    public String getFldName()
    {
        return fldName;
    }

    public void setFldName(String fldName)
    {
        String oldFldName = this.fldName;
        this.fldName = fldName;
        changeSupport.firePropertyChange("fldName", oldFldName, fldName);
    }

    public ElectoralPeriphery getFkElectoralPeripheryId()
    {
        return fkElectoralPeripheryId;
    }

    public void setFkElectoralPeripheryId(ElectoralPeriphery fkElectoralPeripheryId)
    {
        ElectoralPeriphery oldFkElectoralPeripheryId = this.fkElectoralPeripheryId;
        this.fkElectoralPeripheryId = fkElectoralPeripheryId;
        changeSupport.firePropertyChange("fkElectoralPeripheryId", oldFkElectoralPeripheryId, fkElectoralPeripheryId);
    }

    public PoliticalParty getFkPoliticalPartyId()
    {
        return fkPoliticalPartyId;
    }

    public void setFkPoliticalPartyId(PoliticalParty fkPoliticalPartyId)
    {
        PoliticalParty oldFkPoliticalPartyId = this.fkPoliticalPartyId;
        this.fkPoliticalPartyId = fkPoliticalPartyId;
        changeSupport.firePropertyChange("fkPoliticalPartyId", oldFkPoliticalPartyId, fkPoliticalPartyId);
    }

    @XmlTransient
    public Collection<Vote> getVoteCollection()
    {
        return voteCollection;
    }

    public void setVoteCollection(Collection<Vote> voteCollection)
    {
        this.voteCollection = voteCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (pkCandidateId != null ? pkCandidateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidate))
        {
            return false;
        }
        Candidate other = (Candidate) object;
        if ((this.pkCandidateId == null && other.pkCandidateId != null) || (this.pkCandidateId != null && !this.pkCandidateId.equals(other.pkCandidateId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "dbentity.Candidate[ pkCandidateId=" + pkCandidateId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        changeSupport.removePropertyChangeListener(listener);
    }

}
