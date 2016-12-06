
/**
 * DeustoBankServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */

    package es.deusto.arquiSW.SOAP2;

    /**
     *  DeustoBankServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class DeustoBankServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public DeustoBankServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public DeustoBankServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for obtenerTarjeta method
            * override this method for handling normal response from obtenerTarjeta operation
            */
           public void receiveResultobtenerTarjeta(
                    es.deusto.arquiSW.SOAP2.ObtenerTarjetaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerTarjeta operation
           */
            public void receiveErrorobtenerTarjeta(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerTarjetas method
            * override this method for handling normal response from obtenerTarjetas operation
            */
           public void receiveResultobtenerTarjetas(
                    es.deusto.arquiSW.SOAP2.ObtenerTarjetasResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerTarjetas operation
           */
            public void receiveErrorobtenerTarjetas(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerCuentas method
            * override this method for handling normal response from obtenerCuentas operation
            */
           public void receiveResultobtenerCuentas(
                    es.deusto.arquiSW.SOAP2.ObtenerCuentasResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerCuentas operation
           */
            public void receiveErrorobtenerCuentas(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerCuenta method
            * override this method for handling normal response from obtenerCuenta operation
            */
           public void receiveResultobtenerCuenta(
                    es.deusto.arquiSW.SOAP2.ObtenerCuentaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerCuenta operation
           */
            public void receiveErrorobtenerCuenta(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for obtenerCliente method
            * override this method for handling normal response from obtenerCliente operation
            */
           public void receiveResultobtenerCliente(
                    es.deusto.arquiSW.SOAP2.ObtenerClienteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerCliente operation
           */
            public void receiveErrorobtenerCliente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerOperacion method
            * override this method for handling normal response from obtenerOperacion operation
            */
           public void receiveResultobtenerOperacion(
                    es.deusto.arquiSW.SOAP2.ObtenerOperacionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerOperacion operation
           */
            public void receiveErrorobtenerOperacion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerClientes method
            * override this method for handling normal response from obtenerClientes operation
            */
           public void receiveResultobtenerClientes(
                    es.deusto.arquiSW.SOAP2.ObtenerClientesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerClientes operation
           */
            public void receiveErrorobtenerClientes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerOperaciones method
            * override this method for handling normal response from obtenerOperaciones operation
            */
           public void receiveResultobtenerOperaciones(
                    es.deusto.arquiSW.SOAP2.ObtenerOperacionesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerOperaciones operation
           */
            public void receiveErrorobtenerOperaciones(java.lang.Exception e) {
            }
                


    }
    