package SpringConfiguration

import groovyConfiguretion195.Contact
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericApplicationContext

/**
 * Created by AOleynikov on 06.09.2018.
 */

def ctx = new GenericApplicationContext();
def  reader = new GroovyBeanDefinitionReader(ctx)

reader.beans {
    contact(Contact, firstName: 'Chris', lastName: 'Schaefer', age: 32)
}

ctx.refresh()

println ctx.getBean("contact")