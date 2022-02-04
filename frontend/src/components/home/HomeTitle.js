import React from 'react'

const HomeTitle = (props) => {
  const { buttonOnclickCB } = props

  return (
    <div className="container content-space-2 content-space-lg-3">
      <div className="w-md-75 w-lg-50 text-center mx-md-auto">
        <button name="home-get-tasks" type="button"
          className="btn btn-primary btn-sm btn-wide transition-3d-hover"
          onClick={buttonOnclickCB}
        >
          Obtener tareas
        </button>
      </div>
    </div >
  )


}

export default HomeTitle