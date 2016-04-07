/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "fichedetest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichedetest.findAll", query = "SELECT f FROM Fichedetest f"),
    @NamedQuery(name = "Fichedetest.findByIdFicheTest", query = "SELECT f FROM Fichedetest f WHERE f.idFicheTest = :idFicheTest"),
    @NamedQuery(name = "Fichedetest.findByVersion", query = "SELECT f FROM Fichedetest f WHERE f.version = :version")})
public class Fichedetest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFicheTest")
    private Integer idFicheTest;
    @Column(name = "version")
    private Integer version;
    @OneToMany(mappedBy = "idFicheTest")
    private List<Avoirquestions> avoirquestionsList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fichedetest")
    private Faireuntest faireuntest;
    @JoinColumn(name = "idRecruteur", referencedColumnName = "idRecruteur")
    @ManyToOne(optional = false)
    private Recruteur idRecruteur;

    public Fichedetest() {
    }

    public Fichedetest(Integer idFicheTest) {
        this.idFicheTest = idFicheTest;
    }

    public Integer getIdFicheTest() {
        return idFicheTest;
    }

    public void setIdFicheTest(Integer idFicheTest) {
        this.idFicheTest = idFicheTest;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @XmlTransient
    public List<Avoirquestions> getAvoirquestionsList() {
        return avoirquestionsList;
    }

    public void setAvoirquestionsList(List<Avoirquestions> avoirquestionsList) {
        this.avoirquestionsList = avoirquestionsList;
    }

    public Faireuntest getFaireuntest() {
        return faireuntest;
    }

    public void setFaireuntest(Faireuntest faireuntest) {
        this.faireuntest = faireuntest;
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
        hash += (idFicheTest != null ? idFicheTest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichedetest)) {
            return false;
        }
        Fichedetest other = (Fichedetest) object;
        if ((this.idFicheTest == null && other.idFicheTest != null) || (this.idFicheTest != null && !this.idFicheTest.equals(other.idFicheTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Fichedetest[ idFicheTest=" + idFicheTest + " ]";
    }
    
}
