import React from 'react'
import image from '../../../assets/images/task.png'


const TaskContent = (props) => {
  const { data } = props

  const prepareTasksDetails = (tasks) => {
    return tasks.map((x) => {
      return (<div >
        <h5 className="mb-0">

          <strong>
            Tarea: {x?.task_name}
          </strong>
        </h5>
        <span>
          Duración: {x?.duration}
        </span>
      </div>)
    })
  }


  const prepareBodyContent = () => {
    if (!data?.taskPerDay) return (<></>)
    return data?.taskPerDay.map((x, index) => {
      return (
        <div key={index} className="col-sm-6 col-lg-3 mb-3 mb-lg-0">
          <img className="card-img-top" src={image} alt="Tarea" />
          <h3 className="card-text lh-base">
            Tareas del día {x.dayNumber}
          </h3>
          <span className="card-subtitle text-primary">
            {x.taskQuantity} encontradas
          </span>
          <div className="card-body">
            {prepareTasksDetails(x?.tasks)}
          </div>
        </div>
      )
    })
  }


  return (
    <div className="container content-space-2 content-space-lg-3 p-5">
      <div className="w-md-75 w-lg-50 text-center mx-md-auto mb-5 mb-md-9">
        <h2 >
          Listado de tareas
        </h2>
        <p>
          El listado a continuación corresponde a {data?.totalTasks} tareas cargadas desde la API y separadas por día.
        </p>
      </div>

      <div className="row gx-3 mb-5 mb-md-9">
        {prepareBodyContent()}
      </div>
    </div>
  )
}

export default TaskContent