package ws;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.annotation.security.RolesAllowed;

//JBoss Specific Annotations
import org.jboss.ws.api.annotation.WebContext;
import org.jboss.ejb3.annotation.SecurityDomain;

@WebService(name = "SecureCXF_EJB", targetNamespace="http://ws/")
@Stateless
@SecurityDomain("cxfservice-security-domain")
@RolesAllowed("TestRole")
@WebContext(contextRoot="/EJB_CXF_BasicAuthDemo", urlPattern="/*", authMethod="BASIC", transportGuarantee="NONE", secureWSDLAccess=false)
public class SecureCXF_EJB implements SecureCXF_EJB_Intf
{
    public String sayHello(String name)
     {
        System.out.println("\n\t [SecureCXF_EJB] sayHello() invoked : Hello, Mr. "+name);
        return "Hello, Mr. "+name;
     }
}

