import React from 'react'

const Header = () => {
  return (
    <div className="page-header p-5">
      <div className="row align-items-center">
        <div className="col-sm">
          <h2 className="page-header-title">
            schedulator - frontend
          </h2>
          <p className="page-header-text">
            El proposito de esta página es mostrar los resultados de
            las tareas organizadas, que son cargadas de la ruta
            http://localhost:8081/task, estos datos son organizados y
            expuestos por la API solicitada consumiendo la información
            generada del servicio http://localhost:8080/generator/schedule/tasks
          </p>
        </div>
      </div>
    </div>
  )

}

export default Header