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
@Table(name = "modelisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelisation.findAll", query = "SELECT m FROM Modelisation m"),
    @NamedQuery(name = "Modelisation.findByIdModelisation", query = "SELECT m FROM Modelisation m WHERE m.idModelisation = :idModelisation"),
    @NamedQuery(name = "Modelisation.findByDomaine", query = "SELECT m FROM Modelisation m WHERE m.domaine = :domaine"),
    @NamedQuery(name = "Modelisation.findByNiveau", query = "SELECT m FROM Modelisation m WHERE m.niveau = :niveau")})
public class Modelisation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idModelisation")
    private Integer idModelisation;
    @Size(max = 350)
    @Column(name = "domaine")
    private String domaine;
    @Size(max = 254)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idProfilGL", referencedColumnName = "idProfilGL")
    @ManyToOne(optional = false)
    private Profilgl idProfilGL;

    public Modelisation() {
    }

    public Modelisation(Integer idModelisation) {
        this.idModelisation = idModelisation;
    }

    public Integer getIdModelisation() {
        return idModelisation;
    }

    public void setIdModelisation(Integer idModelisation) {
        this.idModelisation = idModelisation;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Profilgl getIdProfilGL() {
        return idProfilGL;
    }

    public void setIdProfilGL(Profilgl idProfilGL) {
        this.idProfilGL = idProfilGL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModelisation != null ? idModelisation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelisation)) {
            return false;
        }
        Modelisation other = (Modelisation) object;
        if ((this.idModelisation == null && other.idModelisation != null) || (this.idModelisation != null && !this.idModelisation.equals(other.idModelisation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Modelisation[ idModelisation=" + idModelisation + " ]";
    }
    
}
