/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nikos
 */
@Entity
@Table(name = "TBL_ELECTORAL_PERIPHERY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElectoralPeriphery.findAll", query = "SELECT e FROM ElectoralPeriphery e")
    , @NamedQuery(name = "ElectoralPeriphery.findByPkElectoralPeripheryId", query = "SELECT e FROM ElectoralPeriphery e WHERE e.pkElectoralPeripheryId = :pkElectoralPeripheryId")
    , @NamedQuery(name = "ElectoralPeriphery.findByFldName", query = "SELECT e FROM ElectoralPeriphery e WHERE e.fldName = :fldName")
    , @NamedQuery(name = "ElectoralPeriphery.findByFldRegisteredCitizensCount", query = "SELECT e FROM ElectoralPeriphery e WHERE e.fldRegisteredCitizensCount = :fldRegisteredCitizensCount")
    , @NamedQuery(name = "ElectoralPeriphery.findByFldSeatsCount", query = "SELECT e FROM ElectoralPeriphery e WHERE e.fldSeatsCount = :fldSeatsCount")})
public class ElectoralPeriphery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_ELECTORAL_PERIPHERY_ID")
    private Integer pkElectoralPeripheryId;
    @Basic(optional = false)
    @Column(name = "FLD_NAME")
    private String fldName;
    @Column(name = "FLD_REGISTERED_CITIZENS_COUNT")
    private Integer fldRegisteredCitizensCount;
    @Column(name = "FLD_SEATS_COUNT")
    private Integer fldSeatsCount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkElectoralPeripheryId")
    private Collection<Candidate> candidateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkElectoralPeripheryId")
    private Collection<Vote> voteCollection;

    public ElectoralPeriphery() {
    }

    public ElectoralPeriphery(Integer pkElectoralPeripheryId) {
        this.pkElectoralPeripheryId = pkElectoralPeripheryId;
    }

    public ElectoralPeriphery(Integer pkElectoralPeripheryId, String fldName) {
        this.pkElectoralPeripheryId = pkElectoralPeripheryId;
        this.fldName = fldName;
    }

    public Integer getPkElectoralPeripheryId() {
        return pkElectoralPeripheryId;
    }

    public void setPkElectoralPeripheryId(Integer pkElectoralPeripheryId) {
        this.pkElectoralPeripheryId = pkElectoralPeripheryId;
    }

    public String getFldName() {
        return fldName;
    }

    public void setFldName(String fldName) {
        this.fldName = fldName;
    }

    public Integer getFldRegisteredCitizensCount() {
        return fldRegisteredCitizensCount;
    }

    public void setFldRegisteredCitizensCount(Integer fldRegisteredCitizensCount) {
        this.fldRegisteredCitizensCount = fldRegisteredCitizensCount;
    }

    public Integer getFldSeatsCount() {
        return fldSeatsCount;
    }

    public void setFldSeatsCount(Integer fldSeatsCount) {
        this.fldSeatsCount = fldSeatsCount;
    }

    @XmlTransient
    public Collection<Candidate> getCandidateCollection() {
        return candidateCollection;
    }

    public void setCandidateCollection(Collection<Candidate> candidateCollection) {
        this.candidateCollection = candidateCollection;
    }

    @XmlTransient
    public Collection<Vote> getVoteCollection() {
        return voteCollection;
    }

    public void setVoteCollection(Collection<Vote> voteCollection) {
        this.voteCollection = voteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkElectoralPeripheryId != null ? pkElectoralPeripheryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElectoralPeriphery)) {
            return false;
        }
        ElectoralPeriphery other = (ElectoralPeriphery) object;
        if ((this.pkElectoralPeripheryId == null && other.pkElectoralPeripheryId != null) || (this.pkElectoralPeripheryId != null && !this.pkElectoralPeripheryId.equals(other.pkElectoralPeripheryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbentity.ElectoralPeriphery[ pkElectoralPeripheryId=" + pkElectoralPeripheryId + " ]";
    }
    
}
