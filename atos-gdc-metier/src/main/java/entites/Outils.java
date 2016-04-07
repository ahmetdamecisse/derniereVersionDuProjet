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
@Table(name = "outils")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Outils.findAll", query = "SELECT o FROM Outils o"),
    @NamedQuery(name = "Outils.findByIdOutils", query = "SELECT o FROM Outils o WHERE o.idOutils = :idOutils"),
    @NamedQuery(name = "Outils.findByDomaine", query = "SELECT o FROM Outils o WHERE o.domaine = :domaine"),
    @NamedQuery(name = "Outils.findByNiveau", query = "SELECT o FROM Outils o WHERE o.niveau = :niveau")})
public class Outils implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOutils")
    private Integer idOutils;
    @Size(max = 350)
    @Column(name = "domaine")
    private String domaine;
    @Size(max = 254)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idProfilGL", referencedColumnName = "idProfilGL")
    @ManyToOne(optional = false)
    private Profilgl idProfilGL;

    public Outils() {
    }

    public Outils(Integer idOutils) {
        this.idOutils = idOutils;
    }

    public Integer getIdOutils() {
        return idOutils;
    }

    public void setIdOutils(Integer idOutils) {
        this.idOutils = idOutils;
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
        hash += (idOutils != null ? idOutils.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Outils)) {
            return false;
        }
        Outils other = (Outils) object;
        if ((this.idOutils == null && other.idOutils != null) || (this.idOutils != null && !this.idOutils.equals(other.idOutils))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Outils[ idOutils=" + idOutils + " ]";
    }
    
}
