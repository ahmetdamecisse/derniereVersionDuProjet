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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "candidat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidat.findAll", query = "SELECT c FROM Candidat c"),
    @NamedQuery(name = "Candidat.findByIdCandidat", query = "SELECT c FROM Candidat c WHERE c.idCandidat = :idCandidat")})
public class Candidat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCandidat")
    private Integer idCandidat;
    @JoinTable(name = "cherchercandidat", joinColumns = {
        @JoinColumn(name = "idCandidat", referencedColumnName = "idCandidat")}, inverseJoinColumns = {
        @JoinColumn(name = "idRecruteur", referencedColumnName = "idRecruteur")})
    @ManyToMany
    private List<Recruteur> recruteurList;
    @JoinTable(name = "contactercandidat", joinColumns = {
        @JoinColumn(name = "idCandidat", referencedColumnName = "idCandidat")}, inverseJoinColumns = {
        @JoinColumn(name = "idRecruteur", referencedColumnName = "idRecruteur")})
    @ManyToMany
    private List<Recruteur> recruteurList1;
    @JoinTable(name = "consulternotification", joinColumns = {
        @JoinColumn(name = "idCandidat", referencedColumnName = "idCandidat")}, inverseJoinColumns = {
        @JoinColumn(name = "idNotification", referencedColumnName = "idNotification")})
    @ManyToMany
    private List<Notification> notificationList;
    @OneToMany(mappedBy = "idCandidat")
    private List<Postulations> postulationsList;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil")
    @ManyToOne(optional = false)
    private Profil idTypeDeProfil;
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCandidat")
    private List<Faireuntest> faireuntestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCandidat")
    private List<Faireentrtien> faireentrtienList;

    public Candidat() {
    }

    public Candidat(Integer idCandidat) {
        this.idCandidat = idCandidat;
    }

    public Integer getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(Integer idCandidat) {
        this.idCandidat = idCandidat;
    }

    @XmlTransient
    public List<Recruteur> getRecruteurList() {
        return recruteurList;
    }

    public void setRecruteurList(List<Recruteur> recruteurList) {
        this.recruteurList = recruteurList;
    }

    @XmlTransient
    public List<Recruteur> getRecruteurList1() {
        return recruteurList1;
    }

    public void setRecruteurList1(List<Recruteur> recruteurList1) {
        this.recruteurList1 = recruteurList1;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @XmlTransient
    public List<Postulations> getPostulationsList() {
        return postulationsList;
    }

    public void setPostulationsList(List<Postulations> postulationsList) {
        this.postulationsList = postulationsList;
    }

    public Profil getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(Profil idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @XmlTransient
    public List<Faireuntest> getFaireuntestList() {
        return faireuntestList;
    }

    public void setFaireuntestList(List<Faireuntest> faireuntestList) {
        this.faireuntestList = faireuntestList;
    }

    @XmlTransient
    public List<Faireentrtien> getFaireentrtienList() {
        return faireentrtienList;
    }

    public void setFaireentrtienList(List<Faireentrtien> faireentrtienList) {
        this.faireentrtienList = faireentrtienList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCandidat != null ? idCandidat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
        if ((this.idCandidat == null && other.idCandidat != null) || (this.idCandidat != null && !this.idCandidat.equals(other.idCandidat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Candidat[ idCandidat=" + idCandidat + " ]";
    }
    
}
