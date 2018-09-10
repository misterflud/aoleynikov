package SpringConfiguration

import groovyConfiguretion195.Contact

/**
 * Created by AOleynikov on 06.09.2018.
 */

beans {
    contact(Contact, firstName: 'Chris', lastName: 'Schaefer', age: 32)
}