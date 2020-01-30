
package com.exo.soap.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.exo.soap.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PersonneList_QNAME = new QName("http://service.soap.exo.com/", "personneList");
    private final static QName _PersonneListResponse_QNAME = new QName("http://service.soap.exo.com/", "personneListResponse");
    private final static QName _Personne_QNAME = new QName("http://service.soap.exo.com/", "personne");
    private final static QName _UpdatePersonneResponse_QNAME = new QName("http://service.soap.exo.com/", "updatePersonneResponse");
    private final static QName _UpdatePersonne_QNAME = new QName("http://service.soap.exo.com/", "updatePersonne");
    private final static QName _DeletePersonneResponse_QNAME = new QName("http://service.soap.exo.com/", "deletePersonneResponse");
    private final static QName _GetPersonneById_QNAME = new QName("http://service.soap.exo.com/", "getPersonneById");
    private final static QName _AddPersonneResponse_QNAME = new QName("http://service.soap.exo.com/", "addPersonneResponse");
    private final static QName _DeletePersonne_QNAME = new QName("http://service.soap.exo.com/", "deletePersonne");
    private final static QName _AddPersonne_QNAME = new QName("http://service.soap.exo.com/", "addPersonne");
    private final static QName _GetPersonneByIdResponse_QNAME = new QName("http://service.soap.exo.com/", "getPersonneByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.exo.soap.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdatePersonne }
     * 
     */
    public UpdatePersonne createUpdatePersonne() {
        return new UpdatePersonne();
    }

    /**
     * Create an instance of {@link Personne }
     * 
     */
    public Personne createPersonne() {
        return new Personne();
    }

    /**
     * Create an instance of {@link UpdatePersonneResponse }
     * 
     */
    public UpdatePersonneResponse createUpdatePersonneResponse() {
        return new UpdatePersonneResponse();
    }

    /**
     * Create an instance of {@link PersonneList }
     * 
     */
    public PersonneList createPersonneList() {
        return new PersonneList();
    }

    /**
     * Create an instance of {@link PersonneListResponse }
     * 
     */
    public PersonneListResponse createPersonneListResponse() {
        return new PersonneListResponse();
    }

    /**
     * Create an instance of {@link AddPersonneResponse }
     * 
     */
    public AddPersonneResponse createAddPersonneResponse() {
        return new AddPersonneResponse();
    }

    /**
     * Create an instance of {@link AddPersonne }
     * 
     */
    public AddPersonne createAddPersonne() {
        return new AddPersonne();
    }

    /**
     * Create an instance of {@link GetPersonneByIdResponse }
     * 
     */
    public GetPersonneByIdResponse createGetPersonneByIdResponse() {
        return new GetPersonneByIdResponse();
    }

    /**
     * Create an instance of {@link DeletePersonne }
     * 
     */
    public DeletePersonne createDeletePersonne() {
        return new DeletePersonne();
    }

    /**
     * Create an instance of {@link DeletePersonneResponse }
     * 
     */
    public DeletePersonneResponse createDeletePersonneResponse() {
        return new DeletePersonneResponse();
    }

    /**
     * Create an instance of {@link GetPersonneById }
     * 
     */
    public GetPersonneById createGetPersonneById() {
        return new GetPersonneById();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonneList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "personneList")
    public JAXBElement<PersonneList> createPersonneList(PersonneList value) {
        return new JAXBElement<PersonneList>(_PersonneList_QNAME, PersonneList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonneListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "personneListResponse")
    public JAXBElement<PersonneListResponse> createPersonneListResponse(PersonneListResponse value) {
        return new JAXBElement<PersonneListResponse>(_PersonneListResponse_QNAME, PersonneListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Personne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "personne")
    public JAXBElement<Personne> createPersonne(Personne value) {
        return new JAXBElement<Personne>(_Personne_QNAME, Personne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "updatePersonneResponse")
    public JAXBElement<UpdatePersonneResponse> createUpdatePersonneResponse(UpdatePersonneResponse value) {
        return new JAXBElement<UpdatePersonneResponse>(_UpdatePersonneResponse_QNAME, UpdatePersonneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "updatePersonne")
    public JAXBElement<UpdatePersonne> createUpdatePersonne(UpdatePersonne value) {
        return new JAXBElement<UpdatePersonne>(_UpdatePersonne_QNAME, UpdatePersonne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "deletePersonneResponse")
    public JAXBElement<DeletePersonneResponse> createDeletePersonneResponse(DeletePersonneResponse value) {
        return new JAXBElement<DeletePersonneResponse>(_DeletePersonneResponse_QNAME, DeletePersonneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonneById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "getPersonneById")
    public JAXBElement<GetPersonneById> createGetPersonneById(GetPersonneById value) {
        return new JAXBElement<GetPersonneById>(_GetPersonneById_QNAME, GetPersonneById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersonneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "addPersonneResponse")
    public JAXBElement<AddPersonneResponse> createAddPersonneResponse(AddPersonneResponse value) {
        return new JAXBElement<AddPersonneResponse>(_AddPersonneResponse_QNAME, AddPersonneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "deletePersonne")
    public JAXBElement<DeletePersonne> createDeletePersonne(DeletePersonne value) {
        return new JAXBElement<DeletePersonne>(_DeletePersonne_QNAME, DeletePersonne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersonne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "addPersonne")
    public JAXBElement<AddPersonne> createAddPersonne(AddPersonne value) {
        return new JAXBElement<AddPersonne>(_AddPersonne_QNAME, AddPersonne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonneByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.exo.com/", name = "getPersonneByIdResponse")
    public JAXBElement<GetPersonneByIdResponse> createGetPersonneByIdResponse(GetPersonneByIdResponse value) {
        return new JAXBElement<GetPersonneByIdResponse>(_GetPersonneByIdResponse_QNAME, GetPersonneByIdResponse.class, null, value);
    }

}
