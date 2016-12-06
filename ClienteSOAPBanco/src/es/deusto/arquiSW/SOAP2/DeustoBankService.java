

/**
 * DeustoBankService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */

    package es.deusto.arquiSW.SOAP2;

    /*
     *  DeustoBankService java interface
     */

    public interface DeustoBankService {
          

        /**
          * Auto generated method signature
          * 
                    * @param obtenerTarjeta0
                
         */

         
                     public es.deusto.arquiSW.SOAP2.ObtenerTarjetaResponse obtenerTarjeta(

                        es.deusto.arquiSW.SOAP2.ObtenerTarjeta obtenerTarjeta0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param obtenerTarjeta0
            
          */
        public void startobtenerTarjeta(

            es.deusto.arquiSW.SOAP2.ObtenerTarjeta obtenerTarjeta0,

            final es.deusto.arquiSW.SOAP2.DeustoBankServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param obtenerTarjetas2
                
         */

         
                     public es.deusto.arquiSW.SOAP2.ObtenerTarjetasResponse obtenerTarjetas(

                        es.deusto.arquiSW.SOAP2.ObtenerTarjetas obtenerTarjetas2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param obtenerTarjetas2
            
          */
        public void startobtenerTarjetas(

            es.deusto.arquiSW.SOAP2.ObtenerTarjetas obtenerTarjetas2,

            final es.deusto.arquiSW.SOAP2.DeustoBankServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param obtenerCuentas4
                
         */

         
                     public es.deusto.arquiSW.SOAP2.ObtenerCuentasResponse obtenerCuentas(

                        es.deusto.arquiSW.SOAP2.ObtenerCuentas obtenerCuentas4)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param obtenerCuentas4
            
          */
        public void startobtenerCuentas(

            es.deusto.arquiSW.SOAP2.ObtenerCuentas obtenerCuentas4,

            final es.deusto.arquiSW.SOAP2.DeustoBankServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param obtenerCuenta6
                
         */

         
                     public es.deusto.arquiSW.SOAP2.ObtenerCuentaResponse obtenerCuenta(

                        es.deusto.arquiSW.SOAP2.ObtenerCuenta obtenerCuenta6)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param obtenerCuenta6
            
          */
        public void startobtenerCuenta(

            es.deusto.arquiSW.SOAP2.ObtenerCuenta obtenerCuenta6,

            final es.deusto.arquiSW.SOAP2.DeustoBankServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  importar(
         es.deusto.arquiSW.SOAP2.Importar importar8

        ) throws java.rmi.RemoteException
        
        ;

        

        /**
          * Auto generated method signature
          * 
                    * @param obtenerCliente9
                
         */

         
                     public es.deusto.arquiSW.SOAP2.ObtenerClienteResponse obtenerCliente(

                        es.deusto.arquiSW.SOAP2.ObtenerCliente obtenerCliente9)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param obtenerCliente9
            
          */
        public void startobtenerCliente(

            es.deusto.arquiSW.SOAP2.ObtenerCliente obtenerCliente9,

            final es.deusto.arquiSW.SOAP2.DeustoBankServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param obtenerOperacion11
                
         */

         
                     public es.deusto.arquiSW.SOAP2.ObtenerOperacionResponse obtenerOperacion(

                        es.deusto.arquiSW.SOAP2.ObtenerOperacion obtenerOperacion11)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param obtenerOperacion11
            
          */
        public void startobtenerOperacion(

            es.deusto.arquiSW.SOAP2.ObtenerOperacion obtenerOperacion11,

            final es.deusto.arquiSW.SOAP2.DeustoBankServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param obtenerClientes13
                
         */

         
                     public es.deusto.arquiSW.SOAP2.ObtenerClientesResponse obtenerClientes(

                        es.deusto.arquiSW.SOAP2.ObtenerClientes obtenerClientes13)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param obtenerClientes13
            
          */
        public void startobtenerClientes(

            es.deusto.arquiSW.SOAP2.ObtenerClientes obtenerClientes13,

            final es.deusto.arquiSW.SOAP2.DeustoBankServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param obtenerOperaciones15
                
         */

         
                     public es.deusto.arquiSW.SOAP2.ObtenerOperacionesResponse obtenerOperaciones(

                        es.deusto.arquiSW.SOAP2.ObtenerOperaciones obtenerOperaciones15)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param obtenerOperaciones15
            
          */
        public void startobtenerOperaciones(

            es.deusto.arquiSW.SOAP2.ObtenerOperaciones obtenerOperaciones15,

            final es.deusto.arquiSW.SOAP2.DeustoBankServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    