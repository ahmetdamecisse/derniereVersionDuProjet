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
@Table(name = "faireuntest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faireuntest.findAll", query = "SELECT f FROM Faireuntest f"),
    @NamedQuery(name = "Faireuntest.findByIdFicheTest", query = "SELECT f FROM Faireuntest f WHERE f.idFicheTest = :idFicheTest"),
    @NamedQuery(name = "Faireuntest.findByDatetest", query = "SELECT f FROM Faireuntest f WHERE f.datetest = :datetest")})
public class Faireuntest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFicheTest")
    private Integer idFicheTest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datetest")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetest;
    @JoinColumn(name = "idCandidat", referencedColumnName = "idCandidat")
    @ManyToOne(optional = false)
    private Candidat idCandidat;
    @JoinColumn(name = "idFicheTest", referencedColumnName = "idFicheTest", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Fichedetest fichedetest;

    public Faireuntest() {
    }

    public Faireuntest(Integer idFicheTest) {
        this.idFicheTest = idFicheTest;
    }

    public Faireuntest(Integer idFicheTest, Date datetest) {
        this.idFicheTest = idFicheTest;
        this.datetest = datetest;
    }

    public Integer getIdFicheTest() {
        return idFicheTest;
    }

    public void setIdFicheTest(Integer idFicheTest) {
        this.idFicheTest = idFicheTest;
    }

    public Date getDatetest() {
        return datetest;
    }

    public void setDatetest(Date datetest) {
        this.datetest = datetest;
    }

    public Candidat getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(Candidat idCandidat) {
        this.idCandidat = idCandidat;
    }

    public Fichedetest getFichedetest() {
        return fichedetest;
    }

    public void setFichedetest(Fichedetest fichedetest) {
        this.fichedetest = fichedetest;
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
        if (!(object instanceof Faireuntest)) {
            return false;
        }
        Faireuntest other = (Faireuntest) object;
        if ((this.idFicheTest == null && other.idFicheTest != null) || (this.idFicheTest != null && !this.idFicheTest.equals(other.idFicheTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Faireuntest[ idFicheTest=" + idFicheTest + " ]";
    }
    
}
