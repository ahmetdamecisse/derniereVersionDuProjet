/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "faireentrtien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faireentrtien.findAll", query = "SELECT f FROM Faireentrtien f"),
    @NamedQuery(name = "Faireentrtien.findByIdEntretien", query = "SELECT f FROM Faireentrtien f WHERE f.idEntretien = :idEntretien"),
    @NamedQuery(name = "Faireentrtien.findByDateentretien", query = "SELECT f FROM Faireentrtien f WHERE f.dateentretien = :dateentretien")})
public class Faireentrtien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEntretien")
    private Integer idEntretien;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateentretien")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateentretien;
    @JoinColumn(name = "idEntretien", referencedColumnName = "idEntretien", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Entretien entretien;
    @JoinColumn(name = "idCandidat", referencedColumnName = "idCandidat")
    @ManyToOne(optional = false)
    private Candidat idCandidat;

    public Faireentrtien() {
    }

    public Faireentrtien(Integer idEntretien) {
        this.idEntretien = idEntretien;
    }

    public Faireentrtien(Integer idEntretien, Date dateentretien) {
        this.idEntretien = idEntretien;
        this.dateentretien = dateentretien;
    }

    public Integer getIdEntretien() {
        return idEntretien;
    }

    public void setIdEntretien(Integer idEntretien) {
        this.idEntretien = idEntretien;
    }

    public Date getDateentretien() {
        return dateentretien;
    }

    public void setDateentretien(Date dateentretien) {
        this.dateentretien = dateentretien;
    }

    public Entretien getEntretien() {
        return entretien;
    }

    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
    }

    public Candidat getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(Candidat idCandidat) {
        this.idCandidat = idCandidat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntretien != null ? idEntretien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faireentrtien)) {
            return false;
        }
        Faireentrtien other = (Faireentrtien) object;
        if ((this.idEntretien == null && other.idEntretien != null) || (this.idEntretien != null && !this.idEntretien.equals(other.idEntretien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Faireentrtien[ idEntretien=" + idEntretien + " ]";
    }
    
}
