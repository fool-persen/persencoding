
package com.persen.beijing.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.persen.beijing.webservice package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ServiceException_QNAME = new QName("http://webservice.service.business.sncp.woniu.com", "ServiceException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.persen.beijing.webservice
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BssChargeByDealflag }
     */
    public BssChargeByDealflag createBssChargeByDealflag() {
        return new BssChargeByDealflag();
    }

    /**
     * Create an instance of {@link BssCoreChargeResponse }
     */
    public BssCoreChargeResponse createBssCoreChargeResponse() {
        return new BssCoreChargeResponse();
    }

    /**
     * Create an instance of {@link BssImprest }
     */
    public BssImprest createBssImprest() {
        return new BssImprest();
    }

    /**
     * Create an instance of {@link BssCoreCharge }
     */
    public BssCoreCharge createBssCoreCharge() {
        return new BssCoreCharge();
    }

    /**
     * Create an instance of {@link BssImprestResponse }
     */
    public BssImprestResponse createBssImprestResponse() {
        return new BssImprestResponse();
    }

    /**
     * Create an instance of {@link TutuAccountQuery }
     */
    public TutuAccountQuery createTutuAccountQuery() {
        return new TutuAccountQuery();
    }

    /**
     * Create an instance of {@link BssChangePasswdResponse }
     */
    public BssChangePasswdResponse createBssChangePasswdResponse() {
        return new BssChangePasswdResponse();
    }

    /**
     * Create an instance of {@link BssChargeResponse }
     */
    public BssChargeResponse createBssChargeResponse() {
        return new BssChargeResponse();
    }

    /**
     * Create an instance of {@link BssCoreChargeByDealflagResponse }
     */
    public BssCoreChargeByDealflagResponse createBssCoreChargeByDealflagResponse() {
        return new BssCoreChargeByDealflagResponse();
    }

    /**
     * Create an instance of {@link BssCharge }
     */
    public BssCharge createBssCharge() {
        return new BssCharge();
    }

    /**
     * Create an instance of {@link BssChargeByDealflagResponse }
     */
    public BssChargeByDealflagResponse createBssChargeByDealflagResponse() {
        return new BssChargeByDealflagResponse();
    }

    /**
     * Create an instance of {@link BssCoreChargeByDealflag }
     */
    public BssCoreChargeByDealflag createBssCoreChargeByDealflag() {
        return new BssCoreChargeByDealflag();
    }

    /**
     * Create an instance of {@link BssChangePasswd }
     */
    public BssChangePasswd createBssChangePasswd() {
        return new BssChangePasswd();
    }

    /**
     * Create an instance of {@link TutuAccountQueryResponse }
     */
    public TutuAccountQueryResponse createTutuAccountQueryResponse() {
        return new TutuAccountQueryResponse();
    }

    /**
     * Create an instance of {@link ServiceException }
     */
    public ServiceException createServiceException() {
        return new ServiceException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceException }{@code >}}
     */
    @XmlElementDecl(namespace = "http://webservice.service.business.sncp.woniu.com", name = "ServiceException")
    public JAXBElement<ServiceException> createServiceException(ServiceException value) {
        return new JAXBElement<ServiceException>(_ServiceException_QNAME, ServiceException.class, null, value);
    }

}
