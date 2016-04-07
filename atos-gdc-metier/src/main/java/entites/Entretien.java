/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "entretien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entretien.findAll", query = "SELECT e FROM Entretien e"),
    @NamedQuery(name = "Entretien.findByIdEntretien", query = "SELECT e FROM Entretien e WHERE e.idEntretien = :idEntretien"),
    @NamedQuery(name = "Entretien.findByTypeEntretien", query = "SELECT e FROM Entretien e WHERE e.typeEntretien = :typeEntretien"),
    @NamedQuery(name = "Entretien.findByDateDebEntreti", query = "SELECT e FROM Entretien e WHERE e.dateDebEntreti = :dateDebEntreti"),
    @NamedQuery(name = "Entretien.findByAteFinEntreti", query = "SELECT e FROM Entretien e WHERE e.ateFinEntreti = :ateFinEntreti"),
    @NamedQuery(name = "Entretien.findByResultat", query = "SELECT e FROM Entretien e WHERE e.resultat = :resultat"),
    @NamedQuery(name = "Entretien.findByVersion", query = "SELECT e FROM Entretien e WHERE e.version = :version")})
public class Entretien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEntretien")
    private Integer idEntretien;
    @Size(max = 500)
    @Column(name = "typeEntretien")
    private String typeEntretien;
    @Column(name = "dateDebEntreti")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebEntreti;
    @Column(name = "ateFinEntreti")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ateFinEntreti;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "resultat")
    private Double resultat;
    @Column(name = "version")
    private Integer version;
    @JoinColumn(name = "idRecruteur", referencedColumnName = "idRecruteur")
    @ManyToOne(optional = false)
    private Recruteur idRecruteur;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "entretien")
    private Faireentrtien faireentrtien;

    public Entretien() {
    }

    public Entretien(Integer idEntretien) {
        this.idEntretien = idEntretien;
    }

    public Integer getIdEntretien() {
        return idEntretien;
    }

    public void setIdEntretien(Integer idEntretien) {
        this.idEntretien = idEntretien;
    }

    public String getTypeEntretien() {
        return typeEntretien;
    }

    public void setTypeEntretien(String typeEntretien) {
        this.typeEntretien = typeEntretien;
    }

    public Date getDateDebEntreti() {
        return dateDebEntreti;
    }

    public void setDateDebEntreti(Date dateDebEntreti) {
        this.dateDebEntreti = dateDebEntreti;
    }

    public Date getAteFinEntreti() {
        return ateFinEntreti;
    }

    public void setAteFinEntreti(Date ateFinEntreti) {
        this.ateFinEntreti = ateFinEntreti;
    }

    public Double getResultat() {
        return resultat;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
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

    public Faireentrtien getFaireentrtien() {
        return faireentrtien;
    }

    public void setFaireentrtien(Faireentrtien faireentrtien) {
        this.faireentrtien = faireentrtien;
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
        if (!(object instanceof Entretien)) {
            return false;
        }
        Entretien other = (Entretien) object;
        if ((this.idEntretien == null && other.idEntretien != null) || (this.idEntretien != null && !this.idEntretien.equals(other.idEntretien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Entretien[ idEntretien=" + idEntretien + " ]";
    }
    
}
