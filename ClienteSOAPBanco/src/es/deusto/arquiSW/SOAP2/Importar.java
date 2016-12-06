
/**
 * Importar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

            
                package es.deusto.arquiSW.SOAP2;
            

            /**
            *  Importar bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Importar
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://SOAP.arquiSW.deusto.es",
                "importar",
                "ns3");

            

                        /**
                        * field for Clientes
                        * This was an Array!
                        */

                        
                                    protected es.deusto.arquiSW.SOAP2.classes.xsd.Cliente[] localClientes ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localClientesTracker = false ;

                           public boolean isClientesSpecified(){
                               return localClientesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return es.deusto.arquisw.classes.xsd.Cliente[]
                           */
                           public  es.deusto.arquiSW.SOAP2.classes.xsd.Cliente[] getClientes(){
                               return localClientes;
                           }

                           
                        


                               
                              /**
                               * validate the array for Clientes
                               */
                              protected void validateClientes(es.deusto.arquiSW.SOAP2.classes.xsd.Cliente[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Clientes
                              */
                              public void setClientes(es.deusto.arquiSW.SOAP2.classes.xsd.Cliente[] param){
                              
                                   validateClientes(param);

                               localClientesTracker = true;
                                      
                                      this.localClientes=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param es.deusto.arquisw.classes.xsd.Cliente
                             */
                             public void addClientes(es.deusto.arquiSW.SOAP2.classes.xsd.Cliente param){
                                   if (localClientes == null){
                                   localClientes = new es.deusto.arquiSW.SOAP2.classes.xsd.Cliente[]{};
                                   }

                            
                                 //update the setting tracker
                                localClientesTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localClientes);
                               list.add(param);
                               this.localClientes =
                             (es.deusto.arquiSW.SOAP2.classes.xsd.Cliente[])list.toArray(
                            new es.deusto.arquiSW.SOAP2.classes.xsd.Cliente[list.size()]);

                             }
                             

                        /**
                        * field for Cuentas
                        * This was an Array!
                        */

                        
                                    protected es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta[] localCuentas ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCuentasTracker = false ;

                           public boolean isCuentasSpecified(){
                               return localCuentasTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return es.deusto.arquisw.classes.xsd.Cuenta[]
                           */
                           public  es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta[] getCuentas(){
                               return localCuentas;
                           }

                           
                        


                               
                              /**
                               * validate the array for Cuentas
                               */
                              protected void validateCuentas(es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Cuentas
                              */
                              public void setCuentas(es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta[] param){
                              
                                   validateCuentas(param);

                               localCuentasTracker = true;
                                      
                                      this.localCuentas=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param es.deusto.arquisw.classes.xsd.Cuenta
                             */
                             public void addCuentas(es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta param){
                                   if (localCuentas == null){
                                   localCuentas = new es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta[]{};
                                   }

                            
                                 //update the setting tracker
                                localCuentasTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localCuentas);
                               list.add(param);
                               this.localCuentas =
                             (es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta[])list.toArray(
                            new es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta[list.size()]);

                             }
                             

                        /**
                        * field for Tarjetas
                        * This was an Array!
                        */

                        
                                    protected es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta[] localTarjetas ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTarjetasTracker = false ;

                           public boolean isTarjetasSpecified(){
                               return localTarjetasTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return es.deusto.arquisw.classes.xsd.Tarjeta[]
                           */
                           public  es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta[] getTarjetas(){
                               return localTarjetas;
                           }

                           
                        


                               
                              /**
                               * validate the array for Tarjetas
                               */
                              protected void validateTarjetas(es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Tarjetas
                              */
                              public void setTarjetas(es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta[] param){
                              
                                   validateTarjetas(param);

                               localTarjetasTracker = true;
                                      
                                      this.localTarjetas=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param es.deusto.arquisw.classes.xsd.Tarjeta
                             */
                             public void addTarjetas(es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta param){
                                   if (localTarjetas == null){
                                   localTarjetas = new es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta[]{};
                                   }

                            
                                 //update the setting tracker
                                localTarjetasTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localTarjetas);
                               list.add(param);
                               this.localTarjetas =
                             (es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta[])list.toArray(
                            new es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta[list.size()]);

                             }
                             

     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME));
            
        }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://SOAP.arquiSW.deusto.es");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":importar",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "importar",
                           xmlWriter);
                   }

               
                   }
                if (localClientesTracker){
                                       if (localClientes!=null){
                                            for (int i = 0;i < localClientes.length;i++){
                                                if (localClientes[i] != null){
                                                 localClientes[i].serialize(new javax.xml.namespace.QName("http://SOAP.arquiSW.deusto.es","clientes"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                            writeStartElement(null, "http://SOAP.arquiSW.deusto.es", "clientes", xmlWriter);

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                writeStartElement(null, "http://SOAP.arquiSW.deusto.es", "clientes", xmlWriter);

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 } if (localCuentasTracker){
                                       if (localCuentas!=null){
                                            for (int i = 0;i < localCuentas.length;i++){
                                                if (localCuentas[i] != null){
                                                 localCuentas[i].serialize(new javax.xml.namespace.QName("http://SOAP.arquiSW.deusto.es","cuentas"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                            writeStartElement(null, "http://SOAP.arquiSW.deusto.es", "cuentas", xmlWriter);

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                writeStartElement(null, "http://SOAP.arquiSW.deusto.es", "cuentas", xmlWriter);

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 } if (localTarjetasTracker){
                                       if (localTarjetas!=null){
                                            for (int i = 0;i < localTarjetas.length;i++){
                                                if (localTarjetas[i] != null){
                                                 localTarjetas[i].serialize(new javax.xml.namespace.QName("http://SOAP.arquiSW.deusto.es","tarjetas"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                            writeStartElement(null, "http://SOAP.arquiSW.deusto.es", "tarjetas", xmlWriter);

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                writeStartElement(null, "http://SOAP.arquiSW.deusto.es", "tarjetas", xmlWriter);

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://SOAP.arquiSW.deusto.es")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace,attName,attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace,attName,attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace), namespace,attName,attValue);
            }
        }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{
        private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Importar parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Importar object =
                new Importar();

            int event;
            javax.xml.namespace.QName currentQName = null;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                currentQName = reader.getName();
                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"importar".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Importar)es.deusto.arquiSW.SOAP2.ws.namespaces.axis2.Enum.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                        java.util.ArrayList list1 = new java.util.ArrayList();
                    
                        java.util.ArrayList list2 = new java.util.ArrayList();
                    
                        java.util.ArrayList list3 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://SOAP.arquiSW.deusto.es","clientes").equals(reader.getName()) || new javax.xml.namespace.QName("","clientes").equals(reader.getName()) ){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list1.add(null);
                                                              reader.next();
                                                          } else {
                                                        list1.add(es.deusto.arquiSW.SOAP2.classes.xsd.Cliente.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone1 = false;
                                                        while(!loopDone1){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone1 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://SOAP.arquiSW.deusto.es","clientes").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list1.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list1.add(es.deusto.arquiSW.SOAP2.classes.xsd.Cliente.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone1 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setClientes((es.deusto.arquiSW.SOAP2.classes.xsd.Cliente[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                es.deusto.arquiSW.SOAP2.classes.xsd.Cliente.class,
                                                                list1));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://SOAP.arquiSW.deusto.es","cuentas").equals(reader.getName()) || new javax.xml.namespace.QName("","cuentas").equals(reader.getName()) ){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list2.add(null);
                                                              reader.next();
                                                          } else {
                                                        list2.add(es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone2 = false;
                                                        while(!loopDone2){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone2 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://SOAP.arquiSW.deusto.es","cuentas").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list2.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list2.add(es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone2 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setCuentas((es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                es.deusto.arquiSW.SOAP2.classes.xsd.Cuenta.class,
                                                                list2));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://SOAP.arquiSW.deusto.es","tarjetas").equals(reader.getName()) || new javax.xml.namespace.QName("","tarjetas").equals(reader.getName()) ){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list3.add(null);
                                                              reader.next();
                                                          } else {
                                                        list3.add(es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone3 = false;
                                                        while(!loopDone3){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone3 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://SOAP.arquiSW.deusto.es","tarjetas").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list3.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list3.add(es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone3 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setTarjetas((es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                es.deusto.arquiSW.SOAP2.classes.xsd.Tarjeta.class,
                                                                list3));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // 2 - A start element we are not expecting indicates a trailing invalid property
                                
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    