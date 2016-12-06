
/**
 * Cuenta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

            
                package es.deusto.arquiSW.SOAP.classes.xsd;
            

            /**
            *  Cuenta bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Cuenta
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = Cuenta
                Namespace URI = http://classes.arquiSW.deusto.es/xsd
                Namespace Prefix = ns2
                */
            

                        /**
                        * field for IBAN
                        */

                        
                                    protected int localIBAN ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIBANTracker = false ;

                           public boolean isIBANSpecified(){
                               return localIBANTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getIBAN(){
                               return localIBAN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IBAN
                               */
                               public void setIBAN(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localIBANTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localIBAN=param;
                                       

                               }
                            

                        /**
                        * field for SWIFT
                        */

                        
                                    protected java.lang.String localSWIFT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSWIFTTracker = false ;

                           public boolean isSWIFTSpecified(){
                               return localSWIFTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSWIFT(){
                               return localSWIFT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SWIFT
                               */
                               public void setSWIFT(java.lang.String param){
                            localSWIFTTracker = true;
                                   
                                            this.localSWIFT=param;
                                       

                               }
                            

                        /**
                        * field for Activa
                        */

                        
                                    protected boolean localActiva ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localActivaTracker = false ;

                           public boolean isActivaSpecified(){
                               return localActivaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getActiva(){
                               return localActiva;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Activa
                               */
                               public void setActiva(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localActivaTracker =
                                       true;
                                   
                                            this.localActiva=param;
                                       

                               }
                            

                        /**
                        * field for FechaApertura
                        */

                        
                                    protected java.util.Date localFechaApertura ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFechaAperturaTracker = false ;

                           public boolean isFechaAperturaSpecified(){
                               return localFechaAperturaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getFechaApertura(){
                               return localFechaApertura;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FechaApertura
                               */
                               public void setFechaApertura(java.util.Date param){
                            localFechaAperturaTracker = true;
                                   
                                            this.localFechaApertura=param;
                                       

                               }
                            

                        /**
                        * field for Interes
                        */

                        
                                    protected float localInteres ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInteresTracker = false ;

                           public boolean isInteresSpecified(){
                               return localInteresTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return float
                           */
                           public  float getInteres(){
                               return localInteres;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Interes
                               */
                               public void setInteres(float param){
                            
                                       // setting primitive attribute tracker to true
                                       localInteresTracker =
                                       !java.lang.Float.isNaN(param);
                                   
                                            this.localInteres=param;
                                       

                               }
                            

                        /**
                        * field for Operaciones
                        * This was an Array!
                        */

                        
                                    protected es.deusto.arquiSW.SOAP.classes.xsd.Operacion[] localOperaciones ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOperacionesTracker = false ;

                           public boolean isOperacionesSpecified(){
                               return localOperacionesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return es.deusto.arquiSW.SOAP.classes.xsd.Operacion[]
                           */
                           public  es.deusto.arquiSW.SOAP.classes.xsd.Operacion[] getOperaciones(){
                               return localOperaciones;
                           }

                           
                        


                               
                              /**
                               * validate the array for Operaciones
                               */
                              protected void validateOperaciones(es.deusto.arquiSW.SOAP.classes.xsd.Operacion[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Operaciones
                              */
                              public void setOperaciones(es.deusto.arquiSW.SOAP.classes.xsd.Operacion[] param){
                              
                                   validateOperaciones(param);

                               localOperacionesTracker = true;
                                      
                                      this.localOperaciones=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param es.deusto.arquiSW.SOAP.classes.xsd.Operacion
                             */
                             public void addOperaciones(es.deusto.arquiSW.SOAP.classes.xsd.Operacion param){
                                   if (localOperaciones == null){
                                   localOperaciones = new es.deusto.arquiSW.SOAP.classes.xsd.Operacion[]{};
                                   }

                            
                                 //update the setting tracker
                                localOperacionesTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localOperaciones);
                               list.add(param);
                               this.localOperaciones =
                             (es.deusto.arquiSW.SOAP.classes.xsd.Operacion[])list.toArray(
                            new es.deusto.arquiSW.SOAP.classes.xsd.Operacion[list.size()]);

                             }
                             

                        /**
                        * field for SaldoActual
                        */

                        
                                    protected float localSaldoActual ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSaldoActualTracker = false ;

                           public boolean isSaldoActualSpecified(){
                               return localSaldoActualTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return float
                           */
                           public  float getSaldoActual(){
                               return localSaldoActual;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SaldoActual
                               */
                               public void setSaldoActual(float param){
                            
                                       // setting primitive attribute tracker to true
                                       localSaldoActualTracker =
                                       !java.lang.Float.isNaN(param);
                                   
                                            this.localSaldoActual=param;
                                       

                               }
                            

                        /**
                        * field for Tarjeta
                        */

                        
                                    protected es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta localTarjeta ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTarjetaTracker = false ;

                           public boolean isTarjetaSpecified(){
                               return localTarjetaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta
                           */
                           public  es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta getTarjeta(){
                               return localTarjeta;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Tarjeta
                               */
                               public void setTarjeta(es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta param){
                            localTarjetaTracker = true;
                                   
                                            this.localTarjeta=param;
                                       

                               }
                            

                        /**
                        * field for Titular
                        */

                        
                                    protected es.deusto.arquiSW.SOAP.classes.xsd.Cliente localTitular ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTitularTracker = false ;

                           public boolean isTitularSpecified(){
                               return localTitularTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return es.deusto.arquiSW.SOAP.classes.xsd.Cliente
                           */
                           public  es.deusto.arquiSW.SOAP.classes.xsd.Cliente getTitular(){
                               return localTitular;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Titular
                               */
                               public void setTitular(es.deusto.arquiSW.SOAP.classes.xsd.Cliente param){
                            localTitularTracker = true;
                                   
                                            this.localTitular=param;
                                       

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


        
               return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(this,parentQName));
            
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://classes.arquiSW.deusto.es/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":Cuenta",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Cuenta",
                           xmlWriter);
                   }

               
                   }
                if (localIBANTracker){
                                    namespace = "http://classes.arquiSW.deusto.es/xsd";
                                    writeStartElement(null, namespace, "IBAN", xmlWriter);
                             
                                               if (localIBAN==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IBAN cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIBAN));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSWIFTTracker){
                                    namespace = "http://classes.arquiSW.deusto.es/xsd";
                                    writeStartElement(null, namespace, "SWIFT", xmlWriter);
                             

                                          if (localSWIFT==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSWIFT);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localActivaTracker){
                                    namespace = "http://classes.arquiSW.deusto.es/xsd";
                                    writeStartElement(null, namespace, "activa", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("activa cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localActiva));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFechaAperturaTracker){
                                    namespace = "http://classes.arquiSW.deusto.es/xsd";
                                    writeStartElement(null, namespace, "fechaApertura", xmlWriter);
                             

                                          if (localFechaApertura==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFechaApertura));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInteresTracker){
                                    namespace = "http://classes.arquiSW.deusto.es/xsd";
                                    writeStartElement(null, namespace, "interes", xmlWriter);
                             
                                               if (java.lang.Float.isNaN(localInteres)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("interes cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInteres));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOperacionesTracker){
                                       if (localOperaciones!=null){
                                            for (int i = 0;i < localOperaciones.length;i++){
                                                if (localOperaciones[i] != null){
                                                 localOperaciones[i].serialize(new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","operaciones"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                            writeStartElement(null, "http://classes.arquiSW.deusto.es/xsd", "operaciones", xmlWriter);

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                writeStartElement(null, "http://classes.arquiSW.deusto.es/xsd", "operaciones", xmlWriter);

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 } if (localSaldoActualTracker){
                                    namespace = "http://classes.arquiSW.deusto.es/xsd";
                                    writeStartElement(null, namespace, "saldoActual", xmlWriter);
                             
                                               if (java.lang.Float.isNaN(localSaldoActual)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("saldoActual cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSaldoActual));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTarjetaTracker){
                                    if (localTarjeta==null){

                                        writeStartElement(null, "http://classes.arquiSW.deusto.es/xsd", "tarjeta", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localTarjeta.serialize(new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","tarjeta"),
                                        xmlWriter);
                                    }
                                } if (localTitularTracker){
                                    if (localTitular==null){

                                        writeStartElement(null, "http://classes.arquiSW.deusto.es/xsd", "titular", xmlWriter);

                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localTitular.serialize(new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","titular"),
                                        xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://classes.arquiSW.deusto.es/xsd")){
                return "ns2";
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
        public static Cuenta parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Cuenta object =
                new Cuenta();

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
                    
                            if (!"Cuenta".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Cuenta)es.deusto.arquiSW.SOAP.ws.namespaces.axis2.Enum.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                        java.util.ArrayList list6 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","IBAN").equals(reader.getName()) || new javax.xml.namespace.QName("","IBAN").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IBAN" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIBAN(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setIBAN(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","SWIFT").equals(reader.getName()) || new javax.xml.namespace.QName("","SWIFT").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSWIFT(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","activa").equals(reader.getName()) || new javax.xml.namespace.QName("","activa").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"activa" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setActiva(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","fechaApertura").equals(reader.getName()) || new javax.xml.namespace.QName("","fechaApertura").equals(reader.getName()) ){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFechaApertura(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","interes").equals(reader.getName()) || new javax.xml.namespace.QName("","interes").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"interes" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInteres(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToFloat(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setInteres(java.lang.Float.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","operaciones").equals(reader.getName()) || new javax.xml.namespace.QName("","operaciones").equals(reader.getName()) ){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list6.add(null);
                                                              reader.next();
                                                          } else {
                                                        list6.add(es.deusto.arquiSW.SOAP.classes.xsd.Operacion.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone6 = false;
                                                        while(!loopDone6){
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
                                                                loopDone6 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","operaciones").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list6.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list6.add(es.deusto.arquiSW.SOAP.classes.xsd.Operacion.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone6 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setOperaciones((es.deusto.arquiSW.SOAP.classes.xsd.Operacion[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                es.deusto.arquiSW.SOAP.classes.xsd.Operacion.class,
                                                                list6));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","saldoActual").equals(reader.getName()) || new javax.xml.namespace.QName("","saldoActual").equals(reader.getName()) ){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"saldoActual" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSaldoActual(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToFloat(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setSaldoActual(java.lang.Float.NaN);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","tarjeta").equals(reader.getName()) || new javax.xml.namespace.QName("","tarjeta").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setTarjeta(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setTarjeta(es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://classes.arquiSW.deusto.es/xsd","titular").equals(reader.getName()) || new javax.xml.namespace.QName("","titular").equals(reader.getName()) ){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setTitular(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setTitular(es.deusto.arquiSW.SOAP.classes.xsd.Cliente.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
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
           
    