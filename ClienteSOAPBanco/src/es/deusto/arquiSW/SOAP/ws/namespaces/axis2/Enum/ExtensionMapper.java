

/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

        
            package es.deusto.arquiSW.SOAP.ws.namespaces.axis2.Enum;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://classes.arquiSW.deusto.es/xsd".equals(namespaceURI) &&
                  "Cliente".equals(typeName)){
                   
                            return  es.deusto.arquiSW.SOAP.classes.xsd.Cliente.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://classes.arquiSW.deusto.es/xsd".equals(namespaceURI) &&
                  "Operacion".equals(typeName)){
                   
                            return  es.deusto.arquiSW.SOAP.classes.xsd.Operacion.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://classes.arquiSW.deusto.es/xsd".equals(namespaceURI) &&
                  "Cuenta".equals(typeName)){
                   
                            return  es.deusto.arquiSW.SOAP.classes.xsd.Cuenta.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.apache.org/namespaces/axis2/enum".equals(namespaceURI) &&
                  "TiposTarjeta".equals(typeName)){
                   
                            return  es.deusto.arquiSW.SOAP.ws.namespaces.axis2.Enum.TiposTarjeta.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://classes.arquiSW.deusto.es/xsd".equals(namespaceURI) &&
                  "Tarjeta".equals(typeName)){
                   
                            return  es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.apache.org/namespaces/axis2/enum".equals(namespaceURI) &&
                  "EnumProveedores".equals(typeName)){
                   
                            return  es.deusto.arquiSW.SOAP.ws.namespaces.axis2.Enum.EnumProveedores.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.apache.org/namespaces/axis2/enum".equals(namespaceURI) &&
                  "EnumTipoOperacion".equals(typeName)){
                   
                            return  es.deusto.arquiSW.SOAP.ws.namespaces.axis2.Enum.EnumTipoOperacion.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    