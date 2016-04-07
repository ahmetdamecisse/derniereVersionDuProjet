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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "fichedeposte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichedeposte.findAll", query = "SELECT f FROM Fichedeposte f"),
    @NamedQuery(name = "Fichedeposte.findByIdFichePoste", query = "SELECT f FROM Fichedeposte f WHERE f.idFichePoste = :idFichePoste"),
    @NamedQuery(name = "Fichedeposte.findByIntitulePoste", query = "SELECT f FROM Fichedeposte f WHERE f.intitulePoste = :intitulePoste"),
    @NamedQuery(name = "Fichedeposte.findByVersion", query = "SELECT f FROM Fichedeposte f WHERE f.version = :version")})
public class Fichedeposte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFichePoste")
    private Integer idFichePoste;
    @Size(max = 1500)
    @Column(name = "intitulePoste")
    private String intitulePoste;
    @Lob
    @Size(max = 16777215)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 16777215)
    @Column(name = "qualiteRequise")
    private String qualiteRequise;
    @Lob
    @Size(max = 16777215)
    @Column(name = "connaissanceTechni")
    private String connaissanceTechni;
    @Column(name = "version")
    private Integer version;
    @JoinColumn(name = "idRecruteur", referencedColumnName = "idRecruteur")
    @ManyToOne(optional = false)
    private Recruteur idRecruteur;

    public Fichedeposte() {
    }

    public Fichedeposte(Integer idFichePoste) {
        this.idFichePoste = idFichePoste;
    }

    public Integer getIdFichePoste() {
        return idFichePoste;
    }

    public void setIdFichePoste(Integer idFichePoste) {
        this.idFichePoste = idFichePoste;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualiteRequise() {
        return qualiteRequise;
    }

    public void setQualiteRequise(String qualiteRequise) {
        this.qualiteRequise = qualiteRequise;
    }

    public String getConnaissanceTechni() {
        return connaissanceTechni;
    }

    public void setConnaissanceTechni(String connaissanceTechni) {
        this.connaissanceTechni = connaissanceTechni;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Recruteur getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(Recruteur idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFichePoste != null ? idFichePoste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichedeposte)) {
            return false;
        }
        Fichedeposte other = (Fichedeposte) object;
        if ((this.idFichePoste == null && other.idFichePoste != null) || (this.idFichePoste != null && !this.idFichePoste.equals(other.idFichePoste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Fichedeposte[ idFichePoste=" + idFichePoste + " ]";
    }
    
}
