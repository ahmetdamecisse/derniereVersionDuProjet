/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "postulations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postulations.findAll", query = "SELECT p FROM Postulations p"),
    @NamedQuery(name = "Postulations.findByIdPostulation", query = "SELECT p FROM Postulations p WHERE p.idPostulation = :idPostulation")})
public class Postulations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPostulation")
    private Integer idPostulation;
    @JoinColumn(name = "idOffresEmpoiStages", referencedColumnName = "idOffresEmpoiStages")
    @ManyToOne
    private OffresDEmploiEtStages idOffresEmpoiStages;
    @JoinColumn(name = "idCandidat", referencedColumnName = "idCandidat")
    @ManyToOne
    private Candidat idCandidat;

    public Postulations() {
    }

    public Postulations(Integer idPostulation) {
        this.idPostulation = idPostulation;
    }

    public Integer getIdPostulation() {
        return idPostulation;
    }

    public void setIdPostulation(Integer idPostulation) {
        this.idPostulation = idPostulation;
    }

    public OffresDEmploiEtStages getIdOffresEmpoiStages() {
        return idOffresEmpoiStages;
    }

    public void setIdOffresEmpoiStages(OffresDEmploiEtStages idOffresEmpoiStages) {
        this.idOffresEmpoiStages = idOffresEmpoiStages;
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
        hash += (idPostulation != null ? idPostulation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postulations)) {
            return false;
        }
        Postulations other = (Postulations) object;
        if ((this.idPostulation == null && other.idPostulation != null) || (this.idPostulation != null && !this.idPostulation.equals(other.idPostulation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Postulations[ idPostulation=" + idPostulation + " ]";
    }
    
}
