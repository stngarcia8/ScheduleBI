import React from 'react'
import image from '../../assets/images/error500.png'

const ErrorMessage = () => {

  return (
    <div className="container content-space-2 content-space-lg-3">
      <div className="row align-items-lg-center">
        <div className="col-lg-5 mb-5 mb-lg-0">
          <div className="pe-lg-6">
            <div className="mb-4">
              <h2 className="h1">
                ¡Ha ocurrido un error!
              </h2>
            </div>

            <div className="mb-4">
              <p>
                En estos momentos no es posible obtener las tareas,
                esto puede ocurrir por diversos motivos,  verifique su conexión
                a la red o puede ser por falta de permisos del servidor, comunique este problema
                al administrador para solucionar posibles problematicas de las politicas
                de permisos del servidor para que la página pueda obtener
                las tareas.
              </p>
            </div>
          </div>
        </div>

        <div className="col-lg-7">
          <figure className="device-browser">
            <div className="position-relative">
              <img className="img-fluid rounded-2"
                src={image} alt="Error 500" />
            </div>
          </figure>
        </div>
      </div>
    </div>
  )
}

export default ErrorMessage